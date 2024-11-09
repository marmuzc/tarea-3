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
     * Realiza la compra de un producto en el expendedor utilizando una o más monedas.
     *
     * @param monedas Las monedas utilizadas para la compra.
     * @param cualProducto El producto que se desea comprar.
     * @param exp El expendedor de donde se realiza la compra.
     * @throws NoHayProductoException Si no hay existencias del producto seleccionado.
     * @throws PagoInsuficienteException Si el pago es menor al precio del producto.
     * @throws PagoIncorrectoException Si no se ingresó una moneda válida.
     */
    public Comprador(DepositoM monedas, productosEnum cualProducto, Expendedor exp) throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        // Intenta realizar la compra en el expendedor usando el depósito de monedas
        exp.comprarProducto(monedas, cualProducto);

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
        Moneda monedaVuelto = exp.getVuelto().getMoneda();
        while (monedaVuelto != null) {
            // Suma el valor de la moneda al vuelto total
            vuelto += monedaVuelto.getValor();
            monedaVuelto = exp.getVuelto().getMoneda();  // Sigue obteniendo el vuelto mientras haya monedas
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
