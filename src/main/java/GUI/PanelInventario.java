package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import LOGICA.Depositos.*;
import LOGICA.Productos.*;


public class PanelInventario extends JPanel {
    private Image inventario; // Para almacenar la imagen de la mochila
    private JLabel etiqueta; // Para la etiqueta que indica "Inventario"
    private DepositoP productos;

    public PanelInventario() {
        // Cargar la imagen de la mochila
        inventario = new ImageIcon("src/resources/Inventario.png").getImage();
        this.productos = new DepositoP();

        // Establecer el tamaño preferido del panel (ajusta según tu imagen)
        setPreferredSize(new Dimension(150, 150)); // Cambia el tamaño según tu imagen deseada

        // Crear la etiqueta
        etiqueta = new JLabel("Inventario");
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER); // Centrar texto
        etiqueta.setFont(new Font("Arial", Font.BOLD, 14)); // Cambiar la fuente y tamaño
        etiqueta.setForeground(Color.BLACK); // Cambiar color del texto
        etiqueta.setPreferredSize(new Dimension(200, 30)); // Establecer tamaño para la etiqueta

        // Añadir un MouseListener para manejar clics
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mostrarProductos(); // Llama a mostrarProductos al hacer clic
            }
        });

        // Establecer el layout del panel
        this.setLayout(new BorderLayout());
        this.add(etiqueta, BorderLayout.NORTH); // Añadir etiqueta en la parte superior
    }

    // Método para mostrar la imagen de la mochila
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Ajustar la imagen al tamaño del panel, menos el espacio de la etiqueta
        g.drawImage(inventario, 0, 30, getWidth(), getHeight() - 30, this); // Dibuja la imagen debajo de la etiqueta
    }

    public void agregarProducto(Productos producto){
        productos.addProducto(producto);
    }
    // Método para mostrar la ventana con los productos
    private void mostrarProductos() {
        JFrame productosFrame = new JFrame("Productos en el Inventario");
        productosFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        productosFrame.setSize(300, 200); // Ajusta el tamaño según tus necesidades
        productosFrame.setLayout(new FlowLayout());

        // Aquí agregarás los productos, por ahora solo un ejemplo
        for (Productos producto : productos.getDeposito()) {
            productosFrame.add(new JLabel(producto.getNombre()));
        }

        productosFrame.setVisible(true); // Mostrar la ventana
    }


}
