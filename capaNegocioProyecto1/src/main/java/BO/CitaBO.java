
package BO;

import Conexion.IConexionBD;
import DAO.CitaDAO;
import DAO.ICitaDAO;
import DAO.MedicoDAO;
import DAO.PacienteDAO;
import DTO.CitaNuevoDTO;
import DTO.MedicoNuevoDTO;
import DTO.PacienteNuevoDTO;
import Entidades.Cita;
import Entidades.Medico;
import Entidades.Paciente;
import Exception.NegocioException;
import Exception.PersistenciaException;
import Mapper.Mapper;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ramon Valencia
 */
public class CitaBO {
    private static final Logger logger = Logger.getLogger(CitaBO.class.getName());
    private final ICitaDAO citaDAO;
    private final IConexionBD conexionBD;
    private PacienteBO pacienteBO;
    private MedicoBO medicoBO;
    Mapper mapper = new Mapper();

    public CitaBO(IConexionBD conexion) {
        this.citaDAO = new CitaDAO(conexion);
        this.conexionBD = conexion;
        this.pacienteBO = new PacienteBO(conexion);
        //this.medicoBO = new MedicoBO(conexion);
    }
    
    // QUITAR TODO LO DE LOS COMENTARIOS CUANDO SE AGREGUEN TODO LA LOGICA DE LOS MEDICOS
    public boolean agendarCita(CitaNuevoDTO citaNueva, PacienteNuevoDTO pacienteNuevo, MedicoNuevoDTO medicoNuevo) throws NegocioException, SQLException {
        if (citaNueva == null){
            throw new NegocioException("La cita no puede ser nula");
        }
        if (pacienteNuevo == null){
            throw new NegocioException("El paciente no puede ser nulo");
        }
        if (medicoNuevo == null){
            throw new NegocioException("El medico no puede ser nulo");
        }
        
        Connection con = null;
        try {
            con = this.conexionBD.crearConexion();
            con.setAutoCommit(false);
            
            Medico medico = mapper.DTOMedicoToEntity(medicoNuevo);
            Paciente paciente = mapper.DTOPacienteToEntity(pacienteNuevo);
            citaNueva.setMedico(medico);
            citaNueva.setPaciente(paciente);
            Cita cita = mapper.DTOCitaToEntity(citaNueva);
            
            citaDAO.agendarCita(cita);
            
            con.commit();
            return true;
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error, No se pudo agregar la cita. Intenta de nuevo.", ex);
            
        } catch (SQLException e){
            con.rollback(); 
        }
        return false;
    } 
    
}
