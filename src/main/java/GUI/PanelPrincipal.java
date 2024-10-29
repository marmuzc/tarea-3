package GUI;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {//se ve en el centro de la ventana
    private PanelComprador com;
    private PanelExpendedor exp;

    public PanelPrincipal() {
        // Inicializa los paneles
        exp = new PanelExpendedor();
        com = new PanelComprador();

        // Configura el diseño y agrega los paneles
        this.setLayout(new BorderLayout());
        this.setBackground(Color.white);

        // Puedes ajustar el BorderLayout para situar los paneles como prefieras
        this.add(exp, BorderLayout.WEST);  // PanelExpendedor en el centro
        this.add(com, BorderLayout.EAST);   // PanelComprador en la parte inferior
    }

    public void paintComponent(Graphics g) { //todo se dibuja a partir de este
       // método
        super.paintComponent(g); //llama al método pint al que hace override en la super clase

        //el de la super clase solo pinta el fondo (background)
        com.paintComponent(g); //llama al metodo paintComponent definido en el
      //  PanelComprador
        exp.paintComponent(g); //llama al metodo paintComponent definido en el
       // PanelExpendedor
    }
}

