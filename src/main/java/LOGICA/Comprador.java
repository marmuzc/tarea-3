package LOGICA;
import LOGICA.Depositos.*;
import LOGICA.Productos.*;
import LOGICA.Monedas.*;
import LOGICA.Excepciones.*;

/**
 * Clase que representa a un comprador que realiza una compra en un expendedor.
 */
public class Comprador {
    private String saborProducto;  // Almacena el sabor del producto comprado
    private int vuelto;  // Almacena el valor del vuelto entregado

    /**
     * Constructor del Comprador.
     * Realiza la compra de un producto en el expendedor utilizando una moneda.
     *
     * @param m La moneda utilizada para la compra.
     * @param cualProducto El producto que se desea comprar.
     * @param exp El expendedor de donde se realiza la compra.
     * @throws NoHayProductoException Si no hay existencias del producto seleccionado.
     * @throws PagoInsuficienteException Si el pago es menor al precio del producto.
     * @throws PagoIncorrectoException Si no se ingresó una moneda válida.
     */
    public Comprador(Moneda m, productosEnum cualProducto, Expendedor exp) throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        // Realiza la compra en el expendedor (ya no retorna un producto)
        exp.comprarProducto(m, cualProducto);

        // Inicializa el valor del vuelto a 0
        vuelto = 0;

        // "Saca" el producto comprado del depósito especial del expendedor
        Productos producto = exp.getProductoComprado();

        if (producto != null) {
            // Asigna el nombre del producto comprado
            saborProducto = cualProducto.getNombre();
        } else {
            saborProducto = null;  // No hay producto disponible
        }

        // Obtiene el vuelto
        m = exp.getVuelto();
        while (m != null) {
            // Suma el valor de la moneda al vuelto total
            vuelto = vuelto + m.getValor();
            m = exp.getVuelto();  // Sigue obteniendo el vuelto mientras haya monedas
        }
    }

    /**
     * Retorna el monto total del vuelto entregado.
     *
     * @return El valor del vuelto en monedas.
     */
    public int cuantoVuelto() {
        return vuelto;
    }

    /**
     * Retorna el sabor del producto comprado.
     *
     * @return El nombre del sabor del producto, o null si no se compró un producto.
     */
    public String getSaborProducto() {
        return saborProducto;
    }
}
