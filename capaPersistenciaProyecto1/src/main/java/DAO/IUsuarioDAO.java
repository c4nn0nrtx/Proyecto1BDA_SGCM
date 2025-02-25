package DAO;

import Entidades.Usuario;
import Exception.PersistenciaException;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad
 * Usuario.
 *
 * @author Ramon Valencia
 */
public interface IUsuarioDAO {

    /**
     * Consulta un usuario por su ID.
     *
     * @param id El ID del usuario que se va a consultar.
     * @return El usuario consultado, o null si no se encuentra.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    public Usuario consultarUsuarioPorId(int id) throws PersistenciaException;

    /**
     * Agrega un nuevo usuario a la base de datos.
     *
     * @param usuario El usuario que se va a agregar.
     * @return El usuario agregado, incluyendo el ID generado por la base de
     * datos.
     * @throws PersistenciaException Si ocurre un error durante la persistencia
     * del usuario.
     */
    public Usuario agregarUsuario(Usuario usuario) throws PersistenciaException;

    /**
     * Autentica un usuario por sus credenciales.
     *
     * @param usuario El usuario con las credenciales que se van a verificar.
     * @return El usuario autenticado si las credenciales son válidas, o null si
     * no lo son.
     * @throws PersistenciaException Si ocurre un error durante la
     * autenticación.
     */
    public Usuario autenticarUsuario(Usuario usuario) throws PersistenciaException;

    /**
     * Consulta el ID de un usuario por sus datos.
     *
     * @param usuario El usuario cuyos datos se van a utilizar para la consulta.
     * @return El ID del usuario, o -1 si no se encuentra.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    public int consultarIdUsuario(Usuario usuario) throws PersistenciaException;

    /**
     * Verifica si un usuario es médico.
     *
     * @param idUsuario El ID del usuario que se va a verificar.
     * @return true si el usuario es médico, false si no lo es.
     * @throws PersistenciaException Si ocurre un error durante la verificación.
     */
    public boolean esMedico(int idUsuario) throws PersistenciaException;

    /**
     * Verifica si un usuario es paciente.
     *
     * @param idUsuario El ID del usuario que se va a verificar.
     * @return true si el usuario es paciente, false si no lo es.
     * @throws PersistenciaException Si ocurre un error durante la verificación.
     */
    public boolean esPaciente(int idUsuario) throws PersistenciaException;

}
