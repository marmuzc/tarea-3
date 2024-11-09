package GUI;

import javax.swing.*;
import java.awt.*;


/**
 * Clase PanelComprador representa el panel del comprador en la interfaz gráfica.
 * Contiene la billetera y el inventario del comprador, y muestra una imagen de fondo y del comprador.
 */

public class PanelComprador extends JPanel {
    private Image imagenComprador;
    private Image fondoComprador;
    private PanelBilletera panelBilletera;
    private PanelInventario panelInventario;

    /**
     * Constructor de PanelComprador. Inicializa los componentes y configura el panel.
     */
    public PanelComprador() {
        fondoComprador = new ImageIcon("src/resources/FondoComprador1.JPG").getImage();
        this.setLayout(new BorderLayout());
        setBackground(Color.lightGray);
        imagenComprador = new ImageIcon("src/resources/Kanye.png").getImage();


        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new FlowLayout());
        panelInferior.setBackground(Color.lightGray);

        panelBilletera = new PanelBilletera();
        panelBilletera.setLayout(new FlowLayout());
        panelBilletera.setBackground(new Color(100, 150, 200));

        panelInventario = new PanelInventario();
        panelInventario.setLayout(new FlowLayout());
        panelInventario.setBackground(new Color(100, 150, 200));

        panelInferior.add(panelBilletera);
        panelInferior.add(panelInventario);

        this.add(panelInferior, BorderLayout.SOUTH);

    }

    /**
     * Obtiene el panel de inventario del comprador.
     *
     * @return El panel de inventario.
     */

    public PanelInventario getPanelInventario() {
        return panelInventario;
    }

    /**
     * Obtiene el panel de la billetera del comprador.
     *
     * @return El panel de la billetera.
     */
    public PanelBilletera getPanelBilletera() {
        return panelBilletera;
    }

    /**
     * Sobrescribe el metodo paintComponent para mostrar la imagen de fondo y la imagen del comprador.
     *
     * @param g El contexto gráfico.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (fondoComprador != null) {
            g.drawImage(fondoComprador, 0, 0, getWidth(), getHeight(), this);
        }


        if (imagenComprador != null) {
            int imageWidth = 450;
            int imageHeight = 450;
            int imageX = 10;
            int imageY = 70;

            g.drawImage(imagenComprador, imageX, imageY, imageWidth, imageHeight, this);
        } else {
            g.drawString("Imagen no encontrada", 10, 20);
        }
    }
}
