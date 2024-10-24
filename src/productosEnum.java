/**
 * Enumeración que representa los diferentes productos disponibles.
 */
public enum productosEnum {
    COCA(1, 1000),
    SPRITE(2, 900),
    SUPER8(3, 400),
    SNICKERS(4, 500);

    private int codigoProducto;
    private int precio;

    /**
     * Constructor de la enumeración de productos.
     *
     * @param codigo El código del producto.
     * @param precio El precio del producto.
     */
    productosEnum(int codigo, int precio) {
        this.codigoProducto = codigo;
        this.precio = precio;
    }

    /**
     * Obtiene el precio del producto.
     *
     * @return El precio del producto.
     */
    public int getPrecio() {
        return this.precio;
    }

    /**
     * Obtiene el nombre del producto basado en su código.
     *
     * @return El nombre del producto.
     */
    public String getNombre() {
        switch (codigoProducto) {
            case 1:
                return "COCACOLA";
            case 2:
                return "SPRITE";
            case 3:
                return "SUPER8";
            case 4:
                return "SNICKERS";
            default:
                return "Null";
        }
    }
}