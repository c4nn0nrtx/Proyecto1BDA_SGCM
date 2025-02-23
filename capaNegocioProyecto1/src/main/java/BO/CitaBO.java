package BO;

import Conexion.IConexionBD;
import DAO.CitaDAO;
import DAO.ICitaDAO;
import DAO.MedicoDAO;
import DAO.PacienteDAO;
import DTO.CitaNuevoDTO;
import DTO.MedicoNuevoDTO;
import DTO.PacienteNuevoDTO;
import Entidades.Cita;
import Entidades.Medico;
import Entidades.Paciente;
import Exception.NegocioException;
import Exception.PersistenciaException;
import Mapper.Mapper;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.DayOfWeek;
import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.DayOfWeek.THURSDAY;
import static java.time.DayOfWeek.TUESDAY;
import static java.time.DayOfWeek.WEDNESDAY;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ramon Valencia
 */
public class CitaBO {

    private static final Logger logger = Logger.getLogger(CitaBO.class.getName());
    private final ICitaDAO citaDAO;
    private final IConexionBD conexionBD;
    private PacienteBO pacienteBO;
    private MedicoBO medicoBO;
    Mapper mapper = new Mapper();

    public CitaBO(IConexionBD conexion) {
        this.citaDAO = new CitaDAO(conexion);
        this.conexionBD = conexion;
        this.pacienteBO = new PacienteBO(conexion);
        //this.medicoBO = new MedicoBO(conexion);
    }

    // QUITAR TODO LO DE LOS COMENTARIOS CUANDO SE AGREGUEN TODO LA LOGICA DE LOS MEDICOS
    public boolean agendarCita(CitaNuevoDTO citaNueva, PacienteNuevoDTO pacienteNuevo, MedicoNuevoDTO medicoNuevo) throws NegocioException, SQLException {
        if (citaNueva == null) {
            throw new NegocioException("La cita no puede ser nula");
        }
        if (pacienteNuevo == null) {
            throw new NegocioException("El paciente no puede ser nulo");
        }
        if (medicoNuevo == null) {
            throw new NegocioException("El medico no puede ser nulo");
        }

        Connection con = null;
        try {
            con = this.conexionBD.crearConexion();
            con.setAutoCommit(false);

            Medico medico = mapper.DTOMedicoToEntity(medicoNuevo);
            Paciente paciente = mapper.DTOPacienteToEntity(pacienteNuevo);
            citaNueva.setMedico(medico);
            citaNueva.setPaciente(paciente);
            Cita cita = mapper.DTOCitaToEntity(citaNueva);

            citaDAO.agendarCita(cita);
            
            con.commit();
            return true;
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error, No se pudo agregar la cita. Intenta de nuevo.", ex);

        } catch (SQLException e) {
            con.rollback();
        }
        return false;
    }

    public List<CitaNuevoDTO> obtenerAgendaCitasProgramadas(int idMedico) {
        Connection con = null;
        try {
            con = this.conexionBD.crearConexion();

            List<Cita> agendaCitas = citaDAO.consultarCitasProgramadasAgenda(idMedico);
            int i = 0;
            List<CitaNuevoDTO> agendaCitaDTO = new ArrayList<>();
            while (i < agendaCitas.size()) {
                CitaNuevoDTO agendaCitaNuevaDTO = mapper.CitaToNuevaDTO(agendaCitas.get(i));

                agendaCitaDTO.add(agendaCitaNuevaDTO);
                i++;
            }
            return agendaCitaDTO;
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error, No se pudieron encontrar  las citas del médico. Intenta de nuevo.", ex);
        }
        return null;
    }

    public List<CitaNuevoDTO> obtenerAgendaCitasEmergencia(int idMedico) {
        Connection con = null;
        try {
            con = this.conexionBD.crearConexion();

            List<Cita> agendaCitas = citaDAO.consultarCitasEmergenciaAgenda(idMedico);
            int i = 0;
            List<CitaNuevoDTO> agendaCitaDTO = new ArrayList<>();
            while (i < agendaCitas.size()) {
                CitaNuevoDTO agendaCitaNuevaDTO = mapper.CitaToNuevaDTO(agendaCitas.get(i));

                agendaCitaDTO.add(agendaCitaNuevaDTO);
                i++;
            }
            return agendaCitaDTO;
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error, No se pudieron encontrar  las citas del médico. Intenta de nuevo.", ex);
        }
        return null;
    }
    
    public List<CitaNuevoDTO> consultarCitasPacientes(Paciente paciente) throws PersistenciaException, NegocioException {
        if (paciente == null) {
            throw new NegocioException("El paciente no puede ser nulo");

        }
        List<CitaNuevoDTO> citasDTOPendientes = new ArrayList<>();
        try {
            List<Cita> citasPacientes = citaDAO.consultarCitasPaciente(paciente);
            
            for (int i = 0; i < citasPacientes.size(); i++) {
                citasDTOPendientes.add(mapper.CitaToNuevaDTO(citasPacientes.get(1)));
            }
            return citasDTOPendientes;
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error, No se pudieron encontrar  las citas del paciente. Intenta de nuevo.", ex);
        }
        return citasDTOPendientes;
    }

    public List<CitaNuevoDTO> cargarCitas(int idMedico, String diaSemana, String fecha) {
        List<CitaNuevoDTO> listaDTO = new ArrayList<>();
        try {
            List<Cita> citasDisponibles = citaDAO.cargarCitas(idMedico, diaSemana, fecha);
            for (Cita citaDisponible : citasDisponibles) {
                CitaNuevoDTO citaDTO = mapper.CitaToNuevaDTO(citaDisponible);
                listaDTO.add(citaDTO);
            }
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error al cargar las citas del médico.", ex);
        }
        return listaDTO;
    }

    public DayOfWeek obtenerDia(String dia) {
        if (dia == null) {
        System.out.println("Error: diaSemana es null en obtenerDia()");
        return null;
    }
        switch (dia) {
            case "Lunes":
                return MONDAY;
            case "Martes":
                return TUESDAY;
            case "Miercoles":
                return WEDNESDAY;
            case "Jueves":
                return THURSDAY;
            case "Viernes":
                return FRIDAY;
            case "Sabado":
                return SATURDAY;
            case "Domingo":
                return SUNDAY;
            default:
                return null;
        }
    }
}
