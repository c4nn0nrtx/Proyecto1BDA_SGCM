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
import java.time.LocalDate;
import java.time.LocalDateTime;
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

            citaDAO.agendarCitaProgramada(cita);

            con.commit();
            return true;
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error, No se pudo agregar la cita. Intenta de nuevo.", ex);

        } catch (SQLException e) {
            con.rollback();
        }
        return false;
    }

    public Cita agendarCitaEmergencia(CitaNuevoDTO citaNueva, PacienteNuevoDTO pacienteNuevo, MedicoNuevoDTO medicoNuevo) throws NegocioException, SQLException {
        if (citaNueva == null) {
            throw new NegocioException("La cita no puede ser nula");
        }
        if (pacienteNuevo == null) {
            throw new NegocioException("El paciente no puede ser nulo");
        }
        if (medicoNuevo == null) {
            throw new NegocioException("El médico no puede ser nulo");
        }

        Connection con = null;
        try {
            con = this.conexionBD.crearConexion();
            con.setAutoCommit(false);

            // Convertir DTOs a entidades
            Medico medico = mapper.DTOMedicoToEntity(medicoNuevo);
            Paciente paciente = mapper.DTOPacienteToEntity(pacienteNuevo);
            citaNueva.setMedico(medico);
            citaNueva.setPaciente(paciente);

            citaNueva.setFechaHora(citaNueva.getFechaHora());
            citaNueva.setEstado("Programada");
            citaNueva.setTipo("emergencia");

            // Convertir DTO a entidad
            Cita cita = mapper.DTOCitaToEntity(citaNueva);

            // Agendar la cita de emergencia
            Cita citaAgendada = citaDAO.agendarCitaEmergencia(cita);

            con.commit();
            return citaAgendada;  // 🔹 Retorna la cita agendada
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error, no se pudo agregar la cita de emergencia. Intenta de nuevo.", ex);
            if (con != null) {
                con.rollback();
            }
            throw new NegocioException("Error al agendar la cita de emergencia.");
        } catch (SQLException e) {
            if (con != null) {
                con.rollback();
            }
            throw e; // Relanzar la excepción
        } finally {
            if (con != null) {
                con.setAutoCommit(true);
            }
        }
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

    public String obtenerUltimaCita(int idPaciente) throws PersistenciaException {
        Cita cita = citaDAO.obtenerUltimaCita(idPaciente);

        if (cita == null) {
            return null;  // Ahora realmente indicará que no hay citas futuras
        }

        CitaNuevoDTO citaNueva = new CitaNuevoDTO();
        citaNueva.setEstado(cita.getEstado());
        citaNueva.setFechaHora(cita.getFechaHora());
        citaNueva.setFolio(cita.getFolio());
        citaNueva.setMedico(cita.getMedico());
        citaNueva.setPaciente(cita.getPaciente());
        citaNueva.setTipo(cita.getTipo());

        // Formatear la información del médico correctamente
        Medico medico = cita.getMedico();
        String medicoInfo = String.format("%s %s %s (Cédula: %s, Especialidad: %s)",
                medico.getNombre(), medico.getApellidoPaterno(), medico.getApellidoMaterno(),
                medico.getCedulaProfesional(), medico.getEspecialidad());

        // Construir la cadena formateada de la cita
        String citaString = String.format("Cita (Horario: %s, Médico: %s, Estado: %s)",
                cita.getFechaHora(), medicoInfo, cita.getEstado());

        return citaString;
    }

    public String obtenerUltimaCitaEmergencia(int idPaciente) throws PersistenciaException {
        Cita cita = citaDAO.obtenerUltimaCitaEmergencia(idPaciente);

        if (cita == null) {
            return null;  // Ahora realmente indicará que no hay citas futuras
        }

        CitaNuevoDTO citaNueva = new CitaNuevoDTO();
        citaNueva.setEstado(cita.getEstado());
        citaNueva.setFechaHora(cita.getFechaHora());
        citaNueva.setFolio(cita.getFolio());
        citaNueva.setMedico(cita.getMedico());
        citaNueva.setPaciente(cita.getPaciente());
        citaNueva.setTipo(cita.getTipo());

        // Formatear la información del médico correctamente
        Medico medico = cita.getMedico();
        String medicoInfo = String.format("%s %s %s (Cédula: %s, Especialidad: %s)",
                medico.getNombre(), medico.getApellidoPaterno(), medico.getApellidoMaterno(),
                medico.getCedulaProfesional(), medico.getEspecialidad());

        // Construir la cadena formateada de la cita
        String citaString = String.format("Cita (Horario: %s, Médico: %s, Estado: %s)",
                cita.getFechaHora(), medicoInfo, cita.getEstado());

        return citaString;
    }

    public List<Cita> consultarCitasPacientes(Paciente paciente) throws PersistenciaException, NegocioException {
        if (paciente == null) {
            throw new NegocioException("El paciente no puede ser nulo");

        }
        List<Cita> citasPacientes = new ArrayList<>();
        try {
            citasPacientes = citaDAO.consultarCitasPaciente(paciente);
            return citasPacientes;
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error, No se pudieron encontrar  las citas del paciente. Intenta de nuevo.", ex);
        }
        return citasPacientes;
    }

    public Cita cancelarCita(int idPaciente) throws NegocioException {
        try {
            Cita cita = citaDAO.obtenerUltimaCita(idPaciente);

            if (cita == null) {
                return null; // No hay citas para cancelar
            }

            boolean cancelada = citaDAO.cancelarCita(cita.getIdCita());

            if (cancelada) {
                return null; // Se canceló correctamente
            } else {
                return cita; // No se pudo cancelar porque pasaron más de 24 horas
            }

        } catch (PersistenciaException e) {
            throw new NegocioException("Error al cancelar la cita.", e);
        }
    }

    public Cita consultarCitaPorFolio(String folio) throws NegocioException, SQLException, PersistenciaException {
        if (folio == null) {
            throw new NegocioException("El folio no puede ser nulo");
        }

        Cita cita = citaDAO.consultarCitaPorFolio(folio);
        return cita;
    }

    public Cita consultarCitaPorFechaYPaciente(String nombrePaciente, String apellidoPat, String apellidoMat, LocalDateTime fecha) {
        try {
            return citaDAO.consultarCitaPorFecha(nombrePaciente, apellidoPat, apellidoMat, fecha);
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error, no se pudo encontrar la cita del paciente en la fecha especificada.", ex);
        }
        return null;
    }

}
