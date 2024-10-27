package GUI;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {//se ve en el centro de la ventana
    private PanelComprador com;
    private PanelExpendedor exp;

    public PanelPrincipal() {
        //exp = new PanelExpendedor(..);
       // cf = new PanelComprador(..);
        this.setBackground(Color.white);
    }

    public void paintComponent(Graphics g) { //todo se dibuja a partir de este
       // método
        super.paintComponent(g); //llama al método pint al que hace override en la
       // super clase
//el de la super clase solo pinta el fondo (background)
        com.paintComponent(g); //llama al metodo paintComponent definido en el
      //  PanelComprador
        exp.paintComponent(g); //llama al metodo paintComponent definido en el
       // PanelExpendedor
    }
}

