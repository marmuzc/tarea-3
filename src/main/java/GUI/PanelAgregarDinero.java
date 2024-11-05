package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelAgregarDinero extends JPanel {
    private MonedasPanel monedasPanel; // Panel para dibujar las monedas

    public PanelAgregarDinero() {
        setLayout(new BorderLayout());

        // Panel para los botones
        JPanel botonesPanel = new JPanel(new GridLayout(3, 1));

        JButton boton100 = new JButton("Agregar $100");
        JButton boton500 = new JButton("Agregar $500");
        JButton boton1000 = new JButton("Agregar $1000");

        // Cambiar el color de fondo de los botones
        Color customColor = new Color(100, 150, 200);
        boton100.setBackground(customColor);
        boton500.setBackground(customColor);
        boton1000.setBackground(customColor);

        // Cambiar el color del texto
        boton100.setForeground(Color.WHITE);
        boton500.setForeground(Color.WHITE);
        boton1000.setForeground(Color.WHITE);

        // Crear el panel donde se dibujarán las monedas
        monedasPanel = new MonedasPanel();

        // Listeners para los botones
        boton100.addActionListener(e -> agregarMoneda(100));
        boton500.addActionListener(e -> agregarMoneda(500));
        boton1000.addActionListener(e -> agregarMoneda(1000));

        // Añadir botones al panel de botones
        botonesPanel.add(boton100);
        botonesPanel.add(boton500);
        botonesPanel.add(boton1000);

        // Añadir el panel de botones y el panel de monedas al panel principal
        add(botonesPanel, BorderLayout.NORTH);
        add(monedasPanel, BorderLayout.CENTER);
    }

    // Método para agregar una moneda y actualizar el área de dibujo
    private void agregarMoneda(int valor) {
        monedasPanel.addMoneda(valor);
        monedasPanel.repaint(); // Redibuja el panel de monedas
    }

    // Panel personalizado para dibujar monedas
    private class MonedasPanel extends JPanel {
        private ArrayList<Integer> monedas = new ArrayList<>(); // Lista de monedas agregadas

        public MonedasPanel() {
            setPreferredSize(new Dimension(200, 200));
            setBackground(Color.WHITE); // Fondo blanco para ver las monedas
        }

        // Método para añadir una moneda al panel
        public void addMoneda(int valor) {
            monedas.add(valor);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int x = 10;
            int y = 10;

            // Dibuja cada moneda como un círculo de un color específico
            for (int moneda : monedas) {
                g.setColor(monedaColor(moneda));
                g.fillOval(x, y, 20, 20); // Dibuja una moneda como un círculo
                x += 30;

                // Si se sale del panel, salta a la siguiente fila
                if (x > getWidth() - 30) {
                    x = 10;
                    y += 30;
                }
            }
        }

        // Método para elegir un color dependiendo del valor de la moneda
        private Color monedaColor(int valor) {
            switch (valor) {
                case 100: return new Color(212, 175, 55); // Dorado para $100
                case 500: return new Color(169, 169, 169); // Plateado para $500
                case 1000: return new Color(205, 127, 50); // Bronce para $1000
                default: return Color.BLACK; // Color negro por defecto
            }
        }
    }
}
