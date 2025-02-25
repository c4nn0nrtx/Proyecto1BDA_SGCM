package Entidades;

/**
 * Esta clase representa a un usuario del sistema. Contiene el ID, nombre de
 * usuario y contraseña del usuario.
 *
 * @author Ramon Valencia
 */
public class Usuario {

    private int idUsuario;
    private String nombreUsuario;
    private String contrasenha;

    /**
     * Constructor vacío de la clase Usuario. Inicializa un objeto Usuario sin
     * valores específicos.
     */
    public Usuario() {
    }

    /**
     * Constructor de la clase Usuario con todos los atributos.
     *
     * @param idUsuario El ID del usuario.
     * @param nombreUsuario El nombre de usuario.
     * @param contrasenha La contraseña del usuario.
     */
    public Usuario(int idUsuario, String nombreUsuario, String contrasenha) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contrasenha = contrasenha;
    }

    /**
     * Constructor de la clase Usuario sin ID. Se utiliza para crear nuevos
     * usuarios. El ID se asignará automáticamente (probablemente por la base de
     * datos).
     *
     * @param nombreUsuario El nombre de usuario.
     * @param contrasenha La contraseña del usuario.
     */
    public Usuario(String nombreUsuario, String contrasenha) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenha = contrasenha;
    }

    /**
     * Obtiene el ID del usuario.
     *
     * @return El ID del usuario.
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Establece el ID del usuario.
     *
     * @param idUsuario El ID del usuario.
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Obtiene el nombre de usuario.
     *
     * @return El nombre de usuario.
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Establece el nombre de usuario.
     *
     * @param nombreUsuario El nombre de usuario.
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return La contraseña del usuario.
     */
    public String getContrasenha() {
        return contrasenha;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param contrasenha La contraseña del usuario.
     */
    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

    /**
     * Devuelve una representación en cadena del objeto Usuario.
     *
     * @return Una cadena que representa al objeto Usuario.
     */
    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", contrasenha=" + contrasenha + '}';
    }

}
