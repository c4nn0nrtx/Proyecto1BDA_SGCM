
package DTO;

/**
 * Esta clase representa a los usuarios para comunicarse con presentacion.
 * @author Sebastian Moreno
 */
public class UsuarioNuevoDTO {

    String nombreUsuario;
    String contrasenha;

    public UsuarioNuevoDTO() {
    }

    public UsuarioNuevoDTO(String nombreUsuario, String contrasenha) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenha = contrasenha;
    }

    public String getUsuario() {
        return nombreUsuario;
    }

    public void setUsuario(String usuario) {
        this.nombreUsuario = usuario;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

    @Override
    public String toString() {
        return "UsuarioNuevoDTO{" + "usuario=" + nombreUsuario + ", contrasenha=" + contrasenha + '}';
    }

}
