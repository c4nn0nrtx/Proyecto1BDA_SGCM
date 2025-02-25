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
 * Clase de negocio para gestionar usuarios. Esta clase contiene la lógica de
 * negocio para agregar, autenticar y verificar el rol de un usuario.
 *
 * @author Sebastian Moreno
 */
public class UsuarioBO {

    private static final Logger logger = Logger.getLogger(UsuarioBO.class.getName());
    private final IUsuarioDAO usuarioDAO;
    Mapper mapper = new Mapper();

    /**
     * Constructor de la clase UsuarioBO.
     *
     * @param conexion La conexión a la base de datos.
     */
    public UsuarioBO(IConexionBD conexion) {
        this.usuarioDAO = new UsuarioDAO(conexion);

    }

    /**
     * Agrega un nuevo usuario. Valida los datos del usuario, incluyendo el
     * formato del nombre de usuario y la contraseña, y verifica si el nombre de
     * usuario ya existe. Luego, guarda el usuario en la base de datos.
     *
     * @param usuario Los datos del nuevo usuario (DTO).
     * @return El usuario agregado (entidad).
     * @throws NegocioException Si hay un error en la lógica de negocio, como
     * datos inválidos o un nombre de usuario duplicado.
     */
    public Usuario agregarUsuario(UsuarioNuevoDTO usuario) throws NegocioException {
        // Validaciones
        if (usuario == null) {
            throw new NegocioException("Los datos del usuario no pueden ser nulos.");
        }
        if (usuario.getUsuario() == null || usuario.getUsuario().isEmpty()
                || usuario.getContrasenha() == null || usuario.getContrasenha().isEmpty()) {
            throw new NegocioException("El nombre de usuario y la contraseña son obligatorios.");
        }
        if (usuario.getUsuario().length() < 3 || usuario.getUsuario().length() > 20) {
            throw new NegocioException("El nombre de usuario debe tener entre 3 y 20 caracteres.");
        }
        if (usuario.getContrasenha().length() < 8 || usuario.getContrasenha().length() > 50) {
            throw new NegocioException("La contraseña debe tener entre 8 y 50 caracteres.");
        }
        if (!usuario.getContrasenha().matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")) {
            throw new NegocioException("La contraseña debe contener al menos una letra y un número.");
        }

        Usuario usuarioEntidad = mapper.DTOUsuarioToEntity(usuario);

        try {
            // Verificar si el usuario ya existe en la base de datos
            if (usuarioDAO.autenticarUsuario(usuarioEntidad) != null) {
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

    /**
     * Autentica un usuario. Verifica las credenciales del usuario (nombre de
     * usuario y contraseña).
     *
     * @param usuarioNuevo Los datos del usuario para autenticar (DTO).
     * @return El usuario autenticado (entidad) si las credenciales son
     * correctas, null en caso contrario.
     * @throws NegocioException Si hay un error en la lógica de negocio o las
     * credenciales son incorrectas.
     */
    public Usuario autenticarUsuario(UsuarioNuevoDTO usuarioNuevo) throws NegocioException {
        if (usuarioNuevo == null) {
            throw new NegocioException("El usuario no puede ser nulo");
        }
        if (usuarioNuevo.getUsuario() == null || usuarioNuevo.getUsuario().isEmpty()
                || usuarioNuevo.getContrasenha() == null || usuarioNuevo.getContrasenha().isEmpty()) {
            throw new NegocioException("El nombre de usuario y la contraseña son obligatorios.");
        }

        Usuario usuario;
        try {
            usuario = mapper.DTOUsuarioToEntity(usuarioNuevo);
        } catch (Exception e) {
            throw new NegocioException("Error al mapear los datos del usuario.", e);
        }

        try {
            // Intentar autenticar el usuario en la base de datos
            Usuario usuarioAutenticado = usuarioDAO.autenticarUsuario(usuario);
            return usuarioAutenticado;
        } catch (PersistenciaException ex) {
            // Registrar el error en los logs
            logger.log(Level.SEVERE, "Error al autenticar usuario en la BD", ex);
            throw new NegocioException("Contraseña incorrecta", ex);
        }
    }

    /**
     * Verifica si un usuario es médico.
     *
     * @param idUsuario El ID del usuario.
     * @return true si el usuario es médico, false en caso contrario.
     * @throws PersistenciaException Si hay un error en la base de datos.
     */
    public boolean esMedico(int idUsuario) throws PersistenciaException {
        return usuarioDAO.esMedico(idUsuario);
    }

}
