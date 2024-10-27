package LOGICA;
import LOGICA.Depositos.*;
import LOGICA.Productos.*;
import LOGICA.Monedas.*;
import LOGICA.Excepciones.*;


/**
 * Clase que representa a un comprador que realiza una compra en un expendedor.
 */
class Comprador {
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
        Productos producto = exp.comprarProducto(m, cualProducto);  // Realiza la compra en el expendedor
        vuelto = 0;
        if (producto != null) {
            saborProducto = cualProducto.getNombre();  // Asigna el nombre del producto comprado
            m = exp.getVuelto();  // Obtiene el vuelto
            while (m != null) {
                vuelto = vuelto + m.getValor();  // Suma el valor de la moneda al vuelto total
                m = exp.getVuelto();  // Sigue obteniendo el vuelto mientras haya monedas
            }
        } else {
            if (m == null) {  // Si no hay monedas en el depósito de vuelto
                vuelto = 0;  // El vuelto es 0
                saborProducto = null;  // No hay producto
            } else {
                m = exp.getVuelto();  // En el caso de que el producto sea null, obtiene el vuelto
                while (m != null) {  // Mientras haya monedas en el depósito
                    vuelto = vuelto + m.getValor();  // Suma el valor de las monedas al vuelto total
                    m = exp.getVuelto(); // Sigue obteniendo el vuelto mientras haya monedas
                }
            }
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
