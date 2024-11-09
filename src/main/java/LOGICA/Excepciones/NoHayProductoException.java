package LOGICA.Excepciones;
/**
 * Clase NoHayProductoException representa una excepción que se lanza cuando no hay un producto disponible.
 */

public class NoHayProductoException extends Exception{
    /**
     * Constructor de NoHayProductoException.
     *
     * @param txt El mensaje de error que describe la excepción.
     */
    public NoHayProductoException(String txt){
        super(txt);
    }
}
