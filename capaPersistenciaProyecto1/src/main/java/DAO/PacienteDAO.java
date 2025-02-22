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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase representan los metodos DAO de un paciente.
 *
 * @author Ramon Valencia
 */
public class PacienteDAO implements IPacienteDAO {

    private IConexionBD conexionBD;

    public PacienteDAO(IConexionBD conexion) {
        this.conexionBD = conexion;
    }

    private static final Logger logger = Logger.getLogger(MedicoDAO.class.getName());

    /**
     * Metodo para agregar un paciente
     *
     * @param paciente el paciente a agregar
     * @return el paciente agregado
     * @throws PersistenciaException
     */
    @Override
    public Paciente agregarPaciente(Paciente paciente) throws PersistenciaException {
        String consultaSQL = "INSERT INTO PACIENTES (idPaciente, idDireccion, nombre, apellidoPat, apellidoMat, correo, fechaNac, telefono) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = this.conexionBD.crearConexion(); PreparedStatement ps = con.prepareStatement(consultaSQL)) {

            ps.setInt(1, paciente.getUsuario().getIdUsuario());
            ps.setInt(2, paciente.getDireccion().getIdDireccion());
            ps.setString(3, paciente.getNombre());
            ps.setString(4, paciente.getApellidoPaterno());
            ps.setString(5, paciente.getApellidoMaterno());
            ps.setString(6, paciente.getCorreo());
            ps.setObject(7, paciente.getFechaNacimiento());
            ps.setString(8, paciente.getTelefono());

            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas == 0) {
                logger.severe("ERROR: Hubo un fallo al agregar al paciente, no se inserto niguna fila.");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Direccion_PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return paciente;
    }

    /* Falta corregir este metodo consultarPacientePorId*/
    @Override
    public Paciente consultarPacientePorId(int id) throws PersistenciaException {
        Paciente paciente = null;

        String consultaSQL = "SELECT p.idPaciente, u.nombreUsuario, d.idDireccion, d.calle, d.colonia, d.cp, d.numero, "
                + "p.nombre, p.apellidoPat, p.apellidoMat, p.correo, p.fechaNac, p.telefono "
                + "FROM PACIENTES p "
                + "INNER JOIN USUARIOS u ON p.idPaciente = u.idUsuario "
                + "INNER JOIN DIRECCIONES_PACIENTES d ON p.idDireccion = d.idDireccion "
                + "WHERE p.idPaciente = ?";

        try (Connection con = this.conexionBD.crearConexion(); PreparedStatement ps = con.prepareStatement(consultaSQL)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // Crear el objeto Usuario
                    Usuario usuario = new Usuario();
                    usuario.setIdUsuario(rs.getInt("idPaciente"));
                    usuario.setNombreUsuario(rs.getString("nombreUsuario"));

                    // Crear el objeto Direccion_Paciente
                    Direccion_Paciente direccion = new Direccion_Paciente();
                    direccion.setIdDireccion(rs.getInt("idDireccion"));
                    direccion.setCalle(rs.getString("calle"));
                    direccion.setColonia(rs.getString("colonia"));
                    direccion.setCp(rs.getInt("cp"));
                    direccion.setNumero(rs.getString("numero"));

                    // Crear el objeto Paciente
                    paciente = new Paciente(usuario, direccion,
                            rs.getString("nombre"),
                            rs.getString("apellidoPat"),
                            rs.getString("apellidoMat"),
                            rs.getString("correo"),
                            rs.getDate("fechaNac").toLocalDate(),
                            rs.getString("telefono"));

                    //LOGER DE PACIENTE SI SE NECESITA
                } else {
                    logger.warning("No hay un paciente registrado con el ID: " + id);
                }
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "ERROR: Hubo un error al consultar los datos del paciente con ID: " + id, ex);
        }
        return paciente;
    }

    /**
     * Actualiza el estado de un paciente
     *
     * @param paciente
     * @return el paciente actualizado.
     * @throws PersistenciaException
     */
    @Override
    public Paciente actualizarPacientePorID(int id, Paciente paciente) throws PersistenciaException {
        String consultaSQL = "UPDATE PACIENTES SET nombre = ?, apellidoPat = ?, apellidoMat = ?, correo = ?, fechaNac = ? ,telefono = ?  WHERE idPaciente = ?";

        try (Connection con = this.conexionBD.crearConexion(); PreparedStatement ps = con.prepareStatement(consultaSQL)) {

            // Verificar si el paciente existe antes de intentar actualizarlo
            if (consultarPacientePorId(id) == null) {
                throw new PersistenciaException("ERROR: No se encontró al paciente con ID " + id);
            }

            // Asignar los valores al PreparedStatement
            ps.setString(1, paciente.getNombre());
            ps.setString(2, paciente.getApellidoPaterno());
            ps.setString(3, paciente.getApellidoMaterno());
            ps.setString(4, paciente.getCorreo());

            // Convertir LocalDate a Date (si fechaNacimiento no es nula)
            if (paciente.getFechaNacimiento() != null) {
                ps.setDate(5, java.sql.Date.valueOf(paciente.getFechaNacimiento()));
            } else {
                ps.setNull(5, java.sql.Types.DATE);
            }

            ps.setString(6, paciente.getTelefono()); // ID del paciente a actualizar
            ps.setInt(7, id);

            // Ejecutar la actualización
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas == 0) {
                throw new PersistenciaException("ERROR: No se pudo actualizar el paciente, no se modificó ninguna fila.");
            }

            return paciente;

        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, "ERROR: no se pudo actualizar el paciente", ex);
            throw new PersistenciaException("ERROR: Hubo un problema con la base de datos y no se pudieron actualizar los datos.");
        }
    }

}
