package configuracion;

import BO.CitaBO;
import BO.ConsultaBO;
import BO.Direccion_PacienteBO;
import BO.HorarioMedicoBO;
import BO.MedicoBO;
import BO.PacienteBO;
import BO.UsuarioBO;
import Conexion.ConexionBD;
import Conexion.IConexionBD;

/**
 * Clase de inyector de dependencias. Esta clase se encarga de crear y
 * configurar las instancias de las clases de negocio (BO) e inyectarles la
 * dependencia de la conexión a la base de datos. Esto permite un mejor manejo
 * de las dependencias y facilita las pruebas unitarias.
 *
 * @author Sebastian Moreno
 */
public class DependencyInjector {

    /**
     * Crea y configura una instancia de UsuarioBO.
     *
     * @return Una instancia de UsuarioBO lista para usar.
     */
    public static UsuarioBO crearUsuarioBO() {
        // Crear una instancia de la conexión a la base de datos, utilizando la implementación de IConexionBD
        IConexionBD conexion = new ConexionBD();

        // Inyectar la dependencia de conexión a la instancia de UsuarioBO
        UsuarioBO usuarioBO = new UsuarioBO(conexion);

        // Retornar la instancia completamente configurada
        return usuarioBO;
    }

    /**
     * Crea y configura una instancia de PacienteBO.
     *
     * @return Una instancia de PacienteBO lista para usar.
     */
    public static PacienteBO crearPacienteBO() {
        // Crear una instancia de la conexión a la base de datos, utilizando la implementación de IConexionBD
        IConexionBD conexion = new ConexionBD();

        // Inyectar la dependencia de conexión a la instancia de PacienteBO
        PacienteBO pacienteBO = new PacienteBO(conexion);

        // Retornar la instancia completamente configurada
        return pacienteBO;
    }

    /**
     * Crea y configura una instancia de Direccion_PacienteBO.
     *
     * @return Una instancia de Direccion_PacienteBO lista para usar.
     */
    public static Direccion_PacienteBO crearDireccionBO() {
        // Crear una instancia de la conexión a la base de datos, utilizando la implementación de IConexionBD
        IConexionBD conexion = new ConexionBD();

        // Inyectar la dependencia de conexión a la instancia de Direccion_PacienteBO
        Direccion_PacienteBO direccion = new Direccion_PacienteBO(conexion);

        // Retornar la instancia completamente configurada
        return direccion;
    }

   /**
     * Crea y configura una instancia de CitaBO.
     *
     * @return Una instancia de CitaBO lista para usar.
     */
    public static CitaBO crearCitaBO() {
        // Crear una instancia de la conexión a la base de datos, utilizando la implementación de IConexionBD
        IConexionBD conexion = new ConexionBD();

        // Inyectar la dependencia de conexión a la instancia de CitaBO
        CitaBO cita = new CitaBO(conexion);

        // Retornar la instancia completamente configurada
        return cita;
    }

    /**
     * Crea y configura una instancia de ConsultaBO.
     *
     * @return Una instancia de ConsultaBO lista para usar.
     */
    public static ConsultaBO crearConsultaBO() {
        // Crear una instancia de la conexión a la base de datos, utilizando la implementación de IConexionBD
        IConexionBD conexion = new ConexionBD();

        // Inyectar la dependencia de conexión a la instancia de ConsultaBO
        ConsultaBO consulta = new ConsultaBO(conexion);

        // Retornar la instancia completamente configurada
        return consulta;
    }

    /**
     * Crea y configura una instancia de MedicoBO.
     *
     * @return Una instancia de MedicoBO lista para usar.
     */
    public static MedicoBO crearMedicoBO() {
        // Crear una instancia de la conexión a la base de datos, utilizando la implementación de IConexionBD
        IConexionBD conexion = new ConexionBD();

        // Inyectar la dependencia de conexión a la instancia de UsuarioBO
        MedicoBO medicoBO = new MedicoBO(conexion);

        // Retornar la instancia completamente configurada
        return medicoBO;
    }

    /**
     * Crea y configura una instancia de HorarioMedicoBO.
     *
     * @return Una instancia de HorarioMedicoBO lista para usar.
     */
    public static HorarioMedicoBO crearHorarioMedicoBO() {
        // Crear una instancia de la conexión a la base de datos, utilizando la implementación de IConexionBD
        IConexionBD conexion = new ConexionBD();

        // Inyectar la dependencia de conexión a la instancia de UsuarioBO
        HorarioMedicoBO horarioMedicoBO = new HorarioMedicoBO(conexion);

        // Retornar la instancia completamente configurada
        return horarioMedicoBO;
    }

}
