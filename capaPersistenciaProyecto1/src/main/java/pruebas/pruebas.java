/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import Conexion.ConexionBD;
import Conexion.IConexionBD;
import DAO.CitaDAO;
import DAO.Direccion_PacienteDAO;
import DAO.HorarioMedicoDAO;
import DAO.MedicoDAO;
import DAO.PacienteDAO;
import DAO.UsuarioDAO;
import Entidades.Cita;
import Entidades.Direccion_Paciente;
import Entidades.Horario;
import Entidades.Horario_Medico;
import Entidades.Medico;
import Entidades.Paciente;
import Entidades.Usuario;
import Exception.PersistenciaException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sebastian Moreno
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws PersistenciaException, SQLException {

        // Crear la conexión a la base de datos
        IConexionBD conexionBD = new ConexionBD();
        UsuarioDAO usuarioDAO = new UsuarioDAO(conexionBD);
        CitaDAO citaDAO = new CitaDAO(conexionBD);

        Usuario usuario1 = new Usuario("Medico1", "clave123");
        Usuario usuario2 = new Usuario("Medico2", "clave456");
        Usuario usuario3 = new Usuario("Medico3", "clave789");
        Usuario usuario4 = new Usuario("Medico4", "clave369");
        
        usuarioDAO.agregarUsuario(usuario1);
        usuarioDAO.agregarUsuario(usuario2);
        usuarioDAO.agregarUsuario(usuario3);
        usuarioDAO.agregarUsuario(usuario4);
        
        


    }
}
