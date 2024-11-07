package LOGICA.Depositos;
import LOGICA.Monedas.*;

/**
 * Clase que representa un depósito especializado en monedas.
 * Hereda de la clase genérica {@code Deposito} para manejar objetos del tipo {@code Moneda}.
 */
public class DepositoM extends Deposito<Moneda> {

    /**
     * Constructor de la clase {@code DepositoM}.
     * Inicializa el depósito de monedas llamando al constructor de la clase padre.
     */
    public DepositoM() {
        super();
    }

    /**
     * Agrega una moneda al depósito.
     *
     * @param moneda La moneda que se desea agregar al depósito.
     */
    public void addMoneda(Moneda moneda) {
        super.addDeposito(moneda);  // Utiliza el método de la clase padre para agregar una moneda
    }

    /**
     * Obtiene y remueve la primera moneda del depósito.
     *
     * @return La primera moneda en el depósito, o {@code null} si el depósito está vacío.
     */
    public Moneda getMoneda() {
        return super.getProducto();  // Utiliza el método de la clase padre para obtener una moneda
    }

    public void limpiarDeposito() {
        super.limpiarDeposito();
    }
}
