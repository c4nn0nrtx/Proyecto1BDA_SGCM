/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Entidades.Consulta;
import Entidades.Paciente;
import Exception.PersistenciaException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Ramon Valencia
 */
public interface IConsultaDAO {
    
    public Consulta agregarConsulta(Consulta consulta) throws PersistenciaException;
  
    public List<Consulta> obtenerConsultasPaciente(Paciente paciente,String especialidad,LocalDate fechaInicial,LocalDate  fechaFin ) throws PersistenciaException;
    
}
