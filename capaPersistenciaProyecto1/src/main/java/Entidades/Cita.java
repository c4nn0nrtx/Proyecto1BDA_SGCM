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
    private int id;
    private String estado;
    private LocalDateTime fechaHora;
    private String folio;
    private String tipo;

    /**
     * Constructor vacío
     */
    public Cita() {
    }

    /**
     * Constructor que crea una cita que es programada
     * 
     * @param id Identificador de la cita
     * @param estado Estado de la cita (Programada, No atendida o Cancelada)
     * @param fechaHora Fecha y hora en la que se realizó la cita
     * @param tipo Tipo de la cita (emergencia o programada)
     */
    public Cita(int id, String estado, LocalDateTime fechaHora, String tipo) {
        this.id = id;
        this.estado = estado;
        this.fechaHora = fechaHora;
        this.tipo = tipo;
    }

    /**
     * Constructor que crea una cita que es programada sin identificador
     * 
     * @param estado Estado de la cita (Programada, No atendida o Cancelada)
     * @param fechaHora Fecha y hora en la que se realizó la cita
     * @param tipo Tipo de la cita (emergencia o programada)
     */
    public Cita(String estado, LocalDateTime fechaHora, String tipo) {
        this.estado = estado;
        this.fechaHora = fechaHora;
        this.tipo = tipo;
    }
    
    /**
     * Constructor que crea una cita de emergencia con un folio
     * 
     * @param id Identificador de la cita
     * @param estado Estado de la cita (Programada, No atendida o Cancelada)
     * @param fechaHora Fecha y hora en la que se realizó la cita
     * @param folio Folio de la cita de emergencia
     * @param tipo Tipo de la cita (emergencia o programada)
     */
    public Cita(int id, String estado, LocalDateTime fechaHora, String folio, String tipo) {
        this.id = id;
        this.estado = estado;
        this.fechaHora = fechaHora;
        this.folio = folio;
        this.tipo = tipo;
    }

     /**
     * Constructor que crea una cita de emergencia con un folio sin identificador
     * 
     * @param estado Estado de la cita (Programada, No atendida o Cancelada)
     * @param fechaHora Fecha y hora en la que se realizó la cita
     * @param folio Folio de la cita de emergencia
     * @param tipo Tipo de la cita (emergencia o programada)
     */
    public Cita(String estado, LocalDateTime fechaHora, String folio, String tipo) {
        this.estado = estado;
        this.fechaHora = fechaHora;
        this.folio = folio;
        this.tipo = tipo;
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
    @Override
    public String toString() {
        return "Cita{" + "id=" + id + ", estado=" + estado + ", fechaHora=" + fechaHora + ", folio=" + folio + ", tipo=" + tipo + '}';
    }
}
