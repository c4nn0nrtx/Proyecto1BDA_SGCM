
package DTO;

/**
 * Esta clase representa a los usuarios para comunicarse con presentacion.
 * @author Sebastian Moreno
 */
public class UsuarioNuevoDTO {

    String nombreUsuario;
    String contrasenha;

    /**
     *
     */
    public UsuarioNuevoDTO() {
    }

    /**
     *
     * @param nombreUsuario
     * @param contrasenha
     */
    public UsuarioNuevoDTO(String nombreUsuario, String contrasenha) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenha = contrasenha;
    }

    /**
     *
     * @return
     */
    public String getUsuario() {
        return nombreUsuario;
    }

    /**
     *
     * @param usuario
     */
    public void setUsuario(String usuario) {
        this.nombreUsuario = usuario;
    }

    /**
     *
     * @return
     */
    public String getContrasenha() {
        return contrasenha;
    }

    /**
     *
     * @param contrasenha
     */
    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "UsuarioNuevoDTO{" + "usuario=" + nombreUsuario + ", contrasenha=" + contrasenha + '}';
    }

}
