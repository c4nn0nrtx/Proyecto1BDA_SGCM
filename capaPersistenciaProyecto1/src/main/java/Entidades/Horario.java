
package Entidades;

import java.time.LocalDateTime;

/**
 * Representa un horario para un doctor.
 * @author Sebastian Moreno
 */
public class Horario {
    private int id;
    private String diaSemana;
    private LocalDateTime horaInicio;
    private LocalDateTime horaFin;
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
    public Horario(int id, String diaSemana, LocalDateTime horaInicio, LocalDateTime horaFin) {
        this.id = id;
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
    public Horario(String diaSemana, LocalDateTime horaInicio, LocalDateTime horaFin) {
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
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
    public LocalDateTime getHoraInicio() {
        return horaInicio;
    }

    /**
     *
     * @param horaInicio
     */
    public void setHoraInicio(LocalDateTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     *
     * @return
     */
    public LocalDateTime getHoraFin() {
        return horaFin;
    }

    /**
     *
     * @param horaFin
     */
    public void setHoraFin(LocalDateTime horaFin) {
        this.horaFin = horaFin;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Horario{" + "id=" + id + ", diaSemana=" + diaSemana + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + '}';
    }
    
    
}
