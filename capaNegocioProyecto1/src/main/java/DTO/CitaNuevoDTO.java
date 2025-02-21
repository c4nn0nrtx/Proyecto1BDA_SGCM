/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import Entidades.Medico;
import Entidades.Paciente;
import java.time.LocalDateTime;

/**
 *
 * @author Ramon Valencia
 */
public class CitaNuevoDTO {
    
    private String estado;
    private LocalDateTime fechaHora;
    private String folio;
    private String tipo;
    private Medico medico;
    private Paciente paciente;
    
    /**
     * Constructor Vacio
     */
    public CitaNuevoDTO() {
    }
    /**
     * Constructor con todos los atributos.
     * @param estado
     * @param fechaHora
     * @param folio
     * @param tipo
     * @param medico
     * @param paciente 
     */
    public CitaNuevoDTO(String estado, LocalDateTime fechaHora, String folio, String tipo, Medico medico, Paciente paciente) {
        this.estado = estado;
        this.fechaHora = fechaHora;
        this.folio = folio;
        this.tipo = tipo;
        this.medico = medico;
        this.paciente = paciente;
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
    public String getFolio() {
        return folio;
    }
    /**
     * 
     * @param folio 
     */
    public void setFolio(String folio) {
        this.folio = folio;
    }
    /**
     * 
     * @return 
     */
    public String getTipo() {
        return tipo;
    }
    /**
     * 
     * @param tipo 
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    /**
     * 
     * @return 
     */
    public Medico getMedico() {
        return medico;
    }
    /**
     * 
     * @param medico 
     */
    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    /**
     * 
     * @return 
     */
    public Paciente getPaciente() {
        return paciente;
    }
    /**
     * 
     * @param paciente 
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return "CitaNuevoDTO{" + "estado=" + estado + ", fechaHora=" + fechaHora + ", folio=" + folio + ", tipo=" + tipo + ", medico=" + medico + ", paciente=" + paciente + '}';
    }
    
    
}
