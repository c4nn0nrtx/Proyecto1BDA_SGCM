/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.IConexionBD;
import Entidades.Direccion_Paciente;
import Entidades.Paciente;
import Entidades.Usuario;
import Exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Ramon Valencia
 */
public class UsuarioDAO implements IUsuarioDAO {

    private IConexionBD conexionBD;

    public UsuarioDAO(IConexionBD conexion) {
        this.conexionBD = conexion;
    }

    private static final Logger logger = Logger.getLogger(MedicoDAO.class.getName());

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

    @Override
    public Usuario actualizarUsuario(Usuario usuario) throws PersistenciaException {
        //Este metodo sirve para actualizar usuarios y de parametro recibe un usuario con id.
        String consultaSQL = "UPDATE USUARIOS SET nombreUsuario = ?, contrasenha = ? WHERE idUsuario = ?";

        String contraseñaEncriptada = BCrypt.hashpw(usuario.getContrasenha(), BCrypt.gensalt());

        try (Connection con = this.conexionBD.crearConexion(); PreparedStatement ps = con.prepareStatement(consultaSQL)) {

            if (consultarUsuarioPorId(usuario.getIdUsuario()) == null) {
                throw new PersistenciaException("ERROR: No se encontro al usuario");
            }

            ps.setString(1, usuario.getNombreUsuario());
            ps.setString(2, contraseñaEncriptada);
            ps.setInt(3, usuario.getIdUsuario());

            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas == 0) {
                logger.severe("ERROR: No se pudo ejecutar la actualizacion del usuario, no se modifico ninguna fila");
            }

            return usuario;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, "ERROR: No se pudo actualizar el usuario");
            throw new PersistenciaException("ERROR: Hubo un problema con la base de datos y no se pudieron actualizar los datos.");
        }
    }

    @Override
    public boolean autenticarUsuario(Usuario usuario) throws PersistenciaException {
        String sql = "SELECT contrasenha FROM usuarios WHERE nombreUsuario = ?";

        try (Connection con = this.conexionBD.crearConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, usuario.getNombreUsuario());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String hashedPassword = rs.getString("contrasenha");

                    // Verificar si la contraseña ingresada coincide con la almacenada
                    if (BCrypt.checkpw(usuario.getContrasenha(), hashedPassword)) {
                        logger.info("Autenticación exitosa para usuario: " + usuario.getNombreUsuario());
                        return true;
                    } else {
                        logger.warning("Contraseña incorrecta para usuario: " + usuario.getNombreUsuario());
                        return false;
                    }
                } else {
                    logger.warning("Usuario no encontrado: " + usuario.getNombreUsuario());
                    return false;
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error en la autenticación del usuario", e);
            throw new PersistenciaException("Error al autenticar al usuario en la base de datos: " + e.getMessage());
        }
    }
    
    @Override
    public boolean agregarUsuarioPaciente(Paciente paciente) throws PersistenciaException {
        String insertUsuarioSQL = "INSERT INTO USUARIOS (nombreUsuario, contrasenha) VALUES (?, ?)";
        String insertDireccionSQL = "INSERT INTO DIRECCIONES_PACIENTES (calle, colonia, cp, numero) VALUES (?, ?, ?, ?)";
        String insertPacienteSQL = "INSERT INTO PACIENTES (idPaciente, idDireccion, nombre, apellidoPat, apellidoMat, correo, fechaNac, telefono) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        Usuario usuario = paciente.getUsuario();
        Direccion_Paciente direccion = paciente.getDireccion();
        
        try (Connection conn = this.conexionBD.crearConexion()) {
            conn.setAutoCommit(false); // Inicia la transacción

            // Insertar el usuario
            try (PreparedStatement psUsuario = conn.prepareStatement(insertUsuarioSQL, Statement.RETURN_GENERATED_KEYS)) {
                psUsuario.setString(1, usuario.getNombreUsuario());
                psUsuario.setString(2, BCrypt.hashpw(usuario.getContrasenha(), BCrypt.gensalt()));
                int filasUsuario = psUsuario.executeUpdate();
                if (filasUsuario == 0) {
                    throw new SQLException("Error: No se pudo insertar el usuario.");
                }
                try (ResultSet rsUsuario = psUsuario.getGeneratedKeys()) {
                    if (rsUsuario.next()) {
                        usuario.setIdUsuario(rsUsuario.getInt(1));
                    } else {
                        throw new SQLException("Error: No se pudo obtener el ID del usuario.");
                    }
                }
            }

            // Insertar la dirección
            try (PreparedStatement psDireccion = conn.prepareStatement(insertDireccionSQL, Statement.RETURN_GENERATED_KEYS)) {
                psDireccion.setString(1, direccion.getCalle());
                psDireccion.setString(2, direccion.getColonia());
                psDireccion.setInt(3, direccion.getCp());
                psDireccion.setString(4, direccion.getNumero());
                int filasDireccion = psDireccion.executeUpdate();
                if (filasDireccion == 0) {
                    throw new SQLException("Error: No se pudo insertar la dirección.");
                }
                try (ResultSet rsDireccion = psDireccion.getGeneratedKeys()) {
                    if (rsDireccion.next()) {
                        direccion.setIdDireccion(rsDireccion.getInt(1));
                    } else {
                        throw new SQLException("Error: No se pudo obtener el ID de la dirección.");
                    }
                }
            }

            // Insertar el paciente
            try (PreparedStatement psPaciente = conn.prepareStatement(insertPacienteSQL)) {
                psPaciente.setInt(1, usuario.getIdUsuario());
                psPaciente.setInt(2, direccion.getIdDireccion());
                psPaciente.setString(3, paciente.getNombre());
                psPaciente.setString(4, paciente.getApellidoPaterno());
                psPaciente.setString(5, paciente.getApellidoMaterno());
                psPaciente.setString(6, paciente.getCorreo());
                psPaciente.setObject(7, paciente.getFechaNacimiento());
                psPaciente.setString(8, paciente.getTelefono());
                int filasPaciente = psPaciente.executeUpdate();
                if (filasPaciente == 0) {
                    throw new SQLException("Error: No se pudo insertar el paciente.");
                }
            }

            conn.commit(); // Confirma la transacción
            return true;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error en agregarUsuarioPaciente", e);
            throw new PersistenciaException("Error al registrar usuario y paciente: " + e.getMessage());
        }
    }

}
