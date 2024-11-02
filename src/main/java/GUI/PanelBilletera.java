package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelBilletera extends JPanel {
    private Image billetera; // Para almacenar la imagen de la billetera
    private JLabel etiqueta; // Para la etiqueta que indica "Billetera"

    public PanelBilletera() {
        // Cargar la imagen de la billetera
        billetera = new ImageIcon("src/resources/Billetera.png").getImage();

        // Establecer el tamaño preferido del panel
        setPreferredSize(new Dimension(150, 150)); // Cambia el tamaño según tu imagen deseada

        // Crear la etiqueta
        etiqueta = new JLabel("Billetera");
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER); // Centrar texto
        etiqueta.setFont(new Font("Arial", Font.BOLD, 14)); // Cambiar la fuente y tamaño
        etiqueta.setForeground(Color.BLACK); // Cambiar color del texto
        etiqueta.setPreferredSize(new Dimension(200, 30)); // Establecer tamaño para la etiqueta

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

    // Método para mostrar la ventana con las monedas
    private void mostrarMonedas() {
        JFrame monedasFrame = new JFrame("Monedas");
        monedasFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        monedasFrame.setSize(200, 100); // Ajusta el tamaño de la ventana
        monedasFrame.setLayout(new FlowLayout());

        // Aquí agregarás las monedas, por ahora solo un ejemplo
        JLabel moneda1 = new JLabel("Moneda de $100");
        JLabel moneda2 = new JLabel("Moneda de $500");
        JLabel moneda3 = new JLabel("Moneda de $1000");

        monedasFrame.add(moneda1);
        monedasFrame.add(moneda2);
        monedasFrame.add(moneda3);

        monedasFrame.setVisible(true); // Mostrar la ventana
    }
}
