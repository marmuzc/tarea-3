package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import LOGICA.Depositos.*;
import LOGICA.Monedas.*;

/**
 * Clase PanelBilletera representa un panel de la billetera en la interfaz gráfica.
 * Muestra una imagen de billetera, una etiqueta, y permite almacenar monedas en un depósito.
 */
public class PanelBilletera extends JPanel {
    private Image billetera; // Para almacenar la imagen de la billetera
    private JLabel etiqueta; // Para la etiqueta de nombre "Billetera"
    private DepositoM monedas;

    /**
     * Constructor de PanelBilletera. Inicializa la imagen de la billetera, el depósito
     * de monedas, y la etiqueta visual. También establece un saldo inicial de monedas
     * y configura el evento de clic para mostrar las monedas en la billetera.
     */
    public PanelBilletera() {
        setPreferredSize(new Dimension(150, 150));
        billetera = new ImageIcon("src/resources/Billetera.png").getImage();
        this.monedas = new DepositoM();

        //Crear la etiqueta con el nombre de la billetera
        etiqueta = new JLabel("Billetera");
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER); // Centrar texto
        etiqueta.setFont(new Font("Arial", Font.BOLD, 14)); // Cambiar la fuente y tamaño
        etiqueta.setForeground(Color.BLACK); // Cambiar color del texto
        etiqueta.setPreferredSize(new Dimension(200, 30));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mostrarMonedas(); // Llama a mostrarMonedas al hacer click
            }
        });

        //Saldo inicial del comprador predefinido por nosotros 3 monedas de cada tipo
        monedas.addMoneda(new Moneda1000());
        monedas.addMoneda(new Moneda1000());
        monedas.addMoneda(new Moneda1000());
        monedas.addMoneda(new Moneda500());
        monedas.addMoneda(new Moneda500());
        monedas.addMoneda(new Moneda500());
        monedas.addMoneda(new Moneda100());
        monedas.addMoneda(new Moneda100());
        monedas.addMoneda(new Moneda100());

        this.setLayout(new BorderLayout());
        this.add(etiqueta, BorderLayout.NORTH); // Añadir etiqueta en la parte superior
    }

    /**
     * Sobrescribe el metodo paintComponent para mostrar la imagen de la billetera.
     *
     * @param g El contexto gráfico.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(billetera, 0, 30, getWidth(), getHeight() - 30, this); // Dibuja la imagen debajo de la etiqueta
    }

    /**
     * Agrega una moneda al depósito y actualiza la interfaz.
     *
     * @param moneda La moneda a agregar al depósito.
     */
    public void agregarMoneda(Moneda moneda) {
        monedas.addMoneda(moneda);
        repaint();
    }

    /**
     * Quita una moneda del depósito según su valor.
     *
     * @param valor El valor de la moneda a quitar.
     * @return true si la moneda se encontró y fue removida, false si no se encontró.
     */
    public boolean quitarMoneda(int valor) {
        for (Moneda moneda : monedas.getDeposito()) { // Itera sobre las monedas en el depósito
            if (moneda.getValor() == valor) { // Compara el valor de la moneda
                monedas.getDeposito().remove(moneda); // Remueve la moneda del depósito
                repaint(); // Actualiza la interfaz después de quitar la moneda
                return true; // Moneda encontrada y removida
            }
        }
        return false; // No se encontró una moneda con el valor especificado
    }

    /**
     * Muestra una ventana emergente con las monedas almacenadas en el depósito.
     */
    private void mostrarMonedas() {
        JFrame monedasFrame = new JFrame("Monedas en la Billetera");
        monedasFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        monedasFrame.setSize(250, 200);

        JPanel panelMonedas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int x = 10;
                int y = 10;
                for (Moneda moneda : monedas.getDeposito()) {
                    g.setColor(monedaColor(moneda));
                    g.fillOval(x, y, 40, 40); // Dibuja el círculo de la moneda

                    // Dibuja el valor de la moneda en el centro del círculo
                    g.setColor(Color.WHITE);
                    String valorTexto = "$" + moneda.getValor();
                    FontMetrics fm = g.getFontMetrics();
                    int textX = x + (40 - fm.stringWidth(valorTexto)) / 2; // Centrar horizontalmente
                    int textY = y + ((40 - fm.getHeight()) / 2) + fm.getAscent(); // Centrar verticalmente
                    g.drawString(valorTexto, textX, textY);

                    // Avanza la posición para la siguiente moneda
                    x += 50;
                    if (x > getWidth() - 50) {
                        x = 10;
                        y += 50;
                    }
                }
            }
        };

        panelMonedas.setPreferredSize(new Dimension(200, 150));
        monedasFrame.add(panelMonedas);
        monedasFrame.setVisible(true); // Mostrar la ventana
    }

    /**
     * Asigna un color a cada moneda en función de su valor.
     *
     * @param moneda La moneda a la que se le asignará un color.
     * @return Color correspondiente al valor de la moneda.
     */
    private Color monedaColor(Moneda moneda) {
        switch (moneda.getValor()) {
            case 1000: return new Color(212, 175, 55); // Dorado
            case 500: return new Color(169, 169, 169); // Plateado
            case 100: return new Color(205, 127, 50); // Bronce
            default: return Color.BLACK;
        }
    }
}
