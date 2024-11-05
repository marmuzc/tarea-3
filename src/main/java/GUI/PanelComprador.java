package GUI;

import javax.swing.*;
import java.awt.*;

public class PanelComprador extends JPanel {
    private Image imagenComprador;
    private PanelAgregarDinero panelAgregarDinero;
    private PanelBilletera panelBilletera;
    private PanelInventario panelInventario;

    public PanelComprador() {
        // Configura el diseño principal como BorderLayout
        this.setLayout(new BorderLayout());
        this.setBackground(Color.LIGHT_GRAY); // Fondo para el PanelComprador

        // Carga la imagen del comprador
        imagenComprador = new ImageIcon("src/resources/Kanye.png").getImage();

        // Crea y configura el panel para agregar dinero en el borde izquierdo
        panelAgregarDinero = new PanelAgregarDinero();
        panelAgregarDinero.setLayout(new GridLayout(3, 1));
        panelAgregarDinero.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelAgregarDinero.setBackground(Color.LIGHT_GRAY); // Fondo del panel de agregar dinero

        // Añade el panel para agregar dinero al borde izquierdo
        this.add(panelAgregarDinero, BorderLayout.WEST);

        // Crea y configura el panel de billetera y el panel de inventario
        JPanel panelLateral = new JPanel(); // Nuevo panel contenedor
        panelLateral.setLayout(new FlowLayout()); // Establecer el diseño como FlowLayout
        panelLateral.setBackground(Color.LIGHT_GRAY); // Fondo del panel lateral

        // Inicializa y configura el panel de la billetera
        panelBilletera = new PanelBilletera();
        panelBilletera.setLayout(new FlowLayout());
        //panelBilletera.setBorder(BorderFactory.createEmptyBorder(10, 500, 10, 10));
        panelBilletera.setBackground(Color.LIGHT_GRAY); // Fondo del panel de la billetera

        // Inicializa y configura el panel de inventario
        panelInventario = new PanelInventario();
        panelInventario.setLayout(new FlowLayout());
        //panelInventario.setBorder(BorderFactory.createEmptyBorder(10, 500, 10, 10));
        panelInventario.setBackground(Color.LIGHT_GRAY); // Fondo del panel de la mochila

        // Añade ambos paneles al panel lateral
        panelLateral.add(panelBilletera);
        panelLateral.add(panelInventario);

        // Añade el panel lateral al borde inferior
        this.add(panelLateral, BorderLayout.SOUTH); // Añade el panel lateral al borde inferior

    }

    public PanelInventario getPanelInventario() {
        return panelInventario;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (imagenComprador != null) {
            int imageWidth = 500;
            int imageHeight = 500;
            int imageX = 120; // Margen izquierdo
            int imageY = 10; // Centra verticalmente la imagen

            // Dibuja la imagen en la posición y tamaño especificados
            g.drawImage(imagenComprador, imageX, imageY, imageWidth, imageHeight, this);
        } else {
            g.drawString("Imagen no encontrada", 10, 20);
        }
    }
}
