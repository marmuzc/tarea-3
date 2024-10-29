package GUI;

import javax.swing.*;
import java.awt.*;

public class PanelComprador extends JPanel {
    private Image imagenComprador; // Imagen del comprador
    private PanelAgregarDinero panelAgregarDinero; // Panel para agregar dinero

    public PanelComprador() {
        // Inicializa el panel para agregar dinero
        panelAgregarDinero = new PanelAgregarDinero();

        // Configura el diseño principal del panel
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setBackground(Color.CYAN);

        // Carga la imagen desde la carpeta resources
        imagenComprador = new ImageIcon("src/resources/08cafa728b59443a9dc5a4c20590d127.jpeg").getImage();

        // Agrega el panel de agregar dinero
        this.add(panelAgregarDinero);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagenComprador != null) {
            g.drawImage(imagenComprador, 10, 10, this); // Dibuja la imagen en la posición deseada
        } else {
            g.drawString("Imagen no encontrada", 50, 20); // Mensaje si la imagen no se carga
        }
        g.drawString("Panel del Comprador", 50, 60); // Título del panel
    }
}
