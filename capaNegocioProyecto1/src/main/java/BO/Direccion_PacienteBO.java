/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import Conexion.IConexionBD;
import DAO.Direccion_PacienteDAO;
import DAO.IDireccion_PacienteDAO;
import DAO.IPacienteDAO;
import DTO.Direccion_PacienteNuevaDTO;
import Entidades.Direccion_Paciente;
import Exception.NegocioException;
import Exception.PersistenciaException;
import Mapper.Mapper;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class Direccion_PacienteBO {

    private static final Logger logger = Logger.getLogger(PacienteBO.class.getName());

    private final IDireccion_PacienteDAO direccionPacienteDAO;
    private final IConexionBD conexionBD;
    Mapper mapper = new Mapper();

    public Direccion_PacienteBO(IConexionBD conexion) {
        this.direccionPacienteDAO = new Direccion_PacienteDAO(conexion);
        this.conexionBD = conexion;
    }

    public Direccion_Paciente agregarDireccionPaciente(Direccion_PacienteNuevaDTO direccionNueva) throws NegocioException {
        if (direccionNueva == null) {
            throw new NegocioException("La dirección no puede ser nula.");
        }

        Direccion_Paciente direccionEntidad = mapper.DTODireccion_PacienteToEntity(direccionNueva);

        try {
            Direccion_Paciente direccionGuardada = direccionPacienteDAO.agregarDireccion(direccionEntidad);
            if (direccionGuardada == null) {
                throw new NegocioException("No se pudo registrar la dirección en la base de datos.");
            }
            return direccionGuardada;
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error al registrar la dirección.", ex);
            throw new NegocioException("Ocurrió un error al guardar la dirección. Inténtalo de nuevo.");
        }
    }

}
