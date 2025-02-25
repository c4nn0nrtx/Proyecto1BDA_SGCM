package DAO;

import Entidades.Paciente;
import Exception.PersistenciaException;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad
 * Paciente.
 *
 * @author Ramon Valencia
 */
public interface IPacienteDAO {

    /**
     * Agrega un nuevo paciente a la base de datos.
     *
     * @param paciente El paciente que se va a agregar.
     * @return El paciente agregado, incluyendo el ID generado por la base de
     * datos.
     * @throws PersistenciaException Si ocurre un error durante la persistencia
     * del paciente.
     */
    public Paciente agregarPaciente(Paciente paciente) throws PersistenciaException;

    /**
     * Consulta un paciente por su ID.
     *
     * @param id El ID del paciente que se va a consultar.
     * @return El paciente consultado, o null si no se encuentra.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    public Paciente consultarPacientePorId(int id) throws PersistenciaException;

    /**
     * Actualiza los atributos de un paciente .
     *
     * @param id
     * @param paciente
     * @return El paciente actualizado.
     * @throws PersistenciaException
     */
    public Paciente actualizarPacientePorID(int id, Paciente paciente) throws PersistenciaException;

    /**
     * Consulta un paciente por su número de celular.
     *
     * @param celular El número de celular del paciente que se va a consultar.
     * @return El paciente consultado, o null si no se encuentra.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    public Paciente consultarPacientePorCelular(String celular) throws PersistenciaException;
}
