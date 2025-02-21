package Conexion;

import Exception.PersistenciaException;
import java.sql.Connection;

/**
 * Interfaz para la conexion de la base de datos.
 * @author brand
 */
public interface IConexionBD {

    /**
     * Crea una conexion hacia una base de datos.
     * @return Objeto tipo Connection.
     * @throws PersistenciaException
     */
    public Connection crearConexion() throws PersistenciaException;
}
