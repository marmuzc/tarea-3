package LOGICA;
import LOGICA.Depositos.*;
import LOGICA.Productos.*;
import LOGICA.Monedas.*;
import LOGICA.Excepciones.*;

/**
 * Clase que representa el expendedor de productos.
 */
class Expendedor {
    private int precio;  // Precio de los productos
    private DepositoM monVu;  // Depósito de monedas para el vuelto
    private DepositoP coca;  // Depósito de CocaColas
    private DepositoP sprite;  // Depósito de Sprites
    private DepositoP snickers;  // Depósito de Snickers
    private DepositoP super8;  // Depósito de Super8
    private int pagoUsuario;  // Pago ingresado por el usuario
    private Productos producto;  // Producto comprado

    /**
     * Constructor del expendedor.
     * Inicializa los depósitos de productos con una cantidad específica.
     *
     * @param numProductos Número de productos de cada tipo a cargar en el expendedor.
     * @param precioProductos Precio unitario de los productos.
     */
    public Expendedor(int numProductos) {
        this.precio = 0;
        this.coca = new DepositoP();
        this.sprite = new DepositoP();
        this.snickers = new DepositoP();
        this.super8 = new DepositoP();
        this.monVu = new DepositoM();

        // Carga de productos en los depósitos
        for (int i = 0; i < numProductos; i++) {
            coca.addProducto(new CocaCola(100+i));  // Agrega CocaCola con un código único
            sprite.addProducto(new Sprite(200+i));  // Agrega Sprite con un código único
            snickers.addProducto(new Snickers(300+i));  // Agrega Snickers con un código único
            super8.addProducto(new Super8(400+i));  // Agrega Super8 con un código único
        }
    }

    /**
     * Método para comprar un producto utilizando una moneda.
     * Si el pago es insuficiente o incorrecto, lanza una excepción.
     *
     * @param m Moneda utilizada para realizar la compra.
     * @param cual Enum que indica el tipo de producto que se desea comprar.
     * @return El producto comprado, o null si no se pudo realizar la compra.
     * @throws NoHayProductoException Si no hay existencias del producto seleccionado.
     * @throws PagoInsuficienteException Si el pago es menor al precio del producto.
     * @throws PagoIncorrectoException Si no se ingresó una moneda válida.
     */
    public Productos comprarProducto(Moneda m, productosEnum cual) throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {

        if (m == null) { // Si no hay moneda, no se puede realizar la compra
            throw new PagoIncorrectoException("Error al comprar, no se ingresó moneda");
        }

        pagoUsuario = m.getValor();  // El valor de la moneda ingresada

        Productos productoComprado = null;  // Inicializamos el producto comprado como null

        // Selección del producto según el tipo solicitado
        switch (cual) {
            case COCA:
                productoComprado = coca.getProducto();
                precio = productosEnum.COCA.getPrecio();
                break;
            case SPRITE:
                productoComprado = sprite.getProducto();
                precio = productosEnum.SPRITE.getPrecio();
                break;
            case SNICKERS:
                productoComprado = snickers.getProducto();
                precio = productosEnum.SNICKERS.getPrecio();
                break;
            case SUPER8:
                productoComprado = super8.getProducto();
                precio = productosEnum.SUPER8.getPrecio();
                break;
            default:
                return null;  // Producto no encontrado
        }

        // Verifica si el pago es insuficiente
        if (pagoUsuario < this.precio) {
            devolverVuelto(pagoUsuario);  // Devuelve el dinero ingresado como vuelto
            throw new PagoInsuficienteException("Error al comprar, pago insuficiente");
        }

        // Si se ha seleccionado y hay disponibilidad del producto
        if (productoComprado != null) {
            pagoUsuario -= this.precio;  // Resta el precio del producto al pago
            devolverVuelto(pagoUsuario);  // Devuelve el vuelto si corresponde
            this.producto = productoComprado;  // Guarda el producto comprado
            return producto;  // Retorna el producto comprado
        } else {  // Si no hay producto disponible
            devolverVuelto(pagoUsuario);  // Devuelve el vuelto si no hay producto
            throw new NoHayProductoException("Error al comprar, no hay producto");  // Lanza una excepción si no hay producto disponible
        }
    }

    /**
     * Método para devolver el vuelto al usuario.
     *
     * @param valorMoneda Cantidad de dinero a devolver en monedas de 100.
     */
    private void devolverVuelto(int valorMoneda) {
        // Mientras quede saldo por devolver, se añaden monedas de 100 al depósito
        while (valorMoneda != 0) {
            monVu.addMoneda(new Moneda100());
            valorMoneda -= 100;
        }
    }

    /**
     * Método para obtener el producto comprado.
     * Retorna una moneda desde el depósito de vuelto.
     *
     * @return Moneda del vuelto, o null si no hay vuelto disponible.
     */
    public Moneda getVuelto() {
        return monVu.getMoneda();
    }
}
