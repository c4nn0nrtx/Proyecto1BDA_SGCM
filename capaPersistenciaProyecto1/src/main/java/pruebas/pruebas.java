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
        
        /*
        //horarioMedicoDAO.obtenerHorariosMedicos();
        UsuarioDAO usuarioDAO = new UsuarioDAO(conexionBD);
        CitaDAO cita = new CitaDAO(conexionBD);
        // Crear y agregar Usuarios (Médico y Paciente)
        Usuario usuarioMedico = new Usuario(53, "MedicoTest", "clave123");
        Usuario usuarioPaciente = new Usuario(54, "PacienteTest", "clave123");

        usuarioDAO.agregarUsuario(usuarioMedico);
        usuarioDAO.agregarUsuario(usuarioPaciente);

        // Crear y agregar Médico
        Medico medico = new Medico(usuarioMedico, "Carlos", "Ramírez", "Gómez", "CD5678", "Cardiología", "Activo");
      

        // Crear y agregar Dirección del Paciente
        Direccion_Paciente direccion = new Direccion_Paciente(27, "Av Siempre Viva", "Centro", 10, "45678");
        direccionDAO.agregarDireccion(direccion);

        // Crear y agregar Paciente
        Paciente paciente = new Paciente(usuarioPaciente, direccion, "Juan", "Pérez", "López", "juan.perez@email.com",
                LocalDate.of(1995, 6, 15), "5551234567");
        pacienteDAO.agregarPaciente(paciente);

        // Crear y agregar Horario
        Horario horario = new Horario(4, "MONDAY", LocalTime.of(14, 0), LocalTime.of(20, 0));
        horarioDAO.agregarHorario(horario);

        // Crear y agregar relación Horario-Médico
        Horario_Medico horarioMedico = new Horario_Medico(2, horario, medico);
        horarioMedicoDAO.agregarHorarioMedico(horarioMedico);

        // Crear y agregar Cita
        Cita citaN = new Cita(10, "Programada", LocalDateTime.of(2025, 2, 23, 15, 30), "folio456", "Consulta General", medico, paciente);
        citaDAO.agregarCita(citaN);

        // Consultar las citas programadas
        List<Cita> citas = citaDAO.consultarCitasProgramadasAgenda(citaN, horarioMedico);

        // Mostrar los resultados
        for (Cita c : citas) {
            System.out.println("Cita encontrada:");
            System.out.println("ID: " + c.getIdCita());
            System.out.println("Estado: " + c.getEstado());
            System.out.println("Fecha y Hora: " + c.getFechaHora());
            System.out.println("Folio: " + c.getFolio());
            System.out.println("Tipo: " + c.getTipo());
            System.out.println("Médico: " + c.getMedico().getNombre() + " " + c.getMedico().getApellidoPat());
            System.out.println("Paciente: " + c.getPaciente().getNombre() + " " + c.getPaciente().getApellidoPat());
            System.out.println("-----------------------------------");
        }*/
    }

}
