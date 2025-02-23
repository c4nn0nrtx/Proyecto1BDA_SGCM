/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import Conexion.IConexionBD;
import DAO.HorarioDAO;
import DAO.HorarioMedicoDAO;
import DAO.IHorarioDAO;
import DAO.IHorarioMedicoDAO;
import DAO.IMedicoDAO;
import DAO.MedicoDAO;
import DTO.HorarioMedicoNuevoDTO;
import DTO.MedicoNuevoDTO;
import Entidades.Horario_Medico;
import Exception.NegocioException;
import Exception.PersistenciaException;
import Mapper.Mapper;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class HorarioMedicoBO {
    private static final Logger logger = Logger.getLogger(HorarioMedicoBO.class.getName());
    private final IMedicoDAO medicoDAO;
    private final IHorarioDAO horarioDAO;
    private final IHorarioMedicoDAO horarioMedicoDAO;
    private final IConexionBD conexionBD;
    Mapper mapper = new Mapper();

    
    public HorarioMedicoBO(IConexionBD conexion) {
        this.conexionBD = conexion;
        this.medicoDAO = new MedicoDAO(conexion);
        this.horarioDAO = new HorarioDAO(conexion);
        this.horarioMedicoDAO = new HorarioMedicoDAO(conexion);
        
    }
    
    public List<HorarioMedicoNuevoDTO> obtenerHorariosMedicos() throws NegocioException, SQLException {
        Connection con = null;
        
        try {
            con = this.conexionBD.crearConexion();
            
            List<Horario_Medico> horariosMedicos = horarioMedicoDAO.obtenerHorariosMedicos();
            int i = 0;
            List<HorarioMedicoNuevoDTO> horariosMedicosDTO = new ArrayList<>();
            while(i < horariosMedicos.size()){
                if (horarioMedicoDAO.consultarHorariosDisponibles(horariosMedicos.get(i))){
                    HorarioMedicoNuevoDTO horarioMedicoNuevoDTO = mapper.Horario_MedicoToNuevoDTO(horariosMedicos.get(i));

                    horariosMedicosDTO.add(horarioMedicoNuevoDTO);
                                      
                }
                i++;  

            }
            return horariosMedicosDTO;
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error, No se pudieron encontrar al medico. Intenta de nuevo.", ex);
        }
        return null;
    }
    
}
