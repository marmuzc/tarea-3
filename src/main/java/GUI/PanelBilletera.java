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
        setPreferredSize(new Dimension(150, 150));
        billetera = new ImageIcon("src/resources/Billetera.png").getImage();
        this.monedas = new DepositoM();

        //Crear la etiqueta
        etiqueta = new JLabel("Billetera");
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER); // Centrar texto
        etiqueta.setFont(new Font("Arial", Font.BOLD, 14)); // Cambiar la fuente y tamaño
        etiqueta.setForeground(Color.BLACK); // Cambiar color del texto
        etiqueta.setPreferredSize(new Dimension(200, 30)); // Establecer tamaño para la etiqueta

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mostrarMonedas(); // Llama a mostrarMonedas al hacer clic
            }
        });
        //Saldo inicial del comprador
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

    // Método para mostrar la imagen de la billetera
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(billetera, 0, 30, getWidth(), getHeight() - 30, this); // Dibuja la imagen debajo de la etiqueta
    }

    // Método para agregar una moneda al depósito y actualizar la interfaz
    public void agregarMoneda(Moneda moneda) {
        monedas.addMoneda(moneda);
        repaint();
    }

    // Método para quitar una moneda específica según su valor
    public boolean quitarMoneda(int valor) {
        for (Moneda moneda : monedas.getDeposito()) {
            if (moneda.getValor() == valor) {
                monedas.getDeposito().remove(moneda);
                repaint(); // Actualiza la interfaz después de quitar la moneda
                return true; // Moneda encontrada y removida
            }
        }
        return false; // No se encontró una moneda con el valor especificado
    }


    // Método para mostrar la ventana con las monedas
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

    // Método para asignar un color a cada moneda en función de su valor
    private Color monedaColor(Moneda moneda) {
        switch (moneda.getValor()) {
            case 1000: return new Color(212, 175, 55); // Dorado
            case 500: return new Color(169, 169, 169); // Plateado
            case 100: return new Color(205, 127, 50); // Bronce
            default: return Color.BLACK;
        }
    }
}