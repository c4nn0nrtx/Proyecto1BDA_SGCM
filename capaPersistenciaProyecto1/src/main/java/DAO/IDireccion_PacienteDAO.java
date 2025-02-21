
package DAO;

import Entidades.Direccion_Paciente;
import Exception.PersistenciaException;

/**
 * Esta interfaz representa los metodos de la clase Direccion_PacienteDAO
 * @author Ramon
 */
public interface IDireccion_PacienteDAO {
    /**
     * Agrega una direccion
     * @param direccion 
     * @return la direccion creada
     * @throws PersistenciaException 
     */
    public Direccion_Paciente agregarDireccion(Direccion_Paciente direccion) throws PersistenciaException;
    /**
     * Consulta una direccion por id.
     * @param id
     * @return La direccion consultada
     * @throws PersistenciaException 
     */
    public Direccion_Paciente consultarDireccionPorId(int id) throws PersistenciaException;
    /**
     * Consulta el id de una direccion dada.
     * @param direccion
     * @return el id de la direccion dada.
     * @throws PersistenciaException 
     */
    public int consultaIdDireccion(Direccion_Paciente direccion) throws PersistenciaException;
    /**
     * Actualiza una direccion especifica
     * @param direccion
     * @return la direccion actualizada.
     * @throws PersistenciaException 
     */
    public Direccion_Paciente actualizarDireccion(Direccion_Paciente direccion) throws PersistenciaException;
    
}

