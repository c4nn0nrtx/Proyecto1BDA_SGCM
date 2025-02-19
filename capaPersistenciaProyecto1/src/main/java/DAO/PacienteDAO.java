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
import java.util.logging.Logger;

/**
 *
 * @author Ramon
 */
public class PacienteDAO implements IPacienteDAO{
    private IConexionBD conexionBD;

    public PacienteDAO(IConexionBD conexion) {
        this.conexionBD = conexion;
    }
    
    private static final Logger logger = Logger.getLogger(MedicoDAO.class.getName());
    
    @Override
    public Paciente agregarPaciente(Paciente paciente) throws PersistenciaException{
        String consultaSQL = "INSERT INTO PACIENTES (idDireccion, nombre, apellidoPaterno, apellidoMaterno, correo, fechaNacimiento, telefono) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try(Connection con = this.conexionBD.crearConexion(); 
                PreparedStatement ps = con.prepareStatement(consultaSQL)){
            
            ps.setInt(1, paciente.getIdDireccion());
            ps.setString(2, paciente.getNombre());
            ps.setString(3, paciente.getApellidoPaterno());
            ps.setString(4, paciente.getApellidoMaterno());
            ps.setString(5, paciente.getCorreo());
            ps.setObject(6, paciente.getFechaNacimiento());
            ps.setString(7, paciente.getTelefono());
            
            
        }
        return null;
    }
    
    public Paciente consultarPacientePorId(Paciente paciente) throws PersistenciaException{
        return null;
    }
}
