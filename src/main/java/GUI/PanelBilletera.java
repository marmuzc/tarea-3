package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import LOGICA.Depositos.*;
import LOGICA.Monedas.*;

public class PanelBilletera extends JPanel {
    private Image billetera; // Para almacenar la imagen de la billetera
    private JLabel etiqueta; // Para la etiqueta que indica "Billetera"
    private DepositoM monedas;

    public PanelBilletera() {
        // Cargar la imagen de la billetera
        billetera = new ImageIcon("src/resources/Billetera.png").getImage();
        this.monedas = new DepositoM();

        // Establecer el tamaño preferido del panel
        setPreferredSize(new Dimension(150, 150)); // Cambia el tamaño según tu imagen deseada

        // Crear la etiqueta
        etiqueta = new JLabel("Billetera");
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER); // Centrar texto
        etiqueta.setFont(new Font("Arial", Font.BOLD, 14)); // Cambiar la fuente y tamaño
        etiqueta.setForeground(Color.BLACK); // Cambiar color del texto
        etiqueta.setPreferredSize(new Dimension(200, 30)); // Establecer tamaño para la etiqueta

        // Añadir un MouseListener para manejar clics
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mostrarMonedas(); // Llama a mostrarMonedas al hacer clic
            }
        });

        // Establecer el layout del panel
        this.setLayout(new BorderLayout());
        this.add(etiqueta, BorderLayout.NORTH); // Añadir etiqueta en la parte superior
    }

    // Método para mostrar la imagen de la billetera
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Ajustar la imagen al tamaño del panel, menos el espacio de la etiqueta
        g.drawImage(billetera, 0, 30, getWidth(), getHeight() - 30, this); // Dibuja la imagen debajo de la etiqueta
    }
    
    public void agregarMoneda(Moneda moneda){
        monedas.addMoneda(moneda);
    }

    // Método para mostrar la ventana con las monedas
    private void mostrarMonedas() {
        JFrame monedasFrame = new JFrame("Monedas en la Billetera");
        monedasFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        monedasFrame.setSize(250, 200); // Ajusta el tamaño de la ventana
        monedasFrame.setLayout(new FlowLayout());

        // Crear las representaciones visuales de las monedas como círculos
        for (Moneda moneda : monedas.getDeposito()) {
            switch (moneda.getValor()) {
                case 1000:
                    monedasFrame.add(crearMonedaCirculo("$1000", new Color(212, 175, 55))); // Dorado
                    break;
            
                case 500:
                    monedasFrame.add(crearMonedaCirculo("$500", new Color(169, 169, 169))); // Plateado
                    break;

                case 100:
                    monedasFrame.add(crearMonedaCirculo("$100", new Color(205, 127, 50))); // Bronce
                    break;
            }
            
        }

        monedasFrame.setVisible(true); // Mostrar la ventana
    }

    private JPanel crearMonedaCirculo(String texto, Color color) {
        JPanel monedaPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(color);
                g.fillOval(0, 0, getWidth(), getHeight()); // Dibujar un círculo del tamaño del panel
                g.setColor(Color.WHITE);
                g.setFont(new Font("Arial", Font.BOLD, 12));

                // Centrar el texto dentro del círculo
                FontMetrics metrics = g.getFontMetrics(g.getFont());
                int x = (getWidth() - metrics.stringWidth(texto)) / 2;
                int y = ((getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
                g.drawString(texto, x, y);
            }
        };

        monedaPanel.setPreferredSize(new Dimension(50, 50)); // Tamaño de cada "moneda"
        monedaPanel.setOpaque(false); // Hacer que el fondo del panel sea transparente
        return monedaPanel;
    }
}
