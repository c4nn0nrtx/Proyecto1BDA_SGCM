package DAO;

import Entidades.Medico;
import Exception.PersistenciaException;
import java.util.List;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad Medico.
 *
 * @author Sebastian Moreno
 */
public interface IMedicoDAO {

    /**
     * Consulta un médico por su ID.
     *
     * @param id El ID del médico que se va a consultar.
     * @return El objeto Medico correspondiente al ID, o null si no se
     * encuentra.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    public Medico consultarMedicoPorId(int id) throws PersistenciaException;

    /**
     * Obtiene una lista de médicos filtrados por especialidad.
     *
     * @param especialidad La especialidad por la que se van a filtrar los
     * médicos.
     * @return Una lista de objetos Medico que tienen la especialidad
     * especificada.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    public List<Medico> obtenerPorEspecialidad(String especialidad) throws PersistenciaException;

    /**
     * Actualiza el estado de un médico.
     *
     * @param medico El objeto Medico cuya información se va a actualizar.
     * @param estado El nuevo estado del médico.
     * @return true si el estado se actualizó correctamente, false si no se pudo
     * actualizar.
     * @throws PersistenciaException Si ocurre un error durante la
     * actualización.
     */
    public boolean actualizarEstadoMedico(Medico medico, String estado) throws PersistenciaException;

    /**
     * Obtiene una lista de médicos con horario asignado.
     *
     * @return Una lista de objetos Medico que tienen un horario asignado.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    public List<Medico> obtenerMedicosConHorario() throws PersistenciaException;

    /**
     * Obtiene un médico por su nombre completo.
     *
     * @param nombreCompleto El nombre completo del médico que se va a buscar.
     * @return El objeto Medico correspondiente al nombre completo, o null si no
     * se encuentra.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    public Medico obtenerMedicoPorNombre(String nombreCompleto) throws PersistenciaException;
}
