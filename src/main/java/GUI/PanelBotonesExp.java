package GUI;

import LOGICA.Depositos.DepositoP;
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
    private double saldoDisponible = 0;
    private Expendedor expendedor;
    private Productos productoComprado;
    private PanelComprador panelComprador;
    private PanelExpendedor panelExpendedor;

    private JLabel cantidadCocaLabel;
    private JLabel cantidadSpriteLabel;
    private JLabel cantidadSnickersLabel;
    private JLabel cantidadSuper8Label;

    private JButton botonSnickers;
    private JButton botonSuper8;
    private JButton botonCoca;
    private JButton botonSprite;


    public PanelBotonesExp(PanelComprador panelComprador, PanelExpendedor panelExpendedor) {
        // Inicialización de paneles y componentes
        this.panelComprador = panelComprador;
        this.panelExpendedor = panelExpendedor;

        // Asegúrate de que el expendedor esté correctamente inicializado
        expendedor = new Expendedor(5);  // Número de productos iniciales
        depositoSaldo = new DepositoM();

        // Configuración del panel
        this.setBackground(Color.DARK_GRAY);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel panelCantidadProductos = new JPanel();
        panelCantidadProductos.setLayout(new GridLayout(4, 1));
        panelCantidadProductos.setPreferredSize(new Dimension(200, 100));
        cantidadCocaLabel = new JLabel("Coca Cola restantes: " + expendedor.getCantidadCoca());
        cantidadSpriteLabel = new JLabel("Sprite restantes: " + expendedor.getCantidadSprite());
        cantidadSnickersLabel = new JLabel("Snickers restantes: " + expendedor.getCantidadSnickers());
        cantidadSuper8Label = new JLabel("Super8 restantes: " + expendedor.getCantidadSuper8());
        panelCantidadProductos.add(cantidadCocaLabel);
        panelCantidadProductos.add(cantidadSpriteLabel);
        panelCantidadProductos.add(cantidadSnickersLabel);
        panelCantidadProductos.add(cantidadSuper8Label);

        JPanel panelElegirProductos = new JPanel();
        panelElegirProductos.setLayout(new GridLayout(2, 2));
        panelElegirProductos.setPreferredSize(new Dimension(200, 100));
        panelElegirProductos.setBackground(Color.DARK_GRAY);


        botonSnickers = new JButton("1");
        botonSuper8 = new JButton("2");
        botonCoca = new JButton("3");
        botonSprite = new JButton("4");

        botonCoca.addActionListener(e -> comprarProducto(productosEnum.COCA));
        botonSprite.addActionListener(e -> comprarProducto(productosEnum.SPRITE));
        botonSnickers.addActionListener(e -> comprarProducto(productosEnum.SNICKERS));
        botonSuper8.addActionListener(e -> comprarProducto(productosEnum.SUPER8));

        panelElegirProductos.add(botonSnickers);
        panelElegirProductos.add(botonSuper8);
        panelElegirProductos.add(botonCoca);
        panelElegirProductos.add(botonSprite);

        JPanel panelVuelto = new JPanel();
        panelVuelto.setBackground(Color.DARK_GRAY);

        JButton botonVuelto = new JButton("Retirar Vuelto");
        botonVuelto.addActionListener(e -> retirarVuelto());
        panelVuelto.add(botonVuelto);

        JPanel panelRetirarProducto = new JPanel();
        panelRetirarProducto.setBackground(Color.DARK_GRAY);

        JButton botonRetirarProducto = new JButton("Retirar Producto");
        botonRetirarProducto.addActionListener(e -> retirarProducto());
        panelRetirarProducto.add(botonRetirarProducto);

        JPanel panelAgregarDinero = new JPanel();
        panelAgregarDinero.setLayout(new GridLayout(3, 1));
        panelAgregarDinero.setBackground(Color.DARK_GRAY);

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
            if (panelComprador.getPanelBilletera().quitarMoneda(100)) {
                depositoSaldo.addMoneda(new Moneda100());
                saldoDisponible += 100;
                actualizarSaldo();
            } else {
                JOptionPane.showMessageDialog(this, "No hay monedas de $100 en la billetera");
            }
        });

        boton500.addActionListener(e -> {
            if (panelComprador.getPanelBilletera().quitarMoneda(500)) {
                depositoSaldo.addMoneda(new Moneda500());
                saldoDisponible += 500;
                actualizarSaldo();
            } else {
                JOptionPane.showMessageDialog(this, "No hay monedas de $500 en la billetera");
            }
        });

        boton1000.addActionListener(e -> {
            if (panelComprador.getPanelBilletera().quitarMoneda(1000)) {
                depositoSaldo.addMoneda(new Moneda1000());
                saldoDisponible += 1000;
                actualizarSaldo();
            } else {
                JOptionPane.showMessageDialog(this, "No hay monedas de $1000 en la billetera");
            }
        });

        panelAgregarDinero.add(boton100);
        panelAgregarDinero.add(boton500);
        panelAgregarDinero.add(boton1000);

        // Configuración del label de saldo
        saldoLabel = new JLabel("Saldo disponible: $" + saldoDisponible);
        saldoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        saldoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        saldoLabel.setForeground(Color.WHITE);

        JLabel labelProductos = new JLabel("Elegir producto:");
        labelProductos.setHorizontalAlignment(SwingConstants.CENTER);
        labelProductos.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelProductos.setForeground(Color.WHITE);

        // Añadir los paneles y componentes al panel principal
        add(panelAgregarDinero);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(saldoLabel);
        add(Box.createRigidArea(new Dimension(0, 15)));
        add(labelProductos);
        add(Box.createRigidArea(new Dimension(0, 15)));
        add(panelElegirProductos);
        add(Box.createRigidArea(new Dimension(0, 25)));
        add(panelVuelto);
        add(panelRetirarProducto);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(panelCantidadProductos);
    }

    private void actualizarCantidadProductos() {
        // Actualiza el texto de cada JLabel para mostrar la cantidad actual de productos en el expendedor
        cantidadCocaLabel.setText("Coca Cola restantes: " + expendedor.getCantidadCoca());
        cantidadSpriteLabel.setText("Sprite restantes: " + expendedor.getCantidadSprite());
        cantidadSnickersLabel.setText("Snickers restantes: " + expendedor.getCantidadSnickers());
        cantidadSuper8Label.setText("Super8 restantes: " + expendedor.getCantidadSuper8());
    }


    private void comprarProducto(productosEnum productoEnum) {
        // Verificar si el saldo es suficiente antes de intentar la compra
        if (saldoDisponible < productoEnum.getPrecio()) {
            JOptionPane.showMessageDialog(this, "No hay saldo suficiente para comprar " + productoEnum);
            return;
        }

        try {
            // Verificar si hay un producto sin retirar
            if (productoComprado != null) {
                JOptionPane.showMessageDialog(this, "Tiene un producto sin retirar. Se añadirá al inventario automáticamente.");
                panelComprador.getPanelInventario().agregarProducto(productoComprado);
                JOptionPane.showMessageDialog(null, productoComprado.getNombre() + " añadido al inventario.");
                productoComprado = null; // Limpiar la referencia de productoComprado
            }

            // Intentar comprar el nuevo producto
            expendedor.comprarProducto(depositoSaldo, productoEnum);
            productoComprado = expendedor.getProductoComprado();
            panelExpendedor.actualizarProductoComprado(productoComprado);

            saldoDisponible -= productoEnum.getPrecio();
            actualizarSaldo();

            actualizarCantidadProductos();


            depositoSaldo = expendedor.getVuelto();

            JOptionPane.showMessageDialog(this, "Puede retirar su " + productoEnum);
            JOptionPane.showMessageDialog(this, "Vuelto: $" + saldoDisponible);
        } catch (PagoInsuficienteException | NoHayProductoException | PagoIncorrectoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

// Elimina el método actualizarEstadoBotonesProductos
// y la llamada a este método en actualizarSaldo, si existe.

    private void actualizarSaldo() {
        saldoLabel.setText("Saldo: $" + saldoDisponible);
    }


    private void retirarVuelto() {
        if (saldoDisponible <= 0) {
            JOptionPane.showMessageDialog(this, "No hay vuelto para retirar.");
            return;
        }

        JFrame ventanaVuelto = new JFrame("Vuelto");
        ventanaVuelto.setSize(300, 200);
        ventanaVuelto.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel vueltoLabel = new JLabel("Tu vuelto es: $" + saldoDisponible);
        JButton botonRetirarVuelto = new JButton("Retirar Vuelto");
        botonRetirarVuelto.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Vuelto retirado!");

            // Entregar cada moneda del depósito de vuelto al panel de billetera
            for (Moneda moneda : depositoSaldo.getDeposito()) {
                panelComprador.getPanelBilletera().agregarMoneda(moneda);
            }

            // Reiniciar el saldo disponible y el depósito de monedas
            saldoDisponible = 0.0;
            actualizarSaldo();
            depositoSaldo.limpiarDeposito();
            ventanaVuelto.dispose();
        });

        ventanaVuelto.setLayout(new FlowLayout());
        ventanaVuelto.add(vueltoLabel);
        ventanaVuelto.add(botonRetirarVuelto);
        ventanaVuelto.setVisible(true);
    }


    private void retirarProducto() {
        if (productoComprado != null) {
            JOptionPane.showMessageDialog(this, "Producto retirado: " + productoComprado.getNombre());
            panelComprador.getPanelInventario().agregarProducto(productoComprado);
            JOptionPane.showMessageDialog(null, productoComprado.getNombre() + " añadido al inventario.");
            productoComprado = null;
            panelExpendedor.actualizarProductoComprado(productoComprado);
        } else {
            JOptionPane.showMessageDialog(this, "No hay producto disponible para retirar");
        }
    }

}