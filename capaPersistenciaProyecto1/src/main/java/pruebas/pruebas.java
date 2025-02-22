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
import Entidades.Medico;
import Entidades.Paciente;
import Entidades.Usuario;
import Exception.PersistenciaException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
        MedicoDAO medicoDAO = new MedicoDAO(conexionBD);
        HorarioMedicoDAO horarioMedicoDAO = new HorarioMedicoDAO(conexionBD);
        Direccion_PacienteDAO direccionDAO = new Direccion_PacienteDAO(conexionBD);
        PacienteDAO pacienteDAO = new PacienteDAO(conexionBD);
        /*
        Usuario usuario = new Usuario(23, "Medico1", "gusanitos123");
       
        //usuarioDAO.agregarUsuario(usuario);
        
        Medico medico = new Medico(usuario, "Juan", "Topo", "Cabada", "JA123", "Nutriologo", "Activo");
        boolean nose = medicoDAO.actualizarEstadoMedico(medico, "Inactivo");
        */
        
        //horarioMedicoDAO.obtenerHorariosMedicos();
        
        UsuarioDAO usuarioDAO = new UsuarioDAO(conexionBD);
        CitaDAO cita = new CitaDAO(conexionBD);
        Usuario usuario = new Usuario(51, "Medico2", "gusanitos123");
        Usuario usuario2 = new Usuario(52, "Paciente3", "gusanitos123");
     
        Medico medico = new Medico(usuario , "Pedrito", "Vm", "", "AB1234", "Penologo", "Activo");
        
        Direccion_Paciente direccion = new Direccion_Paciente(26, "loco", "loco", 3, "1231");
    
        Paciente paciente = new Paciente(usuario2, direccion, "Paciente3", "Loco", "", "pollas@gmail.com", LocalDate.now(), "1234");
        pacienteDAO.agregarPaciente(paciente);
        Cita citaN = new Cita(5, "Programada" , LocalDateTime.now(), "asdas12", "programada", medico, paciente);
        
        cita.agendarCita(citaN);
        
}

    
 
}


