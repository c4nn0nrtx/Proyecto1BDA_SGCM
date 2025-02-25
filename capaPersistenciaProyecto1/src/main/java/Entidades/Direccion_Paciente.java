package Entidades;

/**
 * Esta clase representa la dirección de un paciente.
 *
 * @author Ramon Valencia
 */
public class Direccion_Paciente {

    private int idDireccion;
    private String calle;
    private String colonia;
    private int cp;
    private String numero;

    /**
     * Constructor vacío de la clase Direccion_Paciente.
     */
    public Direccion_Paciente() {
    }

    /**
     * Constructor de la clase Direccion_Paciente con todos los atributos,
     * incluyendo el ID.
     *
     * @param idDireccion El ID de la dirección.
     * @param calle La calle de la dirección.
     * @param colonia La colonia de la dirección.
     * @param cp El código postal de la dirección.
     * @param numero El número de la dirección.
     */
    public Direccion_Paciente(int idDireccion, String calle, String colonia, int cp, String numero) {
        this.idDireccion = idDireccion;
        this.calle = calle;
        this.colonia = colonia;
        this.cp = cp;
        this.numero = numero;
    }

    /**
     * Constructor de la clase Direccion_Paciente con todos los atributos,
     * excepto el ID. Se usa para crear nuevas direcciones.
     *
     * @param calle La calle de la dirección.
     * @param colonia La colonia de la dirección.
     * @param cp El código postal de la dirección.
     * @param numero El número de la dirección.
     */
    public Direccion_Paciente(String calle, String colonia, int cp, String numero) {
        this.calle = calle;
        this.colonia = colonia;
        this.cp = cp;
        this.numero = numero;
    }

    /**
     * Obtiene el ID de la dirección.
     *
     * @return El ID de la dirección.
     */
    public int getIdDireccion() {
        return idDireccion;
    }

    /**
     * Establece el ID de la dirección.
     *
     * @param idDireccion El ID de la dirección.
     */
    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    /**
     * Obtiene la calle de la dirección.
     *
     * @return La calle de la dirección.
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Establece la calle de la dirección.
     *
     * @param calle La calle de la dirección.
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Obtiene la colonia de la dirección.
     *
     * @return La colonia de la dirección.
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Establece la colonia de la dirección.
     *
     * @param colonia La colonia de la dirección.
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * Obtiene el código postal de la dirección.
     *
     * @return El código postal de la dirección.
     */
    public int getCp() {
        return cp;
    }

    /**
     * Establece el código postal de la dirección.
     *
     * @param cp El código postal de la dirección.
     */
    public void setCp(int cp) {
        this.cp = cp;
    }

    /**
     * Obtiene el número de la dirección.
     *
     * @return El número de la dirección.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Establece el número de la dirección.
     *
     * @param numero El número de la dirección.
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Devuelve una representación en cadena del objeto Direccion_Paciente.
     *
     * @return Una cadena que representa al objeto Direccion_Paciente.
     */
    @Override
    public String toString() {
        return "Direccion_Paciente{" + "idDireccion=" + idDireccion + ", calle=" + calle + ", colonia=" + colonia + ", cp=" + cp + ", numero=" + numero + '}';
    }

}
