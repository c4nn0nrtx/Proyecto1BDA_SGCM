/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author Ramon Valencia
 */
public class Horario_Medico {
    private int idHorMed;
    private Horario horario;
    private Medico medico;

    public Horario_Medico() {
    }

    public Horario_Medico(int idHorMed, Horario horario, Medico medico) {
        this.idHorMed = idHorMed;
        this.horario = horario;
        this.medico = medico;
    }

    public Horario_Medico(Horario horario, Medico medico) {
        this.horario = horario;
        this.medico = medico;
    }

    public int getIdHorMed() {
        return idHorMed;
    }

    public void setIdHorMed(int idHorMed) {
        this.idHorMed = idHorMed;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    @Override
    public String toString() {
        return "Horario_Medico{" + "idHorMed=" + idHorMed + ", horario=" + horario + ", medico=" + medico + '}';
    }
    
    
}
