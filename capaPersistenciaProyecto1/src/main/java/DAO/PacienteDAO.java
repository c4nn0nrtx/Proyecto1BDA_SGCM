/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.IConexionBD;
import Entidades.Paciente;
import Exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase sirve para ingresar los datos de 
 * @author Ramon
 */

public class PacienteDAO implements IPacienteDAO{

    private IConexionBD conexionBD;

    public PacienteDAO(IConexionBD conexion) {
        this.conexionBD = conexion;
    }
    
    private static final Logger logger = Logger.getLogger(MedicoDAO.class.getName());
    
    //Util para caso de uso.
    @Override
    public Paciente agregarPaciente(Paciente paciente) throws PersistenciaException{
        String consultaSQL = "INSERT INTO PACIENTES (idPaciente, idDireccion, nombre, apellidoPat, apellidoMat, correo, fechaNac, telefono) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try(Connection con = this.conexionBD.crearConexion(); 
                PreparedStatement ps = con.prepareStatement(consultaSQL)){
            
            ps.setInt(1, paciente.getUsuario().getIdUsuario());
            ps.setInt(2, paciente.getDireccion().getIdDireccion());
            ps.setString(3, paciente.getNombre());
            ps.setString(4, paciente.getApellidoPaterno());
            ps.setString(5, paciente.getApellidoMaterno());
            ps.setString(6, paciente.getCorreo());
            ps.setObject(7, paciente.getFechaNacimiento());
            ps.setString(8, paciente.getTelefono());
            
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas == 0) {
                logger.severe("ERROR: Hubo un fallo al agregar al paciente, no se inserto niguna fila.");
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(Direccion_PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return paciente;
    }
    /*
    @Override
    public Paciente consultarPacientePorId(int id) throws PersistenciaException{
        Paciente paciente = null;
        
        String consutlaSQL = "SELECT idPaciente, idDireccion, nombre, apellidoPat, apellidoMat, correo, fechaNac, telefono "
                + "FROM PACIENTES WHERE idPaciente = ?";
        
        
        try (Connection con = this.conexionBD.crearConexion();
                PreparedStatement ps = con.prepareStatement(consutlaSQL)) {
            
            ps.setInt(1, id);
            
            try(ResultSet rs = ps.executeQuery()) {
                if(rs.next()) {
                    paciente = new Paciente();
                    paciente.setIdPaciente(rs.getInt("idPaciente"));
                    paciente.setIdDireccion(rs.getInt("idDireccion"));
                    paciente.setNombre(rs.getString("nombre"));
                    paciente.setApellidoPaterno(rs.getString("apellidoPat"));
                    paciente.setApellidoMaterno(rs.getString("apellidoMat"));
                    paciente.setCorreo(rs.getString("correo"));
                    paciente.setFechaNacimiento(rs.getDate("fechaNac").toLocalDate());
                    
                    logger.info("Paciente encontrado: " + paciente);
                } else {
                    logger.warning("No hay un paciente registrado con esos datos.");
                }
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "ERROR: Hubo un error al consultar los datos del paciente: " + paciente, ex);
        }
        return paciente;
    }
    
    @Override
    public Paciente actualizarPaciente(Paciente paciente) throws PersistenciaException{
        String consultaSQL = "UPDATE PACIENTES SET nombre = ?, apellidoPat = ?, apellidoMat = ?, correo = ?, fechaNac = ? WHERE idPaciente = ?";
        
        try (Connection con = this.conexionBD.crearConexion(); 
                PreparedStatement ps = con.prepareStatement(consultaSQL)){
            
            if (consultarPacientePorId(paciente.getIdPaciente()) == null){
                throw new PersistenciaException("ERROR: No se encontro al paciente");
            }
            
            ps.setString(1, paciente.getNombre());
            ps.setString(2, paciente.getApellidoPaterno());
            ps.setString(3, paciente.getApellidoMaterno());
            ps.setString(4, paciente.getCorreo());
            ps.setObject(5, paciente.getFechaNacimiento());
            ps.setInt(6, paciente.getIdPaciente());
            
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas == 0) {
                logger.severe("ERROR: No se pudo ejecutar la actualizacion del paciente, no se modifico ninguna fila");
            }
            
            return paciente;
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, "ERROR: no se pudo actualizar el activista");
            throw new PersistenciaException("ERROR: Hubo un problema con la base de datos y no se pudieron actualizar los datos");
        }
    }*/

    @Override
    public Paciente consultarPacientePorId(int id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Paciente actualizarPaciente(Paciente paciente) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
