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
 * Clase Usuario con DAOS
 *
 * @author Ramon Valencia
 */
public class UsuarioDAO implements IUsuarioDAO {

    private IConexionBD conexionBD;
    private static final Logger logger = Logger.getLogger(MedicoDAO.class.getName());

    public UsuarioDAO(IConexionBD conexion) {
        this.conexionBD = conexion;
    }

    /**
     * Metodo para agregar un usuario
     *
     * @param usuario
     * @return El usuario agregado
     * @throws PersistenciaException Si algo falla.
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
     * Metodo para consultar un usuario por id.
     *
     * @param id
     * @return El usuario consultado.
     * @throws PersistenciaException
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

                    logger.info("Usuario encontrado: " + usuario);
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
     * Metodo para consultar el id de un usuario
     *
     * @param usuario
     * @return el id del usuario Consultado.
     * @throws PersistenciaException
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
     * Metodo para validar credenciales de usuario.
     *
     * @param usuario
     * @return Verdadero si las creedenciales son correctas, falso caso
     * contrario.
     * @throws PersistenciaException
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
