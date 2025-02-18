package Conexion;

import Exception.PersistenciaException;
import java.sql.Connection;

/**
 *
 * @author brand
 */
public interface IConexionBD {
    public Connection crearConexion() throws PersistenciaException;
}
