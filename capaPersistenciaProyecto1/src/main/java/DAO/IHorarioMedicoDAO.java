
package DAO;
import Entidades.Horario_Medico;
import Entidades.Medico;
import Exception.PersistenciaException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
/**
 * Esta interfaz representa los metodos de un Hoarario DAO
 * @author Sebastian Moreno
 */
public interface IHorarioMedicoDAO {

    /**
     * Obtiene los medicos disponibles en el horario dado.
     * @param fechaHora
     * @return
     * @throws PersistenciaException
     */
    public List<Medico> obtenerMedicosDisponibles(LocalDateTime fechaHora) throws PersistenciaException;
    
    public List<Horario_Medico> obtenerHorariosMedicos() throws PersistenciaException, SQLException;
    
    public boolean consultarHorariosDisponibles(Horario_Medico horarioMedico);
    
}
