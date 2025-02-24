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
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author PC
 */
public class Pruebas {

    /**
     */
    public class ProximoDiaUtil {

        /**
         *
         * @param args
         * @throws NegocioException
         * @throws SQLException
         */
        public static void main(String[] args) throws NegocioException, SQLException {
            // TODO code application logic here
            IConexionBD conexionBD = new ConexionBD();
            HorarioMedicoBO horarioMedicoBO = new HorarioMedicoBO(conexionBD);

            horarioMedicoBO.obtenerHorariosMedicos();

        }

    }
}
