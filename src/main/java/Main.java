import Excepciones.*;
import Monedas.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("======   Caso 0  ======");
        List<Moneda> monedas = new ArrayList<>();
        monedas.add(new Moneda1000());
        monedas.add(new Moneda1000());
        monedas.add(new Moneda100());
        monedas.add(new Moneda1000());
        monedas.add(new Moneda500());
        monedas.add(new Moneda500());

        System.out.println("=====   Monedas antes de ordenar    =====");
        for (Moneda m : monedas) {
            System.out.println(m); // Imprime valor y número de serie
        }

        // Ordenar la lista de monedas por su valor
        Collections.sort(monedas);

        System.out.println("=====    Monedas después de ordenar =====");
        for (Moneda m : monedas) {
            System.out.println(m); // Imprime valor y número de serie
        }


        //Revisar si estan manejados todos los casos
        System.out.println("==========   Caso 1  ==========");
        Expendedor exp1 = new Expendedor(5);
        Moneda m1 = monedas.remove(0);

        try {
            Comprador c = new Comprador(m1, productosEnum.SUPER8, exp1);
            System.out.println("El sabor del producto es: " + c.getSaborProducto());
            System.out.println("Vuelto: " + c.cuantoVuelto());


        } catch (PagoIncorrectoException e) {
            // Manejo de la excepción de pago incorrecto
            System.out.println(e.getMessage());
        } catch (NoHayProductoException e) {
            // Manejo de la excepción si el producto no está disponible
           System.out.println(e.getMessage());
           System.out.println("Vuelto: " + m1.getValor());
        } catch (PagoInsuficienteException e) {
            // Manejo de la excepción si el pago es insuficiente
            System.out.println(e.getMessage());
            System.out.println("Vuelto: " + m1.getValor());
        }
        
        System.out.println("==========   Caso 2  ==========");
        Expendedor exp2 = new Expendedor(5);
        Moneda m2 = null; //Usamos una moneda null, lo que simula no ingresar ninguna moneda, Porque no usará ninguna moneda de nuestro Array.
        try {
            Comprador c = new Comprador(m2, productosEnum.SPRITE, exp2);
            System.out.println("El sabor del producto es: " + c.getSaborProducto());
            System.out.println("Vuelto: " + c.cuantoVuelto());

        } catch (PagoIncorrectoException e) {
            // Manejo de la excepción de pago incorrecto
            System.out.println(e.getMessage());
        } catch (NoHayProductoException e) {
            // Manejo de la excepción si el producto no está disponible
           System.out.println(e.getMessage());
           System.out.println("Vuelto: " + m2.getValor());
        } catch (PagoInsuficienteException e) {
            // Manejo de la excepción si el pago es insuficiente
            System.out.println(e.getMessage());
            System.out.println("Vuelto: " + m2.getValor());
        }
        
        System.out.println("==========   Caso 3  ==========");
        Expendedor exp3 = new Expendedor(0);
        Moneda m3 = monedas.remove(0);
        try {
            Comprador c = new Comprador(m3, productosEnum.SNICKERS, exp3);
            System.out.println("El sabor del producto es: " + c.getSaborProducto());
            System.out.println("Vuelto: " + c.cuantoVuelto());

        } catch (PagoIncorrectoException e) {
            // Manejo de la excepción de pago incorrecto
            System.out.println(e.getMessage());
        } catch (NoHayProductoException e) {
            // Manejo de la excepción si el producto no está disponible
           System.out.println(e.getMessage());
           System.out.println("Vuelto: " + m3.getValor());
        } catch (PagoInsuficienteException e) {
            // Manejo de la excepción si el pago es insuficiente
            System.out.println(e.getMessage());
            System.out.println("Vuelto: " + m3.getValor());
        }
        
        System.out.println("==========   Caso 4  ==========");
        Expendedor exp4 = new Expendedor(5);
        Moneda m4 = monedas.remove(0);
        try {
            Comprador c = new Comprador(m4, productosEnum.SNICKERS, exp4);
            System.out.println("El sabor del producto es: " + c.getSaborProducto());
            System.out.println("Vuelto: " + c.cuantoVuelto());

        } catch (PagoIncorrectoException e) {
            // Manejo de la excepción de pago incorrecto
            System.out.println(e.getMessage());
        } catch (NoHayProductoException e) {
            // Manejo de la excepción si el producto no está disponible
           System.out.println(e.getMessage());
           System.out.println("Vuelto: " + m4.getValor());
        } catch (PagoInsuficienteException e) {
            // Manejo de la excepción si el pago es insuficiente
            System.out.println(e.getMessage());
            System.out.println("Vuelto: " + m4.getValor());
        }  
        
        System.out.println("==========   Caso 5  ==========");
        Expendedor exp5 = new Expendedor(5);
        Moneda m5 = monedas.remove(0);
        try {
            Comprador c = new Comprador(m5, productosEnum.SUPER8, exp5);
            System.out.println("El sabor del producto es: " + c.getSaborProducto());
            System.out.println("Vuelto: " + c.cuantoVuelto());

        } catch (PagoIncorrectoException e) {
            // Manejo de la excepción de pago incorrecto
            System.out.println(e.getMessage());
        } catch (NoHayProductoException e) {
            // Manejo de la excepción si el producto no está disponible
           System.out.println(e.getMessage());
           System.out.println("Vuelto: " + m5.getValor());
        } catch (PagoInsuficienteException e) {
            // Manejo de la excepción si el pago es insuficiente
            System.out.println(e.getMessage());
            System.out.println("Vuelto: " + m5.getValor());
        }     
        
        System.out.println("==========   Caso 6  ==========");
        Expendedor exp6 = new Expendedor(5);
        Moneda m6 = monedas.remove(0);
        try {
            Comprador c = new Comprador(m6, productosEnum.SPRITE, exp6);
            System.out.println("El sabor del producto es: " + c.getSaborProducto());
            System.out.println("Vuelto: " + c.cuantoVuelto());

        } catch (PagoIncorrectoException e) {
            // Manejo de la excepción de pago incorrecto
            System.out.println(e.getMessage());
        } catch (NoHayProductoException e) {
            // Manejo de la excepción si el producto no está disponible
           System.out.println(e.getMessage());
           System.out.println("Vuelto: " + m6.getValor());
        } catch (PagoInsuficienteException e) {
            // Manejo de la excepción si el pago es insuficiente
            System.out.println(e.getMessage());
            System.out.println("Vuelto: " + m6.getValor());
        }  

        System.out.println("==========   Caso 7  ==========");
        Expendedor exp7 = new Expendedor(5);
        Moneda m7 = monedas.remove(0);
        try {
            Comprador c = new Comprador(m7, productosEnum.COCA, exp7);
            System.out.println("El sabor del producto es: " + c.getSaborProducto());
            System.out.println("Vuelto: " + c.cuantoVuelto());

        } catch (PagoIncorrectoException e) {
            // Manejo de la excepción de pago incorrecto
            System.out.println(e.getMessage());
        } catch (NoHayProductoException e) {
            // Manejo de la excepción si el producto no está disponible
           System.out.println(e.getMessage());
           System.out.println("Vuelto: " + m7.getValor());
        } catch (PagoInsuficienteException e) {
            // Manejo de la excepción si el pago es insuficiente
            System.out.println(e.getMessage());
            System.out.println("Vuelto: " + m7.getValor());
        }  
    }
}


