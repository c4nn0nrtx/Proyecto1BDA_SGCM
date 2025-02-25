package Entidades;

import java.time.LocalTime;

/**
 * Representa un horario para un doctor.
 *
 * @author Sebastian Moreno
 */
public class Horario {

    private int idHorario;
    private String diaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    /**
     * Constructor vacío de la clase Horario.
     */
    public Horario() {
    }

    /**
     * Constructor de la clase Horario con todos los atributos, incluyendo el
     * ID.
     *
     * @param idHorario El ID del horario.
     * @param diaSemana El día de la semana del horario.
     * @param horaInicio La hora de inicio del horario.
     * @param horaFin La hora de fin del horario.
     */
    public Horario(int idHorario, String diaSemana, LocalTime horaInicio, LocalTime horaFin) {
        this.idHorario = idHorario;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    /**
     * Constructor de la clase Horario con todos los atributos, excepto el ID.
     * Se usa para crear nuevos horarios.
     *
     * @param diaSemana El día de la semana del horario.
     * @param horaInicio La hora de inicio del horario.
     * @param horaFin La hora de fin del horario.
     */
    public Horario(String diaSemana, LocalTime horaInicio, LocalTime horaFin) {
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    /**
     * Obtiene el ID del horario.
     *
     * @return El ID del horario.
     */
    public int getIdHorario() {
        return idHorario;
    }

    /**
     * Establece el ID del horario.
     *
     * @param idHorario El ID del horario.
     */
    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    /**
     * Obtiene el día de la semana del horario.
     *
     * @return El día de la semana del horario.
     */
    public String getDiaSemana() {
        return diaSemana;
    }

    /**
     * Establece el día de la semana del horario.
     *
     * @param diaSemana El día de la semana del horario.
     */
    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    /**
     * Obtiene la hora de inicio del horario.
     *
     * @return La hora de inicio del horario.
     */
    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    /**
     * Establece la hora de inicio del horario.
     *
     * @param horaInicio La hora de inicio del horario.
     */
    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * Obtiene la hora de fin del horario.
     *
     * @return La hora de fin del horario.
     */
    public LocalTime getHoraFin() {
        return horaFin;
    }

    /**
     * Establece la hora de fin del horario.
     *
     * @param horaFin La hora de fin del horario.
     */
    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    /**
     * Devuelve una representación en cadena del objeto Horario.
     *
     * @return Una cadena que representa al objeto Horario.
     */
    @Override
    public String toString() {
        return "Horario{" + "idHorario=" + idHorario + ", diaSemana=" + diaSemana + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + '}';
    }

}
