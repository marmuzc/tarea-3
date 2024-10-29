package GUI;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    PanelPrincipal panelPrincipal;

    public Ventana(){
        super();
        this.setTitle("Maquina Expendedora");
        this.setSize(1280, 720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        panelPrincipal = new PanelPrincipal();
        this.add(panelPrincipal, BorderLayout.CENTER);
        this.setVisible(true);
    }
}
