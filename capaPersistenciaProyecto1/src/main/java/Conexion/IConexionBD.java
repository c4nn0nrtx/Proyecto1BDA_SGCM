package Conexion;

import Exception.PersistenciaException;
import java.sql.Connection;

/**
 * Interfaz para la conexión a la base de datos.
 * Esta interfaz define el método para crear una conexión a la base de datos.
 * Las clases que implementen esta interfaz se encargarán de la configuración
 * específica de la conexión (URL, usuario, contraseña, etc.).
 *
 * @author brand
 */
public interface IConexionBD {

    /**
     * Crea una conexión a la base de datos.
     *
     * @return Un objeto Connection que representa la conexión a la base de datos.
     * @throws PersistenciaException Si ocurre un error al crear la conexión.
     */
    public Connection crearConexion() throws PersistenciaException;
}
