package GUI;

import javax.swing.*;
import java.awt.*;
import LOGICA.*;
import LOGICA.Productos.Productos;

public class PanelExpendedor extends JPanel {
    private Image imagenCoca;
    private Image imagenSprite;
    private Image imagenSnickers;
    private Image imagenSuper8;
    private PanelBotonesExp panelBotones;
    private Productos productoComprado;
    private Image imagenProducto;

    // Variables para los precios de los productos
    private final String precioCoca = "(3) - $1200";
    private final String precioSprite = "(4) - $900";
    private final String precioSnickers = "(1) - $500";
    private final String precioSuper8 = "(2) - $400";

    public PanelExpendedor(PanelComprador panelComprador) {
        this.setBackground(Color.darkGray);
        this.setLayout(new BorderLayout());


        imagenCoca = new ImageIcon("src/resources/Cocacola.png").getImage();
        imagenSprite = new ImageIcon("src/resources/Sprite.png").getImage();
        imagenSnickers = new ImageIcon("src/resources/Snickers.png").getImage();
        imagenSuper8 = new ImageIcon("src/resources/Super8.png").getImage();

        panelBotones = new PanelBotonesExp(panelComprador, this);
        panelBotones.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panelBotones.setPreferredSize(new Dimension(240, 700));

        JPanel contenedorBotones = new JPanel();
        contenedorBotones.setLayout(new FlowLayout());
        contenedorBotones.add(panelBotones);
        this.add(contenedorBotones, BorderLayout.EAST);
    }

    public void actualizarProductoComprado(Productos producto) {
        this.productoComprado = producto;
        repaint();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g.setColor(Color.DARK_GRAY); //fondo de la maquina expendedora cuadrado color gris
        g.fillRect(30, 0, 600, 700);

        g.setColor(Color.BLACK); //fondo de la ventana de inventario de la expendedor
        g.fillRect(75, 20, 400, 500);

        g.setColor(new Color(100, 150, 200));//fondo del cuadrado de recoleccion de producto
        g.fillRect(75, 550, 400, 100);


        if (imagenCoca != null) { //dibujamos los productos en el cuadrado negro de inventario de productos junto a su precio
            g.drawImage(imagenCoca, 120, 260, 150, 150, this);
            g.setColor(Color.WHITE);
            g.drawString(precioCoca, 160, 450); // Dibuja el precio debajo de la imagen de Coca-Cola
        }
        if (imagenSprite != null) {
            g.drawImage(imagenSprite, 290, 260, 150, 150, this);
            g.setColor(Color.WHITE);
            g.drawString(precioSprite, 330, 450); // Dibuja el precio debajo de la imagen de Sprite
        }
        if (imagenSnickers != null) {
            g.drawImage(imagenSnickers, 115, 60, 150, 150, this);
            g.setColor(Color.WHITE);
            g.drawString(precioSnickers, 160, 200); // Dibuja el precio debajo de la imagen de Snickers
        }
        if (imagenSuper8 != null) {
            g.drawImage(imagenSuper8, 290, 60, 150, 150, this);
            g.setColor(Color.WHITE);
            g.drawString(precioSuper8, 330, 200); // Dibuja el precio debajo de la imagen de Super8
        }

        if (productoComprado != null) { //
            switch (productoComprado.getNombre()) {
                case "Cocacola":
                    imagenProducto = imagenCoca;
                    g2d.rotate(Math.PI / 2, 180 + imagenProducto.getWidth(this) / 2, 250 + imagenProducto.getHeight(this) / 2);
                    g.drawImage(imagenProducto, 450, 570, 150, 150, this);
                    g2d.rotate(-Math.PI / 2, 180 + imagenProducto.getWidth(this) / 2, 250 + imagenProducto.getHeight(this) / 2);
                    break;
                case "Sprite":
                    imagenProducto = imagenSprite;
                    g2d.rotate(Math.PI / 2, 180 + imagenProducto.getWidth(this) / 2, 250 + imagenProducto.getHeight(this) / 2);
                    g.drawImage(imagenProducto, 450, 770, 150, 150, this);
                    g2d.rotate(-Math.PI / 2, 180 + imagenProducto.getWidth(this) / 2, 250 + imagenProducto.getHeight(this) / 2);
                    break;
                case "Super8":
                    imagenProducto = imagenSuper8;
                    g.drawImage(imagenProducto, 210, 520, 150, 150, this);
                    break;
                case "Snickers":
                    imagenProducto = imagenSnickers;
                    g.drawImage(imagenProducto, 210, 520, 150, 150, this);
                    break;
            }
        }
    }
}