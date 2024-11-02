package GUI;

import LOGICA.*;
import LOGICA.Productos.*;
import LOGICA.Monedas.*;
import LOGICA.Depositos.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelExpendedor extends JPanel {
    private Image imagenCoca;
    private Image imagenSprite;
    private Image imagenSnickers;
    private Image imagenSuper8;
    private PanelBotones panelBotones;

    // Variables para los precios de los productos
    private final String precioCoca = "(3) - $1200";
    private final String precioSprite = "(4) - $900";
    private final String precioSnickers = "(1) - $500";
    private final String precioSuper8 = "(2) - $400";

    public PanelExpendedor() {
        this.setBackground(Color.white);
        this.setLayout(new BorderLayout());

        imagenCoca = new ImageIcon("src/resources/Cocacola.png").getImage();
        imagenSprite = new ImageIcon("src/resources/Sprite.png").getImage();
        imagenSnickers = new ImageIcon("src/resources/Snickers.png").getImage();
        imagenSuper8 = new ImageIcon("src/resources/Super8.png").getImage();

        // Crear y ajustar PanelBotones
        panelBotones = new PanelBotones();
        panelBotones.setLayout(new GridLayout(2, 2));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelBotones.setPreferredSize(new Dimension(150, 100));

        // Crear un contenedor para el PanelBotones
        JPanel contenedorBotones = new JPanel();
        contenedorBotones.setLayout(new FlowLayout());
        contenedorBotones.add(panelBotones);

        // Agregar el contenedor a la parte inferior de PanelExpendedor
        this.add(contenedorBotones, BorderLayout.EAST);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibuja el fondo y los elementos gráficos
        g.setColor(Color.DARK_GRAY);
        g.fillRect(30, 0, 600, 700);

        g.setColor(Color.BLACK);
        g.fillRect(60, 30, 400, 500);

        g.setColor(new Color(100, 150, 200)); //aqui es donde se deberia recoger el producto
        g.fillRect(60, 550, 400, 100);

        // Dibuja las imágenes de productos y sus precios
        if (imagenCoca != null) {
            g.drawImage(imagenCoca, 100, 260, 150, 150, this);
            g.setColor(Color.WHITE);
            g.drawString(precioCoca, 150, 450); // Dibuja el precio debajo de la imagen de Coca-Cola
        }
        if (imagenSprite != null) {
            g.drawImage(imagenSprite, 260, 260, 150, 150, this);
            g.setColor(Color.WHITE);
            g.drawString(precioSprite, 300, 450); // Dibuja el precio debajo de la imagen de Sprite
        }
        if (imagenSnickers != null) {
            g.drawImage(imagenSnickers, 100, 100, 150, 150, this);
            g.setColor(Color.WHITE);
            g.drawString(precioSnickers, 150, 230); // Dibuja el precio debajo de la imagen de Snickers
        }
        if (imagenSuper8 != null) {
            g.drawImage(imagenSuper8, 260, 100, 150, 150, this);
            g.setColor(Color.WHITE);
            g.drawString(precioSuper8, 300, 230); // Dibuja el precio debajo de la imagen de Super8
        }
    }
}
