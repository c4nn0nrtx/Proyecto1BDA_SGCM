
package Entidades;

/**
 * Esta clase representa la direccion de un paciente
 * @author Ramon Valencia
 */
public class Direccion_Paciente {

    private int idDireccion;
    private String calle;
    private String colonia;
    private int cp;
    private String numero;

    /**
     * Constructor vacio.
     */
    public Direccion_Paciente() {
    }

    /**
     *Constructor con id
     * @param idDireccion
     * @param calle
     * @param colonia
     * @param cp
     * @param numero
     */
    public Direccion_Paciente(int idDireccion, String calle, String colonia, int cp, String numero) {
        this.idDireccion = idDireccion;
        this.calle = calle;
        this.colonia = colonia;
        this.cp = cp;
        this.numero = numero;
    }

    /**
     * Constructor sin id
     * @param calle
     * @param colonia
     * @param cp
     * @param numero
     */
    public Direccion_Paciente(String calle, String colonia, int cp, String numero) {
        this.calle = calle;
        this.colonia = colonia;
        this.cp = cp;
        this.numero = numero;
    }

    /**
     *
     * @return
     */
    public int getIdDireccion() {
        return idDireccion;
    }

    /**
     *
     * @param idDireccion
     */
    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
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
        return "Direccion_Paciente{" + "idDireccion=" + idDireccion + ", calle=" + calle + ", colonia=" + colonia + ", cp=" + cp + ", numero=" + numero + '}';
    }

}
