package BO;

import Conexion.IConexionBD;
import DAO.CitaDAO;
import DAO.ConsultaDAO;
import DAO.ICitaDAO;
import DAO.IConsultaDAO;
import DTO.CitaNuevoDTO;
import DTO.ConsultaNuevaDTO;
import Entidades.Cita;
import Entidades.Consulta;
import Exception.NegocioException;
import Exception.PersistenciaException;
import Mapper.Mapper;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase de negocio para gestionar las consultas médicas.
 * Esta clase contiene la lógica de negocio para agregar y obtener consultas.
 *
 * @author brand
 */
public class ConsultaBO {
        private static final Logger logger = Logger.getLogger(CitaBO.class.getName());
        private final IConsultaDAO consultaDAO;
        private final IConexionBD conexionBD;
        private CitaBO citaBO;
        private final ICitaDAO citaDAO;
        Mapper mapper = new Mapper();

    /**
     * Constructor de la clase ConsultaBO.
     *
     * @param conexion La conexión a la base de datos.
     */
    public ConsultaBO(IConexionBD conexion) {
        this.consultaDAO = new ConsultaDAO(conexion);
        this.citaDAO = new CitaDAO(conexion);
        this.conexionBD = conexion;
        this.citaBO = new CitaBO(conexion);
    }
    
    /**
     * Agrega una consulta médica.
     * Valida los datos de la consulta y la cita, y luego guarda la consulta en la base de datos.
     *
     * @param consultaNueva Los datos de la nueva consulta (DTO).
     * @param cita La cita asociada a la consulta (Entidad).
     * @return true si la consulta se agregó correctamente, false en caso contrario.
     * @throws NegocioException Si hay un error en la lógica de negocio, como datos inválidos.
     * @throws SQLException Si hay un error en la base de datos.
     */
    public boolean agregarConsulta(ConsultaNuevaDTO consultaNueva, Cita cita) throws NegocioException, SQLException {
        // Validaciones
        if (consultaNueva == null) {
            throw new NegocioException("La consulta no puede ser nula");
        }
        if (cita == null) {
            throw new NegocioException("La cita no puede ser nula");
        }
        if (consultaNueva.getDiagnostico() == null || consultaNueva.getDiagnostico().isEmpty()) {
            throw new NegocioException("El diagnóstico no puede ser nulo o vacío");
        }
        if (consultaNueva.getTratamiento() == null || consultaNueva.getTratamiento().isEmpty()) {
            throw new NegocioException("El tratamiento no puede ser nulo o vacío");
        }
        
        Connection con = null;
        try {
            con = this.conexionBD.crearConexion();
            con.setAutoCommit(false);
            
            consultaNueva.setCita(cita);
            Consulta consulta = mapper.DTOConsultaToEntity(consultaNueva);
            
            
            if (consultaDAO.agregarConsulta(consulta) != null) {
                logger.log(Level.SEVERE, "Consulta realizada correctamente.");
                con.commit();
            };
            
            return true;
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error, No se pudo agregar la consulta. Intenta de nuevo.", ex);
            
        } catch (SQLException e){
            con.rollback(); // por si no funciona utilizamos el rollback de la transaccion.
        }
        return false;
    }
    
    /**
     * Obtiene la consulta de un paciente asociada a una cita.
     *
     * @param citaNueva La cita para la cual se va a obtener la consulta.
     * @return La consulta del paciente (DTO), o null si no se encuentra.
     * @throws PersistenciaException Si hay un error en la base de datos.
     * @throws NegocioException     Si hay un error en la lógica de negocio.
     */
    public ConsultaNuevaDTO obtenerConsultasPaciente(Cita citaNueva) throws PersistenciaException, NegocioException {
        if (citaNueva == null) {
            throw new NegocioException("La cita no puede ser nula");
        }
        
        Consulta consulta = consultaDAO.obtenerConsultasPaciente(citaNueva);
        ConsultaNuevaDTO consultaNueva = mapper.ConsultaToNuevaDTO(consulta);
        return consultaNueva;
    }
        
}
