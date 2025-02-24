/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

    public ConsultaBO(IConexionBD conexion) {
        this.consultaDAO = new ConsultaDAO(conexion);
        this.citaDAO = new CitaDAO(conexion);
        this.conexionBD = conexion;
        this.citaBO = new CitaBO(conexion);
    }
    
    public boolean agregarConsulta(ConsultaNuevaDTO consultaNueva, Cita cita) throws NegocioException, SQLException {
        if (consultaNueva == null) {
            throw new NegocioException("La consulta no puede ser nula");
        }
        if (cita == null) {
            throw new NegocioException("La cita no puede ser nula");
        }
        
        Connection con = null;
        try {
            con = this.conexionBD.crearConexion();
            con.setAutoCommit(false);
            
            consultaNueva.setCita(cita);
            Consulta consulta = mapper.DTOConsultaToEntity(consultaNueva);
            
            consultaDAO.agregarConsulta(consulta);
            if (citaDAO.actualizarEstadoCita(cita.getIdCita())) {
                logger.log(Level.SEVERE, "Estado de la cita actualizado correctamente.");
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
    
    public ConsultaNuevaDTO obtenerConsultasPaciente(Cita citaNueva) throws PersistenciaException, NegocioException {
        if (citaNueva == null) {
            throw new NegocioException("La cita no puede ser nula");
        }
        
        Consulta consulta = consultaDAO.obtenerConsultasPaciente(citaNueva);
        ConsultaNuevaDTO consultaNueva = mapper.ConsultaToNuevaDTO(consulta);
        return consultaNueva;
    }
        
}
