
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCedulaProfesional() {
        return cedulaProfesional;
    }

    public void setCedulaProfesional(String cedulaProfesional) {
        this.cedulaProfesional = cedulaProfesional;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Medico{" + "id=" + id + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", cedulaProfesional=" + cedulaProfesional + ", especialidad=" + especialidad + ", estado=" + estado + '}';
    }
    
    
    
    
}
