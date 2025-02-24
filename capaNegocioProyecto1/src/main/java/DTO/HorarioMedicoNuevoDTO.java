/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import Entidades.Horario;
import Entidades.Medico;

/**
 *
 * @author PC
 */
public class HorarioMedicoNuevoDTO { 
    private Medico medico;
    private Horario horario;

    /**
     *
     */
    public HorarioMedicoNuevoDTO() {
    }

    /**
     *
     * @param medico
     * @param horario
     */
    public HorarioMedicoNuevoDTO(Medico medico, Horario horario) {
        this.medico = medico;
        this.horario = horario;
    }

    /**
     *
     * @return
     */
    public Medico getMedico() {
        return medico;
    }

    /**
     *
     * @param medico
     */
    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    /**
     *
     * @return
     */
    public Horario getHorario() {
        return horario;
    }

    /**
     *
     * @param horario
     */
    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "HorarioMedicoNuevoDTO{" + "medico=" + medico + ", horario=" + horario + '}';
    }
    
}
