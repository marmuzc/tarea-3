//Ya no es necesario
package GUI;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelMonedas extends JPanel {
    private ArrayList<Integer> monedas = new ArrayList<>();
    //Quiza cambiar por depositoM

    public PanelMonedas() {
        setPreferredSize(new Dimension(200, 120));
        setBackground(Color.DARK_GRAY);
    }

    public void addMoneda(int valor) {
        monedas.add(valor);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 10;
        int y = 10;

        // Establece una fuente más pequeña
        g.setFont(new Font("Arial", Font.BOLD, 12));

        for (int moneda : monedas) {
            // Dibujar la moneda como círculo
            g.setColor(monedaColor(moneda));
            g.fillOval(x, y, 40, 40); // Tamaño del círculo

            // Cambiar el color del texto y dibujar el valor en el centro
            g.setColor(Color.WHITE);
            String valorTexto = "$" + moneda;
            FontMetrics fm = g.getFontMetrics();
            int textX = x + (40 - fm.stringWidth(valorTexto)) / 2; // Centrar horizontalmente
            int textY = y + ((40 - fm.getHeight()) / 2) + fm.getAscent(); // Centrar verticalmente
            g.drawString(valorTexto, textX, textY);

            // Avanzar a la siguiente posición
            x += 50; // Ajusta la distancia entre las monedas
            if (x > getWidth() - 50) {
                x = 10;
                y += 50;
            }
        }
    }

    private Color monedaColor(int valor) {
        switch (valor) {
            case 1000: return new Color(212, 175, 55); // Dorado
            case 500: return new Color(169, 169, 169); // Plateado
            case 100: return new Color(205, 127, 50); // Bronce
            default: return Color.BLACK;
        }
    }
}
