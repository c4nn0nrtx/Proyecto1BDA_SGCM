/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Entidades.Direccion_Paciente;
import Exception.PersistenciaException;

/**
 *
 * @author Ramon
 */
public interface IDireccion_PacienteDAO {
    public Direccion_Paciente agregarDireccion(Direccion_Paciente direccion) throws PersistenciaException;
    
    public Direccion_Paciente consultarDireccionPorId(int id) throws PersistenciaException;
    
    public Direccion_Paciente actualizarDireccion(Direccion_Paciente direccion) throws PersistenciaException;
    
}
