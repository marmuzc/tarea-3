package LOGICA.Productos;

/**
 * Clase abstracta que representa un producto.
 */
public abstract class Productos {
    private int serie;

    /**
     * Constructor para Productos.
     *
     * @param numSerie El número de serie del producto.
     */
    public Productos(int numSerie) {
        this.serie = numSerie;
    }

    /**
     * Obtiene el número de serie del producto.
     *
     * @return El número de serie del producto.
     */
    public int getSerie() {
        return serie;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return El nombre del producto.
     */
    public abstract String getNombre();

    @Override
    public String toString() {
        return "Nombre: " + this.getNombre() + " Serie: " + this.getSerie() + ".";
    }
}