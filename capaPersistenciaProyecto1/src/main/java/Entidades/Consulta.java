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
    private int id;
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
     * Constructor que crea una consulta
     * 
     * @param id
     * @param estado
     * @param diagnostico
     * @param tratamiento
     * @param observaciones
     * @param fechaHora 
     */
    public Consulta(int id, String estado, String diagnostico, String tratamiento, String observaciones, LocalDateTime fechaHora) {
        this.id = id;
        this.estado = estado;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.observaciones = observaciones;
        this.fechaHora = fechaHora;
    }

    /**
     * Constructor que crea una consulta sin identificador
     * 
     * @param estado
     * @param diagnostico
     * @param tratamiento
     * @param observaciones
     * @param fechaHora 
     */
    public Consulta(String estado, String diagnostico, String tratamiento, String observaciones, LocalDateTime fechaHora) {
        this.estado = estado;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.observaciones = observaciones;
        this.fechaHora = fechaHora;
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
    public String getEstado() {
        return estado;
    }

    /**
     *
     * @param estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     *
     * @return
     */
    public String getDiagnostico() {
        return diagnostico;
    }

    /**
     *
     * @param diagnostico
     */
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    /**
     *
     * @return
     */
    public String getTratamiento() {
        return tratamiento;
    }

    /**
     *
     * @param tratamiento
     */
    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    /**
     *
     * @return
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     *
     * @param observaciones
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /**
     *
     * @return
     */
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    /**
     *
     * @param fechaHora
     */
    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Consulta{" + "id=" + id + ", estado=" + estado + ", diagnostico=" + diagnostico + ", tratamiento=" + tratamiento + ", observaciones=" + observaciones + ", fechaHora=" + fechaHora + '}';
    }
    
    
}
