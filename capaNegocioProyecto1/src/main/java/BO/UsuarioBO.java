package BO;

import Conexion.IConexionBD;
import DAO.IUsuarioDAO;
import DAO.UsuarioDAO;
import DTO.Direccion_PacienteNuevaDTO;
import DTO.PacienteNuevoDTO;
import DTO.UsuarioNuevoDTO;
import Entidades.Direccion_Paciente;
import Entidades.Paciente;
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

    public Usuario agregarUsuario(UsuarioNuevoDTO usuario) throws NegocioException {
        if (usuario == null) {
            throw new NegocioException("Los datos del usuario, paciente y dirección no pueden ser nulos.");
        }

        // verificar que los campos obligatorios no estén vacíos
        if (usuario.getUsuario().isEmpty() || usuario.getContrasenha().isEmpty()) {
            throw new NegocioException("Todos los campos son obligatorios.");
        }

        // Validar longitud de usuario y contraseña
        if (usuario.getUsuario().length() < 3 || usuario.getUsuario().length() > 20) {
            throw new NegocioException("El nombre de usuario debe tener entre 3 y 20 caracteres.");
        }

        if (usuario.getContrasenha().length() < 8 || usuario.getContrasenha().length() > 50) {
            throw new NegocioException("La contraseña debe tener entre 8 y 50 caracteres.");
        }

        // Validar que la contraseña contenga al menos una letra y un número
        if (!usuario.getContrasenha().matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")) {
            throw new NegocioException("La contraseña debe contener al menos una letra y un número.");
        }
    
      
            Usuario usuarioEntidad = mapper.DTOUsuarioToEntity(usuario);
        
        

        try {
            // Verificar si el usuario ya existe en la base de datos
            if (usuarioDAO.autenticarUsuario(usuarioEntidad)) {
                throw new NegocioException("El nombre de usuario ya existe. Por favor, elige otro.");
            }

            // Intentar guardar el usuario, paciente y dirección en la base de datos
            Usuario usuarioGuardado = usuarioDAO.agregarUsuario(usuarioEntidad);
            return usuarioGuardado;
        } catch (PersistenciaException ex) {
            // Registrar el error en los logs
            logger.log(Level.SEVERE, "Error al guardar usuario en la BD", ex);
            throw new NegocioException("Hubo un error al guardar el paciente", ex);
        }
    }

    public boolean autenticarUsuario(UsuarioNuevoDTO usuarioNuevo) throws NegocioException {
        if (usuarioNuevo == null) {
            throw new NegocioException("El usuario no puede ser nulo");
        }

        if (usuarioNuevo.getUsuario().isEmpty() || usuarioNuevo.getContrasenha().isEmpty()) {
            throw new NegocioException("Todos los campos son obligatorios.");
        }

        // Validar longitud y formato de usuario y contraseña
        if (usuarioNuevo.getUsuario().length() < 3 || usuarioNuevo.getUsuario().length() > 20) {
            throw new NegocioException("El nombre de usuario debe tener entre 3 y 20 caracteres.");
        }

        if (usuarioNuevo.getContrasenha().length() < 8 || usuarioNuevo.getContrasenha().length() > 50) {
            throw new NegocioException("La contraseña debe tener entre 8 y 50 caracteres.");
        }

        if (!usuarioNuevo.getContrasenha().matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")) {
            throw new NegocioException("La contraseña debe contener al menos una letra y un número.");
        }

        if (!usuarioNuevo.getUsuario().matches("^[a-zA-Z0-9._-]{3,}$")) {
            throw new NegocioException("El nombre de usuario solo puede contener letras, números, puntos, guiones y guiones bajos.");
        }

        Usuario usuario;
        try {
            usuario = mapper.DTOUsuarioToEntity(usuarioNuevo);
        } catch (Exception e) {
            throw new NegocioException("Error al mapear los datos del usuario.", e);
        }

        try {
            // Intentar autenticar el usuario en la base de datos
            boolean usuarioAutenticado = usuarioDAO.autenticarUsuario(usuario);
            return usuarioAutenticado;
        } catch (PersistenciaException ex) {
            // Registrar el error en los logs
            logger.log(Level.SEVERE, "Error al autenticar usuario en la BD", ex);
            throw new NegocioException("Hubo un error al autenticar el usuario.", ex);
        }
    }

}
