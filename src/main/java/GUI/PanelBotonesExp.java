package GUI;

import LOGICA.Expendedor;
import LOGICA.Monedas.Moneda;
import LOGICA.productosEnum;
import javax.swing.*;
import java.awt.*;

public class PanelBotonesExp extends JPanel {
    private JLabel saldoLabel;
    private double saldoDisponible = 4500;
    private Expendedor expendedor;
    private Moneda moneda;

    public PanelBotonesExp(Expendedor expendedor) {
        this.expendedor = expendedor;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Panel para elegir productos
        JPanel panelElegirProductos = new JPanel();
        panelElegirProductos.setLayout(new GridLayout(2, 2));
        panelElegirProductos.setPreferredSize(new Dimension(200, 100));

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

        // Panel para otros botones (Retirar vuelto y producto)
   //     JPanel panelOtrosBotones = new JPanel();
  //      panelOtrosBotones.setLayout(new GridLayout(2, 1));
    //    panelOtrosBotones.setPreferredSize(new Dimension(200, 100));

        JButton botonVuelto = new JButton("Retirar Vuelto");
        botonVuelto.addActionListener(e -> retirarVuelto());

        JButton botonRetirarProducto = new JButton("Retirar Producto");
        botonRetirarProducto.addActionListener(e -> JOptionPane.showMessageDialog(null, "Producto en inventario!"));

      //  panelOtrosBotones.add(botonVuelto);
        //panelOtrosBotones.add(botonRetirarProducto);

        // Panel para agregar dinero
        JPanel panelAgregarDinero = new JPanel();
        panelAgregarDinero.setLayout(new GridLayout(3, 1));
        panelAgregarDinero.setPreferredSize(new Dimension(200, 150));

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

        panelAgregarDinero.add(boton100);
        panelAgregarDinero.add(boton500);
        panelAgregarDinero.add(boton1000);

        // Saldo label
        saldoLabel = new JLabel("Saldo: $" + saldoDisponible);

        // Añadir los paneles en orden
        add(panelElegirProductos);
        add(Box.createRigidArea(new Dimension(0, 25))); // Espacio de 10px entre paneles

        add(panelAgregarDinero);
        add(Box.createRigidArea(new Dimension(0, 25))); // Espacio de 10px entre paneles
        add(saldoLabel);
        add(Box.createRigidArea(new Dimension(0, 25))); // Espacio de 10px entre paneles
     //   add(panelOtrosBotones);
        add(botonVuelto);
        add(botonRetirarProducto);

        // Bordes para facilitar la visualización
        panelElegirProductos.setBorder(BorderFactory.createLineBorder(Color.RED));
       // panelOtrosBotones.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        panelAgregarDinero.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        saldoLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private void comprarProducto(productosEnum producto) {
        try {
            expendedor.comprarProducto(moneda, producto);

            Moneda vuelto = expendedor.getVuelto();
            if (vuelto != null) {
                JOptionPane.showMessageDialog(this, "Vuelto: $" + vuelto.getValor());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void retirarVuelto() {
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
    }

    private void actualizarSaldo() {
        saldoLabel.setText("Saldo: $" + saldoDisponible);
    }
}
