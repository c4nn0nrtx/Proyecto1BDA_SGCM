package DAO;

import Entidades.Horario_Medico;
import Entidades.Medico;
import Exception.PersistenciaException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad
 * HorarioMedico.
 *
 * @author Sebastian Moreno, Ramon Valencia
 */
public interface IHorarioMedicoDAO {

    /**
     * Obtiene una lista de médicos disponibles en una fecha y hora específica.
     *
     * @param fechaHora La fecha y hora para la cual se va a verificar la
     * disponibilidad de los médicos.
     * @return Una lista de objetos Medico que están disponibles en la fecha y
     * hora especificada.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    public List<Medico> obtenerMedicosDisponibles(LocalDateTime fechaHora) throws PersistenciaException;

    /**
     * Obtiene una lista de horarios de médicos.
     *
     * @return Una lista de objetos Horario_Medico.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     * @throws SQLException Si ocurre un error durante la consulta a la base de
     * datos.
     */
    public List<Horario_Medico> obtenerHorariosMedicos() throws PersistenciaException, SQLException;

    /**
     * Verifica si un horario está disponible para un médico específico.
     *
     * @param horarioMedico El objeto Horario_Medico que contiene la información
     * del horario y el médico.
     * @return true si el horario está disponible, false si no lo está.
     */
    public boolean consultarHorariosDisponibles(Horario_Medico horarioMedico);

}
