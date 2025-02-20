/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Entidades.Usuario;
import Exception.PersistenciaException;

/**
 *
 * @author Sebastian Moreno
 */
public interface IUsuarioDAO {
     public Usuario consultarUsuarioPorId(int id) throws PersistenciaException;
     public Usuario agregarUsuario(Usuario usuario) throws PersistenciaException;
     public Usuario actualizarUsuario(Usuario usuario) throws PersistenciaException;
     public boolean autenticarUsuario(Usuario usuario)throws PersistenciaException;
}
