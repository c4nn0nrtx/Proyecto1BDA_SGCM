package Entidades;

import java.time.LocalDateTime;

/**
 * Cita.java
 * 
 * Clase Entidad que representa una cita en el sistema
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
     * Constructor vacío
     */
    public Cita() {
    }
    /**
     * Contructor con todos los atributos incluido el id
     * @param idCita
     * @param estado
     * @param fechaHora
     * @param folio
     * @param tipo
     * @param medico
     * @param paciente 
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
     * Constructor con todos los atributos excepto el id
     * @param estado
     * @param fechaHora
     * @param folio
     * @param tipo
     * @param medico
     * @param paciente 
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
     * 
     * @return 
     */
    public int getIdCita() {
        return idCita;
    }
    /**
     * 
     * @param idCita 
     */
    public void setIdCita(int idCita) {
        this.idCita = idCita;
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
        return "Cita{" + "idCita=" + idCita + ", estado=" + estado + ", fechaHora=" + fechaHora + ", folio=" + folio + ", tipo=" + tipo + ", medico=" + medico + ", paciente=" + paciente + '}';
    }
    
}
