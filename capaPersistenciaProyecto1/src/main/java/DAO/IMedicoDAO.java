
package DAO;

import Entidades.Medico;
import Exception.PersistenciaException;
import java.util.List;
/**
 * Esta interfaz representan los metodos CRU de un medico.
 * @author Sebastian Moreno
 */ 
public interface IMedicoDAO {
    /**
     * Agrega un medico a la base de datos.
     * @param medico
     * @return un Objeto del tipo Medico.
     * @throws PersistenciaException 
     */
    public Medico agregarMedico(Medico medico)throws PersistenciaException;
    
    /**
     * Consulta un Medico por su id.
     * @param id
     * @return un objeto del tipo Medico.
     * @throws PersistenciaException 
     */
    public Medico consultarMedicoPorId(int id) throws PersistenciaException;
    
    /**
     * Devuelve una lista de medicos filtrados por especialidad.
     * @param especialidad
     * @return Una lista de Medicos filtrados por su especialidad.
     * @throws PersistenciaException 
     */
    public List<Medico> obtenerPorEspecialidad(String especialidad) throws PersistenciaException;
    
    /**
     *  Metodo para actualizar el estado de un Medico
     * @param medico
     * @return regresa Verdadero si se actualizo
     * @throws PersistenciaException 
     */
    public boolean actualizarEstadoMedico(Medico medico, String estado)throws PersistenciaException;
    
  
    
}
