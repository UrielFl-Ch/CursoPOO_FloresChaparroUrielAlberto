/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Pc
 */
import java.io.Serializable;

public class Sala implements Serializable { // Definicion de clase sala
    private final String tipo; // Variables
    private int boletosVendidos;
    private double totalRecaudado;

    public Sala(String tipo) {  //Constructor 
        this.tipo = tipo;
        this.boletosVendidos = 0;  //inicializacion de variables
        this.totalRecaudado = 0.0;
    }

    public void venderBoleto(double precio) {
        boletosVendidos++;  // invrementa el valor de boletos vendidoa
        totalRecaudado += precio;
    }

    public int getBoletosVendidos() {
        return boletosVendidos; //devuelve el valor de la variable.
    }

    public double getTotalRecaudado() { //Devuelve el valor de esa variable.
        return totalRecaudado;
    }

    public String getTipo() {
        return tipo;
    }
}