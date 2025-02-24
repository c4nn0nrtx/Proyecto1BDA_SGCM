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
        MedicoDAO medicoDAO = new MedicoDAO(conexionBD);
        HorarioMedicoDAO horarioMedicoDAO = new HorarioMedicoDAO(conexionBD);
        Direccion_PacienteDAO direccionDAO = new Direccion_PacienteDAO(conexionBD);
        PacienteDAO pacienteDAO = new PacienteDAO(conexionBD);

        CitaDAO citaDAO = new CitaDAO(conexionBD);

        Usuario usuarioMedico = new Usuario(1, "Juan1", "clave123");

        Usuario usuarioPaciente = new Usuario(27, "Lukino", "gusanitos123");

        Direccion_Paciente direccion = new Direccion_Paciente(12, "Nose", "Capistrano", 85132, "28");

        Paciente paciente = new Paciente(usuarioPaciente, direccion, "Luciano", "Barcelo", "Murrieta", "Luciano@gmail.sdasda", LocalDate.of(2025, 04, 30), "644190122");

        Medico medico = new Medico(usuarioMedico, "Juan Manuel", "Perez", "Montoya", "ABC313", "Ginecologia", "Inactivo");
        Horario horario = new Horario(1, "martes", LocalTime.of(07, 00, 0, 0), LocalTime.of(12, 00, 00));

        Horario_Medico horarioMedico = new Horario_Medico(1, horario, medico);

        Cita citaN = new Cita(10, "Programada", LocalDateTime.of(2025, Month.JULY, 22, 11, 59, 59, 0), "folio456", "programada", medico, paciente);
        System.out.println(citaN);
        citaDAO.agendarCitaEmergencia(citaN);
        

        /* Medico medico = medicoDAO.obtenerMedicoPorNombre("Juan Manuel Perez Montoya");
        System.out.println(medico);*/

        /*
        Usuario usuario = new Usuario(23, "Medico1", "gusanitos123");
       
        //usuarioDAO.agregarUsuario(usuario);
        
        Paciente paciente = new Paciente (usuario)
        Medico medico = new Medico(usuario, "Juan", "Topo", "Cabada", "JA123", "Nutriologo", "Activo");
        boolean nose = medicoDAO.actualizarEstadoMedico(medico, "Inactivo");
         */
        //horarioMedicoDAO.obtenerHorariosMedicos();
        /* UsuarioDAO usuarioDAO = new UsuarioDAO(conexionBD);
       
        // Crear y agregar Usuarios (Médico y Paciente)
        Usuario usuarioMedico = new Usuario(1, "Juan1", "clave123");
 
        Usuario usuarioPaciente = new Usuario(27,"Lukino", "gusanitos123");
 

        Direccion_Paciente direccion = new Direccion_Paciente(12,"Nose","Capistrano",85132,"28");

        Paciente paciente = new Paciente(usuarioPaciente, direccion, "Luciano", "Barcelo", "Murrieta", "Luciano@gmail.sdasda", LocalDate.of(2025, 04, 30), "644190122");

        Medico medico = new Medico(usuarioMedico, "Juan Manuel", "Perez", "Montoya", "ABC313", "Ginecologia", "Inactivo");
        Horario horario = new Horario(1, "martes", LocalTime.of(07, 00, 0, 0), LocalTime.of(12, 00, 00));

        Horario_Medico horarioMedico = new Horario_Medico(1, horario, medico);

        Cita citaN = new Cita(10, "Programada", LocalDateTime.of(2025, Month.JULY, 22, 11, 59, 59, 0), "folio456", "programada", medico, paciente);
        

        //List<Cita> citas = citaDAO.consultarCitasProgramadasAgenda(citaN, horarioMedico);
        List<Cita> citas = citaDAO.consultarCitasProgramadasAgenda(medico.getUsuario().getIdUsuario());
        // Mostrar los resultados
        for (Cita c : citas) {
            System.out.println("Cita encontrada:");
            System.out.println("ID: " + c.getIdCita());
            System.out.println("Estado: " + c.getEstado());
            System.out.println("Fecha y Hora: " + c.getFechaHora());
            System.out.println("Folio: " + c.getFolio());
            System.out.println("Tipo: " + c.getTipo());
            System.out.println("Médico: " + c.getMedico().getNombre() + " " + c.getMedico().getApellidoPaterno());
            System.out.println("Paciente: " + c.getPaciente().getNombre() + " " + c.getPaciente().getApellidoPaterno());
            System.out.println("-----------------------------------");

           
        }*/
 /*// ID del médico, día de la semana y fecha específica
        int idMedico = 51; // Cambia esto por el ID real
        String diaSemana = "Viernes";
        String fecha = "2025-02-23"; // Formato YYYY-MM-DD

        try {
            // Obtener citas disponibles
            List<Cita> citasDisponibles = citaDAO.cargarCitas(idMedico, diaSemana, fecha);

            // Mostrar resultados
            System.out.println("ID  | Fecha y Hora          | Estado      | Médico           | Especialidad");
            System.out.println("-------------------------------------------------------------------------");
            for (Cita cita : citasDisponibles) {
                System.out.printf("%-3d | %-20s | %-10s | %-15s | %-15s%n",
                        cita.getIdCita(),
                        cita.getFechaHora(), // Se muestra fecha y hora de la cita
                        cita.getEstado(),
                        cita.getMedico().getNombre(),
                        cita.getMedico().getEspecialidad()
                );
            }

        } catch (PersistenciaException e) {
            System.err.println("Error al cargar las citas: " + e.getMessage());
        }/*
         */
    }
}
