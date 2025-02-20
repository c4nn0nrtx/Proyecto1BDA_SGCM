/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.time.LocalDate;

/**
 * Esta clase representa a un paciente del sistema
 *
 * @author Ramon Valencia
 */
public class Paciente {

    private int idPaciente;
    private int idDireccion;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correo;
    private LocalDate fechaNacimiento;
    private String telefono;

    /**
     * Constructor vacio
     */
    public Paciente() {
    }

    /**
     * Constructor con todos los atributos
     *
     * @param idPaciente
     * @param idDireccion
     * @param nombre
     * @param apellidoPaterno
     * @param apellidoMaterno
     * @param correo
     * @param fechaNacimiento
     * @param telefono
     */
    public Paciente(int idPaciente, int idDireccion, String nombre, String apellidoPaterno, String apellidoMaterno, String correo, LocalDate fechaNacimiento, String telefono) {
        this.idPaciente = idPaciente;
        this.idDireccion = idDireccion;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
    }

    /**
     * Constructor sin id
     *
     * @param idDireccion
     * @param nombre
     * @param apellidoPaterno
     * @param apellidoMaterno
     * @param correo
     * @param fechaNacimiento
     * @param telefono
     */
    public Paciente(int idDireccion, String nombre, String apellidoPaterno, String apellidoMaterno, String correo, LocalDate fechaNacimiento, String telefono) {
        this.idDireccion = idDireccion;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
    }

    /**
     *
     * @return
     */
    public int getIdPaciente() {
        return idPaciente;
    }

    /**
     *
     * @param idPaciente
     */
    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
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
    public String getCorreo() {
        return correo;
    }

    /**
     *
     * @param correo
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     *
     * @return
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     *
     * @param fechaNacimiento
     */
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     *
     * @return
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     *
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Paciente{" + "idPaciente=" + idPaciente + ", idDireccion=" + idDireccion + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", correo=" + correo + ", fechaNacimiento=" + fechaNacimiento + ", telefono=" + telefono + '}';
    }

}
