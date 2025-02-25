package DAO;

import Conexion.IConexionBD;
import Entidades.Horario;
import Entidades.Horario_Medico;
import Entidades.Medico;
import Entidades.Usuario;
import Exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
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
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Objeto de acceso a datos (DAO) para la entidad HorarioMedico. Proporciona
 * métodos para obtener médicos disponibles y horarios de médicos.
 *
 * @author Sebastian Moreno, Ramon Valencia
 */
public class HorarioMedicoDAO implements IHorarioMedicoDAO {

    private IConexionBD conexion;
    private static final Logger logger = Logger.getLogger(MedicoDAO.class.getName());
    private UsuarioDAO usuarioDAO;
    private MedicoDAO medicoDAO;
    private HorarioDAO horarioDAO;

    /**
     * Constructor de la clase HorarioMedicoDAO.
     *
     * @param conexion La conexión a la base de datos.
     */
    public HorarioMedicoDAO(IConexionBD conexion) {
        this.conexion = conexion;
        this.usuarioDAO = new UsuarioDAO(conexion);
        this.medicoDAO = new MedicoDAO(conexion);
        this.horarioDAO = new HorarioDAO(conexion);
    }
    //Quite momentaneamente los metodos de Horarios Medicos de igual manera para que no haya errores por el momento

    /**
     * Obtiene el nombre del día de la semana en español.
     *
     * @param dia El día de la semana (DayOfWeek).
     * @return El nombre del día de la semana en español (String).
     */
    public static String obtenerDiaEnEspanol(DayOfWeek dia) {
        switch (dia) {
            case MONDAY:
                return "Lunes";
            case TUESDAY:
                return "Martes";
            case WEDNESDAY:
                return "Miercoles";
            case THURSDAY:
                return "Jueves";
            case FRIDAY:
                return "Viernes";
            case SATURDAY:
                return "Sábado";
            case SUNDAY:
                return "Domingo";
            default:
                return "";
        }
    }

    /**
     * Obtiene una lista de médicos disponibles en una fecha y hora específica.
     *
     * @param fechaHora La fecha y hora para la cual se va a verificar la
     * disponibilidad de los médicos.
     * @return Una lista de objetos Medico que están disponibles en la fecha y
     * hora especificada.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    @Override
    public List<Medico> obtenerMedicosDisponibles(LocalDateTime fechaHora) throws PersistenciaException {
        List<Medico> medicosDisponibles = new ArrayList<>();
        String sql = "SELECT m.* "
                + "FROM Medicos m "
                + "INNER JOIN horarios_medicos hm ON hm.idMedico = m.idMedico "
                + "INNER JOIN horarios as h on h.idHorario = hm.idHorario "
                + "WHERE h.diaSemana = ? AND ? BETWEEN h.horaInicio AND h.horaFin "
                + "AND m.estado = 'activo'";

        try (Connection con = conexion.crearConexion(); PreparedStatement stmt = con.prepareStatement(sql)) {

            // Extraer el día de la semana de la fecha solicitada
            DayOfWeek diaSemana = fechaHora.getDayOfWeek();
            String diaSemanaBD = obtenerDiaEnEspanol(diaSemana); // utilizo metodo para convertir "MONDAY" a "Lunes" para mejor uso.
            stmt.setString(1, diaSemanaBD); // Se supone que en la BD se guarda como texto (ej. "Lunes")
            stmt.setTime(2, Time.valueOf(fechaHora.toLocalTime()));

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Medico medico = new Medico();
                Usuario usuario = usuarioDAO.consultarUsuarioPorId(rs.getInt("idMedico"));
                medico.setUsuario(usuario);
                medico.setNombre(rs.getString("nombre"));
                medico.setNombre(rs.getString("nombre"));
                medico.setApellidoPaterno(rs.getString("apellidoPat"));
                medico.setApellidoMaterno(rs.getString("apellidoMat"));
                medico.setEspecialidad(rs.getString("especialidad"));
                medico.setCedulaProfesional(rs.getString("cedulaProf"));
                medico.setEstado(rs.getString("estado"));
                medicosDisponibles.add(medico);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new PersistenciaException("Hubo un error consultando a los medicos." + ex.getSQLState());
        }
        return medicosDisponibles;
    }

    /**
     * Obtiene una lista de horarios de médicos.
     *
     * @return Una lista de objetos Horario_Medico.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    @Override
    public List<Horario_Medico> obtenerHorariosMedicos() throws PersistenciaException, SQLException {
        List<Horario_Medico> horariosMedicos = new ArrayList<>();
        String consultaSQL = "SELECT idHorarioMedicos, idMedico, idHorario "
                + "FROM HORARIOS_MEDICOS";

        try (Connection con = this.conexion.crearConexion(); PreparedStatement ps = con.prepareStatement(consultaSQL)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Medico medico = medicoDAO.consultarMedicoPorId(rs.getInt("idMedico"));
                Horario horario = horarioDAO.consultarHorarioPorId(rs.getInt("idHorario"));

                Horario_Medico horarioMedico = new Horario_Medico(rs.getInt("idHorarioMedicos"), horario, medico);

                horariosMedicos.add(horarioMedico);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new PersistenciaException("Hubo un error consultando a los medicos u horarios." + ex.getSQLState());
        }
        return horariosMedicos;
    }

    /**
     * Verifica si un horario está disponible para un médico específico.
     *
     * @param horarioMedico El objeto Horario_Medico que contiene la información
     * del horario y el médico.
     * @return true si el horario está disponible, false si no lo está.
     */
    @Override
    public boolean consultarHorariosDisponibles(Horario_Medico horarioMedico) {
        Horario horario = horarioMedico.getHorario();
        Medico medico = horarioMedico.getMedico();

        DayOfWeek dia = obtenerDia(horario.getDiaSemana());
        LocalDate fecha = obtenerProximoDia(dia);
        LocalDateTime fechaHora = fecha.atTime(horario.getHoraInicio());

        String consultaSQL = "SELECT fechaHoraProgramada, idMedico FROM CITAS "
                + "WHERE fechaHoraProgramada = ?";

        try (Connection con = this.conexion.crearConexion(); PreparedStatement ps = con.prepareStatement(consultaSQL)) {

            ps.setObject(1, fechaHora);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                LocalDateTime fechaHoraProgramada = rs.getObject("fechaHoraProgramada", LocalDateTime.class);
                int idMedico = rs.getInt("idMedico");
                if (fechaHora == fechaHoraProgramada || medico.getUsuario().getIdUsuario() == idMedico || medico.getEstado() == "Inactivo") {
                    return false;
                }
            }
        } catch (PersistenciaException ex) {
            Logger.getLogger(HorarioMedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(HorarioMedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

    /**
     * Obtiene el próximo día de la semana dado a partir de la fecha actual.
     *
     * @param dia El día de la semana (DayOfWeek) que se va a buscar.
     * @return La fecha (LocalDate) del próximo día de la semana especificado.
     */
    public static LocalDate obtenerProximoDia(DayOfWeek dia) {
        //Este metodo sirve para buscar el proximo dia posible para la cita
        LocalDate hoy = LocalDate.now();
        for (int i = 1; i <= 10; i++) {
            LocalDate futuro = hoy.plusDays(i);
            if (futuro.getDayOfWeek() == dia) {
                return futuro;
            }
        }
        return null;
    }

    /**
     * Convierte un nombre de día de la semana en español a su representación en
     * DayOfWeek.
     *
     * @param dia El nombre del día de la semana en español (String).
     * @return El objeto DayOfWeek correspondiente al nombre del día, o null si
     * el nombre no es válido.
     */
    public DayOfWeek obtenerDia(String dia) {
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
                return null; // Devolver null para indicar un día no válido
        }
    }
}
