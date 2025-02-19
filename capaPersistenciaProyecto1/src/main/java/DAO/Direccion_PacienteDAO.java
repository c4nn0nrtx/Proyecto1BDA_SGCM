/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.IConexionBD;
import Entidades.Direccion_Paciente;
import Exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ramon
 */
public class Direccion_PacienteDAO implements IDireccion_PacienteDAO{
    private IConexionBD conexionBD;

    public Direccion_PacienteDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }
    
    private static final Logger logger = Logger.getLogger(Direccion_PacienteDAO.class.getName());
    
    @Override
    public Direccion_Paciente agregarDireccion(Direccion_Paciente direccion) throws PersistenciaException{
        String consultaSQL = "INSERT INTO DIRECCIONES_PACIENTES (calle, colonia, cp, numero)"
                + "VALUES (?, ?, ?, ?)";
        
        try(Connection con = this.conexionBD.crearConexion();
                PreparedStatement ps = con.prepareStatement(consultaSQL)){
            
            ps.setString(1, direccion.getCalle());
            ps.setString(2, direccion.getColonia());
            ps.setInt(3, direccion.getCp());
            ps.setString(4, direccion.getNumero());
            
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas == 0) {
                logger.severe("ERROR: Hubo un fallo al agregar la direccion, no se inserto ninguna fila");
            }
            
            try (ResultSet generatedKeys = ps.getGeneratedKeys()){
                if (generatedKeys.next()) {
                    direccion.setIdDireccion(generatedKeys.getInt(1));
                    logger.info("Direccion agregada exitosamente");
                } else {
                    logger.severe("ERROR: La agregacion de la direccion fallo, no se pudo obtener el ID.");
                }
            }
        } catch (SQLException ex){
            Logger.getLogger(Direccion_PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public Direccion_Paciente consultarDireccionPorId(int id) throws PersistenciaException {
        Direccion_Paciente direccion = null;
        
        String consultaSQL = "SELECT idDireccion, calle, colonia, cp, numero FROM DIRECCIONES_PACIENTES WHERE idDireccion = ?";
        
        try(Connection con = this.conexionBD.crearConexion(); 
                PreparedStatement ps = con.prepareStatement(consultaSQL)){
            
            ps.setInt(1, id);
            
            try(ResultSet rs = ps.executeQuery()) {
                if(rs.next()){
                    direccion = new Direccion_Paciente();
                    direccion.setIdDireccion(rs.getInt("idDireccion"));
                    direccion.setCalle(rs.getString("calle"));
                    direccion.setColonia(rs.getString("colonia"));
                    direccion.setCp(rs.getInt("cp"));
                    direccion.setNumero(rs.getString("numero"));
                    
                    logger.info("Direccion encontrada: " + direccion);
                } else {
                    logger.warning("No se encontro una direccion con el ID: " + id);
                }
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "ERROR: Hubo un error al consultar la direccion con ID: " + id, ex);
        }
        return direccion;
    }

    @Override
    public Direccion_Paciente actualizarDireccion(Direccion_Paciente direccion) throws PersistenciaException {
        String consultaSQL = "UPDATE DIRECCIONES_PACIENTES SET calle = ?, colonia = ?, cp = ?, numero = ? WHERE idDireccion = ?";
        
        try (Connection con = this.conexionBD.crearConexion(); 
                PreparedStatement ps = con.prepareStatement(consultaSQL)){
            
            if (consultarDireccionPorId(direccion.getIdDireccion()) == null){
                throw new PersistenciaException("ERROR: No se encontro la direccion");
            }
            
            ps.setString(1, direccion.getCalle());
            ps.setString(2, direccion.getColonia());
            ps.setInt(3, direccion.getCp());
            ps.setString(4, direccion.getNumero());
            ps.setInt(5, direccion.getIdDireccion());
            
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas == 0) {
                logger.severe("ERROR: No se pudo ejecutar la actualizacion de la direccion, no se modifico ninguna fila.");
            }
            
            return direccion;
            
        } catch (SQLException ex) {
            Logger.getLogger(Direccion_PacienteDAO.class.getName()).log(Level.SEVERE, "ERROR: No se pudo actualizar el activista");
            throw new PersistenciaException("ERROR: Hubo un problema con la base de datos y no se pudieron actualizar los datos.");
        }
    }
}
