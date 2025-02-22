
package GUI;

import Exception.PersistenciaException;

/**
 * Clase de ejecucion de la interfaz grafica.
 * @author brand
 */
public class principal {

    public static void main(String[] args) throws PersistenciaException {
        FramePrincipal frame = new FramePrincipal();
        frame.setSize(1000,700);
        frame.setVisible(true);
    }
    
}
