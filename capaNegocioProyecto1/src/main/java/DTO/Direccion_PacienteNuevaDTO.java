
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

    public Direccion_PacienteNuevaDTO() {
    }

    public Direccion_PacienteNuevaDTO(String calle, String colonia, int cp, String numero) {
        this.calle = calle;
        this.colonia = colonia;
        this.cp = cp;
        this.numero = numero;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Direccion_PacienteNuevaDTO{" + "calle=" + calle + ", colonia=" + colonia + ", cp=" + cp + ", numero=" + numero + '}';
    }
    
    
}
