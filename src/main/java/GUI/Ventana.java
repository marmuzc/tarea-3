package GUI;

import javax.swing.*;
import java.awt.*;
/**
 * Clase Ventana representa la ventana principal de la aplicación.
 * Configura la ventana y añade el panel principal de la interfaz gráfica.
 */
public class Ventana extends JFrame {

    PanelPrincipal panelPrincipal;

    /**
     * Constructor de Ventana. Inicializa los componentes y configura la ventana.
     */
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
