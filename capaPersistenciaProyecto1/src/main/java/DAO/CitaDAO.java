/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.IConexionBD;
import DAO.ICitaDAO;
import Entidades.Cita;
import Entidades.Horario_Medico;
import Entidades.Medico;
import Entidades.Paciente;
import Entidades.Usuario;
import Exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ramon Valencia
 */
public class CitaDAO implements ICitaDAO {

    private IConexionBD conexionBD;

    public CitaDAO(IConexionBD conexion) {
        this.conexionBD = conexion;
    }

    private static final Logger logger = Logger.getLogger(CitaDAO.class.getName());

    /**
     * Metodo que agenda una cita pasandole un Objeto del tipo Cita.
     *
     * @param cita
     * @return Una cita si se agenda.
     * @throws PersistenciaException
     */
    @Override
    public Cita agendarCita(Cita cita) throws PersistenciaException {
        String consultaSQL = "INSERT INTO CITAS (estado, fechaHoraProgramada, folio, tipo, idMedico, idPaciente) "
                + "VALUES(?, ?, ?, ?, ?, ?)";  // 🔹 Eliminada la coma extra

        try (Connection con = this.conexionBD.crearConexion(); PreparedStatement ps = con.prepareStatement(consultaSQL, PreparedStatement.RETURN_GENERATED_KEYS)) {

            if (cita.getEstado() == null || cita.getEstado().trim().isEmpty()) {
                cita.setEstado("Programada"); // Asigna un estado por defecto
                cita.setTipo("programada");
            }

            ps.setString(1, cita.getEstado());
            ps.setObject(2, cita.getFechaHora());
            ps.setString(3, generarFolio());
            ps.setString(4, cita.getTipo());
            ps.setInt(5, cita.getMedico().getUsuario().getIdUsuario());
            ps.setInt(6, cita.getPaciente().getUsuario().getIdUsuario());
            System.out.println("Logger ID Médico: " + cita.getMedico().getUsuario().getIdUsuario());
            System.out.println("Logger ID PACIENTE: " + cita.getPaciente().getUsuario().getIdUsuario());

            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas == 0) {
                logger.severe("ERROR: Hubo un fallo al agendar la cita, no se insertó ninguna fila.");
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    cita.setIdCita(generatedKeys.getInt(1));
                    logger.info("Cita agregada exitosamente");
                } else {
                    logger.severe("ERROR: La agregación de la cita falló, no se pudo obtener el ID.");
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Error al registrar una cita en la base de datos.");
        }
        return cita;
    }

    public List<Cita> consultarCitasProgramadasAgenda(int idMedico) throws PersistenciaException {
        List<Cita> citas = new ArrayList<>();

        String sql = "SELECT c.idCita, c.estado, c.fechaHoraProgramada, c.folio, c.tipo, "
                + "m.idMedico, m.nombre AS nombreMedico, m.apellidoPat AS apellidoPatMedico, "
                + "m.apellidoMat AS apellidoMatMedico, m.cedulaProf, m.especialidad, "
                + "p.idPaciente, p.nombre AS nombrePaciente, p.apellidoPat AS apellidoPatPaciente, "
                + "p.apellidoMat AS apellidoMatPaciente, p.correo, p.fechaNac, p.telefono "
                + "FROM CITAS c "
                + "JOIN MEDICOS m ON c.idMedico = m.idMedico "
                + "JOIN PACIENTES p ON c.idPaciente = p.idPaciente "
                + "JOIN HORARIOS_MEDICOS hm ON m.idMedico = hm.idMedico "
                + "JOIN HORARIOS h ON hm.idHorario = h.idHorario "
                + "WHERE c.idMedico = ? "
                + "AND TIME(c.fechaHoraProgramada) BETWEEN h.horaInicio AND h.horaFin "
                + "AND c.fechaHoraProgramada >= NOW() "
                + "AND c.estado = 'Programada' "
                + "AND c.tipo = 'programada' "
                + "ORDER BY c.fechaHoraProgramada ASC";

        try (Connection con = this.conexionBD.crearConexion(); PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, idMedico);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    // Crear objeto Usuario para Medico
                    Usuario usuarioMedico = new Usuario();
                    usuarioMedico.setIdUsuario(rs.getInt("idMedico"));

                    // Crear objeto Medico y asociarle el Usuario
                    Medico medico = new Medico();
                    medico.setUsuario(usuarioMedico);
                    medico.setNombre(rs.getString("nombreMedico"));
                    medico.setApellidoPaterno(rs.getString("apellidoPatMedico"));
                    medico.setApellidoMaterno(rs.getString("apellidoMatMedico"));
                    medico.setCedulaProfesional(rs.getString("cedulaProf"));
                    medico.setEspecialidad(rs.getString("especialidad"));

                    // Crear objeto Usuario para Paciente
                    Usuario usuarioPaciente = new Usuario();
                    usuarioPaciente.setIdUsuario(rs.getInt("idPaciente"));

                    // Crear objeto Paciente y asociarle el Usuario
                    Paciente paciente = new Paciente();
                    paciente.setUsuario(usuarioPaciente);
                    paciente.setNombre(rs.getString("nombrePaciente"));
                    paciente.setApellidoPaterno(rs.getString("apellidoPatPaciente"));
                    paciente.setApellidoMaterno(rs.getString("apellidoMatPaciente"));
                    paciente.setCorreo(rs.getString("correo"));
                    paciente.setFechaNacimiento(rs.getDate("fechaNac").toLocalDate());
                    paciente.setTelefono(rs.getString("telefono"));

                    // Crear objeto Cita
                    Cita nuevaCita = new Cita();
                    nuevaCita.setIdCita(rs.getInt("idCita"));
                    nuevaCita.setEstado(rs.getString("estado"));
                    nuevaCita.setFechaHora(rs.getTimestamp("fechaHoraProgramada").toLocalDateTime());
                    nuevaCita.setFolio(rs.getString("folio"));
                    nuevaCita.setTipo(rs.getString("tipo"));
                    nuevaCita.setMedico(medico);
                    nuevaCita.setPaciente(paciente);

                    // Agregar la cita a la lista
                    citas.add(nuevaCita);
                }
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al consultar las citas programadas", e);
        }
        return citas;
    }

    public List<Cita> consultarCitasEmergenciaAgenda(int idMedico) throws PersistenciaException {
        List<Cita> citas = new ArrayList<>();

        String sql = "SELECT c.idCita, c.estado, c.fechaHoraProgramada, c.folio, c.tipo, "
                + "m.idMedico, m.nombre AS nombreMedico, m.apellidoPat AS apellidoPatMedico, "
                + "m.apellidoMat AS apellidoMatMedico, m.cedulaProf, m.especialidad, "
                + "p.idPaciente, p.nombre AS nombrePaciente, p.apellidoPat AS apellidoPatPaciente, "
                + "p.apellidoMat AS apellidoMatPaciente, p.correo, p.fechaNac, p.telefono "
                + "FROM CITAS c "
                + "JOIN MEDICOS m ON c.idMedico = m.idMedico "
                + "JOIN PACIENTES p ON c.idPaciente = p.idPaciente "
                + "JOIN HORARIOS_MEDICOS hm ON m.idMedico = hm.idMedico "
                + "JOIN HORARIOS h ON hm.idHorario = h.idHorario "
                + "WHERE c.idMedico = ? "
                + "AND TIME(c.fechaHoraProgramada) BETWEEN h.horaInicio AND h.horaFin "
                + "AND c.fechaHoraProgramada >= NOW() "
                + "AND c.estado = 'Programada' "
                + "AND c.tipo = 'emergencia' "
                + "ORDER BY c.fechaHoraProgramada ASC";

        try (Connection con = this.conexionBD.crearConexion(); PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, idMedico);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    // Crear objeto Usuario para Medico
                    Usuario usuarioMedico = new Usuario();
                    usuarioMedico.setIdUsuario(rs.getInt("idMedico"));

                    // Crear objeto Medico y asociarle el Usuario
                    Medico medico = new Medico();
                    medico.setUsuario(usuarioMedico);
                    medico.setNombre(rs.getString("nombreMedico"));
                    medico.setApellidoPaterno(rs.getString("apellidoPatMedico"));
                    medico.setApellidoMaterno(rs.getString("apellidoMatMedico"));
                    medico.setCedulaProfesional(rs.getString("cedulaProf"));
                    medico.setEspecialidad(rs.getString("especialidad"));

                    // Crear objeto Usuario para Paciente
                    Usuario usuarioPaciente = new Usuario();
                    usuarioPaciente.setIdUsuario(rs.getInt("idPaciente"));

                    // Crear objeto Paciente y asociarle el Usuario
                    Paciente paciente = new Paciente();
                    paciente.setUsuario(usuarioPaciente);
                    paciente.setNombre(rs.getString("nombrePaciente"));
                    paciente.setApellidoPaterno(rs.getString("apellidoPatPaciente"));
                    paciente.setApellidoMaterno(rs.getString("apellidoMatPaciente"));
                    paciente.setCorreo(rs.getString("correo"));
                    paciente.setFechaNacimiento(rs.getDate("fechaNac").toLocalDate());
                    paciente.setTelefono(rs.getString("telefono"));

                    // Crear objeto Cita
                    Cita nuevaCita = new Cita();
                    nuevaCita.setIdCita(rs.getInt("idCita"));
                    nuevaCita.setEstado(rs.getString("estado"));
                    nuevaCita.setFechaHora(rs.getTimestamp("fechaHoraProgramada").toLocalDateTime());
                    nuevaCita.setFolio(rs.getString("folio"));
                    nuevaCita.setTipo(rs.getString("tipo"));
                    nuevaCita.setMedico(medico);
                    nuevaCita.setPaciente(paciente);

                    // Agregar la cita a la lista
                    citas.add(nuevaCita);
                }
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al consultar las citas programadas", e);
        }
        return citas;
    }

    public String generarFolio() throws SQLException {
        String consultaSQL = "SELECT folio FROM CITAS ORDER BY folio DESC LIMIT 1;";

        try (Connection con = this.conexionBD.crearConexion(); PreparedStatement ps = con.prepareStatement(consultaSQL)) {

            try (ResultSet rs = ps.executeQuery()) {

                String nuevoFolio;
                if (rs.next()) { // Verifica si hay un resultado
                    String folioActual = rs.getString("folio"); // Obtiene el último folio

                    // Validar si folioActual es nulo o no numérico
                    if (folioActual == null || !folioActual.matches("\\d+")) {
                        System.err.println("Folio inválido en la BD: " + folioActual);
                        return "00001"; // Reiniciar folio
                    }

                    int numeroFolio = Integer.parseInt(folioActual); // Convertir a entero
                    nuevoFolio = String.format("%05d", numeroFolio + 1); // Aumentar y formatear

                } else {
                    nuevoFolio = "00001"; // Si no hay registros, empieza en 00001
                }
                return nuevoFolio;

            }
        } catch (PersistenciaException ex) {
            Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, "Error en generarFolio", ex);
        } catch (NumberFormatException ex) {
            Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, "Error al convertir folio a número", ex);
        }
        return "00001"; // Retorna un valor por defecto en caso de error
    }


    /**
     * Obtiene los horarios disponibles de un médico con su nombre y
     * especialidad.
     *
     * @param idMedico ID del médico.
     * @param diaSemana Día de la semana (Ejemplo: "Lunes").
     * @param fecha Fecha específica en formato "YYYY-MM-DD".
     * @return Lista con los datos en formato "Doctor | Especialidad | Horario".
     * @throws Exception.PersistenciaException
     */
    @Override
    public List<Cita> cargarCitas(int idMedico, String diaSemana, String fecha) throws PersistenciaException {
        List<Cita> citasDisponibles = new ArrayList<>();

        try (Connection con = this.conexionBD.crearConexion()) {
            // 1. Obtener el horario, nombre y especialidad del médico
            String sqlHorario = """
        SELECT m.idMedico, m.nombre, m.apellidoPat, m.apellidoMat, m.especialidad, h.horaInicio, h.horaFin
        FROM HORARIOS h
        JOIN HORARIOS_MEDICOS hm ON h.idHorario = hm.idHorario
        JOIN MEDICOS m ON hm.idMedico = m.idMedico
        WHERE m.idMedico = ? AND LOWER(h.diaSemana) = LOWER(?);
        """;

            try (PreparedStatement stmtHorario = con.prepareStatement(sqlHorario)) {
                stmtHorario.setInt(1, idMedico);
                stmtHorario.setString(2, diaSemana);

                try (ResultSet rsHorario = stmtHorario.executeQuery()) {
                    if (!rsHorario.next()) {
                        System.out.println("No se encontraron horarios para el médico en ese día.");
                        return citasDisponibles;
                    }

                    // Recuperar datos del médico y su horario
                    Usuario usuarioMedico = new Usuario();
                    usuarioMedico.setIdUsuario(rsHorario.getInt("idMedico"));

                    Medico medico = new Medico();
                    medico.setUsuario(usuarioMedico);
                    medico.setNombre(rsHorario.getString("nombre"));
                    medico.setApellidoPaterno(rsHorario.getString("apellidoPat"));
                    medico.setApellidoMaterno(rsHorario.getString("apellidoMat"));
                    medico.setEspecialidad(rsHorario.getString("especialidad"));

                    Time horaInicio = rsHorario.getTime("horaInicio");
                    Time horaFin = rsHorario.getTime("horaFin");

                    System.out.println("Médico encontrado: " + medico.getNombre() + " - " + medico.getEspecialidad());

                    // 2. Generar intervalos de 30 minutos
                    List<String> intervalos = generarIntervalos(horaInicio, horaFin);

                    // 3. Obtener citas ocupadas para ese día y médico
                    String sqlOcupadas = """
                SELECT TIME(fechaHoraProgramada) AS hora
                FROM CITAS
                WHERE idMedico = ? AND DATE(fechaHoraProgramada) = ?;
                """;

                    List<LocalTime> ocupadas = new ArrayList<>();
                    try (PreparedStatement stmtOcupadas = con.prepareStatement(sqlOcupadas)) {
                        stmtOcupadas.setInt(1, idMedico);
                        stmtOcupadas.setString(2, fecha);

                        try (ResultSet rsOcupadas = stmtOcupadas.executeQuery()) {
                            while (rsOcupadas.next()) {
                                ocupadas.add(rsOcupadas.getTime("hora").toLocalTime());
                            }
                        }
                    }

                    // 4. Filtrar las citas disponibles y crear objetos Cita
                    for (String intervaloStr : intervalos) { // Ahora recorremos la lista de Strings
                        LocalTime intervalo = LocalTime.parse(intervaloStr); // Convertimos el String a LocalTime

                        if (!ocupadas.contains(intervalo)) {
                            LocalDateTime fechaHora = LocalDateTime.of(LocalDate.parse(fecha), intervalo);

                            // Se crea la cita con estado "Disponible" y sin paciente asignado aún
                            Cita citaDisponible = new Cita();
                            citaDisponible.setIdCita(0);
                            citaDisponible.setEstado("Disponible");
                            citaDisponible.setFechaHora(fechaHora);
                            citaDisponible.setFolio("");
                            citaDisponible.setTipo("Consulta");
                            citaDisponible.setMedico(medico);
                            citaDisponible.setPaciente(null);

                            citasDisponibles.add(citaDisponible);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al cargar citas", e);
        }

        return citasDisponibles;
    }

    /**
     * Genera intervalos de 30 minutos entre la hora de inicio y la hora de fin.
     */
    private List<String> generarIntervalos(Time inicio, Time fin) {
        List<String> intervalos = new ArrayList<>();
        long inicioMillis = inicio.getTime();
        long finMillis = fin.getTime();
        long intervalo = 30 * 60 * 1000; // 30 minutos en milisegundos

        while (inicioMillis < finMillis) {
            Time actual = new Time(inicioMillis);
            intervalos.add(actual.toString()); // Guardar el intervalo
            inicioMillis += intervalo; // Avanzar 30 minutos
        }
        return intervalos;
    }



    @Override
    public List<Cita> consultarCitasPaciente(Paciente paciente2) throws PersistenciaException {
        List<Cita> citas = new ArrayList<>();

        String sql = "SELECT c.idCita, c.estado, c.fechaHoraProgramada, c.folio, c.tipo, "
                + "m.idMedico, m.nombre AS nombreMedico, m.apellidoPat AS apellidoPatMedico, "
                + "m.apellidoMat AS apellidoMatMedico, m.cedulaProf, m.especialidad, "
                + "p.idPaciente, p.nombre AS nombrePaciente, p.apellidoPat AS apellidoPatPaciente, "
                + "p.apellidoMat AS apellidoMatPaciente, p.correo, p.fechaNac, p.telefono "
                + "FROM CITAS c "
                + "JOIN MEDICOS m ON c.idMedico = m.idMedico "
                + "JOIN PACIENTES p ON c.idPaciente = p.idPaciente "
                + "JOIN HORARIOS_MEDICOS hm ON m.idMedico = hm.idMedico "
                + "JOIN HORARIOS h ON hm.idHorario = h.idHorario "
                + "WHERE c.idPaciente = ? "
                + "AND TIME(c.fechaHoraProgramada) BETWEEN h.horaInicio AND h.horaFin "
                + "AND c.fechaHoraProgramada >= NOW() "
                + "AND c.estado = 'Programada' "
                + "AND c.tipo = 'programada' "
                + "ORDER BY c.fechaHoraProgramada ASC";

        try (Connection con = this.conexionBD.crearConexion(); PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, paciente2.getUsuario().getIdUsuario());

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    // Crear objeto Usuario para Medico
                    Usuario usuarioMedico = new Usuario();
                    usuarioMedico.setIdUsuario(rs.getInt("idMedico"));

                    // Crear objeto Medico y asociarle el Usuario
                    Medico medico = new Medico();
                    medico.setUsuario(usuarioMedico);
                    medico.setNombre(rs.getString("nombreMedico"));
                    medico.setApellidoPaterno(rs.getString("apellidoPatMedico"));
                    medico.setApellidoMaterno(rs.getString("apellidoMatMedico"));
                    medico.setCedulaProfesional(rs.getString("cedulaProf"));
                    medico.setEspecialidad(rs.getString("especialidad"));

                    // Crear objeto Usuario para Paciente
                    Usuario usuarioPaciente = new Usuario();
                    usuarioPaciente.setIdUsuario(rs.getInt("idPaciente"));

                    // Crear objeto Paciente y asociarle el Usuario
                    Paciente paciente = new Paciente();
                    paciente.setUsuario(usuarioPaciente);
                    paciente.setNombre(rs.getString("nombrePaciente"));
                    paciente.setApellidoPaterno(rs.getString("apellidoPatPaciente"));
                    paciente.setApellidoMaterno(rs.getString("apellidoMatPaciente"));
                    paciente.setCorreo(rs.getString("correo"));
                    paciente.setFechaNacimiento(rs.getDate("fechaNac").toLocalDate());
                    paciente.setTelefono(rs.getString("telefono"));

                    // Crear objeto Cita
                    Cita nuevaCita = new Cita();
                    nuevaCita.setIdCita(rs.getInt("idCita"));
                    nuevaCita.setEstado(rs.getString("estado"));
                    nuevaCita.setFechaHora(rs.getTimestamp("fechaHoraProgramada").toLocalDateTime());
                    nuevaCita.setFolio(rs.getString("folio"));
                    nuevaCita.setTipo(rs.getString("tipo"));
                    nuevaCita.setMedico(medico);
                    nuevaCita.setPaciente(paciente);

                    // Agregar la cita a la lista
                    citas.add(nuevaCita);
                }
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al consultar las citas programadas", e);
        }
        return citas;
    }

}
