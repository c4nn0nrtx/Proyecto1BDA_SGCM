package Conexion;

import Exception.PersistenciaException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que implementa la interfaz IConexionBD para la conexión a la base de datos.
 * Esta clase se encarga de establecer la conexión con la base de datos MySQL,
 * utilizando las credenciales y la URL especificadas.
 *
 * @author Brandon Valenzuela
 */
public class ConexionBD implements IConexionBD {

    final String USER = "root";
    final String PASS = "itson";
    final String STR_CONECTION = "jdbc:mysql://localhost:3306/clinica";

    /*ALTER USER 'root'@'localhost' IDENTIFIED BY 'itson';*/

   /**
     * Crea una conexión a la base de datos.
     *
     * @return Un objeto Connection que representa la conexión a la base de datos.
     * @throws PersistenciaException Si ocurre un error al conectar a la base de datos.
     */
    @Override
    public Connection crearConexion() throws PersistenciaException {
        try {
            Connection conexion = DriverManager.getConnection(STR_CONECTION, USER, PASS);
            return conexion;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Error al conectar a la base de datos", ex);
        }
    }
}
