
package Entidades;

import java.time.LocalTime;

/**
 * Representa un horario para un doctor.
 * @author Sebastian Moreno
 */
public class Horario {
    private int idHorario;
    private String diaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    /**
     * Constuctor vacio.
     */
    public Horario() {
    }
    /**
     * Constructor con todos los atributos.
     * @param id
     * @param diaSemana
     * @param horaInicio
     * @param horaFin 
     */
    public Horario(int idHorario, String diaSemana, LocalTime horaInicio, LocalTime horaFin) {
        this.idHorario = idHorario;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }
    /**
     * Contructor sin id.
     * @param diaSemana
     * @param horaInicio
     * @param horaFin 
     */
    public Horario(String diaSemana, LocalTime horaInicio, LocalTime horaFin) {
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    /**
     *
     * @return
     */
    public int getIdHorario() {
        return idHorario;
    }

    /**
     *
     * @param id
     */
    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    /**
     *
     * @return
     */
    public String getDiaSemana() {
        return diaSemana;
    }

    /**
     *
     * @param diaSemana
     */
    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    /**
     *
     * @return
     */
    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    /**
     *
     * @param horaInicio
     */
    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     *
     * @return
     */
    public LocalTime getHoraFin() {
        return horaFin;
    }

    /**
     *
     * @param horaFin
     */
    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Horario{" + "idHorario=" + idHorario + ", diaSemana=" + diaSemana + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + '}';
    }
    
    
}
