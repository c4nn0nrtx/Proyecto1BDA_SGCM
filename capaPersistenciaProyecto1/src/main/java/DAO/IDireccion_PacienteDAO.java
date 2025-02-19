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

    /**
     *
     * @param direccion
     * @return
     * @throws PersistenciaException
     */
    public Direccion_Paciente agregarDireccion(Direccion_Paciente direccion) throws PersistenciaException;
    
    /**
     *
     * @param id
     * @return
     * @throws PersistenciaException
     */
    public Direccion_Paciente consultarDireccionPorId(int id) throws PersistenciaException;
    
    /**
     *
     * @param direccion
     * @return
     * @throws PersistenciaException
     */
    public Direccion_Paciente actualizarDireccion(Direccion_Paciente direccion) throws PersistenciaException;
    
}
