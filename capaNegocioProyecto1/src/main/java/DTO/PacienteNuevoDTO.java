/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import Entidades.Direccion_Paciente;
import Entidades.Usuario;
import java.time.LocalDate;

/**
 * Paciente DTO sin idPaciente ni direccion.
 *
 * @author Sebastian Moreno
 */
public class PacienteNuevoDTO {
    
    private Usuario usuario;
    private Direccion_Paciente direccion;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correo;
    private LocalDate fechaNacimiento;
    private String telefono;

    public PacienteNuevoDTO() {
    }

    public PacienteNuevoDTO(Usuario usuario, Direccion_Paciente direccion, String nombre, String apellidoPaterno, String apellidoMaterno, String correo, LocalDate fechaNacimiento, String telefono) {
        this.usuario = usuario;
        this.direccion = direccion;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
    }


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Direccion_Paciente getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion_Paciente direccion) {
        this.direccion = direccion;
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
        return "PacienteNuevoDTO{" + "usuario=" + usuario + ", direccion=" + direccion + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", correo=" + correo + ", fechaNacimiento=" + fechaNacimiento + ", telefono=" + telefono + '}';
    }

    
}
