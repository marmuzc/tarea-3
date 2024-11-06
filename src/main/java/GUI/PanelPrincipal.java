package GUI;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    private PanelComprador com;
    private PanelExpendedor exp;

    public PanelPrincipal() {
        // Inicializa los paneles
        com = new PanelComprador();
        exp = new PanelExpendedor(com);


        // Cambia el diseño a BorderLayout
        this.setLayout(new BorderLayout());
        this.setBackground(Color.white);

        // Ajusta el tamaño preferido para que el panel del expendedor ocupe un 70% aprox.
        exp.setPreferredSize(new Dimension(800, 600)); // Ajusta el ancho (700 es solo un ejemplo)

        // Agrega los paneles
        this.add(exp, BorderLayout.WEST); // Expendedor a la izquierda
        this.add(com, BorderLayout.CENTER); // Comprador a la derecha
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
