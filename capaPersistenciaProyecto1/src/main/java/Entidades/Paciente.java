package Entidades;

import java.time.LocalDate;

/**
 * Esta clase representa a un paciente en el sistema. Contiene información
 * personal y de contacto del paciente, así como su usuario y dirección.
 *
 * @author Ramon Valencia
 */
public class Paciente {

    private Usuario usuario;
    private Direccion_Paciente direccion;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correo;
    private LocalDate fechaNacimiento;
    private String telefono;

    /**
     * Constructor vacío de la clase Paciente. Inicializa un objeto Paciente sin
     * valores específicos.
     */
    public Paciente() {
    }

    /**
     * Constructor de la clase Paciente con todos los atributos.
     *
     * @param usuario El usuario del paciente.
     * @param direccion La dirección del paciente.
     * @param nombre El nombre del paciente.
     * @param apellidoPaterno El apellido paterno del paciente.
     * @param apellidoMaterno El apellido materno del paciente.
     * @param correo El correo electrónico del paciente.
     * @param fechaNacimiento La fecha de nacimiento del paciente.
     * @param telefono El teléfono del paciente.
     */
    public Paciente(Usuario usuario, Direccion_Paciente direccion, String nombre, String apellidoPaterno, String apellidoMaterno, String correo, LocalDate fechaNacimiento, String telefono) {
        this.usuario = usuario;
        this.direccion = direccion;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
    }

    /**
     * Constructor de la clase Paciente sin usuario ni dirección. Se usa para
     * crear nuevos pacientes.
     *
     * @param nombre El nombre del paciente.
     * @param apellidoPaterno El apellido paterno del paciente.
     * @param apellidoMaterno El apellido materno del paciente.
     * @param correo El correo electrónico del paciente.
     * @param fechaNacimiento La fecha de nacimiento del paciente.
     * @param telefono El teléfono del paciente.
     */
    public Paciente(String nombre, String apellidoPaterno, String apellidoMaterno, String correo, LocalDate fechaNacimiento, String telefono) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
    }

    /**
     * Obtiene el usuario del paciente.
     *
     * @return El usuario del paciente.
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario del paciente.
     *
     * @param usuario El usuario del paciente.
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene la dirección del paciente.
     *
     * @return La dirección del paciente.
     */
    public Direccion_Paciente getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección del paciente.
     *
     * @param direccion La dirección del paciente.
     */
    public void setDireccion(Direccion_Paciente direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene el nombre del paciente.
     *
     * @return El nombre del paciente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del paciente.
     *
     * @param nombre El nombre del paciente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido paterno del paciente.
     *
     * @return El apellido paterno del paciente.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Establece el apellido paterno del paciente.
     *
     * @param apellidoPaterno El apellido paterno del paciente.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Obtiene el apellido materno del paciente.
     *
     * @return El apellido materno del paciente.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Establece el apellido materno del paciente.
     *
     * @param apellidoMaterno El apellido materno del paciente.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Obtiene el correo electrónico del paciente.
     *
     * @return El correo electrónico del paciente.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del paciente.
     *
     * @param correo El correo electrónico del paciente.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene la fecha de nacimiento del paciente.
     *
     * @return La fecha de nacimiento del paciente.
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del paciente.
     *
     * @param fechaNacimiento La fecha de nacimiento del paciente.
     */
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene el teléfono del paciente.
     *
     * @return El teléfono del paciente.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono del paciente.
     *
     * @param telefono El teléfono del paciente.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Devuelve una representación en cadena del objeto Paciente.
     *
     * @return Una cadena que representa al objeto Paciente.
     */
    @Override
    public String toString() {
        return "Paciente{" + "usuario=" + usuario + ", direccion=" + direccion + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", correo=" + correo + ", fechaNacimiento=" + fechaNacimiento + ", telefono=" + telefono + '}';
    }

}
