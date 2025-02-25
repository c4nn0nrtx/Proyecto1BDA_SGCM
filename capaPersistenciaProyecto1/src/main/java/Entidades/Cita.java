package Entidades;

import java.time.LocalDateTime;

/**
 * Cita.java
 *
 * Clase Entidad que representa una cita en el sistema.
 *
 * @author Brandon Valenzuela
 */
public class Cita {

    private int idCita;
    private String estado;
    private LocalDateTime fechaHora;
    private String folio;
    private String tipo;
    private Medico medico;
    private Paciente paciente;

    /**
     * Constructor vacío de la clase Cita.
     */
    public Cita() {
    }

    /**
     * Constructor de la clase Cita con todos los atributos, incluyendo el ID.
     *
     * @param idCita El ID de la cita.
     * @param estado El estado de la cita.
     * @param fechaHora La fecha y hora de la cita.
     * @param folio El folio de la cita.
     * @param tipo El tipo de cita.
     * @param medico El médico asignado a la cita.
     * @param paciente El paciente asignado a la cita.
     */
    public Cita(int idCita, String estado, LocalDateTime fechaHora, String folio, String tipo, Medico medico, Paciente paciente) {
        this.idCita = idCita;
        this.estado = estado;
        this.fechaHora = fechaHora;
        this.folio = folio;
        this.tipo = tipo;
        this.medico = medico;
        this.paciente = paciente;
    }

    /**
     * Constructor de la clase Cita con todos los atributos, excepto el ID. Se
     * usa para crear nuevas citas.
     *
     * @param estado El estado de la cita.
     * @param fechaHora La fecha y hora de la cita.
     * @param folio El folio de la cita.
     * @param tipo El tipo de cita.
     * @param medico El médico asignado a la cita.
     * @param paciente El paciente asignado a la cita.
     */
    public Cita(String estado, LocalDateTime fechaHora, String folio, String tipo, Medico medico, Paciente paciente) {
        this.estado = estado;
        this.fechaHora = fechaHora;
        this.folio = folio;
        this.tipo = tipo;
        this.medico = medico;
        this.paciente = paciente;
    }

    /**
     * Obtiene el ID de la cita.
     *
     * @return El ID de la cita.
     */
    public int getIdCita() {
        return idCita;
    }

    /**
     * Establece el ID de la cita.
     *
     * @param idCita El ID de la cita.
     */
    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    /**
     * Obtiene el estado de la cita.
     *
     * @return El estado de la cita.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la cita.
     *
     * @param estado El estado de la cita.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtiene la fecha y hora de la cita.
     *
     * @return La fecha y hora de la cita.
     */
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    /**
     * Establece la fecha y hora de la cita.
     *
     * @param fechaHora La fecha y hora de la cita.
     */
    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Obtiene el folio de la cita.
     *
     * @return El folio de la cita.
     */
    public String getFolio() {
        return folio;
    }

    /**
     * Establece el folio de la cita.
     *
     * @param folio El folio de la cita.
     */
    public void setFolio(String folio) {
        this.folio = folio;
    }

    /**
     * Obtiene el tipo de cita.
     *
     * @return El tipo de cita.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de cita.
     *
     * @param tipo El tipo de cita.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene el médico asignado a la cita.
     *
     * @return El médico asignado a la cita.
     */
    public Medico getMedico() {
        return medico;
    }

    /**
     * Establece el médico asignado a la cita.
     *
     * @param medico El médico asignado a la cita.
     */
    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    /**
     * Obtiene el paciente asignado a la cita.
     *
     * @return El paciente asignado a la cita.
     */
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * Establece el paciente asignado a la cita.
     *
     * @param paciente El paciente asignado a la cita.
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    /**
     * Devuelve una representación en cadena del objeto Cita.
     *
     * @return Una cadena que representa al objeto Cita.
     */
    @Override
    public String toString() {
        return "Cita{" + "idCita=" + idCita + ", estado=" + estado + ", fechaHora=" + fechaHora + ", folio=" + folio + ", tipo=" + tipo + ", medico=" + medico + ", paciente=" + paciente + '}';
    }

}
