package DAO;

import Conexion.IConexionBD;
import Entidades.Cita;
import Entidades.Consulta;
import Entidades.Paciente;
import Exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase representa un objeto de acceso a datos (DAO) para la entidad
 * Consulta. Proporciona métodos para agregar y obtener consultas médicas.
 *
 * @author Ramon Valencia, Sebastian
 */
public class ConsultaDAO implements IConsultaDAO {

    private IConexionBD conexionBD;

    /**
     * Constructor de la clase ConsultaDAO.
     *
     * @param conexion La conexión a la base de datos.
     */
    public ConsultaDAO(IConexionBD conexion) {
        this.conexionBD = conexion;
    }

    private static final Logger logger = Logger.getLogger(ConsultaDAO.class.getName());

    /**
     * Agrega una nueva consulta médica a la base de datos.
     *
     * @param consulta La consulta médica que se va a agregar.
     * @return La consulta médica agregada, incluyendo el ID generado por la
     * base de datos.
     * @throws PersistenciaException Si ocurre un error durante la persistencia
     * de la consulta.
     */
    @Override
    public Consulta agregarConsulta(Consulta consulta) throws PersistenciaException {
        String consultaSQL = "INSERT INTO CONSULTAS (idCita, estado, diagnostico, tratamiento, observaciones, fechaHoraEntrada) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = this.conexionBD.crearConexion(); PreparedStatement ps = con.prepareStatement(consultaSQL, PreparedStatement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, consulta.getCita().getIdCita());
            ps.setString(2, consulta.getEstado());
            ps.setString(3, consulta.getDiagnostico());
            ps.setString(4, consulta.getTratamiento());
            ps.setString(5, consulta.getObservaciones());
            ps.setObject(6, consulta.getFechaHora());

            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas == 0) {
                logger.severe("ERROR: Hubo un fallo al agregar la consulta medica, no se inserto niguna fila.");
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    consulta.setIdConsulta(generatedKeys.getInt(1));
                    logger.info("Consulta medica agregada exitosamente");
                } else {
                    logger.severe("ERROR: La agregacion de la consulta medica fallo, no se pudo obtener el id.");
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Error al registrar una consulta medica en la base de datos.");
        }
        return consulta;

    }

    /**
     * Obtiene la consulta médica asociada a una cita específica.
     *
     * @param cita La cita cuya consulta se va a obtener.
     * @return La consulta médica asociada a la cita, o null si no existe.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    @Override
    public Consulta obtenerConsultasPaciente(Cita cita) throws PersistenciaException {
        String consultaSQL = "SELECT estado, diagnostico, tratamiento, observaciones, fechaHoraEntrada "
                + "FROM CONSULTAS WHERE idCita = ?";

        try (Connection con = this.conexionBD.crearConexion(); PreparedStatement ps = con.prepareStatement(consultaSQL, PreparedStatement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, cita.getIdCita());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Consulta consulta = new Consulta();
                    consulta.setEstado(rs.getString("estado"));
                    consulta.setDiagnostico(rs.getString("diagnostico"));
                    consulta.setTratamiento(rs.getString("tratamiento"));
                    consulta.setObservaciones(rs.getString("observaciones"));
                    consulta.setFechaHora(rs.getTimestamp("fechaHoraEntrada").toLocalDateTime());
                    return consulta;
                }
            } catch (SQLException ex) {
                Logger.getLogger(ConsultaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
