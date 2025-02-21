
package DAO;

import Conexion.IConexionBD;
import Entidades.Medico;
import Exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Esta clase representa el horario de un medico.
 * @author Sebastian Moreno
 */
public class HorarioMedicoDAO implements IHorarioMedicoDAO {

    private IConexionBD conexion;
    private static final Logger logger = Logger.getLogger(MedicoDAO.class.getName());
    /**
     * Constructor que inicializa la conexion con la base de datos.
     * @param conexion
     */
    public HorarioMedicoDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }

    /**
     * Metodo auxiliar para obtener dias en español
     * @param dia
     * @return un string del dia en español.
     */
    public static String obtenerDiaEnEspanol(DayOfWeek dia) {
    switch (dia) {
        case MONDAY: return "Lunes";
        case TUESDAY: return "Martes";
        case WEDNESDAY: return "Miercoles";
        case THURSDAY: return "Jueves";
        case FRIDAY: return "Viernes";
        case SATURDAY: return "Sábado";
        case SUNDAY: return "Domingo";
        default: return "";
    }
}

    /**
     * Metodo para obtener medicos disponibles en una hora especifica.
     * @param fechaHora
     * @return Una lista de medicos en caso de encontrar.
     * @throws PersistenciaException
     */
    @Override
    public List<Medico> obtenerMedicosDisponibles(LocalDateTime fechaHora) throws PersistenciaException {
        List<Medico> medicosDisponibles = new ArrayList<>();
        String sql = "SELECT m.* "
                + "FROM Medicos m "
                + "INNER JOIN horarios_medicos hm ON hm.idMedico = m.idMedico "
                + "INNER JOIN horarios as h on h.idHorario = hm.idHorario "
                + "WHERE h.diaSemana = ? AND ? BETWEEN h.horaInicio AND h.horaFin "
                + "AND m.estado = 'activo'";

        try (Connection con = conexion.crearConexion(); PreparedStatement stmt = con.prepareStatement(sql)) {

            // Extraer el día de la semana de la fecha solicitada
            DayOfWeek diaSemana = fechaHora.getDayOfWeek();
            String diaSemanaBD = obtenerDiaEnEspanol(diaSemana); // utilizo metodo para convertir "MONDAY" a "Lunes" para mejor uso.
            stmt.setString(1, diaSemanaBD); // Se supone que en la BD se guarda como texto (ej. "Lunes")
            stmt.setTime(2, Time.valueOf(fechaHora.toLocalTime()));

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Medico medico = new Medico();
                medico.setId(rs.getInt("idMedico"));
                medico.setNombre(rs.getString("nombre"));
                medico.setApellidoPaterno(rs.getString("apellidoPat"));
                medico.setApellidoMaterno(rs.getString("apellidoMat"));
                medico.setEspecialidad(rs.getString("especialidad"));
                medico.setCedulaProfesional(rs.getString("cedulaProf"));
                medico.setEstado(rs.getString("estado"));
                medicosDisponibles.add(medico);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new PersistenciaException("Hubo un error consultando a los medicos." + ex.getSQLState());
        }
        return medicosDisponibles;
    }

}
