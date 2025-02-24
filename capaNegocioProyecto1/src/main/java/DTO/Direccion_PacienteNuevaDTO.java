
package DTO;

/**
 * Direccion DTO
 * @author PC
 */
public class Direccion_PacienteNuevaDTO {
    
    private String calle;
    private String colonia;
    private int cp;
    private String numero;

    /**
     *
     */
    public Direccion_PacienteNuevaDTO() {
    }

    /**
     *
     * @param calle
     * @param colonia
     * @param cp
     * @param numero
     */
    public Direccion_PacienteNuevaDTO(String calle, String colonia, int cp, String numero) {
        this.calle = calle;
        this.colonia = colonia;
        this.cp = cp;
        this.numero = numero;
    }

    /**
     *
     * @return
     */
    public String getCalle() {
        return calle;
    }

    /**
     *
     * @param calle
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     *
     * @return
     */
    public String getColonia() {
        return colonia;
    }

    /**
     *
     * @param colonia
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     *
     * @return
     */
    public int getCp() {
        return cp;
    }

    /**
     *
     * @param cp
     */
    public void setCp(int cp) {
        this.cp = cp;
    }

    /**
     *
     * @return
     */
    public String getNumero() {
        return numero;
    }

    /**
     *
     * @param numero
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Direccion_PacienteNuevaDTO{" + "calle=" + calle + ", colonia=" + colonia + ", cp=" + cp + ", numero=" + numero + '}';
    }
    
    
}
