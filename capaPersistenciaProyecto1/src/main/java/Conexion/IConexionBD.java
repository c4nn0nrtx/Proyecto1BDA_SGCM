package Conexion;

import Exception.PersistenciaException;
import java.sql.Connection;

/**
 *
 * @author brand
 */
public interface IConexionBD {

    /**
     *
     * @return
     * @throws PersistenciaException
     */
    public Connection crearConexion() throws PersistenciaException;
}
