package DAO;

import Conexion.IConexionBD;
import Entidades.Horario;
import Exception.PersistenciaException;
import static com.mysql.cj.conf.PropertyKey.logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Objeto de acceso a datos (DAO) para la entidad Horario. Proporciona métodos
 * para consultar horarios.
 *
 * @author Ramon Valencia
 */
public class HorarioDAO implements IHorarioDAO {

    private IConexionBD conexionBD;
    private static final Logger logger = Logger.getLogger(MedicoDAO.class.getName());

    /**
     * Constructor de la clase HorarioDAO.
     *
     * @param conexion La conexión a la base de datos.
     */
    public HorarioDAO(IConexionBD conexion) {
        this.conexionBD = conexion;
    }

    /**
     * Consulta un horario por su ID.
     *
     * @param id El ID del horario que se va a consultar.
     * @return El objeto Horario correspondiente al ID, o null si no se
     * encuentra.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    @Override
    public Horario consultarHorarioPorId(int id) throws PersistenciaException, SQLException {
        Horario horario = null;
        String consultaSQL = "SELECT idHorario, diaSemana, horaInicio, horaFin FROM HORARIOS WHERE idHorario = ?;";

        try (Connection con = this.conexionBD.crearConexion(); PreparedStatement ps = con.prepareStatement(consultaSQL, PreparedStatement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    horario = new Horario();
                    horario.setIdHorario(id);
                    horario.setDiaSemana(rs.getString("diaSemana"));

                    LocalTime horaInicio = rs.getObject("horaInicio", LocalTime.class);
                    horario.setHoraInicio(horaInicio);

                    LocalTime horaFin = rs.getObject("horaFin", LocalTime.class);
                    horario.setHoraFin(horaFin);

                    return horario;

                } else {
                    logger.severe("No se encontro horario con id " + id);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(HorarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
