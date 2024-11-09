package LOGICA.Monedas;
/**
 * Clase que representa una moneda de 1000.
 * Hereda de la clase {@code Moneda}.
 */
public class Moneda1000 extends Moneda {
    private static final int valor = 1000;

    /**
     * Constructor de la clase {@code Moneda1000}.
     * Inicializa la moneda de 1000 llamando al constructor de la clase padre.
     */
    public Moneda1000() {
        super();
    }

    /**
     * Obtiene el valor de la moneda.
     *
     * @return El valor de la moneda.
     */
    public int getValor() {
        return valor;
    }
}
