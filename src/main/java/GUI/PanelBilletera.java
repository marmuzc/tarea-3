package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import LOGICA.Depositos.*;
import LOGICA.Monedas.*;

public class PanelBilletera extends JPanel {
    private Image billetera; // Para almacenar la imagen de la billetera
    private JLabel etiqueta; // Para la etiqueta que indica "Billetera"
    private DepositoM monedas;
    private PanelMonedas panelMonedas; // Instancia de PanelMonedas

    public PanelBilletera() {
        setPreferredSize(new Dimension(150, 150));
        billetera = new ImageIcon("src/resources/Billetera.png").getImage();
        this.monedas = new DepositoM();

        etiqueta = new JLabel("Billetera");
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER); // Centrar texto
        etiqueta.setFont(new Font("Arial", Font.BOLD, 14)); // Cambiar la fuente y tamaño
        etiqueta.setForeground(Color.BLACK); // Cambiar color del texto
        etiqueta.setPreferredSize(new Dimension(200, 30)); // Establecer tamaño para la etiqueta

        // Instanciar PanelMonedas y añadir monedas de ejemplo
        //tendremos 5000 pesos
        panelMonedas = new PanelMonedas();
        panelMonedas.addMoneda(1000);
        panelMonedas.addMoneda(1000);
        panelMonedas.addMoneda(1000);
        panelMonedas.addMoneda(1000);
        panelMonedas.addMoneda(500);
        panelMonedas.addMoneda(100);
        panelMonedas.addMoneda(100);
        panelMonedas.addMoneda(100);
        panelMonedas.addMoneda(100);
        panelMonedas.addMoneda(100);
        // Puedes añadir más monedas aquí si lo deseas

        // Añadir un MouseListener para manejar clics
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mostrarMonedas(); // Llama a mostrarMonedas al hacer clic
            }
        });

        // Establecer el layout del panel
        this.setLayout(new BorderLayout());
        this.add(etiqueta, BorderLayout.NORTH); // Añadir etiqueta en la parte superior
    }

    // Método para mostrar la imagen de la billetera
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Ajustar la imagen al tamaño del panel, menos el espacio de la etiqueta
        g.drawImage(billetera, 0, 30, getWidth(), getHeight() - 30, this); // Dibuja la imagen debajo de la etiqueta
    }
    
    /**public void agregarMoneda(Moneda moneda){
        monedas.addMoneda(moneda);
    }**/

    // Método para mostrar la ventana con las monedas usando PanelMonedas
    private void mostrarMonedas() {
        JFrame monedasFrame = new JFrame("Monedas en la Billetera");
        monedasFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        monedasFrame.setSize(250, 200); // Ajusta el tamaño de la ventana

        monedasFrame.add(panelMonedas); // Agregar panelMonedas en la ventana
        monedasFrame.setVisible(true); // Mostrar la ventana
    }
}

