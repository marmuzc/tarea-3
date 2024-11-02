package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelBotones extends JPanel {
    public PanelBotones() {
        setLayout(new GridLayout(2, 2)); // 2 filas y 2 columnas

        // Crear botones para cada producto
        JButton botonCoca = new JButton("1");
        JButton botonSprite = new JButton("2");
        JButton botonSnickers = new JButton("3");
        JButton botonSuper8 = new JButton("4");

        // Agregar ActionListeners a los botones
        botonCoca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Coca-Cola comprada!");
            }
        });
        botonSprite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Sprite comprada!");
            }
        });
        botonSnickers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Snickers comprado!");
            }
        });
        botonSuper8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Super 8 comprado!");
            }
        });

        // Añadir los botones al panel
        add(botonCoca);
        add(botonSprite);
        add(botonSnickers);
        add(botonSuper8);
    }
}
