package DAO;

import Conexion.IConexionBD;
import Entidades.Cita;
import Entidades.Medico;
import Entidades.Paciente;
import Entidades.Usuario;
import Exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
    public Cita agendarCitaProgramada(Cita cita) throws PersistenciaException {
        String consultaSQL = "INSERT INTO CITAS (estado, fechaHoraProgramada, folio, tipo, idMedico, idPaciente) "
                + "VALUES(?, ?, ?, ?, ?, ?)";  // 🔹 Eliminada la coma extra

        try (Connection con = this.conexionBD.crearConexion(); PreparedStatement ps = con.prepareStatement(consultaSQL, PreparedStatement.RETURN_GENERATED_KEYS)) {

            if (cita.getEstado() == null || cita.getEstado().trim().isEmpty()) {
                cita.setEstado("Programada"); // Asigna un estado por defecto
                cita.setTipo("programada");
            }

            ps.setString(1, cita.getEstado());
            ps.setObject(2, cita.getFechaHora());
            ps.setString(3, "");
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

    @Override
    public Cita agendarCitaEmergencia(Cita cita) throws PersistenciaException {
        String consultaSQL = "INSERT INTO CITAS (estado, fechaHoraProgramada, folio, tipo, idMedico, idPaciente) "
                + "VALUES(?, ?, ?, ?, ?, ?)";

        try (Connection con = this.conexionBD.crearConexion(); PreparedStatement ps = con.prepareStatement(consultaSQL, PreparedStatement.RETURN_GENERATED_KEYS)) {

            if (cita.getEstado() == null || cita.getEstado().trim().isEmpty()) {
                cita.setEstado("Programada");
                cita.setTipo("emergencia");
            }

            String folioGenerado = generarFolio();

            ps.setString(1, cita.getEstado());
            ps.setObject(2, cita.getFechaHora());
            ps.setString(3, folioGenerado);
            ps.setString(4, cita.getTipo());
            ps.setInt(5, cita.getMedico().getUsuario().getIdUsuario());
            ps.setInt(6, cita.getPaciente().getUsuario().getIdUsuario());

            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas == 0) {
                logger.severe("ERROR: No se insertó ninguna fila.");
                throw new PersistenciaException("No se pudo agendar la cita.");
            }

            // Obtener el ID generado
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    cita.setIdCita(generatedKeys.getInt(1));
                    logger.info("Cita agregada con ID: " + cita.getIdCita());
                } else {
                    logger.severe("ERROR: No se pudo obtener el ID de la cita.");
                    throw new PersistenciaException("No se pudo obtener el ID de la cita.");
                }
            }

            // Recuperar el folio de la base de datos
            String consultaFolio = "SELECT folio FROM CITAS WHERE idCita = ?";
            try (PreparedStatement psFolio = con.prepareStatement(consultaFolio)) {
                psFolio.setInt(1, cita.getIdCita());
                try (ResultSet rs = psFolio.executeQuery()) {
                    if (rs.next()) {
                        cita.setFolio(rs.getString("folio"));
                        System.out.println("Folio recuperado de la BD: " + cita.getFolio());
                    } else {
                        logger.severe("ERROR: No se pudo recuperar el folio.");
                        throw new PersistenciaException("No se pudo recuperar el folio.");
                    }
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Error al registrar una cita en la base de datos.");
        }

        return cita;
    }

    @Override
    public List<Cita> consultarCitasProgramadasAgenda(int idMedico) throws PersistenciaException {
        List<Cita> citas = new ArrayList<>();

        String sql = "SELECT DISTINCT "
                + "c.idCita, c.estado, c.fechaHoraProgramada, c.folio, c.tipo, "
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
                + "ORDER BY c.fechaHoraProgramada ASC;";

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

    @Override
    public List<Cita> consultarCitasEmergenciaAgenda(int idMedico) throws PersistenciaException {
        List<Cita> citas = new ArrayList<>();

        String sql = "SELECT DISTINCT "
                + "c.idCita, c.estado, c.fechaHoraProgramada, c.folio, c.tipo, "
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
                + "ORDER BY c.fechaHoraProgramada ASC;";

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

    public String generarFolio() throws SQLException, PersistenciaException {
        String nuevoFolio;
        boolean folioExiste;
        String consultaSQL = "SELECT COUNT(*) FROM CITAS WHERE folio = ?;";

        try (Connection con = this.conexionBD.crearConexion(); PreparedStatement ps = con.prepareStatement(consultaSQL)) {
            do {
                nuevoFolio = String.format("%08d", (int) (Math.random() * 100_000_000)); // Genera un número de 8 dígitos
                // Verificar si el folio ya existe en la BD
                ps.setString(1, nuevoFolio);
                try (ResultSet rs = ps.executeQuery()) {
                    rs.next();
                    folioExiste = rs.getInt(1) > 0; // Si COUNT(*) > 0, el folio ya existe
                }
            } while (folioExiste); // Repetir si el folio ya existe

            return nuevoFolio;

        } catch (SQLException ex) {
            Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, "Error en generarFolio", ex);
            throw ex;
        }
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
            // 1. Obtener los horarios del médico
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
                    boolean tieneHorarios = false;

                    while (rsHorario.next()) { // Recorremos todos los horarios del médico
                        tieneHorarios = true;

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

                        System.out.println("Horario encontrado para el médico: " + medico.getNombre() + " de " + horaInicio + " a " + horaFin);

                        // 2. Generar intervalos de 30 minutos
                        List<String> intervalos = generarIntervalos(horaInicio, horaFin);

                        // 3. Obtener citas ocupadas para ese horario del médico
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

                        // Obtener la fecha de consulta y la hora actual
                        LocalDate fechaConsulta = LocalDate.parse(fecha);
                        LocalTime horaActual = LocalTime.now();

                        // 4. Filtrar las citas disponibles y crear objetos Cita
                        for (String intervaloStr : intervalos) {
                            LocalTime intervalo = LocalTime.parse(intervaloStr);
                            LocalDateTime fechaHora = LocalDateTime.of(fechaConsulta, intervalo);

                            // Si la fecha de la cita es hoy y el horario ya pasó, se omite
                            if (fechaConsulta.isEqual(LocalDate.now()) && intervalo.isBefore(horaActual)) {
                                continue; // Saltar este horario
                            }

                            if (!ocupadas.contains(intervalo)) {
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

                    if (!tieneHorarios) {
                        System.out.println("No se encontraron horarios para el médico en ese día.");
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
    public Cita obtenerProximaCitaPendiente(int idPaciente) throws PersistenciaException {
        String sql = "SELECT c.idCita, c.estado, c.fechaHoraProgramada, c.folio, c.tipo, "
                + "m.idMedico, m.nombre AS nombreMedico, m.apellidoPat AS apellidoPatMedico, "
                + "m.apellidoMat AS apellidoMatMedico, m.cedulaProf, m.especialidad, "
                + "p.idPaciente, p.nombre AS nombrePaciente, p.apellidoPat AS apellidoPatPaciente, "
                + "p.apellidoMat AS apellidoMatPaciente, p.correo, p.fechaNac, p.telefono "
                + "FROM CITAS c "
                + "JOIN MEDICOS m ON c.idMedico = m.idMedico "
                + "JOIN PACIENTES p ON c.idPaciente = p.idPaciente "
                + "WHERE c.idPaciente = ? "
                + "AND c.estado IN ('Programada', 'No Atendida') "
                + "AND c.fechaHoraProgramada >= NOW() "
                + "ORDER BY c.fechaHoraProgramada ASC "
                + "LIMIT 1;"; // Obtiene la próxima cita más cercana

        try (Connection con = this.conexionBD.crearConexion(); PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, idPaciente);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Crear objeto Usuario para Medico
                    Usuario usuarioMedico = new Usuario();
                    usuarioMedico.setIdUsuario(rs.getInt("idMedico"));

                    // Crear objeto Medico
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

                    // Crear objeto Paciente
                    Paciente paciente = new Paciente();
                    paciente.setUsuario(usuarioPaciente);
                    paciente.setNombre(rs.getString("nombrePaciente"));
                    paciente.setApellidoPaterno(rs.getString("apellidoPatPaciente"));
                    paciente.setApellidoMaterno(rs.getString("apellidoMatPaciente"));
                    paciente.setCorreo(rs.getString("correo"));
                    paciente.setFechaNacimiento(rs.getDate("fechaNac").toLocalDate());
                    paciente.setTelefono(rs.getString("telefono"));

                    // Crear objeto Cita
                    Cita proximaCita = new Cita();
                    proximaCita.setIdCita(rs.getInt("idCita"));
                    proximaCita.setEstado(rs.getString("estado"));
                    proximaCita.setFechaHora(rs.getTimestamp("fechaHoraProgramada").toLocalDateTime());
                    proximaCita.setFolio(rs.getString("folio"));
                    proximaCita.setTipo(rs.getString("tipo"));
                    proximaCita.setMedico(medico);
                    proximaCita.setPaciente(paciente);

                    return proximaCita; // Retornar la próxima cita
                }
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al obtener la próxima cita del paciente", e);
        }
        return null; // No hay citas pendientes
    }

    @Override
    public Cita obtenerUltimaCita(int idPaciente) throws PersistenciaException {
        Cita ultimaCita = null;
        String sql = "SELECT "
                + "c.idCita, c.estado, c.fechaHoraProgramada, c.folio, c.tipo, "
                + "m.idMedico, m.nombre AS nombreMedico, m.apellidoPat AS apellidoPatMedico, m.apellidoMat AS apellidoMatMedico, "
                + "m.cedulaProf, m.especialidad, "
                + "p.idPaciente, p.nombre AS nombrePaciente, p.apellidoPat AS apellidoPatPaciente, p.apellidoMat AS apellidoMatPaciente, "
                + "p.correo, p.fechaNac, p.telefono "
                + "FROM CITAS c "
                + "JOIN MEDICOS m ON c.idMedico = m.idMedico "
                + "JOIN PACIENTES p ON c.idPaciente = p.idPaciente "
                + "WHERE c.idPaciente = ?  AND c.tipo = 'programada'"
                + "AND c.ESTADO = 'programada'"
                + "AND c.fechaHoraProgramada > NOW() "
                + // Filtra solo citas futuras
                "ORDER BY c.fechaHoraProgramada ASC "
                + // Ordena por la fecha más cercana
                "LIMIT 1";

        try (Connection con = this.conexionBD.crearConexion(); PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, idPaciente);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Crear objeto Cita
                    ultimaCita = new Cita();
                    ultimaCita.setIdCita(rs.getInt("idCita"));
                    ultimaCita.setEstado(rs.getString("estado"));
                    ultimaCita.setFechaHora(rs.getTimestamp("fechaHoraProgramada").toLocalDateTime());
                    ultimaCita.setFolio(rs.getString("folio"));
                    ultimaCita.setTipo(rs.getString("tipo"));

                    // Crear objeto Medico
                    Medico medico = new Medico();
                    medico.setNombre(rs.getString("nombreMedico"));
                    medico.setApellidoPaterno(rs.getString("apellidoPatMedico"));
                    medico.setApellidoMaterno(rs.getString("apellidoMatMedico"));
                    medico.setCedulaProfesional(rs.getString("cedulaProf"));
                    medico.setEspecialidad(rs.getString("especialidad"));

                    // Crear objeto Paciente
                    Paciente paciente = new Paciente();
                    paciente.setNombre(rs.getString("nombrePaciente"));
                    paciente.setApellidoPaterno(rs.getString("apellidoPatPaciente"));
                    paciente.setApellidoMaterno(rs.getString("apellidoMatPaciente"));
                    paciente.setCorreo(rs.getString("correo"));
                    paciente.setFechaNacimiento(rs.getDate("fechaNac").toLocalDate());
                    paciente.setTelefono(rs.getString("telefono"));

                    // Asignar médico y paciente a la cita
                    ultimaCita.setMedico(medico);
                    ultimaCita.setPaciente(paciente);
                }
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al obtener la última cita", e);
        }
        return ultimaCita;
    }

    @Override
    public List<Cita> consultarCitasPaciente(Paciente paciente2) throws PersistenciaException {
        List<Cita> citas = new ArrayList<>();

        String sql = "SELECT DISTINCT c.idCita, c.estado, c.fechaHoraProgramada, c.folio, c.tipo, "
                + "m.idMedico, m.nombre AS nombreMedico, m.apellidoPat AS apellidoPatMedico, "
                + "m.apellidoMat AS apellidoMatMedico, m.cedulaProf, m.especialidad, "
                + "p.idPaciente, p.nombre AS nombrePaciente, p.apellidoPat AS apellidoPatPaciente, "
                + "p.apellidoMat AS apellidoMatPaciente, p.correo, p.fechaNac, p.telefono "
                + "FROM CITAS c "
                + "JOIN MEDICOS m ON c.idMedico = m.idMedico "
                + "JOIN PACIENTES p ON c.idPaciente = p.idPaciente "
                + "JOIN HORARIOS_MEDICOS hm ON m.idMedico = hm.idMedico "
                + "JOIN HORARIOS h ON hm.idHorario = h.idHorario "
                + "WHERE c.idPaciente = ? ";

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
                    System.out.println(nuevaCita);
                }
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al consultar las citas programadas", e);
        }
        return citas;
    }

    @Override
    public boolean cancelarCita(int idCita) throws PersistenciaException {
        String verificarSql = "SELECT fechaHoraProgramada FROM Citas WHERE idcita = ?";
        String cancelarSql = "UPDATE Citas SET estado = 'Cancelada' WHERE idcita = ?";

        try (Connection conn = this.conexionBD.crearConexion(); PreparedStatement verificarStmt = conn.prepareStatement(verificarSql); PreparedStatement cancelarStmt = conn.prepareStatement(cancelarSql)) {

            verificarStmt.setInt(1, idCita);
            ResultSet rs = verificarStmt.executeQuery();

            if (rs.next()) {
                Timestamp fechaCreacion = rs.getTimestamp("fechaHoraProgramada");
                Timestamp ahora = new Timestamp(System.currentTimeMillis());

                // Calculamos la diferencia en horas
                long diferenciaHoras = (ahora.getTime() - fechaCreacion.getTime()) / (1000 * 60 * 60);

                if (diferenciaHoras <= 24) {
                    // Solo si está dentro de las 24 horas, se cancela
                    cancelarStmt.setInt(1, idCita);
                    int filasAfectadas = cancelarStmt.executeUpdate();
                    return filasAfectadas > 0;
                } else {
                    return false; // No se puede cancelar porque pasó el tiempo permitido
                }
            }
            return false; // No se encontró la cita

        } catch (SQLException e) {
            throw new PersistenciaException("Error al cancelar la cita: " + e.getMessage(), e);
        }
    }

    @Override
    public Cita obtenerUltimaCitaEmergencia(int idPaciente) throws PersistenciaException {
        Cita ultimaCita = null;
        String sql = "SELECT "
                + "c.idCita, c.estado, c.fechaHoraProgramada, c.folio, c.tipo, "
                + "m.idMedico, m.nombre AS nombreMedico, m.apellidoPat AS apellidoPatMedico, m.apellidoMat AS apellidoMatMedico, "
                + "m.cedulaProf, m.especialidad, "
                + "p.idPaciente, p.nombre AS nombrePaciente, p.apellidoPat AS apellidoPatPaciente, p.apellidoMat AS apellidoMatPaciente, "
                + "p.correo, p.fechaNac, p.telefono "
                + "FROM CITAS c "
                + "JOIN MEDICOS m ON c.idMedico = m.idMedico "
                + "JOIN PACIENTES p ON c.idPaciente = p.idPaciente "
                + "WHERE c.idPaciente = ?  AND c.tipo = 'emergencia'"
                + "AND c.ESTADO = 'programada'"
                + "AND c.fechaHoraProgramada > NOW() "
                + // Filtra solo citas futuras
                "ORDER BY c.fechaHoraProgramada ASC "
                + // Ordena por la fecha más cercana
                "LIMIT 1";

        try (Connection con = this.conexionBD.crearConexion(); PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, idPaciente);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Crear objeto Cita
                    ultimaCita = new Cita();
                    ultimaCita.setIdCita(rs.getInt("idCita"));
                    ultimaCita.setEstado(rs.getString("estado"));
                    ultimaCita.setFechaHora(rs.getTimestamp("fechaHoraProgramada").toLocalDateTime());
                    ultimaCita.setFolio(rs.getString("folio"));
                    ultimaCita.setTipo(rs.getString("tipo"));

                    // Crear objeto Medico
                    Medico medico = new Medico();
                    medico.setNombre(rs.getString("nombreMedico"));
                    medico.setApellidoPaterno(rs.getString("apellidoPatMedico"));
                    medico.setApellidoMaterno(rs.getString("apellidoMatMedico"));
                    medico.setCedulaProfesional(rs.getString("cedulaProf"));
                    medico.setEspecialidad(rs.getString("especialidad"));

                    // Crear objeto Paciente
                    Paciente paciente = new Paciente();
                    paciente.setNombre(rs.getString("nombrePaciente"));
                    paciente.setApellidoPaterno(rs.getString("apellidoPatPaciente"));
                    paciente.setApellidoMaterno(rs.getString("apellidoMatPaciente"));
                    paciente.setCorreo(rs.getString("correo"));
                    paciente.setFechaNacimiento(rs.getDate("fechaNac").toLocalDate());
                    paciente.setTelefono(rs.getString("telefono"));

                    // Asignar médico y paciente a la cita
                    ultimaCita.setMedico(medico);
                    ultimaCita.setPaciente(paciente);
                }
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al obtener la última cita", e);
        }
        return ultimaCita;
    }

    @Override
    public Cita consultarCitaPorFolio(String folio) throws SQLException, PersistenciaException {
        String consultaSQL = "SELECT idCita, estado, fechaHoraProgramada, folio, tipo, idMedico, idPaciente "
                + "FROM CITAS WHERE folio = ?";
        Cita cita = null;
        Medico medico = null;
        Paciente paciente = null;
        try (Connection con = this.conexionBD.crearConexion(); PreparedStatement ps = con.prepareStatement(consultaSQL)) {

            ps.setString(1, folio);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // Crear objeto Cita
                    cita = new Cita();
                    cita.setIdCita(rs.getInt("idCita"));
                    cita.setEstado(rs.getString("estado"));
                    cita.setFechaHora(rs.getTimestamp("fechaHoraProgramada").toLocalDateTime());
                    cita.setFolio(rs.getString("folio"));
                    cita.setTipo(rs.getString("tipo"));
                    cita.setMedico(medico);
                    cita.setPaciente(paciente);
                }
            }
        }
        return cita;
    }

    @Override
    public Cita consultarCitaPorFecha(String nombrePaciente, String apellidoPat, String apellidoMat, LocalDateTime fechaHora) throws PersistenciaException {
        String sql = "SELECT c.idCita, c.estado, c.fechaHoraProgramada, c.folio, c.tipo, "
                + "m.idMedico, m.nombre AS nombreMedico, m.apellidoPat AS apellidoPatMedico, "
                + "m.apellidoMat AS apellidoMatMedico, m.cedulaProf, m.especialidad, "
                + "p.idPaciente, p.nombre AS nombrePaciente, p.apellidoPat AS apellidoPatPaciente, "
                + "p.apellidoMat AS apellidoMatPaciente, p.correo, p.fechaNac, p.telefono "
                + "FROM CITAS c "
                + "JOIN MEDICOS m ON c.idMedico = m.idMedico "
                + "JOIN PACIENTES p ON c.idPaciente = p.idPaciente "
                + "WHERE p.nombre = ? AND p.apellidoPat = ? AND p.apellidoMat = ? "
                + "AND c.fechaHoraProgramada = ? "
                + "LIMIT 1";  // Solo obtenemos una cita exacta

        try (Connection con = this.conexionBD.crearConexion(); PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, nombrePaciente);
            stmt.setString(2, apellidoPat);
            stmt.setString(3, apellidoMat);
            stmt.setTimestamp(4, Timestamp.valueOf(fechaHora));  // Comparación exacta con fecha y hora

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
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
                    Paciente pacienteEncontrado = new Paciente();
                    pacienteEncontrado.setUsuario(usuarioPaciente);
                    pacienteEncontrado.setNombre(rs.getString("nombrePaciente"));
                    pacienteEncontrado.setApellidoPaterno(rs.getString("apellidoPatPaciente"));
                    pacienteEncontrado.setApellidoMaterno(rs.getString("apellidoMatPaciente"));
                    pacienteEncontrado.setCorreo(rs.getString("correo"));
                    pacienteEncontrado.setFechaNacimiento(rs.getDate("fechaNac").toLocalDate());
                    pacienteEncontrado.setTelefono(rs.getString("telefono"));

                    // Crear objeto Cita
                    Cita citaEncontrada = new Cita();
                    citaEncontrada.setIdCita(rs.getInt("idCita"));
                    citaEncontrada.setEstado(rs.getString("estado"));
                    citaEncontrada.setFechaHora(rs.getTimestamp("fechaHoraProgramada").toLocalDateTime());
                    citaEncontrada.setFolio(rs.getString("folio"));
                    citaEncontrada.setTipo(rs.getString("tipo"));
                    citaEncontrada.setMedico(medico);
                    citaEncontrada.setPaciente(pacienteEncontrado);

                    return citaEncontrada;
                }
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al consultar la cita", e);
        }

        return null;  // Si no hay cita, devuelve null
    }

}
