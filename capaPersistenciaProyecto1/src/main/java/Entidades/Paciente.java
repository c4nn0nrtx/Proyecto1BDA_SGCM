/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.time.LocalDate;

/**
 * Esta clase representa a un paciente del sistema
 * @author Ramon
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

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Paciente{" + "idPaciente=" + idPaciente + ", idDireccion=" + idDireccion + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", correo=" + correo + ", fechaNacimiento=" + fechaNacimiento + ", telefono=" + telefono + '}';
    }
    
    
}

