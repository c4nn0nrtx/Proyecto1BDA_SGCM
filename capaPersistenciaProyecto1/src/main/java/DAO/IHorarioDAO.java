/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Entidades.Horario;
import Exception.PersistenciaException;
import java.sql.SQLException;

/**
 *
 * @author Ramon Valencia
 */
public interface IHorarioDAO {
    
    public Horario consultarHorarioPorId(int id) throws PersistenciaException, SQLException;
}
