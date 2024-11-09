package LOGICA.Depositos;
import java.util.ArrayList;

/**
 * Clase genérica que representa un depósito de productos.
 *
 * @param <T> El tipo de producto que se almacena en el depósito.
 */
public class Deposito<T> {
    private ArrayList<T> deposito;  // Lista que almacena los productos

    /**
     * Constructor para la clase Deposito.
     * Inicializa la lista que contendrá los productos.
     */
    public Deposito() {
        this.deposito = new ArrayList<T>();
    }

    /**
     * Agrega un producto al depósito.
     *
     * @param t El producto que se agregará al depósito.
     */
    public void addDeposito(T t) {
        this.deposito.add(t);
    }

    /**
     * Obtiene la lista de productos del depósito.
     *
     * @return Una lista con todos los productos en el depósito.
     */
    public ArrayList<T> getDeposito() {
        return this.deposito;
    }

    /**
     * Obtiene y remueve el primer producto del depósito.
     *
     * @return El primer producto en el depósito, o null si el depósito está vacío.
     */
    public T getProducto() {
        if (deposito != null && !deposito.isEmpty()) {
            return deposito.remove(0);  // Remueve y retorna el primer producto de la lista
        }
        return null;  // Retorna null si el depósito está vacío
    }

    /**
     * Limpia el depósito de productos.
     */
    public void limpiarDeposito() {
        deposito.clear();
    }
    /**
     * Obtiene la cantidad de productos en el depósito.
     *
     * @return El número de productos en el depósito.
     */
    public int getCantidadDeposito() {
        return deposito.size();
    }
}
