/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 * Esta clase representa a un usuario del sistema
 * @author Ramon
 */
public class Usuario {
    private int idUsuario;
    private String nombreUsuario;
    private String contrasenha;
    /**
     * 
     */
    public Usuario() {
    }
    /**
     * 
     * @param idUsuario
     * @param nombreUsuario
     * @param contrasenha 
     */
    public Usuario(int idUsuario, String nombreUsuario, String contrasenha) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contrasenha = contrasenha;
    }
    /**
     * 
     * @param nombreUsuario
     * @param contrasenha 
     */
    public Usuario(String nombreUsuario, String contrasenha) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenha = contrasenha;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", contrasenha=" + contrasenha + '}';
    }
    
    
}
