package LOGICA.Depositos;
import LOGICA.Productos.*;

/**
 * Clase que representa un depósito especializado en productos.
 * Hereda de la clase genérica {@code Deposito} para manejar objetos del tipo {@code Productos}.
 */
public class DepositoP extends Deposito<Productos> {

    /**
     * Constructor de la clase {@code DepositoP}.
     * Inicializa el depósito de productos llamando al constructor de la clase padre.
     */
    public DepositoP() {
        super();
    }

    /**
     * Agrega un producto al depósito.
     *
     * @param producto El producto que se desea agregar al depósito.
     */
    public void addProducto(Productos producto) {
        super.addDeposito(producto);  // Utiliza el método de la clase padre para agregar un producto
    }

    /**
     * Obtiene y remueve el primer producto del depósito.
     *
     * @return El primer producto en el depósito, o {@code null} si el depósito está vacío.
     */
    @Override
    public Productos getProducto() {
        return super.getProducto();  // Utiliza el método de la clase padre para obtener un producto
    }

    public int getCantidadProductos() {
        return super.getCantidadDeposito();
    }

}