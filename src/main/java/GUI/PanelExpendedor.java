package GUI;

import LOGICA.*;
import LOGICA.Productos.*;
import LOGICA.Monedas.*;
import LOGICA.Depositos.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelExpendedor extends JPanel{
    public PanelExpendedor() {
        this.setBackground(Color.white);
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


    }
}