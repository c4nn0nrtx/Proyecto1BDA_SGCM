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

    public HorarioMedicoNuevoDTO() {
    }

    public HorarioMedicoNuevoDTO(Medico medico, Horario horario) {
        this.medico = medico;
        this.horario = horario;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "HorarioMedicoNuevoDTO{" + "medico=" + medico + ", horario=" + horario + '}';
    }
    
}
