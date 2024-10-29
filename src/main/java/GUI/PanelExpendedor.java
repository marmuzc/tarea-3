package GUI;

import LOGICA.*;
import LOGICA.Productos.*;
import LOGICA.Monedas.*;
import LOGICA.Depositos.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelExpendedor extends JPanel{
    private Image imagenCoca;
    private Image imagenSprite;
    private Image imagenSnickers;


    public PanelExpendedor() {
        this.setBackground(Color.white);

        imagenCoca = new ImageIcon("src/resources/Cocacola.png").getImage();
        imagenSprite = new ImageIcon("src/resources/Sprite.png").getImage();
        imagenSnickers = new ImageIcon("src/resources/Snickers.png").getImage();




    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibuja el rectángulo negro
        g.setColor(Color.DARK_GRAY); // Establece el color negro
        g.fillRect(30, 0, 600, 700); // Dibuja un rectángulo en (30,30) de 80x40 px

        g.setColor(Color.BLACK); // Establece el color negro
        g.fillRect(60, 30, 400, 500); // Dibuja un rectángulo en (30,30) de 80x40 px

        g.setColor(Color.RED); // Establece el color negro
        g.fillRect(60, 550, 400, 100); // Dibuja un rectángulo en (30,30) de 80x40 px

        if (imagenCoca != null) {
            g.drawImage(imagenCoca, 60, 260, 200,200,this);
        }
        if (imagenSprite != null) {
            g.drawImage(imagenSprite, 260, 260, 200,200,this);
        }
        if (imagenSnickers != null) {
            g.drawImage(imagenSnickers, 60, 60, 200,200,this);
        }

    }
}