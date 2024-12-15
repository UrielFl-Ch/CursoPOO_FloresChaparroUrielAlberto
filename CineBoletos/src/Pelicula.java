/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Pc
 */
import java.io.Serializable; //con esto los objetos de la clse 'pelicula' se pueden serializar

public class Pelicula implements Serializable { // publico para su facil acceso desde otras clases
    private final String nombre; //nombre almacebara el nombre de la pelicula

    public Pelicula(String nombre) { // Definiendo el contructor
        this.nombre = nombre;
    }

    public String getNombre() { // Devuelve el valor de 'nombre'
        return nombre;
    }
}