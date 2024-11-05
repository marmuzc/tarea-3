package GUI;

import LOGICA.Expendedor;
import LOGICA.Monedas.Moneda;
import LOGICA.Monedas.Moneda100;
import LOGICA.productosEnum;
import LOGICA.Depositos.DepositoM;
import LOGICA.Excepciones.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelBotonesExp extends JPanel {
    private JLabel saldoLabel;
    private DepositoM depositoSaldo;
    private double saldoDisponible = 4500; // Monto inicial del saldo
    private Expendedor expendedor; //test

    public PanelBotonesExp() {
        setLayout(new BorderLayout());

        expendedor = new Expendedor(5);

        JPanel panelElegirProductos = new JPanel();
        panelElegirProductos.setLayout(new GridLayout(2, 2));

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


        JPanel panelOtrosBotones = new JPanel();
        panelOtrosBotones.setLayout(new GridLayout(3, 1));

        JButton botonVuelto = new JButton("Retirar Vuelto");
        botonVuelto.addActionListener(e -> retirarVuelto());

        JButton botonRetirarProducto = new JButton("Retirar Producto");
        botonRetirarProducto.addActionListener(e -> retirarProducto());

        saldoLabel = new JLabel("Saldo: $" + saldoDisponible);
        saldoLabel.setHorizontalAlignment(SwingConstants.CENTER);


        panelOtrosBotones.add(botonVuelto);
        panelOtrosBotones.add(botonRetirarProducto);
        panelOtrosBotones.add(saldoLabel);


        add(panelElegirProductos, BorderLayout.CENTER);
        add(panelOtrosBotones, BorderLayout.SOUTH);
    }

    private void comprarProducto(productosEnum productoEnum) {
        try {
            Moneda100 moneda = new Moneda100(); // Simulación de una moneda de pago de 100
            expendedor.comprarProducto(moneda, productoEnum);
            
            saldoDisponible -= productoEnum.getPrecio(); // Descontar el saldo
            actualizarSaldo();

            JOptionPane.showMessageDialog(this, "Has comprado " + productoEnum);
        } catch (PagoInsuficienteException | NoHayProductoException | PagoIncorrectoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
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
        if (expendedor.getProductoComprado() != null) {
            JOptionPane.showMessageDialog(this, "Producto retirado: " + expendedor.getProductoComprado().getNombre());
        } else {
            JOptionPane.showMessageDialog(this, "No hay producto disponible para retirar");
        }
    }

    private void actualizarSaldo() {
        saldoLabel.setText("Saldo : $" + saldoDisponible);
    }
}
