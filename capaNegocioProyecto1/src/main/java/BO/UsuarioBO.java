package BO;

import Conexion.IConexionBD;
import DAO.IUsuarioDAO;
import DAO.UsuarioDAO;
import DTO.UsuarioNuevoDTO;
import Entidades.Usuario;
import Mapper.Mapper;
import java.util.logging.Logger;
import Exception.NegocioException;
import Exception.PersistenciaException;
import java.util.logging.Level;

/**
 * Esta clase representa los metodos de negocio de un Usuario.
 *
 * @author Sebastian Moreno
 */
public class UsuarioBO {

    private static final Logger logger = Logger.getLogger(UsuarioBO.class.getName());
    private final IUsuarioDAO usuarioDAO;
    Mapper mapper = new Mapper();

    public UsuarioBO(IConexionBD conexion) {
        this.usuarioDAO = new UsuarioDAO(conexion);
    }

    public boolean agregarUsuario(UsuarioNuevoDTO usuarioNuevo) throws NegocioException {
        if (usuarioNuevo == null) {
            throw new NegocioException("El usuario no puede ser nulo.");
        }

        // Validaciones básicas: verificar que los campos obligatorios no estén vacíos
        if (usuarioNuevo.getUsuario().isEmpty() || usuarioNuevo.getContrasenha().isEmpty()) {
            throw new NegocioException("Todos los campos son obligatorios.");
        }

        Usuario usuario = mapper.DTOUsuarioToEntity(usuarioNuevo);

        try {
            // Intentar guardar el activista en la base de datos
            Usuario usuarioGuardado = usuarioDAO.agregarUsuario(usuario);

            // Si el activista fue guardado con éxito, devuelve true, si no, devuelve false
            return usuarioGuardado != null;
        } catch (PersistenciaException ex) {
            // Registrar el error en los logs
            logger.log(Level.SEVERE, "Error al guardar usuario en la BD", ex);

            // Lanzar una excepción de negocio con un mensaje más amigable
            throw new NegocioException("Hubo un error al guardar el activista.", ex);
        }
    }
    
    public boolean autenticarUsuario(UsuarioNuevoDTO usuarioNuevo)throws NegocioException{
        if(usuarioNuevo == null){
            throw new NegocioException("El usuario no puede ser nulo");
        }
        if (usuarioNuevo.getUsuario().isEmpty() || usuarioNuevo.getContrasenha().isEmpty()) {
            throw new NegocioException("Todos los campos son obligatorios.");
        }
        
        Usuario usuario = mapper.DTOUsuarioToEntity(usuarioNuevo);
        
        try {
            // Intentar guardar el activista en la base de datos
            boolean usuarioGuardado = usuarioDAO.autenticarUsuario(usuario);

            // Si el activista fue guardado con éxito, devuelve true, si no, devuelve false
            if(usuarioGuardado == true){
                return true;
            } else {
                return false;
            }
            
            
        } catch (PersistenciaException ex) {
            // Registrar el error en los logs
            logger.log(Level.SEVERE, "Error al guardar usuario en la BD", ex);

            // Lanzar una excepción de negocio con un mensaje más amigable
            throw new NegocioException("Hubo un error al guardar el activista.", ex);
        }
    
    }
}
