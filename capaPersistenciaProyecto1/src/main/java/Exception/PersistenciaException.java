package Exception;

/**
 * PersistenciaException.java
 *
 * Clase que extiende de Exception para excepciones personalizadas.
 *
 * @author Brandon Valenzuela
 */
public class PersistenciaException extends Exception {

    /**
     *
     * @param message
     */
    public PersistenciaException(String message) {
        super(message);
    }

    /**
     *
     * @param message
     * @param cause
     */
    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }

}
