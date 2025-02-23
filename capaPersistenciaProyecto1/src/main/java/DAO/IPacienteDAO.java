
package DAO;

import Entidades.Paciente;
import Exception.PersistenciaException;

/**
 * Esta interfaz representa los metodos DAO de medicos.
 * @author Ramon Valencia
 */
public interface IPacienteDAO {
    /**
     * Metodo para agregar un paciente
     * @param paciente
     * @return el paciente agregado para su uso en BO.
     * @throws PersistenciaException 
     */
    public Paciente agregarPaciente(Paciente paciente) throws PersistenciaException;
    /**
     * Metodo para consultar un paciente por su id.
     * @param id
     * @return el paciente consultado.
     * @throws PersistenciaException 
     */
    public Paciente consultarPacientePorId(int id) throws PersistenciaException;
    /**
     * Actualiza los atributos de un paciente .
     * @param paciente
     * @return El paciente actualizado.
     * @throws PersistenciaException 
     */
    public Paciente actualizarPacientePorID(int id, Paciente paciente) throws PersistenciaException;
    
    public Paciente consultarPacientePorCelular(String celular) throws PersistenciaException;
}
