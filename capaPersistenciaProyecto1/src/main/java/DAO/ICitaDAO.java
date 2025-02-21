/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Entidades.Cita;
import Exception.PersistenciaException;

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
}
