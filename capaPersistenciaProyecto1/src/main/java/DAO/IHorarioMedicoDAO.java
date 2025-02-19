
package DAO;
import Entidades.Medico;
import Exception.PersistenciaException;
import java.time.LocalDateTime;
import java.util.List;
/**
 * Esta interfaz representa los metodos de un Hoarario DAO
 * @author Sebastian Moreno
 */
public interface IHorarioMedicoDAO {
    public List<Medico> obtenerMedicosDisponibles(LocalDateTime fechaHora) throws PersistenciaException;
    
}
