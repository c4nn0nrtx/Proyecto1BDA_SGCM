/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.IConexionBD;
import Entidades.Horario;
import Exception.PersistenciaException;
import static com.mysql.cj.conf.PropertyKey.logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ramon Valencia
 */
public class HorarioDAO implements IHorarioDAO {

    private IConexionBD conexionBD;
    private static final Logger logger = Logger.getLogger(MedicoDAO.class.getName());

    public HorarioDAO(IConexionBD conexion) {
        this.conexionBD = conexion;
    }

    @Override
    public Horario consultarHorarioPorId(int id) throws PersistenciaException, SQLException {
        Horario horario = null;
        String consultaSQL = "SELECT idHorario, diaSemana, horaInicio, horaFin FROM HORARIOS WHERE idHorario = ?;";

        try (Connection con = this.conexionBD.crearConexion(); PreparedStatement ps = con.prepareStatement(consultaSQL, PreparedStatement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    horario = new Horario();
                    horario.setIdHorario(id);
                    horario.setDiaSemana(rs.getString("diaSemana"));
                    
                    LocalTime horaInicio = rs.getObject("horaInicio", LocalTime.class);
                    horario.setHoraInicio(horaInicio);
                    
                    LocalTime horaFin = rs.getObject("horaFin", LocalTime.class);
                    horario.setHoraFin(horaFin);
                    
                    return horario;
                    
                } else {
                    logger.severe("No se encontro horario con id " + id);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(HorarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
