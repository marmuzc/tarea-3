package LOGICA.Monedas;
/**
 * Clase que representa una moneda de 500.
 * Hereda de la clase {@code Moneda}.
 */
public class Moneda500 extends Moneda {
    private static final int valor = 500;

    /**
     * Constructor de la clase {@code Moneda500}.
     * Inicializa la moneda de 500 llamando al constructor de la clase padre.
     */
    public Moneda500() {
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
