/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Entidades.Consulta;
import Exception.PersistenciaException;

/**
 *
 * @author Ramon Valencia
 */
public interface IConsultaDAO {
    
    public Consulta agregarConsulta(Consulta consulta) throws PersistenciaException;
    
}
