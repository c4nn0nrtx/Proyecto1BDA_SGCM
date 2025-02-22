/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import Conexion.ConexionBD;
import Conexion.IConexionBD;
import DAO.Direccion_PacienteDAO;
import DAO.MedicoDAO;
import DAO.PacienteDAO;
import DAO.UsuarioDAO;
import Entidades.Direccion_Paciente;
import Entidades.Medico;
import Entidades.Paciente;
import Entidades.Usuario;
import Exception.PersistenciaException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sebastian Moreno
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws PersistenciaException {
        // Crear la conexión a la base de datos
        IConexionBD conexionBD = new ConexionBD();
        MedicoDAO medicoDAO = new MedicoDAO(conexionBD);
        
        
        Usuario usuario = new Usuario(23, "Medico1", "gusanitos123");
        UsuarioDAO usuarioDAO = new UsuarioDAO(conexionBD);
        //usuarioDAO.agregarUsuario(usuario);
        
        Medico medico = new Medico(usuario, "Juan", "Topo", "Cabada", "JA123", "Nutriologo", "Activo");
        boolean nose = medicoDAO.actualizarEstadoMedico(medico, "Inactivo");
}

    
 
}


