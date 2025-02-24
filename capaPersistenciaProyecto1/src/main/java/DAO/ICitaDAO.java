/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
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
 *
 * @author Ramon Valencia
 */
public interface ICitaDAO {

    /**
     *
     * @param cita
     * @return
     * @throws PersistenciaException
     */
    public Cita agendarCitaProgramada(Cita cita) throws PersistenciaException;

    public List<Cita> consultarCitasProgramadasAgenda(int idMedico) throws PersistenciaException;

    public List<Cita> consultarCitasEmergenciaAgenda(int idMedico) throws PersistenciaException;

    /**
     * Metodo que carga un listado de citas por horario que pertenecen a un
     * medico dentro de un dia de la semana y una fecha.
     *
     * @param idMedico
     * @param diaSemana
     * @param fecha
     * @return Listado de citas.
     * @throws PersistenciaException
     */
    public List<Cita> cargarCitas(int idMedico, String diaSemana, String fecha) throws PersistenciaException;

    public Cita obtenerProximaCitaPendiente(int idPaciente) throws PersistenciaException;

    public Cita obtenerUltimaCita(int idPaciente) throws PersistenciaException;

    public Cita agendarCitaEmergencia(Cita cita) throws PersistenciaException;

    public List<Cita> consultarCitasPaciente(Paciente paciente) throws PersistenciaException;

    public boolean cancelarCita(int idCita) throws PersistenciaException;

    public Cita obtenerUltimaCitaEmergencia(int idPaciente) throws PersistenciaException;

    public Cita consultarCitaPorFolio(String folio) throws SQLException, PersistenciaException;

    public Cita consultarCitaPorFecha(String nombrePaciente, String apellidoPat, String apellidoMat, LocalDateTime fechaHora) throws PersistenciaException;

    public void actualizarCitas() throws SQLException, PersistenciaException;

    public String consultarFolio(Cita cita) throws PersistenciaException;
}
