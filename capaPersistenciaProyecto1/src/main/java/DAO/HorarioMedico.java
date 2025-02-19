/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.IConexionBD;
import Entidades.Medico;
import Exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Sebastian Moreno
 */
public class HorarioMedico implements IHorarioMedicoDAO{
    private IConexionBD conexion;

    public HorarioMedico(IConexionBD conexion) {
        this.conexion = conexion;
    }
    private static final Logger logger = Logger.getLogger(MedicoDAO.class.getName());

    @Override
public List<Medico> obtenerMedicosDisponibles(LocalDateTime fechaHora)throws PersistenciaException{
    List<Medico> medicosDisponibles = new ArrayList<>();
    String sql = "SELECT DISTINCT m.* FROM Medico m "
               + "JOIN medico_horarios mh ON m.id = mh.id_medico "
               + "WHERE mh.dia_semana = ? AND ? BETWEEN mh.hora_inicio AND mh.hora_fin "
               + "AND m.estado = 'activo'";
    
    try (Connection con = conexion.crearConexion();
         PreparedStatement stmt = con.prepareStatement(sql)) {

        // Extraer el día de la semana de la fecha solicitada
        DayOfWeek diaSemana = fechaHora.getDayOfWeek();
        stmt.setString(1, diaSemana.name()); // Se supone que en la BD se guarda como texto (ej. "MONDAY")
        stmt.setTime(2, Time.valueOf(fechaHora.toLocalTime()));

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Medico medico = new Medico();
            medico.setId(rs.getInt("idMedico"));
            medico.setNombre(rs.getString("nombre"));
            medico.setApellidoPaterno(rs.getString("apellidoPat"));
            medico.setApellidoMaterno(rs.getString("apellidoMat"));
            medico.setEspecialidad(rs.getString("especialidad"));
            medico.setCedulaProfesional(rs.getString("cedulaProfesional"));
            medico.setEstado(rs.getString("estado"));
            medicosDisponibles.add(medico);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        throw new PersistenciaException("Hubo un error consultando a los medicos." +ex.getSQLState() );
    }
    return medicosDisponibles;
}

}
