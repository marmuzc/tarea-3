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


        // Cambia el diseño a GridLayout con 1 fila y 2 columnas
        this.setLayout(new GridLayout(1, 2));
        this.setBackground(Color.white);

        // Agrega los paneles
        this.add(exp); // Panel de expendedor a la izquierda
        this.add(com); // Panel de comprador a la derecha
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // No es necesario llamar a exp.paintComponent(g) ni com.paintComponent(g) aquí,
        // ya que el método paintComponent se llama automáticamente para cada panel agregado
    }
}
