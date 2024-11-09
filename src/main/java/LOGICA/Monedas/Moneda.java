package LOGICA.Monedas;
/**
 * Clase abstracta que representa una moneda.
 */
public abstract class Moneda implements Comparable<Moneda> {

    private int numeroDeSerie;
    private static int contadorSerie = 0;

    /**
     * Constructor para Moneda.
     * Inicializa el número de serie.
     */
    public Moneda() {
        this.numeroDeSerie = ++contadorSerie;
    }

    /**
     * Obtiene el valor de la moneda.
     *
     * @return el valor de la moneda.
     */
    public abstract int getValor();

    /**
     * Obtiene el número de serie de la moneda.
     *
     * @return el número de serie de la moneda.
     */
    public int getNumeroDeSerie() {
        return numeroDeSerie;
    }

    /**
     * Representación en cadena de la moneda.
     * @return una cadena que representa la moneda.
     */
    @Override
    public String toString() {
        return "Moneda{valor =" + getValor() + ", numeroSerie =" + getNumeroDeSerie() + "}";
    }

    /**
     * Compara dos monedas por su valor.
     *
     * @param otraMoneda La moneda con la que se compara.
     * @return un valor negativo si esta moneda es menor que la otra, cero si son iguales, y un valor positivo si es mayor.
     */

    @Override
    public int compareTo(Moneda otraMoneda) {
        return Integer.compare(this.getValor(), otraMoneda.getValor());
    }
}