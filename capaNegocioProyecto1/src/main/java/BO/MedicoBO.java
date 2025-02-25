package BO;

import Conexion.IConexionBD;
import DAO.IMedicoDAO;
import DAO.MedicoDAO;
import DTO.MedicoNuevoDTO;
import Entidades.Medico;
import Entidades.Usuario;
import Exception.NegocioException;
import Exception.PersistenciaException;
import Mapper.Mapper;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase de negocio para gestionar médicos. Esta clase contiene la lógica de
 * negocio para consultar, obtener por especialidad, actualizar y obtener
 * médicos con horario.
 *
 * @author Ramon Valencia
 */
public class MedicoBO {

    private static final Logger logger = Logger.getLogger(MedicoBO.class.getName());
    private final IMedicoDAO medicoDAO;
    private final IConexionBD conexionBD;
    Mapper mapper = new Mapper();

    /**
     * Constructor de la clase MedicoBO.
     *
     * @param conexion La conexión a la base de datos.
     */
    public MedicoBO(IConexionBD conexion) {
        this.conexionBD = conexion;
        this.medicoDAO = new MedicoDAO(conexion);
    }

    /**
     * Consulta un médico por su ID de usuario.
     *
     * @param usuario El usuario asociado al médico.
     * @return Los datos del médico (DTO).
     * @throws NegocioException Si hay un error en la lógica de negocio, como un
     * usuario nulo.
     * @throws SQLException Si hay un error en la base de datos.
     * @throws PersistenciaException Si hay un error en la base de datos.
     */
    public MedicoNuevoDTO consultarMedico(Usuario usuario) throws NegocioException, SQLException, PersistenciaException {
        if (usuario == null) {
            throw new NegocioException("El usuario no puede ser nulo");
        }

        Connection con = null;
        try {
            con = this.conexionBD.crearConexion();
            Medico medico = medicoDAO.consultarMedicoPorId(usuario.getIdUsuario());
            MedicoNuevoDTO medicoNuevo = mapper.MedicoToNuevoDTO(medico);
            return medicoNuevo;
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error, No se pudo encontrar al medico. Intenta de nuevo.", ex);
        }
        return null;
    }

    /**
     * Obtiene una lista de médicos por especialidad.
     *
     * @param especialidad La especialidad de los médicos.
     * @return Una lista de médicos (DTOs).
     * @throws PersistenciaException Si hay un error en la base de datos.
     * @throws NegocioException Si hay un error en la lógica de negocio, como
     * una especialidad nula.
     */
    public List<MedicoNuevoDTO> obtenerPorEspecialidad(String especialidad) throws PersistenciaException, NegocioException {

        if (especialidad == null || especialidad.isEmpty()) {
            throw new NegocioException("La especialidad no puede ser nula o vacía.");
        }

        Connection con = null;
        try {
            con = this.conexionBD.crearConexion();

            List<Medico> medicos = medicoDAO.obtenerPorEspecialidad(especialidad);
            int i = 0;
            List<MedicoNuevoDTO> medicosDTO = new ArrayList<>();
            while (i < medicos.size()) {
                MedicoNuevoDTO medicoNuevo = mapper.MedicoToNuevoDTO(medicos.get(i));

                medicosDTO.add(medicoNuevo);
            }

            return medicosDTO;
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error, No se pudieron encontrar al medico. Intenta de nuevo.", ex);
        }
        return null;
    }

    /**
     * Actualiza el estado de un médico.
     *
     * @param medicoNuevo Los datos del médico a actualizar (DTO).
     * @param estado El nuevo estado del médico.
     * @return true si el estado se actualizó correctamente, false en caso
     * contrario.
     * @throws PersistenciaException Si hay un error en la base de datos.
     * @throws NegocioException Si hay un error en la lógica de negocio, como un
     * médico nulo o un estado igual al actual.
     */
    public boolean actualizarMedico(MedicoNuevoDTO medicoNuevo, String estado) throws PersistenciaException, NegocioException {
        if (medicoNuevo == null) {
            throw new NegocioException("El medico no puede ser nulo");
        }
        if (estado == null || estado.isEmpty()) {
            throw new NegocioException("El estado no puede ser nulo o vacío.");
        }
        if (estado == medicoNuevo.getEstado()) {
            logger.log(Level.SEVERE, "El estado ya se encuentra: " + estado);
            return false;
        }
        Connection con = null;
        try {
            con = this.conexionBD.crearConexion();

            Medico medico = mapper.DTOMedicoToEntity(medicoNuevo);
            if (medicoDAO.actualizarEstadoMedico(medico, estado)) {
                return true;
            }

        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error, No sse pudo cambiar el estado del medico.", ex);
        }
        return false;
    }

    /**
     * Obtiene una lista de médicos con horario asignado.
     *
     * @return Una lista de médicos (entidades).
     * @throws SQLException Si hay un error en la base de datos.
     * @throws PersistenciaException Si hay un error en la base de datos.
     */
    public List<Medico> obtenerMedicosConHorario() throws SQLException, PersistenciaException {
        return medicoDAO.obtenerMedicosConHorario();
    }

    /**
     * Obtiene un médico por su nombre completo.
     *
     * @param nombreCompleto El nombre completo del médico.
     * @return Los datos del médico (DTO), o null si no se encuentra.
     * @throws NegocioException Si hay un error en la lógica de negocio.
     */
    public MedicoNuevoDTO obtenerMedicoPorNombre(String nombreCompleto) throws NegocioException {
        try {
            Medico medico = medicoDAO.obtenerMedicoPorNombre(nombreCompleto);
            if (medico == null) {
                return null;
            }
            return mapper.MedicoToNuevoDTO(medico);
        } catch (PersistenciaException ex) {
            Logger.getLogger(MedicoBO.class.getName()).log(Level.SEVERE, "Error en negocio al obtener médico por nombre", ex);
            throw new NegocioException("Error al obtener el médico con nombre: " + nombreCompleto, ex);
        }
    }
}
