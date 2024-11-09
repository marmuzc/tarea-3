package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Clase PanelPrincipal representa el panel principal de la interfaz gráfica.
 * Contiene los paneles del comprador y del expendedor, y organiza su disposición.
 */
public class PanelPrincipal extends JPanel {
    private PanelComprador com;
    private PanelExpendedor exp;

    /**
     * Constructor de PanelPrincipal. Inicializa los componentes y configura el panel.
     */
    public PanelPrincipal() {
        com = new PanelComprador();
        exp = new PanelExpendedor(com);

        this.setLayout(new BorderLayout());
        this.setBackground(Color.LIGHT_GRAY);

        exp.setPreferredSize(new Dimension(800, 600));

        this.add(exp, BorderLayout.WEST);
        this.add(com, BorderLayout.CENTER);
    }
    /**
     * Sobrescribe el metodo paintComponent para dibujar el fondo del panel.
     *
     * @param g El contexto gráfico.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
