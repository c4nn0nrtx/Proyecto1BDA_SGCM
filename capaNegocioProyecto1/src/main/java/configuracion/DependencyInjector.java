
package configuracion;

import BO.CitaBO;
import BO.ConsultaBO;
import BO.Direccion_PacienteBO;
import BO.MedicoBO;
import BO.PacienteBO;
import BO.UsuarioBO;
import Conexion.ConexionBD;
import Conexion.IConexionBD;

/**
 * Clase de injector de dependencias
 * Sirve para crear conexiones mas privadas a las bases de datos.
 * @author Sebastian Moreno
 */
public class DependencyInjector {

    public static UsuarioBO crearUsuarioBO() {
        // Crear una instancia de la conexión a la base de datos, utilizando la implementación de IConexionBD
        IConexionBD conexion = new ConexionBD();

        // Inyectar la dependencia de conexión a la instancia de UsuarioBO
        UsuarioBO usuarioBO = new UsuarioBO(conexion);

        // Retornar la instancia completamente configurada
        return usuarioBO;
    }
    
    public static PacienteBO crearPacienteBO() {
        // Crear una instancia de la conexión a la base de datos, utilizando la implementación de IConexionBD
        IConexionBD conexion = new ConexionBD();

        // Inyectar la dependencia de conexión a la instancia de PacienteBO
        PacienteBO pacienteBO = new PacienteBO(conexion);

        // Retornar la instancia completamente configurada
        return pacienteBO;
    }
    public static Direccion_PacienteBO crearDireccionBO() {
        // Crear una instancia de la conexión a la base de datos, utilizando la implementación de IConexionBD
        IConexionBD conexion = new ConexionBD();

        // Inyectar la dependencia de conexión a la instancia de Direccion_PacienteBO
        Direccion_PacienteBO direccion = new Direccion_PacienteBO(conexion);

        // Retornar la instancia completamente configurada
        return direccion;
    }
    public static CitaBO crearCitaBO() {
        // Crear una instancia de la conexión a la base de datos, utilizando la implementación de IConexionBD
        IConexionBD conexion = new ConexionBD();

        // Inyectar la dependencia de conexión a la instancia de CitaBO
        CitaBO cita = new CitaBO(conexion);

        // Retornar la instancia completamente configurada
        return cita;
    }
    public static ConsultaBO crearConsultaBO() {
        // Crear una instancia de la conexión a la base de datos, utilizando la implementación de IConexionBD
        IConexionBD conexion = new ConexionBD();

        // Inyectar la dependencia de conexión a la instancia de ConsultaBO
        ConsultaBO consulta = new ConsultaBO(conexion);

        // Retornar la instancia completamente configurada
        return consulta;
    }
    public static MedicoBO crearMedicoBO() {
        // Crear una instancia de la conexión a la base de datos, utilizando la implementación de IConexionBD
        IConexionBD conexion = new ConexionBD();

        // Inyectar la dependencia de conexión a la instancia de UsuarioBO
        MedicoBO medicoBO = new MedicoBO(conexion);

        // Retornar la instancia completamente configurada
        return medicoBO;
    }
    
}
