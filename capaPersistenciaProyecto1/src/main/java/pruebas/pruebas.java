/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import Conexion.ConexionBD;
import Conexion.IConexionBD;
import DAO.HorarioMedico;
import DAO.MedicoDAO;
import Entidades.Medico;
import Exception.PersistenciaException;
import java.time.LocalDateTime;
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
    public static void main(String[] args) {
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
 
 
        HorarioMedico horarios = new HorarioMedico(conexionBD);
        try {
            List<Medico> listaMedicos = horarios.obtenerMedicosDisponibles(LocalDateTime.now());
            for(Medico a : listaMedicos){
                System.out.println(a);
            }
            
            
        } catch (PersistenciaException ex) {
            Logger.getLogger(pruebas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
