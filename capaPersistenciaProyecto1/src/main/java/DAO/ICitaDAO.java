/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Entidades.Cita;
import Entidades.Horario_Medico;
import Exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author Ramon Valencia
 */
public interface ICitaDAO {
    /**
     * 
     * @param cita
     * @return
     * @throws PersistenciaException 
     */
    public Cita agendarCita(Cita cita) throws PersistenciaException;
    
    public List<Cita> consultarCitasProgramadasAgenda(Cita cita,Horario_Medico horario) throws PersistenciaException;
    
}
