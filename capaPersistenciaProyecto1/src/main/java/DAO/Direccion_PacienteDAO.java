package DAO;

import Conexion.IConexionBD;
import Entidades.Direccion_Paciente;
import Exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase representa un objeto de acceso a datos (DAO) para la entidad
 * Direccion_Paciente. Proporciona métodos para agregar, consultar, y actualizar
 * direcciones de pacientes.
 *
 * @author Ramon Valencia
 */
public class Direccion_PacienteDAO implements IDireccion_PacienteDAO {

    private IConexionBD conexionBD;
    private static final Logger logger = Logger.getLogger(Direccion_PacienteDAO.class.getName());

    /**
     * Constructor de la clase Direccion_PacienteDAO.
     *
     * @param conexionBD La conexión a la base de datos.
     */
    public Direccion_PacienteDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    /**
     * Agrega una nueva dirección de paciente a la base de datos.
     *
     * @param direccion La dirección de paciente que se va a agregar.
     * @return La dirección de paciente agregada, incluyendo el ID generado por
     * la base de datos.
     * @throws PersistenciaException Si ocurre un error durante la persistencia
     * de la dirección.
     */
    @Override
    public Direccion_Paciente agregarDireccion(Direccion_Paciente direccion) throws PersistenciaException {
        String consultaSQL = "INSERT INTO DIRECCIONES_PACIENTES (calle, colonia, cp, numero)"
                + "VALUES (?, ?, ?, ?)";

        try (Connection con = this.conexionBD.crearConexion(); PreparedStatement ps = con.prepareStatement(consultaSQL, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, direccion.getCalle());
            ps.setString(2, direccion.getColonia());
            ps.setInt(3, direccion.getCp());
            ps.setString(4, direccion.getNumero());

            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas == 0) {
                logger.severe("ERROR: Hubo un fallo al agregar la dirección, no se insertó ninguna fila.");
                return null; // Salimos temprano si no se insertó nada
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    direccion.setIdDireccion(generatedKeys.getInt(1));
                    logger.info("Dirección agregada exitosamente con ID: " + direccion.getIdDireccion());
                    return direccion; // ✅ Devolvemos la dirección con el ID asignado
                } else {
                    logger.severe("ERROR: La agregación de la dirección falló, no se pudo obtener el ID.");
                    return null;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Direccion_PacienteDAO.class.getName()).log(Level.SEVERE, "Error al insertar dirección", ex);
            throw new PersistenciaException("Error al insertar dirección: " + ex.getMessage(), ex);
        }
    }

    /**
     * Consulta una dirección de paciente por su ID.
     *
     * @param id El ID de la dirección que se va a consultar.
     * @return La dirección de paciente consultada, o null si no se encuentra.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    @Override
    public Direccion_Paciente consultarDireccionPorId(int id) throws PersistenciaException {
        Direccion_Paciente direccion = null;

        String consultaSQL = "SELECT idDireccion, calle, colonia, cp, numero FROM DIRECCIONES_PACIENTES WHERE idDireccion = ?";

        try (Connection con = this.conexionBD.crearConexion(); PreparedStatement ps = con.prepareStatement(consultaSQL)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    direccion = new Direccion_Paciente();
                    direccion.setIdDireccion(rs.getInt("idDireccion"));
                    direccion.setCalle(rs.getString("calle"));
                    direccion.setColonia(rs.getString("colonia"));
                    direccion.setCp(rs.getInt("cp"));
                    direccion.setNumero(rs.getString("numero"));

                    logger.info("Direccion encontrada: " + direccion);
                } else {
                    logger.warning("No se encontro una direccion con el ID: " + id);
                }
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "ERROR: Hubo un error al consultar la direccion con ID: " + id, ex);
        }
        return direccion;
    }

    /**
     * Consulta el ID de una dirección de paciente por sus datos.
     *
     * @param direccion La dirección de paciente cuyos datos se van a utilizar
     * para la consulta.
     * @return El ID de la dirección, o -1 si no se encuentra.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    @Override
    public int consultaIdDireccion(Direccion_Paciente direccion) throws PersistenciaException {
        int id = -1;
        String consultaSQL = "SELECT idDireccion FROM DIRECCIONES_PACIENTES WHERE calle = ? AND colonia = ? AND cp = ? AND numero = ?";

        try (Connection con = this.conexionBD.crearConexion(); PreparedStatement ps = con.prepareStatement(consultaSQL)) {

            ps.setString(1, direccion.getCalle());
            ps.setString(2, direccion.getColonia());
            ps.setInt(3, direccion.getCp());
            ps.setString(4, direccion.getNumero());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    id = rs.getInt("idDireccion");

                    logger.info("ID Encontrado: " + id);
                } else {
                    logger.warning("No hay un direccion registrada con esos datos.");
                }
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "ERROR: Hubo un error al consultar los datos de la direccion: " + direccion, ex);
        }
        return id;
    }

    /**
     * Actualiza la información de una dirección de paciente en la base de
     * datos.
     *
     * @param direccion La dirección de paciente con la información actualizada.
     * @return La dirección de paciente actualizada.
     * @throws PersistenciaException Si ocurre un error durante la
     * actualización.
     */
    @Override
    public Direccion_Paciente actualizarDireccion(Direccion_Paciente direccion) throws PersistenciaException {
        String consultaSQL = "UPDATE DIRECCIONES_PACIENTES SET calle = ?, colonia = ?, cp = ?, numero = ? WHERE idDireccion = ?";

        try (Connection con = this.conexionBD.crearConexion(); PreparedStatement ps = con.prepareStatement(consultaSQL)) {

            if (consultarDireccionPorId(direccion.getIdDireccion()) == null) {
                throw new PersistenciaException("ERROR: No se encontro la direccion");
            }

            ps.setString(1, direccion.getCalle());
            ps.setString(2, direccion.getColonia());
            ps.setInt(3, direccion.getCp());
            ps.setString(4, direccion.getNumero());
            ps.setInt(5, direccion.getIdDireccion());

            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas == 0) {
                logger.severe("ERROR: No se pudo ejecutar la actualizacion de la direccion, no se modifico ninguna fila.");
            }

            return direccion;

        } catch (SQLException ex) {
            Logger.getLogger(Direccion_PacienteDAO.class.getName()).log(Level.SEVERE, "ERROR: No se pudo actualizar el activista");
            throw new PersistenciaException("ERROR: Hubo un problema con la base de datos y no se pudieron actualizar los datos.");
        }
    }

}
