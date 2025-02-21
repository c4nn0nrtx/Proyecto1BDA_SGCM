/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.IConexionBD;
import Entidades.Cita;
import Exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ramon Valencia
 */
public class CitaDAO implements ICitaDAO {
     
    private IConexionBD conexionBD;

    public CitaDAO(IConexionBD conexion) {
        this.conexionBD = conexion;
    }
    
    private static final Logger logger = Logger.getLogger(CitaDAO.class.getName());
    
    @Override
    public Cita agendarCita(Cita cita) throws PersistenciaException{
        String consultaSQL = "INSERT INTO CITAS (estado, fechaHoraProgramada, folio, tipo, idMedico, idPaciente)"
                + "VALUES(?, ?, ?, ?, ?, ?,)";
        
        try (Connection con = this.conexionBD.crearConexion(); 
                PreparedStatement ps = con.prepareStatement(consultaSQL, PreparedStatement.RETURN_GENERATED_KEYS)){
            
            ps.setString(1, cita.getEstado());
            ps.setObject(2, cita.getFechaHora());
            ps.setString(3, cita.getFolio());
            ps.setString(4, cita.getTipo());
            ps.setInt(5, cita.getMedico().getUsuario().getIdUsuario());
            ps.setInt(6, cita.getPaciente().getUsuario().getIdUsuario());
            
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas == 0) {
                logger.severe("ERROR: Hubo un fallo al agendar la cita, no se inserto niguna fila.");
            }
            
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    cita.setIdCita(generatedKeys.getInt(1));
                    logger.info("Cita agregada exitosamente");
                } else {
                    logger.severe("ERROR: La agregacion de la cita fallo, no se pudo obtener el id.");
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Error al registrar una cita en la base de datos.");
        }
        return cita;
    }
}
