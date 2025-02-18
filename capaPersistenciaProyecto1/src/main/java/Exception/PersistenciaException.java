package Exception;

/**
 * PersistenciaException.java
 * 
 * Clase que extiende de Exception para excepciones personalizadas.
 * 
 * @author Brandon Valenzuela
 */
public class PersistenciaException extends Exception{

    public PersistenciaException(String message) {
        super(message);
    }

    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
