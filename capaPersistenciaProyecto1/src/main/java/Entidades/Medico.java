
package Entidades;

/**
 * Esta clase representa un medico en el sistema.
 * @author Sebastian Moreno
 */
public class Medico {
    private int id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String cedulaProfesional;
    private String especialidad;
    private String estado;

    
    /**
     * Constructor vacio.
     */
    public Medico() {
    }
    
    /**
     * Constructor con todos los atributos.
     * @param id
     * @param nombre
     * @param apellidoPaterno
     * @param apellidoMaterno
     * @param cedulaProfesional
     * @param especialidad
     * @param estado 
     */
    public Medico(int id, String nombre, String apellidoPaterno, String apellidoMaterno, String cedulaProfesional, String especialidad, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.cedulaProfesional = cedulaProfesional;
        this.especialidad = especialidad;
        this.estado = estado;
    }
    /**
     * Constructor sin id.
     * @param nombre
     * @param apellidoPaterno
     * @param apellidoMaterno
     * @param cedulaProfesional
     * @param especialidad
     * @param estado 
     */
    public Medico(String nombre, String apellidoPaterno, String apellidoMaterno, String cedulaProfesional, String especialidad, String estado) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.cedulaProfesional = cedulaProfesional;
        this.especialidad = especialidad;
        this.estado = estado;
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
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     *
     * @param apellidoPaterno
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     *
     * @return
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     *
     * @param apellidoMaterno
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     *
     * @return
     */
    public String getCedulaProfesional() {
        return cedulaProfesional;
    }

    /**
     *
     * @param cedulaProfesional
     */
    public void setCedulaProfesional(String cedulaProfesional) {
        this.cedulaProfesional = cedulaProfesional;
    }

    /**
     *
     * @return
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     *
     * @param especialidad
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
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
    @Override
    public String toString() {
        return "Medico{" + "id=" + id + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", cedulaProfesional=" + cedulaProfesional + ", especialidad=" + especialidad + ", estado=" + estado + '}';
    }
    
    
    
    
}
