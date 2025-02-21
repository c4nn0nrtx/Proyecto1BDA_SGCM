/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import Conexion.IConexionBD;
import DAO.Direccion_PacienteDAO;
import DAO.IDireccion_PacienteDAO;
import DAO.IPacienteDAO;
import DAO.IUsuarioDAO;
import DAO.PacienteDAO;
import DAO.UsuarioDAO;
import DTO.Direccion_PacienteNuevaDTO;
import DTO.PacienteNuevoDTO;
import DTO.UsuarioNuevoDTO;
import Entidades.Direccion_Paciente;
import Entidades.Paciente;
import Entidades.Usuario;
import Exception.NegocioException;
import Exception.PersistenciaException;
import Mapper.Mapper;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author brand
 */
public class PacienteBO {
    
    private static final Logger logger = Logger.getLogger(PacienteBO.class.getName());

    private final IPacienteDAO pacienteDAO;
    private final IConexionBD conexionBD;
    Mapper mapper = new Mapper();

    public PacienteBO(IConexionBD conexion) {
        this.pacienteDAO = new PacienteDAO(conexion);
        this.conexionBD = conexion;
    }
    
    public Paciente agregarPaciente(PacienteNuevoDTO pacienteNuevo) throws NegocioException, SQLException{
        if (pacienteNuevo == null) {
            throw new NegocioException("El paciente no puede ser nulo.");
        }
       
        
        Paciente pacienteEntidad  = mapper.DTOPacienteToEntity(pacienteNuevo);
        try (Connection con = this.conexionBD.crearConexion()) {

            Paciente pacienteGuardado = pacienteDAO.agregarPaciente(pacienteEntidad);
            
            return pacienteGuardado ;
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error, No se pudo agregar al paciente. Intenta de nuevo.", ex);
            
        }
        return null;
    }
    }
    
    /*
    public boolean agregarUsuario(UsuarioNuevoDTO usuarioNuevo, PacienteNuevoDTO pacienteNuevo, Direccion_PacienteNuevaDTO direccionNueva) throws NegocioException, PersistenciaException, SQLException {

        if (usuarioNuevo == null) {
            throw new NegocioException("El usuario no puede ser nulo.");
        }
        if (pacienteNuevo == null) {
            throw new NegocioException("El paciente no puede ser nulo.");
        }
        if (direccionNueva == null) {
            throw new NegocioException("La direccion no puede ser nulo.");
        }

        // Validaciones básicas: verificar que los campos obligatorios no estén vacíos
        if (usuarioNuevo.getUsuario().isEmpty() || usuarioNuevo.getContrasenha().isEmpty()) {
            throw new NegocioException("Todos los campos son obligatorios.");
        }

        if (pacienteNuevo.getNombre().isEmpty() || pacienteNuevo.getApellidoPaterno().isEmpty()
                || pacienteNuevo.getCorreo().isEmpty() || pacienteNuevo.getFechaNacimiento() == null || pacienteNuevo.getTelefono().isEmpty()) {
            throw new NegocioException("Todos los campos son obligatorios.");
        }

        if (direccionNueva.getCalle().isEmpty() || direccionNueva.getColonia().isEmpty() || direccionNueva.getCp() == 0 || direccionNueva.getNumero().isEmpty()) {
            throw new NegocioException("Todos los campos son obligatorios.");
        }

        Usuario usuario = mapper.DTOUsuarioToEntity(usuarioNuevo);
        Paciente paciente = mapper.DTOPacienteToEntity(pacienteNuevo);
        Direccion_Paciente direccion = mapper.DTODireccion_PacienteToEntity(direccionNueva);
        

        try (Connection con = this.conexionBD.crearConexion()) {
            con.setAutoCommit(false);            // Intentar guardar el activista en la base de datos
            Usuario usuarioGuardado = usuarioDAO.agregarUsuario(usuario);
            Direccion_Paciente direccionGuardado = direccionDAO.agregarDireccion(direccion);
            
            paciente.setIdPaciente(usuarioDAO.consultarIdUsuario(usuario));
            paciente.setIdDireccion(direccionDAO.consultaIdDireccion(direccion));
            
            Paciente pacienteGuardado = pacienteDAO.agregarPaciente(paciente);
            

            con.commit(); //Este commit se activa si todo resulta ser exitoso
            // Si el activista fue guardado con éxito, devuelve true, si no, devuelve false
            return usuarioGuardado != null && pacienteGuardado != null && direccionGuardado != null;
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error, revirtiendo transacción", ex);
            if (conexionBD != null) {
                Connection con = this.conexionBD.crearConexion();
                con.rollback(); // 🔴 Revertir cambios si hay un error
            }
        }
        return false;
    }
    */


