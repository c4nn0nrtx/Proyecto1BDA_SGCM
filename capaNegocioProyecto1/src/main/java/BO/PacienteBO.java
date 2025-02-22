package BO;

import Conexion.IConexionBD;
import DAO.IPacienteDAO;
import DAO.PacienteDAO;
import DTO.Direccion_PacienteNuevaDTO;
import DTO.PacienteNuevoDTO;
import DTO.UsuarioNuevoDTO;
import Entidades.Direccion_Paciente;
import Entidades.Paciente;
import Entidades.Usuario;
import Exception.NegocioException;
import Exception.PersistenciaException;
import Mapper.Mapper;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase representa un Paciente con logica de negocio.
 *
 * @author brand
 */
public class PacienteBO {

    private static final Logger logger = Logger.getLogger(PacienteBO.class.getName());
    private final IPacienteDAO pacienteDAO;
    private final IConexionBD conexionBD;
    private UsuarioBO usuarioBO;
    private Direccion_PacienteBO direccionBO;
    Mapper mapper = new Mapper();

    /**
     * Constructor que inicializa la conexion a la base de datos de:
     * paciente,usuario y direcciones.
     *
     * @param conexion
     */
    public PacienteBO(IConexionBD conexion) {
        this.pacienteDAO = new PacienteDAO(conexion);
        this.conexionBD = conexion;
        this.usuarioBO = new UsuarioBO(conexion);
        this.direccionBO = new Direccion_PacienteBO(conexion);
    }

    /**
     * Agrega un paciente sincronizado. Contiene una transaccion para agregar al
     * usuario,direccion y paciente en ese orden.
     *
     * @param pacienteNuevo El paciente a agregar
     * @param usuarioNuevo El usuario a agregar
     * @param direccionNueva La direccion a agregar
     * @return Verdadero en caso de haber cumplido las validaciones y haberse
     * agregado.
     * @throws NegocioException si existe alguna validacion.
     * @throws SQLException si existe un error de sql
     */
    public boolean agregarPaciente(PacienteNuevoDTO pacienteNuevo, UsuarioNuevoDTO usuarioNuevo, Direccion_PacienteNuevaDTO direccionNueva) throws NegocioException, SQLException {
        if (pacienteNuevo == null) {
            throw new NegocioException("El paciente no puede ser nulo.");
        }
        if (usuarioNuevo == null) {
            throw new NegocioException("El usuario no puede ser nulo.");
        }
        if (direccionNueva == null) {
            throw new NegocioException("La direccion no puede ser nula.");
        }

        Connection con = null;
        try {
            con = this.conexionBD.crearConexion();
            con.setAutoCommit(false);

            Usuario usuario = usuarioBO.agregarUsuario(usuarioNuevo);
            Direccion_Paciente direccion = direccionBO.agregarDireccionPaciente(direccionNueva);

            pacienteNuevo.setUsuario(usuario);
            pacienteNuevo.setDireccion(direccion);
            Paciente pacienteEntidad = mapper.DTOPacienteToEntity(pacienteNuevo);
            pacienteDAO.agregarPaciente(pacienteEntidad);

            con.commit();
            return true;
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error, No se pudo agregar al paciente. Intenta de nuevo.", ex);

        } catch (SQLException e) {
            con.rollback(); // por si no funciona utilizamos el rollback de la transaccion.
        }
        return false;
    }
    /**
     * Busca un paciente por su id
     * @param id
     * @return Objeto paciente con direccion y usuario.
     * @throws PersistenciaException 
     */
    public Paciente buscarPacientePorID(int id) throws PersistenciaException {
        try {
            Paciente pacienteEncontrado = pacienteDAO.consultarPacientePorId(id);
            if (pacienteEncontrado != null) {
                return pacienteEncontrado;
            } else {
                logger.warning("No se encontró un paciente con ID: " + id);
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al buscar paciente con ID: " + id, e);
            throw new PersistenciaException("Error al buscar paciente.", e);
        }
        return null; // Devuelve null si el paciente no se encuentra
    }
    /**
     * Actualiza los atributos de un paciente
     * @param id el id del paciente a actualizar
     * @param pacienteNuevo el paciente con el usuario y Direccion
     * @return el paciente Nuevo Actualizado
     * @throws PersistenciaException
     * @throws NegocioException 
     */
    public Paciente actualizarPaciente(int id, PacienteNuevoDTO pacienteNuevo) throws PersistenciaException, NegocioException { // FALTAN VERIFICACIONES PARA ANTES DE ACTUALIZAR

        Paciente paciente = mapper.DTOPacienteToEntity(pacienteNuevo);
        Paciente pacienteEncontrado = pacienteDAO.consultarPacientePorId(id);
        Direccion_Paciente direccionPaciente = new Direccion_Paciente(pacienteEncontrado.getDireccion().getIdDireccion(), pacienteNuevo.getDireccion().getCalle(), pacienteNuevo.getDireccion().getColonia(), pacienteNuevo.getDireccion().getCp(),
                 pacienteNuevo.getDireccion().getNumero());

        Direccion_Paciente dir = direccionBO.actualizarDireccionPaciente(direccionPaciente);

        Paciente pacienteActualizado = pacienteDAO.actualizarPacientePorID(id, paciente);
        if (pacienteActualizado != null) {
            return pacienteActualizado;
        }

        return null;
    }
}
