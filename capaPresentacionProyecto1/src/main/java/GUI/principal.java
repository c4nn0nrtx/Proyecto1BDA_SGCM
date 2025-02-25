package GUI;

import Exception.NegocioException;
import Exception.PersistenciaException;
import java.sql.SQLException;

/**
 * Clase de ejecucion de la interfaz grafica.
 *
 * @author brand
 */
public class principal {

    /**
     *
     * @param args
     * @throws PersistenciaException
     * @throws SQLException
     * @throws NegocioException
     */
    public static void main(String[] args) throws PersistenciaException, SQLException, NegocioException {
        FramePrincipal frame = new FramePrincipal();
        frame.setSize(1000, 700);
        frame.setVisible(true);

    }

}
