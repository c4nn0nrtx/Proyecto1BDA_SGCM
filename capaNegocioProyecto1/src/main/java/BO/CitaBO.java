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
 * Clase de negocio para gestionar las citas. Esta clase contiene la lógica de
 * negocio para agendar, cancelar y consultar citas, tanto programadas como de
 * emergencia.
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

    /**
     * Constructor de la clase CitaBO. Inicializa los objetos DAOs y el mapper,
     * y establece la conexión a la base de datos.
     *
     * @param conexion La conexión a la base de datos.
     */
    public CitaBO(IConexionBD conexion) {
        this.citaDAO = new CitaDAO(conexion);
        this.conexionBD = conexion;
        this.pacienteBO = new PacienteBO(conexion);
        //this.medicoBO = new MedicoBO(conexion);
    }

    // QUITAR TODO LO DE LOS COMENTARIOS CUANDO SE AGREGUEN TODO LA LOGICA DE LOS MEDICOS
    /**
     * Agenda una cita programada. Valida los datos de la cita, el paciente y el
     * médico, y luego guarda la cita en la base de datos.
     *
     * @param citaNueva Los datos de la nueva cita (DTO).
     * @param pacienteNuevo Los datos del paciente (DTO).
     * @param medicoNuevo Los datos del médico (DTO).
     * @return true si la cita se agendó correctamente, false en caso contrario.
     * @throws NegocioException Si hay un error en la lógica de negocio, como
     * datos inválidos.
     * @throws SQLException Si hay un error en la base de datos.
     */
    public boolean agendarCita(CitaNuevoDTO citaNueva, PacienteNuevoDTO pacienteNuevo, MedicoNuevoDTO medicoNuevo) throws NegocioException, SQLException {
        // Validaciones
        if (citaNueva == null) {
            throw new NegocioException("La cita no puede ser nula");
        }
        if (pacienteNuevo == null) {
            throw new NegocioException("El paciente no puede ser nulo");
        }
        if (medicoNuevo == null) {
            throw new NegocioException("El medico no puede ser nulo");
        }
        if (citaNueva.getFechaHora() == null) {
            throw new NegocioException("La fecha y hora de la cita no pueden ser nulas");
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

    /**
     * Agenda una cita de emergencia. Similar a agendarCita, pero establece el
     * tipo de cita como "emergencia".
     *
     * @param citaNueva Los datos de la nueva cita (DTO).
     * @param pacienteNuevo Los datos del paciente (DTO).
     * @param medicoNuevo Los datos del médico (DTO).
     * @return La cita agendada (entidad).
     * @throws NegocioException Si hay un error en la lógica de negocio.
     * @throws SQLException Si hay un error en la base de datos.
     */
    public Cita agendarCitaEmergencia(CitaNuevoDTO citaNueva, PacienteNuevoDTO pacienteNuevo, MedicoNuevoDTO medicoNuevo) throws NegocioException, SQLException {
        // Validaciones
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

    /**
     * Obtiene la agenda de citas programadas de un médico.
     *
     * @param idMedico El ID del médico.
     * @return Una lista de citas programadas (DTOs).
     */
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

    /**
     * Obtiene la agenda de citas de emergencia de un médico.
     *
     * @param idMedico El ID del médico.
     * @return Una lista de citas de emergencia (DTOs).
     */
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

    /**
     * Carga las citas disponibles para un médico en un día específico.
     *
     * @param idMedico El ID del médico.
     * @param diaSemana El día de la semana (String).
     * @param fecha La fecha (String).
     * @return Una lista de citas disponibles (DTOs).
     */
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

    /**
     * Obtiene el día de la semana a partir de un String.
     *
     * @param dia El día de la semana (String).
     * @return El día de la semana (DayOfWeek).
     */
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

    /**
     * Obtiene la última cita (programada o de emergencia) de un paciente.
     *
     * @param idPaciente El ID del paciente.
     * @return Una cadena con la información de la última cita.
     * @throws PersistenciaException Si hay un error en la base de datos.
     */
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

    /**
     * Obtiene la última cita de emergencia de un paciente.
     *
     * @param idPaciente El ID del paciente.
     * @return Una cadena con la información de la última cita de emergencia.
     * @throws PersistenciaException Si hay un error en la base de datos.
     */
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

    /**
     * Consulta las citas de un paciente.
     *
     * @param paciente El paciente (entidad).
     * @return Una lista de citas del paciente (entidades).
     * @throws PersistenciaException Si hay un error en la base de datos.
     * @throws NegocioException Si hay un error en la lógica de negocio.
     */
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

    /**
     * Cancela la última cita de un paciente.
     *
     * @param idPaciente El ID del paciente.
     * @return La cita cancelada (entidad), o null si no hay citas o se canceló
     * correctamente.
     * @throws NegocioException Si hay un error en la lógica de negocio.
     */
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

    /**
     * Consulta una cita por su folio.
     *
     * @param folio El folio de la cita.
     * @return La cita (entidad).
     * @throws NegocioException Si hay un error en la lógica de negocio.
     * @throws SQLException Si hay un error en la base de datos.
     * @throws PersistenciaException Si hay un error en la base de datos.
     */
    public Cita consultarCitaPorFolio(String folio) throws NegocioException, SQLException, PersistenciaException {
        if (folio == null) {
            throw new NegocioException("El folio no puede ser nulo");
        }

        Cita cita = citaDAO.consultarCitaPorFolio(folio);
        return cita;
    }

    /**
     * Consulta una cita por la fecha y los datos del paciente.
     *
     * @param nombrePaciente El nombre del paciente.
     * @param apellidoPat El apellido paterno del paciente.
     * @param apellidoMat El apellido materno del paciente.
     * @param fecha La fecha y hora de la cita.
     * @return La cita (entidad).
     */
    public Cita consultarCitaPorFechaYPaciente(String nombrePaciente, String apellidoPat, String apellidoMat, LocalDateTime fecha) {
        try {
            return citaDAO.consultarCitaPorFecha(nombrePaciente, apellidoPat, apellidoMat, fecha);
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error, no se pudo encontrar la cita del paciente en la fecha especificada.", ex);
        }
        return null;
    }

    public void actualizarCita() throws SQLException, PersistenciaException {
        citaDAO.actualizarCitas();
    }

    public boolean validarFolio(Cita citaNueva) throws NegocioException, PersistenciaException {
        String folio = citaDAO.consultarFolio(citaNueva);

        if (folio != null && folio.equals(citaNueva.getFolio())) {
            return true;
        }

        return false;
    }

}
