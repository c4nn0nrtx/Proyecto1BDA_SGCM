/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import Entidades.Cita;
import java.time.LocalDateTime;

/**
 *
 * @author Ramon Valencia
 */
public class ConsultaNuevaDTO {
    
    private Cita cita;
    private String estado;
    private String diagnostico;
    private String tratamiento;
    private String observaciones;
    private LocalDateTime fechaHora;
    /**
     * Constructor vacio
     */
    public ConsultaNuevaDTO() {
    }
    /**
     * Constructor DTO con todos los atributos
     * @param cita
     * @param estado
     * @param diagnostico
     * @param tratamiento
     * @param observaciones
     * @param fechaHora 
     */
    public ConsultaNuevaDTO(Cita cita, String estado, String diagnostico, String tratamiento, String observaciones, LocalDateTime fechaHora) {
        this.cita = cita;
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
    public Cita getCita() {
        return cita;
    }
    /**
     * 
     * @param cita 
     */
    public void setCita(Cita cita) {
        this.cita = cita;
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
        return "ConsultaNuevaDTO{" + "cita=" + cita + ", estado=" + estado + ", diagnostico=" + diagnostico + ", tratamiento=" + tratamiento + ", observaciones=" + observaciones + ", fechaHora=" + fechaHora + '}';
    }
    
    
}
