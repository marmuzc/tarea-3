package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelAgregarDinero extends JPanel {
    public PanelAgregarDinero() {
        setLayout(new GridLayout(3, 1));

        JButton boton100 = new JButton("Agregar $100");
        JButton boton500 = new JButton("Agregar $500");
        JButton boton1000 = new JButton("Agregar $1000");

        // Cambiar el color de fondo de los botones
        Color customColor = new Color(100, 150, 200);
        boton100.setBackground(customColor);
        boton500.setBackground(customColor);
        boton1000.setBackground(customColor);

        // También puedes cambiar el color del texto, si lo deseas
        boton100.setForeground(Color.WHITE);
        boton500.setForeground(Color.WHITE);
        boton1000.setForeground(Color.WHITE);

        boton100.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para agregar $1 al expendedor
            }
        });

        boton500.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para agregar $5 al expendedor
            }
        });

        boton1000.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para agregar $10 al expendedor
            }
        });

        add(boton100);
        add(boton500);
        add(boton1000);
    }
}
