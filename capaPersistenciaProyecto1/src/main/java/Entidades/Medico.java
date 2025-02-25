package Entidades;

/**
 * Esta clase representa un médico en el sistema.
 *
 * @author Sebastian Moreno
 */
public class Medico {

    private Usuario usuario;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String cedulaProfesional;
    private String especialidad;
    private String estado;

    /**
     * Constructor vacío de la clase Medico.
     */
    public Medico() {
    }

    /**
     * Constructor de la clase Medico con todos los atributos.
     *
     * @param usuario El usuario del médico.
     * @param nombre El nombre del médico.
     * @param apellidoPaterno El apellido paterno del médico.
     * @param apellidoMaterno El apellido materno del médico.
     * @param cedulaProfesional La cédula profesional del médico.
     * @param especialidad La especialidad del médico.
     * @param estado El estado del médico (activo, inactivo, etc.).
     */
    public Medico(Usuario usuario, String nombre, String apellidoPaterno, String apellidoMaterno, String cedulaProfesional, String especialidad, String estado) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.cedulaProfesional = cedulaProfesional;
        this.especialidad = especialidad;
        this.estado = estado;
    }

    /**
     * Obtiene el usuario del médico.
     *
     * @return El usuario del médico.
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario del médico.
     *
     * @param usuario El usuario del médico.
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene el nombre del médico.
     *
     * @return El nombre del médico.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del médico.
     *
     * @param nombre El nombre del médico.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido paterno del médico.
     *
     * @return El apellido paterno del médico.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Establece el apellido paterno del médico.
     *
     * @param apellidoPaterno El apellido paterno del médico.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Obtiene el apellido materno del médico.
     *
     * @return El apellido materno del médico.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Establece el apellido materno del médico.
     *
     * @param apellidoMaterno El apellido materno del médico.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Obtiene la cédula profesional del médico.
     *
     * @return La cédula profesional del médico.
     */
    public String getCedulaProfesional() {
        return cedulaProfesional;
    }

    /**
     * Establece la cédula profesional del médico.
     *
     * @param cedulaProfesional La cédula profesional del médico.
     */
    public void setCedulaProfesional(String cedulaProfesional) {
        this.cedulaProfesional = cedulaProfesional;
    }

    /**
     * Obtiene la especialidad del médico.
     *
     * @return La especialidad del médico.
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * Establece la especialidad del médico.
     *
     * @param especialidad La especialidad del médico.
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    /**
     * Obtiene el estado del médico.
     *
     * @return El estado del médico.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado del médico.
     *
     * @param estado El estado del médico.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Devuelve una representación en cadena del objeto Medico.
     *
     * @return Una cadena que representa al objeto Medico.
     */
    @Override
    public String toString() {
        return "Medico{" + "usuario=" + usuario + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", cedulaProfesional=" + cedulaProfesional + ", especialidad=" + especialidad + ", estado=" + estado + '}';
    }

}
