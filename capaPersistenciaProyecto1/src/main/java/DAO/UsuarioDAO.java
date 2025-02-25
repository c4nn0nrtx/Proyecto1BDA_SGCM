package DAO;

import Conexion.IConexionBD;
import Entidades.Usuario;
import Exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mindrot.jbcrypt.BCrypt;

/**
 * Clase que implementa el objeto de acceso a datos (DAO) para la entidad
 * Usuario. Proporciona métodos para agregar, consultar, autenticar y verificar
 * roles de usuarios.
 *
 * @author Ramon Valencia
 */
public class UsuarioDAO implements IUsuarioDAO {

    private IConexionBD conexionBD;
    private static final Logger logger = Logger.getLogger(MedicoDAO.class.getName());

    /**
     * Constructor de la clase UsuarioDAO.
     *
     * @param conexion La conexión a la base de datos.
     */
    public UsuarioDAO(IConexionBD conexion) {
        this.conexionBD = conexion;
    }

    /**
     * Agrega un nuevo usuario a la base de datos.
     *
     * @param usuario El usuario que se va a agregar. Se espera que el usuario
     * no tenga ID.
     * @return El usuario agregado, incluyendo el ID generado por la base de
     * datos.
     * @throws PersistenciaException Si ocurre un error durante la persistencia
     * del usuario.
     */
    @Override
    public Usuario agregarUsuario(Usuario usuario) throws PersistenciaException {
        //Metodo para insertar nuevos usuarios, recibe como parametro un usuario sin id
        String consultaSQL = "INSERT INTO USUARIOS (nombreUsuario, contrasenha)"
                + "VALUES (?, ?)";
        String contraseñaEncriptada = BCrypt.hashpw(usuario.getContrasenha(), BCrypt.gensalt());

        try (Connection con = this.conexionBD.crearConexion(); PreparedStatement ps = con.prepareStatement(consultaSQL, PreparedStatement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, usuario.getNombreUsuario());
            ps.setString(2, contraseñaEncriptada);

            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas == 0) {
                logger.severe("ERROR: Hubo un fallo al agregar al usuario, no se inserto niguna fila.");
                throw new PersistenciaException("Error: no se inserto ninguna fila.");
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    usuario.setIdUsuario(generatedKeys.getInt(1));
                    logger.info("Usuario agregado exitosamente");
                } else {
                    logger.severe("ERROR: La agregacion del usuario fallo, no se pudo obtener el id.");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Error al registrar un usuario en la base de datos.");
        }
        return usuario;
    }

    /**
     * Consulta un usuario por su ID.
     *
     * @param id El ID del usuario que se va a consultar.
     * @return El usuario consultado, o null si no se encuentra.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    @Override
    public Usuario consultarUsuarioPorId(int id) throws PersistenciaException {
        //Este metodo sirve para consultar un usuario mediante el id
        Usuario usuario = null;

        String consultaSQL = "SELECT idUsuario, nombreUsuario, contrasenha FROM USUARIOS WHERE idUsuario = ?";

        try (Connection con = this.conexionBD.crearConexion(); PreparedStatement ps = con.prepareStatement(consultaSQL)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    usuario = new Usuario();
                    usuario.setIdUsuario(rs.getInt("idUsuario"));
                    usuario.setNombreUsuario(rs.getString("nombreUsuario"));
                    usuario.setContrasenha(rs.getString("contrasenha"));

                } else {
                    logger.warning("No hay un paciente registrado con esos datos.");
                }
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "ERROR: Hubo un error al consultar los datos del usuario: " + usuario, ex);
        }
        return usuario;
    }

    /**
     * Consulta el ID de un usuario por su nombre de usuario.
     *
     * @param usuario El usuario cuyo ID se va a consultar. Se espera que el
     * usuario tenga el nombre de usuario.
     * @return El ID del usuario, o -1 si no se encuentra.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    @Override
    public int consultarIdUsuario(Usuario usuario) throws PersistenciaException {
        //Este metodo sirve para consultar el id de un usuario y recibe de parametro un usuario sin id
        int id = -1;

        String consultaSQL = "SELECT idUsuario FROM USUARIOS WHERE nombreUsuario = ?";

        String contraseñaEncriptada = BCrypt.hashpw(usuario.getContrasenha(), BCrypt.gensalt());

        try (Connection con = this.conexionBD.crearConexion(); PreparedStatement ps = con.prepareStatement(consultaSQL)) {

            ps.setString(1, usuario.getNombreUsuario());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    id = rs.getInt("idUsuario");

                    logger.info("Usuario encontrado: " + usuario);
                } else {
                    logger.warning("No hay un paciente registrado con esos datos.");
                }
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "ERROR: Hubo un error al consultar los datos del usuario: " + usuario, ex);
        }
        return id;
    }

    /**
     * Autentica un usuario por sus credenciales.
     *
     * @param usuario El usuario con las credenciales que se van a verificar
     * (nombre de usuario y contraseña).
     * @return El usuario autenticado si las credenciales son válidas, o null si
     * no lo son. El usuario retornado tendrá el ID si la autenticación es
     * exitosa.
     * @throws PersistenciaException Si ocurre un error durante la
     * autenticación.
     */
    @Override
    public Usuario autenticarUsuario(Usuario usuario) throws PersistenciaException {
        String consultaSQL = "SELECT idUsuario, contrasenha FROM usuarios WHERE nombreUsuario = ?";

        try (Connection con = this.conexionBD.crearConexion(); PreparedStatement ps = con.prepareStatement(consultaSQL)) {

            ps.setString(1, usuario.getNombreUsuario());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String hashedPassword = rs.getString("contrasenha");
                    int idUsuario = rs.getInt("idUsuario");
                    usuario.setIdUsuario(idUsuario);
                    // Verificar si la contraseña ingresada coincide con la almacenada
                    if (BCrypt.checkpw(usuario.getContrasenha(), hashedPassword)) {
                        logger.info("Autenticación exitosa para usuario: " + usuario.getNombreUsuario());
                        return usuario;
                    } else {
                        logger.warning("Contraseña incorrecta para usuario: " + usuario.getNombreUsuario());
                        return null;
                    }
                } else {
                    logger.warning("Usuario no encontrado: " + usuario.getNombreUsuario());
                    return null;
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error en la autenticación del usuario", e);
            throw new PersistenciaException("Error al autenticar al usuario en la base de datos: " + e.getMessage());
        }
    }

    /**
     * Verifica si un usuario es médico.
     *
     * @param idUsuario El ID del usuario que se va a verificar.
     * @return true si el usuario es médico, false si no lo es.
     * @throws PersistenciaException Si ocurre un error durante la verificación.
     */
    @Override
    public boolean esMedico(int idUsuario) throws PersistenciaException {
        String sql = "SELECT idMedico FROM MEDICOS WHERE idMedico = ?";
        try (Connection con = this.conexionBD.crearConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idUsuario);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next(); // Si hay resultado, es médico
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al verificar si el usuario es médico: " + e.getMessage());
        }
    }

    /**
     * Verifica si un usuario es paciente.
     *
     * @param idUsuario El ID del usuario que se va a verificar.
     * @return true si el usuario es paciente, false si no lo es.
     * @throws PersistenciaException Si ocurre un error durante la verificación.
     */
    @Override
    public boolean esPaciente(int idUsuario) throws PersistenciaException {
        String sql = "SELECT idPaciente FROM PACIENTES WHERE idPaciente = ?";
        try (Connection con = this.conexionBD.crearConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idUsuario);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next(); // Si hay resultado, es paciente
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al verificar si el usuario es paciente: " + e.getMessage());
        }
    }

}
