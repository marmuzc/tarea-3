package LOGICA.Excepciones;
/**
 * Clase PagoIncorrectoException representa una excepción que se lanza cuando el pago no es correcto.
 */

public class PagoIncorrectoException extends Exception{
    /**
     * Constructor de PagoIncorrectoException.
     *
     * @param txt El mensaje de error que describe la excepción.
     */
    public PagoIncorrectoException(String txt){
        super(txt);
    }
}
