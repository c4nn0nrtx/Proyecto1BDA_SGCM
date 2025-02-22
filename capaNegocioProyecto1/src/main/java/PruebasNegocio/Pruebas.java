/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package PruebasNegocio;

import BO.HorarioMedicoBO;
import Conexion.ConexionBD;
import Conexion.IConexionBD;
import DAO.Direccion_PacienteDAO;
import DAO.HorarioMedicoDAO;
import Exception.NegocioException;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NegocioException, SQLException {
        // TODO code application logic here
        IConexionBD conexionBD = new ConexionBD();
        HorarioMedicoBO horarioMedicoBO = new HorarioMedicoBO(conexionBD);
        
        horarioMedicoBO.obtenerHorariosMedicos();

    }
    
}
