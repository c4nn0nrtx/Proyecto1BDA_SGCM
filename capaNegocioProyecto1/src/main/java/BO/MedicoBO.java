
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
 * Esta clase representa un MedicoBO
 * @author Ramon Valencia
 */
public class MedicoBO {
    
    private static final Logger logger = Logger.getLogger(MedicoBO.class.getName());
    private final IMedicoDAO medicoDAO;
    private final IConexionBD conexionBD;
    Mapper mapper = new Mapper();
    
    public MedicoBO(IConexionBD conexion) {
        this.conexionBD = conexion;
        this.medicoDAO = new MedicoDAO(conexion);
    }
    
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
    
    public List<MedicoNuevoDTO> obtenerPorEspecialidad(String especialidad) throws PersistenciaException, NegocioException {
        
        if (especialidad == null) {
            throw new NegocioException("La especialidad no puede ser nula.");
        }
        
        Connection con = null;
        try {
            con = this.conexionBD.crearConexion();
            
            List<Medico> medicos = medicoDAO.obtenerPorEspecialidad(especialidad);
            int i = 0;
            List<MedicoNuevoDTO> medicosDTO = new ArrayList<>();
            while(i < medicos.size()){
                MedicoNuevoDTO medicoNuevo = mapper.MedicoToNuevoDTO(medicos.get(i));
                
                medicosDTO.add(medicoNuevo);
            }
            
            return medicosDTO;
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error, No se pudieron encontrar al medico. Intenta de nuevo.", ex);
        }
        return null;
    }
    
    public boolean actualizarMedico(MedicoNuevoDTO medicoNuevo, String estado) throws PersistenciaException, NegocioException {
        if (medicoNuevo == null) {
            throw new NegocioException("El medico no puede ser nulo");
        }
        if (estado == medicoNuevo.getEstado()){
            logger.log(Level.SEVERE, "El estado ya se encuentra: " + estado);
            return false;
        }
        Connection con = null;
        try {
            con = this.conexionBD.crearConexion();
            
            Medico medico = mapper.DTOMedicoToEntity(medicoNuevo);
            if(medicoDAO.actualizarEstadoMedico(medico, estado)){
                return true;
            }
            
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error, No sse pudo cambiar el estado del medico.", ex);
        }
        return false;
    }
}
