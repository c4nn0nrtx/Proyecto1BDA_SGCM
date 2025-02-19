/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import Conexion.ConexionBD;
import Conexion.IConexionBD;
import DAO.Direccion_PacienteDAO;
import DAO.MedicoDAO;
import Entidades.Direccion_Paciente;
import Entidades.Medico;
import Exception.PersistenciaException;
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

        MedicoDAO medico = new MedicoDAO(conexionBD);
/*IGNORAR , SOLAMENTE LA HICE PARA PROBAR LOS METODOS DE LA CLASE MEDICODAO*/
        /*try {
            int idConsulta = 1;  // ID a consultar
            Medico medicoConsultado = medico.consultarMedicoPorId(idConsulta);

            if (medicoConsultado != null) {
                System.out.println("Activista encontrado: " + medicoConsultado);
            } else {
                System.out.println("No se encontró ningún activista con ID: " + idConsulta);
            }
        } catch (PersistenciaException e) {
            System.err.println("Error al consultar activista: " + e.getMessage());
            e.printStackTrace();
        }**/
 /*
        try {
            List<Medico> lista =  medico.obtenerPorEspecialidad("Ginecologia");
            for(Medico a : lista){
                System.out.println(a);
            }

        } catch (PersistenciaException ex) {
            Logger.getLogger(pruebas.class.getName()).log(Level.SEVERE, null, ex);
        }*/
 /*
        Medico m = new Medico(1, "Juan Manuel", "Perez ", "Montoya", "ABC313 ", "Ginecologia", "Activo");

        try {
            if (medico.actualizarEstadoMedico(m, "Inactiv")) {
                System.out.println("Correctamente actualizado.");
            } else {
                System.out.println("Hubo un error.");
            };

        } catch (PersistenciaException ex) {
            Logger.getLogger(pruebas.class.getName()).log(Level.SEVERE, null, ex);
        }*/
 
        /*Direccion_PacienteDAO direccion = new Direccion_PacienteDAO(conexionBD);
        
        direccion.consultarDireccionPorId(1);
        
        direccion.agregarDireccion(dir);
        
        Direccion_Paciente dir = new Direccion_Paciente(1,"Martin Luis Guzman", "Villa de Cortes", 85000, "#308");
        
        direccion.actualizarDireccion(dir);
        */
        
        
    }

}
