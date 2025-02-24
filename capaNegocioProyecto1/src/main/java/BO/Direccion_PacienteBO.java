package BO;

import Conexion.IConexionBD;
import DAO.Direccion_PacienteDAO;
import DAO.IDireccion_PacienteDAO;
import DTO.Direccion_PacienteNuevaDTO;
import Entidades.Direccion_Paciente;
import Exception.NegocioException;
import Exception.PersistenciaException;
import Mapper.Mapper;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase de negocio para gestionar las direcciones de pacientes.
 * Esta clase contiene la lógica de negocio para agregar y actualizar direcciones de pacientes.
 *
 * @author PC
 */
public class Direccion_PacienteBO {

    private static final Logger logger = Logger.getLogger(PacienteBO.class.getName());
    private final IDireccion_PacienteDAO direccionPacienteDAO;
    private final IConexionBD conexionBD;
    Mapper mapper = new Mapper();

    /**
     * Constructor de la clase Direccion_PacienteBO.
     *
     * @param conexion La conexión a la base de datos.
     */
    public Direccion_PacienteBO(IConexionBD conexion) {
        this.direccionPacienteDAO = new Direccion_PacienteDAO(conexion);
        this.conexionBD = conexion;
    }
   /**
     * Agrega una nueva dirección de paciente.
     * Valida los datos de la dirección y luego la guarda en la base de datos.
     *
     * @param direccionNueva Los datos de la nueva dirección (DTO).
     * @return La dirección creada (entidad).
     * @throws NegocioException Si hay un error en la lógica de negocio, como datos inválidos.
     */
    public Direccion_Paciente agregarDireccionPaciente(Direccion_PacienteNuevaDTO direccionNueva) throws NegocioException {
        // Validación
        if (direccionNueva == null) {
            throw new NegocioException("La dirección no puede ser nula.");
        }
        if (direccionNueva.getCalle() == null || direccionNueva.getCalle().isEmpty()) {
            throw new NegocioException("La calle no puede ser nula o vacía.");
        }
        if (direccionNueva.getNumero() == null || direccionNueva.getNumero().isEmpty()) {
            throw new NegocioException("El número no puede ser nulo o vacío.");
        }
        if (direccionNueva.getColonia() == null || direccionNueva.getColonia().isEmpty()) {
            throw new NegocioException("La colonia no puede ser nula o vacía.");
        }
  
        Direccion_Paciente direccionEntidad = mapper.DTODireccion_PacienteToEntity(direccionNueva);

        try {
            Direccion_Paciente direccionGuardada = direccionPacienteDAO.agregarDireccion(direccionEntidad);
            if (direccionGuardada == null) {
                throw new NegocioException("No se pudo registrar la dirección en la base de datos.");
            }
            return direccionGuardada;
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error al registrar la dirección.", ex);
            throw new NegocioException("Ocurrió un error al guardar la dirección. Inténtalo de nuevo.");
        }
    }
    
    /**
     * Actualiza una dirección de paciente.
     * Valida los datos de la dirección y luego la actualiza en la base de datos.
     *
     * @param direccionNueva Los datos de la dirección actualizada (entidad).
     * @return La dirección actualizada (entidad).
     * @throws NegocioException Si hay un error en la lógica de negocio, como datos inválidos.
     */
    public Direccion_Paciente actualizarDireccionPaciente(Direccion_Paciente direccionNueva)throws NegocioException{
       // Validación
        if (direccionNueva == null) {
            throw new NegocioException("La dirección no puede ser nula.");
        }
        if (direccionNueva.getCalle() == null || direccionNueva.getCalle().isEmpty()) {
            throw new NegocioException("La calle no puede ser nula o vacía.");
        }
        if (direccionNueva.getNumero() == null || direccionNueva.getNumero().isEmpty()) {
            throw new NegocioException("El número no puede ser nulo o vacío.");
        }
        if (direccionNueva.getColonia() == null || direccionNueva.getColonia().isEmpty()) {
            throw new NegocioException("La colonia no puede ser nula o vacía.");
        }
        
        try {
            Direccion_Paciente direccionGuardada = direccionPacienteDAO.actualizarDireccion(direccionNueva);
            if (direccionGuardada == null) {
                throw new NegocioException("No se pudo actualizar la dirección en la base de datos.");
            }
            return direccionGuardada;
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error al actualizar la dirección.", ex);
            throw new NegocioException("Ocurrió un error al actualizar la dirección. Inténtalo de nuevo.");
        }
        
       
    }

}
