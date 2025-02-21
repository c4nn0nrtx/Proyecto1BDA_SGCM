
package DAO;

import Entidades.Usuario;
import Exception.PersistenciaException;

/**
 *  Esta interfaz representa los metodos DAO de usuarios.
 * @author Ramon Valencia
 */
public interface IUsuarioDAO {
    /**
     * Consulta un usuario por id.
     * @param id
     * @return el usuario consultado.
     * @throws PersistenciaException si el usuario no existe.
     */
     public Usuario consultarUsuarioPorId(int id) throws PersistenciaException;
     /**
      * Este metodo agrega un usuario.    
      * @param usuario
      * @return El usuario agregado para su uso en BO
      * @throws PersistenciaException si no se puede agregar
      */
     public Usuario agregarUsuario(Usuario usuario) throws PersistenciaException;
     /**
      * Autentica los datos de un usuario.
      * @param usuario 
      * @return verdadero si las credenciales son validas
      * @throws PersistenciaException si algo falla.
      */
     public boolean autenticarUsuario(Usuario usuario)throws PersistenciaException;
     /**
      * Consulta el id de un usuario.
      * @param usuario
      * @return el id de el usuario dado.
      * @throws PersistenciaException 
      */
     public int consultarIdUsuario (Usuario usuario) throws PersistenciaException;
 

}
