/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 * Esta clase representa a un usuario del sistema
 *
 * @author Ramon Valencia
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

    /**
     *
     * @return
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     *
     * @param idUsuario
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     *
     * @return
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     *
     * @param nombreUsuario
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
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
        return "Usuario{" + "idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", contrasenha=" + contrasenha + '}';
    }

}
