/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.IConexionBD;
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

    @Override
    public Cita agendarCita(Cita cita) throws PersistenciaException {
        String consultaSQL = "INSERT INTO CITAS (estado, fechaHoraProgramada, folio, tipo, idMedico, idPaciente) "
                + "VALUES(?, ?, ?, ?, ?, ?)";  // 🔹 Eliminada la coma extra

        try (Connection con = this.conexionBD.crearConexion(); PreparedStatement ps = con.prepareStatement(consultaSQL, PreparedStatement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, cita.getEstado());
            ps.setObject(2, cita.getFechaHora());
            ps.setString(3, generarFolio());
            ps.setString(4, cita.getTipo());
            ps.setInt(5, cita.getMedico().getUsuario().getIdUsuario());
            ps.setInt(6, cita.getPaciente().getUsuario().getIdUsuario());
            System.out.println("ID Médico: " + cita.getMedico().getUsuario().getIdUsuario());
            System.out.println("ID PACIENTE: " + cita.getPaciente().getUsuario().getIdUsuario());

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

    public List<Cita> consultarCitasProgramadasAgenda(Cita cita, Horario_Medico horario) throws PersistenciaException {
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
                + "AND DATE(c.fechaHoraProgramada) = ? "
                + "AND TIME(c.fechaHoraProgramada) BETWEEN h.horaInicio AND h.horaFin "
                + "AND c.estado = 'Programada'";

        try (Connection con = this.conexionBD.crearConexion(); PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, cita.getMedico().getUsuario().getIdUsuario());
            stmt.setDate(2, java.sql.Date.valueOf(cita.getFechaHora().toLocalDate()));

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    // Crear objeto Usuario para Medico
                    Usuario usuarioMedico = new Usuario();
                    usuarioMedico.setIdUsuario(rs.getInt("idMedico"));  // Asignar ID del médico

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
                    usuarioPaciente.setIdUsuario(rs.getInt("idPaciente"));  // Asignar ID del paciente

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
    
    public String generarFolio() throws SQLException{
        String consultaSQL = "SELECT folio FROM CITAS ORDER BY folio DSC LIMIT 1;";
        
        try (Connection con = this.conexionBD.crearConexion(); PreparedStatement ps = con.prepareStatement(consultaSQL)) {
            
            try (ResultSet rs = ps.executeQuery()) {

            String nuevoFolio;
            if (rs.next()) { // Verifica si hay un resultado
                String folioActual = rs.getString("folio"); // Obtiene el último folio
                int numeroFolio = Integer.parseInt(folioActual); // Convierte a entero
                nuevoFolio = String.format("%05d", numeroFolio + 1); // Aumenta y formatea a 5 dígitos
            } else {
                nuevoFolio = "00001"; // Si no hay registros, empieza en 00001
            }
            return nuevoFolio; // Retorna el nuevo folio

            }
        } catch (PersistenciaException ex) {
            Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}