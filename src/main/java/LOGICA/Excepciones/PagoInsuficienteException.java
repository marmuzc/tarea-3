package LOGICA.Excepciones;
/**
 * Clase PagoInsuficienteException representa una excepción que se lanza cuando el pago es insuficiente.
 */
public class PagoInsuficienteException extends Exception{
    /**
     * Constructor de PagoInsuficienteException.
     *
     * @param txt El mensaje de error que describe la excepción.
     */
    public PagoInsuficienteException(String txt){
        super(txt);
    }
}
