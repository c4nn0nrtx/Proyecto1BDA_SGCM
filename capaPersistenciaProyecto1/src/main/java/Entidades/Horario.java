
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public LocalDateTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalDateTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalDateTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalDateTime horaFin) {
        this.horaFin = horaFin;
    }

    @Override
    public String toString() {
        return "Horario{" + "id=" + id + ", diaSemana=" + diaSemana + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + '}';
    }
    
    
}
