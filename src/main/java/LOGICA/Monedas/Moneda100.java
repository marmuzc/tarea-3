package LOGICA.Monedas;

/**
 * Clase que representa una moneda de 100.
 * Hereda de la clase {@code Moneda}.
 */
public class Moneda100 extends Moneda {
    private static final int valor = 100;

    /**
     * Constructor de la clase {@code Moneda100}.
     * Inicializa la moneda de 100 llamando al constructor de la clase padre.
     */
    public Moneda100() {
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
