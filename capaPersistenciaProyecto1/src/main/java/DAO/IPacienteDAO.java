/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Entidades.Paciente;
import Exception.PersistenciaException;

/**
 *
 * @author Ramon Valencia
 */
public interface IPacienteDAO {
    
    public Paciente agregarPaciente(Paciente paciente) throws PersistenciaException;
    
    public Paciente consultarPacientePorId(int id) throws PersistenciaException;
    
    public Paciente actualizarPaciente(Paciente paciente) throws PersistenciaException;
    
}
