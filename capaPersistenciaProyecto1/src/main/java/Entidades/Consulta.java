package Entidades;

import java.time.LocalDateTime;

/**
 * Consulta.java
 *
 * Clase Entidad que representa una consulta en el sistema.
 *
 * @author Brandon Valenzuela
 */
public class Consulta {

    private int idConsulta;
    private Cita cita;
    private String estado;
    private String diagnostico;
    private String tratamiento;
    private String observaciones;
    private LocalDateTime fechaHora;

    /**
     * Constructor vacío de la clase Consulta.
     */
    public Consulta() {
    }

    /**
     * Constructor de la clase Consulta con todos los atributos, incluyendo el
     * ID.
     *
     * @param idConsulta El ID de la consulta.
     * @param cita La cita asociada a la consulta.
     * @param estado El estado de la consulta.
     * @param diagnostico El diagnóstico de la consulta.
     * @param tratamiento El tratamiento de la consulta.
     * @param observaciones Las observaciones de la consulta.
     * @param fechaHora La fecha y hora de la consulta.
     */
    public Consulta(int idConsulta, Cita cita, String estado, String diagnostico, String tratamiento, String observaciones, LocalDateTime fechaHora) {
        this.idConsulta = idConsulta;
        this.cita = cita;
        this.estado = estado;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.observaciones = observaciones;
        this.fechaHora = fechaHora;
    }

    /**
     * Constructor de la clase Consulta con todos los atributos, excepto el ID.
     * Se usa para crear nuevas consultas.
     *
     * @param cita La cita asociada a la consulta.
     * @param estado El estado de la consulta.
     * @param diagnostico El diagnóstico de la consulta.
     * @param tratamiento El tratamiento de la consulta.
     * @param observaciones Las observaciones de la consulta.
     * @param fechaHora La fecha y hora de la consulta.
     */
    public Consulta(Cita cita, String estado, String diagnostico, String tratamiento, String observaciones, LocalDateTime fechaHora) {
        this.cita = cita;
        this.estado = estado;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.observaciones = observaciones;
        this.fechaHora = fechaHora;
    }

    /**
     * Obtiene el ID de la consulta.
     *
     * @return El ID de la consulta.
     */
    public int getIdConsulta() {
        return idConsulta;
    }

    /**
     * Establece el ID de la consulta.
     *
     * @param idConsulta El ID de la consulta.
     */
    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    /**
     * Obtiene la cita asociada a la consulta.
     *
     * @return La cita asociada a la consulta.
     */
    public Cita getCita() {
        return cita;
    }

    /**
     * Establece la cita asociada a la consulta.
     *
     * @param cita La cita asociada a la consulta.
     */
    public void setCita(Cita cita) {
        this.cita = cita;
    }

    /**
     * Obtiene el estado de la consulta.
     *
     * @return El estado de la consulta.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la consulta.
     *
     * @param estado El estado de la consulta.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtiene el diagnóstico de la consulta.
     *
     * @return El diagnóstico de la consulta.
     */
    public String getDiagnostico() {
        return diagnostico;
    }

    /**
     * Establece el diagnóstico de la consulta.
     *
     * @param diagnostico El diagnóstico de la consulta.
     */
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    /**
     * Obtiene el tratamiento de la consulta.
     *
     * @return El tratamiento de la consulta.
     */
    public String getTratamiento() {
        return tratamiento;
    }

    /**
     * Establece el tratamiento de la consulta.
     *
     * @param tratamiento El tratamiento de la consulta.
     */
    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    /**
     * Obtiene las observaciones de la consulta.
     *
     * @return Las observaciones de la consulta.
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * Establece las observaciones de la consulta.
     *
     * @param observaciones Las observaciones de la consulta.
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /**
     * Obtiene la fecha y hora de la consulta.
     *
     * @return La fecha y hora de la consulta.
     */
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    /**
     * Establece la fecha y hora de la consulta.
     *
     * @param fechaHora La fecha y hora de la consulta.
     */
    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Devuelve una representación en cadena del objeto Consulta.
     *
     * @return Una cadena que representa al objeto Consulta.
     */
    @Override
    public String toString() {
        return "Consulta{" + "idConsulta=" + idConsulta + ", cita=" + cita + ", estado=" + estado + ", diagnostico=" + diagnostico + ", tratamiento=" + tratamiento + ", observaciones=" + observaciones + ", fechaHora=" + fechaHora + '}';
    }

}
