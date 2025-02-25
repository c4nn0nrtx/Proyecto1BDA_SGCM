package DAO;

import Entidades.Cita;
import Entidades.Horario_Medico;
import Entidades.Paciente;
import Exception.PersistenciaException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad Cita.
 *
 * @author Ramon Valencia
 */
public interface ICitaDAO {

    /**
     * Agenda una cita programada.
     *
     * @param cita La cita que se va a agendar.
     * @return La cita agendada, incluyendo el ID generado por la base de datos.
     * @throws PersistenciaException Si ocurre un error durante la persistencia
     * de la cita.
     */
    public Cita agendarCitaProgramada(Cita cita) throws PersistenciaException;

    /**
     * Consulta las citas programadas para un médico específico.
     *
     * @param idMedico El ID del médico cuyas citas se van a consultar.
     * @return Una lista de citas programadas para el médico.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    public List<Cita> consultarCitasProgramadasAgenda(int idMedico) throws PersistenciaException;

    /**
     * Consulta las citas de emergencia para un médico específico.
     *
     * @param idMedico El ID del médico cuyas citas se van a consultar.
     * @return Una lista de citas de emergencia para el médico.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    public List<Cita> consultarCitasEmergenciaAgenda(int idMedico) throws PersistenciaException;

    /**
     * Carga las citas de un médico en un día de la semana y fecha específicos.
     *
     * @param idMedico El ID del médico.
     * @param diaSemana El día de la semana (ej. "Lunes").
     * @param fecha La fecha (en formato String, se recomienda usar ISO 8601:
     * "yyyy-MM-dd").
     * @return Una lista de citas para el médico en el día y fecha
     * especificados.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    public List<Cita> cargarCitas(int idMedico, String diaSemana, String fecha) throws PersistenciaException;

    /**
     * Obtiene la próxima cita pendiente de un paciente.
     *
     * @param idPaciente El ID del paciente.
     * @return La próxima cita pendiente del paciente, o null si no tiene citas
     * pendientes.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    public Cita obtenerProximaCitaPendiente(int idPaciente) throws PersistenciaException;

    /**
     * Obtiene la última cita de un paciente.
     *
     * @param idPaciente El ID del paciente.
     * @return La última cita del paciente, o null si no tiene citas.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    public Cita obtenerUltimaCita(int idPaciente) throws PersistenciaException;

    /**
     * Agenda una cita de emergencia.
     *
     * @param cita La cita de emergencia que se va a agendar.
     * @return La cita de emergencia agendada, incluyendo el ID generado por la
     * base de datos.
     * @throws PersistenciaException Si ocurre un error durante la persistencia
     * de la cita.
     */
    public Cita agendarCitaEmergencia(Cita cita) throws PersistenciaException;

    /**
     * Consulta las citas de un paciente específico.
     *
     * @param paciente El objeto Paciente cuyas citas se van a consultar.
     * @return Una lista de citas para el paciente.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    public List<Cita> consultarCitasPaciente(Paciente paciente) throws PersistenciaException;

    /**
     * Cancela una cita específica.
     *
     * @param idCita El ID de la cita que se va a cancelar.
     * @return true si la cita fue cancelada exitosamente, false si no se pudo
     * cancelar.
     * @throws PersistenciaException Si ocurre un error durante la cancelación.
     */
    public boolean cancelarCita(int idCita) throws PersistenciaException;

    /**
     * Obtiene la última cita de emergencia de un paciente.
     *
     * @param idPaciente El ID del paciente.
     * @return La última cita de emergencia del paciente, o null si no tiene
     * citas de emergencia.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    public Cita obtenerUltimaCitaEmergencia(int idPaciente) throws PersistenciaException;

    /**
     * Consulta una cita por su número de folio.
     *
     * @param folio El número de folio de la cita que se va a buscar.
     * @return Un objeto Cita si se encuentra una cita con el folio
     * especificado, o null si no se encuentra.
     * @throws SQLException Si ocurre un error durante la consulta a la base de
     * datos.
     * @throws PersistenciaException Si ocurre un error de persistencia.
     */
    public Cita consultarCitaPorFolio(String folio) throws SQLException, PersistenciaException;

    /**
     * Consulta una cita por la fecha y hora exacta, y los datos del paciente.
     *
     * @param nombrePaciente El nombre del paciente.
     * @param apellidoPat El apellido paterno del paciente.
     * @param apellidoMat El apellido materno del paciente.
     * @param fechaHora La fecha y hora exacta de la cita.
     * @return Un objeto Cita si se encuentra una cita que coincide con los
     * criterios especificados, o null si no se encuentra.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    public Cita consultarCitaPorFecha(String nombrePaciente, String apellidoPat, String apellidoMat, LocalDateTime fechaHora) throws PersistenciaException;

    /**
     * Actualiza la información de las citas en la base de datos.
     *
     * @throws SQLException Si ocurre un error durante la actualización en la
     * base de datos.
     * @throws PersistenciaException Si ocurre un error en la capa de
     * persistencia.
     */
    public void actualizarCitas() throws SQLException, PersistenciaException;

    /**
     * Consulta el folio de una cita en la base de datos.
     *
     * @param cita La cita cuyo folio se va a consultar.
     * @return El folio de la cita, o `null` si no se encuentra.
     * @throws PersistenciaException Si ocurre un error durante la consulta en
     * la capa de persistencia.
     */
    public String consultarFolio(Cita cita) throws PersistenciaException;
}
