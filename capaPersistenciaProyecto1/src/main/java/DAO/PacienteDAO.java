/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.IConexionBD;
import Entidades.Paciente;
import Exception.PersistenciaException;
import java.util.logging.Logger;

/**
 *
 * @author Ramon
 */
public class PacienteDAO implements IPacienteDAO{
    private IConexionBD conexion;

    public PacienteDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }
    
    private static final Logger logger = Logger.getLogger(MedicoDAO.class.getName());
    
    @Override
    public Paciente agregarPaciente(Paciente paciente) throws PersistenciaException{
        String consultaSQL = "INSER INTO PACIENTES (idPaciente, idDireccion, nombre, apellidoPaterno, apellidoMaterno)"
    }
    
    public Paciente consultarPacientePorId(Paciente paciente) throws PersistenciaException{
        
    }
}
