package DAO;

import Conexion.IConexionBD;
import Entidades.Medico;
import Entidades.Usuario;
import Exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase representa el DAO de la clase Medico.
 *
 * @author Sebastian Moreno
 */
public class MedicoDAO implements IMedicoDAO {

    private IConexionBD conexion;
    private UsuarioDAO usuarioDAO;

    /**
     * Constructor que inicializa la conexion.
     *
     * @param conexion
     */
    public MedicoDAO(IConexionBD conexion) {
        this.conexion = conexion;
        this.usuarioDAO = new UsuarioDAO(conexion);
    }

    private static final Logger logger = Logger.getLogger(MedicoDAO.class.getName());

    /**
     * Consulta un medico por un id dado.
     *
     * @param id
     * @return el medico consultado.
     * @throws PersistenciaException
     */
    @Override
    public Medico consultarMedicoPorId(int id) throws PersistenciaException {
        Medico medico = null;
        String consultaSQL = "SELECT idMedico, nombre, apellidoPat, apellidoMat, cedulaProf, estado, especialidad FROM MEDICOS WHERE idMedico = ?";

        try (Connection con = this.conexion.crearConexion(); PreparedStatement ps = con.prepareStatement(consultaSQL)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    medico = new Medico();

                    // Como idMedico también es idUsuario, usamos directamente el ID del método
                    Usuario usuario = usuarioDAO.consultarUsuarioPorId(id);
                    medico.setUsuario(usuario);

                    medico.setNombre(rs.getString("nombre"));
                    medico.setApellidoPaterno(rs.getString("apellidoPat"));
                    medico.setApellidoMaterno(rs.getString("apellidoMat"));
                    medico.setCedulaProfesional(rs.getString("cedulaProf"));
                    medico.setEstado(rs.getString("estado"));
                    medico.setEspecialidad(rs.getString("especialidad"));
                    System.out.println("Connsultando para el id del medico : "+id);
                } else {
                    logger.severe("No se encontró médico con id " + id);
                }
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Error al consultar médico con ID: " + id, ex);
            throw new PersistenciaException("Error al consultar médico con ID " + id + " desde la base de datos", ex);
        }
        return medico;
    }

    /**
     * Obtiene los medicos de una especialidad especifica.
     *
     * @param especialidad
     * @return una lista de medicos.
     * @throws PersistenciaException
     */
    @Override
    public List<Medico> obtenerPorEspecialidad(String especialidad) throws PersistenciaException {

        String consultaSQL = "SELECT idMedico, nombre, apellidoPat, apellidoMat, cedulaProf, estado, especialidad "
                + "FROM MEDICOS WHERE especialidad = ?";
        List<Medico> listaMedicos = new ArrayList<>();

        try (Connection con = conexion.crearConexion(); PreparedStatement ps = con.prepareStatement(consultaSQL)) {

            ps.setString(1, especialidad);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Medico medico = new Medico();
                Usuario usuario = usuarioDAO.consultarUsuarioPorId(rs.getInt("idMedico"));
                medico.setUsuario(usuario);
                medico.setNombre(rs.getString("nombre"));
                medico.setApellidoPaterno(rs.getString("apellidoPat"));
                medico.setApellidoMaterno(rs.getString("apellidoMat"));
                medico.setCedulaProfesional(rs.getString("cedulaProf"));
                medico.setEstado(rs.getString("estado"));
                medico.setEspecialidad(rs.getString("especialidad"));
                listaMedicos.add(medico);
            }
            return listaMedicos;
        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            // Se lanza una excepción personalizada si hay un error en la consulta
            throw new PersistenciaException("Error al obtener la lista de medicos por especialidad desde la base de datos.", ex);
        }
    }

    /**
     * Actualiza el estado de un medico
     *
     * @param medico
     * @param estado activo o inactivo
     * @return verdadero si, se actualizo el estado.
     * @throws PersistenciaException
     */
    @Override
    public boolean actualizarEstadoMedico(Medico medico, String estado) throws PersistenciaException {
        String consultaSQL = "UPDATE MEDICOS SET ESTADO = ? WHERE idMedico = ?";

        try (Connection con = this.conexion.crearConexion(); PreparedStatement ps = con.prepareStatement(consultaSQL)) {

            ps.setString(1, estado); // seteo el valor del estado para remplazar el ?
            ps.setInt(2, medico.getUsuario().getIdUsuario());

            int lineasAfectadas = ps.executeUpdate(); // ejecuto la consulta y guardo los rows afectados en un int

            if (lineasAfectadas == 0) { // validacion 
                logger.severe("Error: no se encontro medico con el id: " + medico.getUsuario().getIdUsuario());
                throw new PersistenciaException("No se encontro el medico con el id: " + medico.getUsuario().getIdUsuario());

            } else {
                logger.info("Correctamente actualizado el medico con el id: " + medico.getUsuario().getIdUsuario() + "!");
                return true;
            }

        } catch (SQLException e) {
            if ("22001".equals(e.getSQLState()) || e.getErrorCode() == 1265) { // obtenemos el codigo del error de SQL por ejemplo 23000 es el código estándar para errores de integridad
                throw new PersistenciaException("Error: No se puede actualizar a un valor que no sea (Activo o Inactivo) ", e);
            }
            logger.log(Level.SEVERE, "Error: ", e.getSQLState()); //Ultima validacion
            throw new PersistenciaException("Hubo un error actualizando", e);
        }
    }

    public List<Medico> obtenerMedicosConHorario() throws PersistenciaException {
        String consultaSQL = "SELECT DISTINCT m.idMedico, m.nombre, m.apellidoPat, m.apellidoMat, "
                + "m.cedulaProf, m.estado, m.especialidad "
                + "FROM MEDICOS m "
                + "JOIN HORARIOS_MEDICOS h ON m.idMedico = h.idMedico "
                + "WHERE m.estado = 'Activo'";

        List<Medico> listaMedicos = new ArrayList<>();

        try (Connection con = conexion.crearConexion(); PreparedStatement ps = con.prepareStatement(consultaSQL); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Medico medico = new Medico();
                Usuario usuario = usuarioDAO.consultarUsuarioPorId(rs.getInt("idMedico")); // Asociamos el usuario
                medico.setUsuario(usuario);
                medico.setNombre(rs.getString("nombre"));
                medico.setApellidoPaterno(rs.getString("apellidoPat"));
                medico.setApellidoMaterno(rs.getString("apellidoMat"));
                medico.setCedulaProfesional(rs.getString("cedulaProf"));
                medico.setEstado(rs.getString("estado"));
                medico.setEspecialidad(rs.getString("especialidad"));

                listaMedicos.add(medico);
            }
            return listaMedicos;
        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, "Error al obtener médicos con horario", ex);
            throw new PersistenciaException("Error al obtener médicos con horario desde la base de datos.", ex);
        }
    }

    /**
     * Obtiene un medico por su nombre Completo.
     *
     * @param nombreCompleto
     * @return Un medico tipo Medico
     * @throws PersistenciaException
     */
    public Medico obtenerMedicoPorNombre(String nombreCompleto) throws PersistenciaException {
        String consultaSQL = "SELECT idMedico, nombre, apellidoPat, apellidoMat, cedulaProf, estado, especialidad "
                + "FROM MEDICOS WHERE CONCAT(nombre, ' ', apellidoPat, ' ', apellidoMat) = ? AND estado = 'Activo'";

        try (Connection con = conexion.crearConexion(); PreparedStatement ps = con.prepareStatement(consultaSQL)) {

            ps.setString(1, nombreCompleto);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Medico medico = new Medico();
                    Usuario usuario = usuarioDAO.consultarUsuarioPorId(rs.getInt("idMedico")); // Asociamos el usuario
                    medico.setUsuario(usuario);
                    medico.setNombre(rs.getString("nombre"));
                    medico.setApellidoPaterno(rs.getString("apellidoPat"));
                    medico.setApellidoMaterno(rs.getString("apellidoMat"));
                    medico.setCedulaProfesional(rs.getString("cedulaProf"));
                    medico.setEstado(rs.getString("estado"));
                    medico.setEspecialidad(rs.getString("especialidad"));
                    return medico;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, "Error al obtener médico por nombre", ex);
            throw new PersistenciaException("Error al obtener médico por nombre.", ex);
        }
        return null; // Retorna null si no encuentra al médico
    }

}
