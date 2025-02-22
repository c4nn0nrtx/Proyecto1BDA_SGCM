package Entidades;

import java.time.LocalDateTime;

/**
 * Consulta.java
 * 
 * Clase Entidad que representa una consulta del sistema
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
     * Constructor vacío
     */
    public Consulta() {
    }
    /**
     * Constructor con todos los atributos
     * @param idConsulta
     * @param cita
     * @param estado
     * @param diagnostico
     * @param tratamiento
     * @param observaciones
     * @param fechaHora 
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

    public Consulta(Cita cita, String estado, String diagnostico, String tratamiento, String observaciones, LocalDateTime fechaHora) {
        this.cita = cita;
        this.estado = estado;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.observaciones = observaciones;
        this.fechaHora = fechaHora;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    @Override
    public String toString() {
        return "Consulta{" + "idConsulta=" + idConsulta + ", cita=" + cita + ", estado=" + estado + ", diagnostico=" + diagnostico + ", tratamiento=" + tratamiento + ", observaciones=" + observaciones + ", fechaHora=" + fechaHora + '}';
    }
    
}
