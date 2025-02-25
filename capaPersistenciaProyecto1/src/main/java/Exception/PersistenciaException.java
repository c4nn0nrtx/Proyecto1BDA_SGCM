package Exception;

/**
 * Excepción personalizada para errores de la persistencia de datos. Esta
 * excepción se utiliza para encapsular excepciones de bajo nivel (como
 * SQLExceptions) y proporcionar una abstracción más clara para las capas
 * superiores de la aplicación.
 *
 * @author Brandon Valenzuela
 */
public class PersistenciaException extends Exception {

    /**
     * Constructor de la excepción con un mensaje descriptivo.
     *
     * @param message El mensaje descriptivo de la excepción.
     */
    public PersistenciaException(String message) {
        super(message);
    }

    /**
     * Constructor de la excepción con un mensaje descriptivo y la causa
     * original de la excepción. Este constructor es especialmente útil para
     * encapsular excepciones de bajo nivel, preservando la información original
     * de la excepción para fines de depuración.
     *
     * @param message El mensaje descriptivo de la excepción.
     * @param cause La causa original de la excepción (por ejemplo, una
     * SQLException).
     */
    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }

}
