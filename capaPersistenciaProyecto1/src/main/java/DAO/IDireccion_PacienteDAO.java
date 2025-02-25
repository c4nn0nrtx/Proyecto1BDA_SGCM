package DAO;

import Entidades.Direccion_Paciente;
import Exception.PersistenciaException;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad
 * Direccion_Paciente.
 *
 * @author Ramon Valencia
 */
public interface IDireccion_PacienteDAO {

    /**
     * Agrega una nueva dirección de paciente a la base de datos.
     *
     * @param direccion La dirección de paciente que se va a agregar.
     * @return La dirección de paciente agregada, incluyendo el ID generado por
     * la base de datos.
     * @throws PersistenciaException Si ocurre un error durante la persistencia
     * de la dirección.
     */
    public Direccion_Paciente agregarDireccion(Direccion_Paciente direccion) throws PersistenciaException;

    /**
     * Consulta una dirección de paciente por su ID.
     *
     * @param id El ID de la dirección que se va a consultar.
     * @return La dirección de paciente consultada, o null si no se encuentra.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    public Direccion_Paciente consultarDireccionPorId(int id) throws PersistenciaException;

    /**
     * Consulta el ID de una dirección de paciente por sus datos.
     *
     * @param direccion La dirección de paciente cuyos datos se van a utilizar
     * para la consulta.
     * @return El ID de la dirección, o -1 si no se encuentra.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    public int consultaIdDireccion(Direccion_Paciente direccion) throws PersistenciaException;

    /**
     * Actualiza la información de una dirección de paciente en la base de
     * datos.
     *
     * @param direccion La dirección de paciente con la información actualizada.
     * @return La dirección de paciente actualizada.
     * @throws PersistenciaException Si ocurre un error durante la
     * actualización.
     */
    public Direccion_Paciente actualizarDireccion(Direccion_Paciente direccion) throws PersistenciaException;

}
