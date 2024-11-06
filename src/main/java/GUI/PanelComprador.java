package GUI;

import javax.swing.*;
import java.awt.*;

public class PanelComprador extends JPanel {
    private Image imagenComprador;
    private Image fondoComprador;
    private PanelBilletera panelBilletera;
    private PanelInventario panelInventario;

    public PanelComprador() {
        // Configura el diseño principal como BorderLayout
        fondoComprador = new ImageIcon("src/resources/fondoComprador.jpeg").getImage();
        this.setLayout(new BorderLayout());
       setBackground(Color.lightGray); // Cambia el fondo del panel principal
        // Carga la imagen del comprador
        imagenComprador = new ImageIcon("src/resources/Kanye.png").getImage();


        JPanel panelInferior = new JPanel(); // Nuevo panel contenedor
        panelInferior.setLayout(new FlowLayout()); // Establecer el diseño como FlowLayout
        panelInferior.setBackground(Color.lightGray); // Fondo del panel lateral

        // Inicializa y configura el panel de la billetera
        panelBilletera = new PanelBilletera();
        panelBilletera.setLayout(new FlowLayout());
        panelBilletera.setBackground(Color.LIGHT_GRAY); // Fondo del panel de la billetera

        // Inicializa y configura el panel de inventario
        panelInventario = new PanelInventario();
        panelInventario.setLayout(new FlowLayout());
        panelInventario.setBackground(Color.LIGHT_GRAY); // Fondo del panel de la mochila

        // Añade ambos paneles al panel lateral
        panelInferior.add(panelBilletera);
        panelInferior.add(panelInventario);

        // Añade el panel lateral al borde inferior
        this.add(panelInferior, BorderLayout.SOUTH); // Añade el panel lateral al borde inferior

    }

    public PanelInventario getPanelInventario() {
        return panelInventario;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (fondoComprador != null) {
            g.drawImage(fondoComprador, 0, 0, getWidth(), getHeight(), this);
        }


        if (imagenComprador != null) {
            int imageWidth = 450;
            int imageHeight = 450;
            int imageX = 10; // Margen izquierdo
            int imageY = 10; // Centra verticalmente la imagen

            // Dibuja la imagen en la posición y tamaño especificados
            g.drawImage(imagenComprador, imageX, imageY, imageWidth, imageHeight, this);
        } else {
            g.drawString("Imagen no encontrada", 10, 20);
        }


    }
}
