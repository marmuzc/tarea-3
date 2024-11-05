package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelBotonesExp extends JPanel {
    private JLabel saldoLabel;
    private double saldoDisponible = 4500; // Monto inicial del saldo

    public PanelBotonesExp() {
        setLayout(new BorderLayout());


        JPanel panelElegirProductos = new JPanel();
        panelElegirProductos.setLayout(new GridLayout(2, 2));

        JButton botonSnickers = new JButton("1");
        JButton botonSuper8 = new JButton("2");
        JButton botonCoca = new JButton("3");
        JButton botonSprite = new JButton("4");

        botonCoca.addActionListener(e -> comprarProducto("Coca-Cola"));
        botonSprite.addActionListener(e -> comprarProducto("Sprite"));
        botonSnickers.addActionListener(e -> comprarProducto("Snickers"));
        botonSuper8.addActionListener(e -> comprarProducto("Super 8"));


        panelElegirProductos.add(botonSnickers);
        panelElegirProductos.add(botonSuper8);
        panelElegirProductos.add(botonCoca);
        panelElegirProductos.add(botonSprite);


        JPanel panelOtrosBotones = new JPanel();
        panelOtrosBotones.setLayout(new GridLayout(3, 1));

        JButton botonVuelto = new JButton("Retirar Vuelto");
        botonVuelto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear una ventana emergente para mostrar el vuelto
                JFrame ventanaVuelto = new JFrame("Vuelto");
                ventanaVuelto.setSize(300, 200);
                ventanaVuelto.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


                JLabel vueltoLabel = new JLabel("Tu vuelto es: $" + saldoDisponible);
                JButton botonRetirarVuelto = new JButton("Retirar Vuelto");
                botonRetirarVuelto.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(null, "Vuelto retirado!");
                        saldoDisponible = 0.0;
                        actualizarSaldo();
                        ventanaVuelto.dispose();
                    }
                });


                ventanaVuelto.setLayout(new FlowLayout());
                ventanaVuelto.add(vueltoLabel);
                ventanaVuelto.add(botonRetirarVuelto);
                ventanaVuelto.setVisible(true);
            }
        });


        JButton botonRetirarProducto = new JButton("Retirar Producto");
        botonRetirarProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Producto retirado!");
            }
        });


        saldoLabel = new JLabel("Saldo: $" + saldoDisponible);
        saldoLabel.setHorizontalAlignment(SwingConstants.CENTER);


        panelOtrosBotones.add(botonVuelto);
        panelOtrosBotones.add(botonRetirarProducto);
        panelOtrosBotones.add(saldoLabel);


        add(panelElegirProductos, BorderLayout.CENTER);
        add(panelOtrosBotones, BorderLayout.SOUTH);
    }

    private void comprarProducto(String producto) {
        // Aquí iría la lógica de compra de productos
    }

    private void actualizarSaldo() {
        saldoLabel.setText("Saldo : $" + saldoDisponible);
    }
}
