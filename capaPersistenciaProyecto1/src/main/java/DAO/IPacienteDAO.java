/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Entidades.Paciente;
import Exception.PersistenciaException;

/**
 *
 * @author Ramon
 */
public interface IPacienteDAO {
    
    public Paciente agregarPaciente(Paciente paciente) throws PersistenciaException;
    
    public Paciente consultarPacientePorId(Paciente paciente) throws PersistenciaException;
    
    //public Direccion agregarDireccion
    
    
}
