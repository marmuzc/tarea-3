package GUI;

import LOGICA.Expendedor;
import LOGICA.Monedas.*;
import LOGICA.productosEnum;
import LOGICA.Depositos.DepositoM;
import LOGICA.Excepciones.*;
import LOGICA.Productos.*;

import javax.swing.*;
import java.awt.*;

public class PanelBotonesExp extends JPanel {
    private JLabel saldoLabel;
    private DepositoM depositoSaldo;
    private double saldoDisponible = 4500; // Monto inicial del saldo
    private Expendedor expendedor; //test
    private Productos productoComprado;
    private PanelComprador panelComprador; // Referencia a PanelComprador
    //test
    private Moneda moneda;
    private PanelMonedas panelMonedas;
    

    public PanelBotonesExp(PanelComprador panelComprador) {
        this.panelComprador = panelComprador;

        expendedor = new Expendedor(5);
        
        // Cambia el fondo del panel principal a gris oscuro
        this.setBackground(Color.DARK_GRAY);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel panelElegirProductos = new JPanel();
        panelElegirProductos.setLayout(new GridLayout(2, 2));
        panelElegirProductos.setPreferredSize(new Dimension(200, 100));
        panelElegirProductos.setBackground(Color.DARK_GRAY); // Cambia el fondo de este panel

        JButton botonSnickers = new JButton("1");
        JButton botonSuper8 = new JButton("2");
        JButton botonCoca = new JButton("3");
        JButton botonSprite = new JButton("4");

        botonCoca.addActionListener(e -> comprarProducto(productosEnum.COCA));
        botonSprite.addActionListener(e -> comprarProducto(productosEnum.SPRITE));
        botonSnickers.addActionListener(e -> comprarProducto(productosEnum.SNICKERS));
        botonSuper8.addActionListener(e -> comprarProducto(productosEnum.SUPER8));

        panelElegirProductos.add(botonSnickers);
        panelElegirProductos.add(botonSuper8);
        panelElegirProductos.add(botonCoca);
        panelElegirProductos.add(botonSprite);

        JPanel panelVuelto = new JPanel();
        panelVuelto.setBackground(Color.DARK_GRAY); // Cambia el fondo de este panel
        JButton botonVuelto = new JButton("Retirar Vuelto");
        botonVuelto.addActionListener(e -> retirarVuelto());
        panelVuelto.add(botonVuelto);

        JPanel panelRetirarProducto = new JPanel();
        panelRetirarProducto.setBackground(Color.DARK_GRAY); // Cambia el fondo de este panel
        JButton botonRetirarProducto = new JButton("Retirar Producto");
        //Viejo
        botonRetirarProducto.addActionListener(e -> retirarProducto());
        //Nuevo
        botonRetirarProducto.addActionListener(e -> JOptionPane.showMessageDialog(null, "Producto en inventario!"));
        panelRetirarProducto.add(botonRetirarProducto);

        JPanel panelAgregarDinero = new JPanel();
        panelAgregarDinero.setLayout(new GridLayout(3, 1));
        panelAgregarDinero.setBackground(Color.DARK_GRAY); // Cambia el fondo de este panel

        // Inicializa el panelMonedas
        panelMonedas = new PanelMonedas();
        panelMonedas.setBackground(Color.DARK_GRAY); // Cambia el fondo de panelMonedas

        // Botones de agregar dinero
        JButton boton100 = new JButton("Agregar $100");
        JButton boton500 = new JButton("Agregar $500");
        JButton boton1000 = new JButton("Agregar $1000");

        Color customColor = new Color(100, 150, 200);
        boton100.setBackground(customColor);
        boton500.setBackground(customColor);
        boton1000.setBackground(customColor);

        boton100.setForeground(Color.WHITE);
        boton500.setForeground(Color.WHITE);
        boton1000.setForeground(Color.WHITE);

        boton100.addActionListener(e -> {
            agregarMoneda(100);
            actualizarSaldo();
        });

        boton500.addActionListener(e -> {
            agregarMoneda(500);
            actualizarSaldo();
        });

        boton1000.addActionListener(e -> {
            agregarMoneda(1000);
            actualizarSaldo();
        });

        panelAgregarDinero.add(boton100);
        panelAgregarDinero.add(boton500);
        panelAgregarDinero.add(boton1000);

        // Configuración del label de saldo
        saldoLabel = new JLabel("Saldo disponible: $" + saldoDisponible);
        saldoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        saldoLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar en el BoxLayout
        saldoLabel.setForeground(Color.WHITE); // Cambia el color del texto a blanco

        // Configuración del label de productos
        JLabel labelProductos = new JLabel("Elegir producto:");
        labelProductos.setHorizontalAlignment(SwingConstants.CENTER);
        labelProductos.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar en el BoxLayout
        labelProductos.setForeground(Color.WHITE); // Cambia el color del texto a blanco

        // Añadir los paneles y componentes al panel principal en el orden deseado
        add(panelAgregarDinero); // Añade los botones primero
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(panelMonedas); // Luego el panel para mostrar las monedas
        add(Box.createRigidArea(new Dimension(0, 15)));
        add(saldoLabel);
        add(Box.createRigidArea(new Dimension(0, 15)));
        add(labelProductos);
        add(Box.createRigidArea(new Dimension(0, 15)));
        add(panelElegirProductos);
        add(Box.createRigidArea(new Dimension(0, 25)));
        add(panelVuelto);
        add(panelRetirarProducto);

    }

    private void comprarProducto(productosEnum productoEnum) {
        try {
            Moneda moneda = new Moneda1000(); // Simulación de una moneda de pago de 100
            expendedor.comprarProducto(moneda, productoEnum);
            productoComprado = expendedor.getProductoComprado();
            
            saldoDisponible -= productoEnum.getPrecio(); // Descontar el saldo
            actualizarSaldo();


            JOptionPane.showMessageDialog(this, "Puede retirar su " + productoEnum);
        } catch (PagoInsuficienteException | NoHayProductoException | PagoIncorrectoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    /**private void comprarProducto(productosEnum producto) {
        try {
            expendedor.comprarProducto(moneda, producto);

            Moneda vuelto = expendedor.getVuelto();
            if (vuelto != null) {
                JOptionPane.showMessageDialog(this, "Vuelto: $" + vuelto.getValor());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }**/
    }

    private void retirarVuelto() {
        Moneda vuelto = expendedor.getVuelto();
        if (vuelto != null) {
            saldoDisponible += vuelto.getValor();
            actualizarSaldo();
            JOptionPane.showMessageDialog(this, "Vuelto retirado: $" + vuelto.getValor());
        } else {
            JOptionPane.showMessageDialog(this, "No hay vuelto disponible");
        }
    }

    private void retirarProducto() {
        if (productoComprado != null) {
            JOptionPane.showMessageDialog(this, "Producto retirado: " + productoComprado.getNombre());
            panelComprador.getPanelInventario().agregarProducto(productoComprado); // Añade al inventario
            JOptionPane.showMessageDialog(null, productoComprado.getNombre() + " añadido al inventario.");

        } else {
            JOptionPane.showMessageDialog(this, "No hay producto disponible para retirar");
        }
        /**
        JFrame ventanaVuelto = new JFrame("Vuelto");
        ventanaVuelto.setSize(300, 200);
        ventanaVuelto.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel vueltoLabel = new JLabel("Tu vuelto es: $" + saldoDisponible);
        JButton botonRetirarVuelto = new JButton("Retirar Vuelto");
        botonRetirarVuelto.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Vuelto retirado!");
            saldoDisponible = 0.0;
            actualizarSaldo();
            ventanaVuelto.dispose();
        });

        ventanaVuelto.setLayout(new FlowLayout());
        ventanaVuelto.add(vueltoLabel);
        ventanaVuelto.add(botonRetirarVuelto);
        ventanaVuelto.setVisible(true);
        **/
    }

    private void actualizarSaldo() {
        saldoLabel.setText("Saldo: $" + saldoDisponible);
    }

    private void agregarMoneda(int valor) {
        panelMonedas.addMoneda(valor); // Agrega la moneda al panel
    }
}
