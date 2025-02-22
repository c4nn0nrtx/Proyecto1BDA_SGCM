/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import Conexion.IConexionBD;
import DAO.ConsultaDAO;
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
        Mapper mapper = new Mapper();

    public ConsultaBO(IConexionBD conexion) {
        this.consultaDAO = new ConsultaDAO(conexion);
        this.conexionBD = conexion;
        this.citaBO = new CitaBO(conexion);
    }
    
    public boolean agregarConsulta(ConsultaNuevaDTO consultaNueva, CitaNuevoDTO citaNueva) throws NegocioException, SQLException {
        if (consultaNueva == null) {
            throw new NegocioException("La consulta no puede ser nula");
        }
        if (citaNueva == null) {
            throw new NegocioException("La cita no puede ser nula");
        }
        
        Connection con = null;
        try {
            con = this.conexionBD.crearConexion();
            con.setAutoCommit(false);
            
            Cita cita = mapper.DTOCitaToEntity(citaNueva);
            //cita.setIdCita(aqui agregare un metodo para consultar el idCita);
            consultaNueva.setCita(cita);
            Consulta consulta = mapper.DTOConsultaToEntity(consultaNueva);
            
            consultaDAO.agregarConsulta(consulta);
            
            con.commit();
            return true;
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error, No se pudo agregar la consulta. Intenta de nuevo.", ex);
            
        } catch (SQLException e){
            con.rollback(); // por si no funciona utilizamos el rollback de la transaccion.
        }
        return false;
    }
        
}
