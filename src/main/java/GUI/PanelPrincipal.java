package GUI;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel { // se ve en el centro de la ventana
    private PanelComprador com;
    private PanelExpendedor exp;

    public PanelPrincipal() {
        // Inicializa los paneles
        exp = new PanelExpendedor();
        com = new PanelComprador();

        // Configura el diseño y agrega los paneles
        this.setLayout(new BorderLayout());
        this.setBackground(Color.white);

        // Puedes ajustar el BorderLayout para situar los paneles como prefieras
        this.add(exp, BorderLayout.WEST);  // PanelExpendedor en el centro
        this.add(com, BorderLayout.EAST);   // PanelComprador en la parte inferior
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        com.paintComponent(g);
    }
}
