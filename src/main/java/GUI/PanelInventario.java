package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import LOGICA.Depositos.*;
import LOGICA.Productos.*;
/**
 * Clase PanelInventario representa el panel de inventario en la interfaz gráfica.
 * Muestra la imagen de la mochila y permite al usuario ver los productos almacenados.
 */


public class PanelInventario extends JPanel {
    private Image inventario;
    private JLabel etiqueta;
    private DepositoP productos;

    /**
     * Constructor de PanelInventario. Inicializa los componentes y configura el panel.
     */
    public PanelInventario() {
        inventario = new ImageIcon("src/resources/Inventario.png").getImage();
        this.productos = new DepositoP();


        setPreferredSize(new Dimension(150, 150));

        etiqueta = new JLabel("Inventario");
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER); // Centrar texto
        etiqueta.setFont(new Font("Arial", Font.BOLD, 14)); // Cambiar la fuente y tamaño
        etiqueta.setForeground(Color.BLACK); // Cambiar color del texto
        etiqueta.setPreferredSize(new Dimension(200, 30)); // Establecer tamaño para la etiqueta

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mostrarProductos();
            }
        });

        this.setLayout(new BorderLayout());
        this.add(etiqueta, BorderLayout.NORTH);
    }

    /**
     * Sobrescribe el metodo paintComponent para mostrar la imagen de la mochila.
     *
     * @param g El contexto gráfico.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(inventario, 0, 30, getWidth(), getHeight() - 30, this); // Dibuja la imagen debajo de la etiqueta
    }
    /**
     * Agrega un producto al inventario.
     *
     * @param producto El producto a agregar.
     */
    public void agregarProducto(Productos producto){
        productos.addProducto(producto);
    }

    /**
     * Muestra una ventana con los productos almacenados en el inventario.
     */

    private void mostrarProductos() {
        JFrame productosFrame = new JFrame("Productos en el Inventario");
        productosFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        productosFrame.setSize(300, 200);
        productosFrame.setLayout(new FlowLayout());

        for (Productos producto : productos.getDeposito()) {
            productosFrame.add(new JLabel(producto.getNombre()));
        }

        productosFrame.setVisible(true);
    }
}
