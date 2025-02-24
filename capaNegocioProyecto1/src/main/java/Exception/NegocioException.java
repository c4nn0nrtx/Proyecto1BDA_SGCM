package Exception;

/**
 * Excepción personalizada para errores de lógica de negocio. Esta excepción se
 * utiliza para indicar que ha ocurrido un error en la lógica de negocio de la
 * aplicación, como datos inválidos, reglas de negocio violadas, etc.
 *
 * @author brand
 */
public class NegocioException extends Exception {

    /**
     * Constructor de la excepción con un mensaje.
     *
     * @param message El mensaje de error.
     */
    public NegocioException(String message) {
        super(message);
    }

    /**
     * Constructor de la excepción con un mensaje y una causa. Este constructor
     * se utiliza cuando la excepción de negocio es causada por otra excepción
     * (por ejemplo, una excepción de persistencia).
     *
     * @param message El mensaje de error.
     * @param cause La causa de la excepción (otra excepción).
     */
    public NegocioException(String message, Throwable cause) {
        super(message, cause);
    }
}
