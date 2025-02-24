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
 * Clase de negocio para gestionar pacientes. Esta clase contiene la lógica de
 * negocio para agregar, buscar y actualizar pacientes, incluyendo la gestión de
 * usuario y dirección asociada.
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
     * Constructor de la clase PacienteBO.
     *
     * @param conexion La conexión a la base de datos.
     */
    public PacienteBO(IConexionBD conexion) {
        this.pacienteDAO = new PacienteDAO(conexion);
        this.conexionBD = conexion;
        this.usuarioBO = new UsuarioBO(conexion);
        this.direccionBO = new Direccion_PacienteBO(conexion);
    }

    /**
     * Agrega un nuevo paciente, incluyendo usuario y dirección. Realiza una
     * transacción para asegurar la consistencia de los datos.
     *
     * @param pacienteNuevo Los datos del paciente (DTO).
     * @param usuarioNuevo Los datos del usuario (DTO).
     * @param direccionNueva Los datos de la dirección (DTO).
     * @return true si el paciente se agregó correctamente, false en caso
     * contrario.
     * @throws NegocioException Si hay un error en la lógica de negocio, como
     * datos inválidos.
     * @throws SQLException Si hay un error en la base de datos.
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
     * Busca un paciente por su ID.
     *
     * @param id El ID del paciente.
     * @return El paciente encontrado (entidad), o null si no se encuentra.
     * @throws PersistenciaException Si hay un error en la base de datos.
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
     * Actualiza los datos de un paciente.
     *
     * @param id El ID del paciente a actualizar.
     * @param pacienteNuevo Los datos actualizados del paciente (DTO).
     * @return El paciente actualizado (entidad).
     * @throws PersistenciaException Si hay un error en la base de datos.
     * @throws NegocioException Si hay un error en la lógica de negocio.
     */
    public Paciente actualizarPaciente(int id, PacienteNuevoDTO pacienteNuevo) throws PersistenciaException, NegocioException { // FALTAN VERIFICACIONES PARA ANTES DE ACTUALIZAR
        if (pacienteNuevo == null) {
            throw new NegocioException("Los datos del paciente no pueden ser nulos.");
        }
        if (pacienteNuevo.getNombre() == null || pacienteNuevo.getNombre().isEmpty()) {
            throw new NegocioException("El nombre del paciente no puede ser nulo o vacío.");
        }
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

    /**
     * Busca un paciente por su número de celular.
     *
     * @param celular El número de celular del paciente.
     * @return El paciente encontrado (entidad), o null si no se encuentra.
     * @throws PersistenciaException Si hay un error en la base de datos.
     */
    public Paciente buscarPacientePorCelular(String celular) throws PersistenciaException {
        try {
            Paciente pacienteEncontrado = pacienteDAO.consultarPacientePorCelular(celular);
            if (pacienteEncontrado != null) {
                return pacienteEncontrado;
            } else {
                logger.warning("No se encontró un paciente con telefono: " + celular);
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al buscar paciente con telefono: " + celular, e);
            throw new PersistenciaException("Error al buscar paciente.", e);
        }
        return null; // Devuelve null si el paciente no se encuentra
    }
}
