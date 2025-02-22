/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.IConexionBD;
import Entidades.Consulta;
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
public class ConsultaDAO implements IConsultaDAO{
    
    private IConexionBD conexionBD;

    public ConsultaDAO(IConexionBD conexion) {
        this.conexionBD = conexion;
    }
    
    private static final Logger logger = Logger.getLogger(ConsultaDAO.class.getName());
    
    @Override
    public Consulta agregarConsulta(Consulta consulta) throws PersistenciaException {
        String consultaSQL = "INSERT INTO CONSULTAS (idCita, estado, diagnostico, tratamiento, observaciones, fechaHoraEntrada) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection con = this.conexionBD.crearConexion(); 
                PreparedStatement ps = con.prepareStatement(consultaSQL, PreparedStatement.RETURN_GENERATED_KEYS)){
            
            ps.setInt(1, consulta.getCita().getIdCita());
            ps.setString(2, consulta.getEstado());
            ps.setString(3, consulta.getDiagnostico());
            ps.setString(4, consulta.getTratamiento());
            ps.setString(4, consulta.getObservaciones());
            ps.setObject(6, consulta.getFechaHora());
            
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas == 0) {
                logger.severe("ERROR: Hubo un fallo al agregar la consulta medica, no se inserto niguna fila.");
            }
            
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    consulta.setIdConsulta(generatedKeys.getInt(1));
                    logger.info("Consulta medica agregada exitosamente");
                } else {
                    logger.severe("ERROR: La agregacion de la consulta medica fallo, no se pudo obtener el id.");
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Error al registrar una consulta medica en la base de datos.");
        }
        return consulta;
        
    }
}
