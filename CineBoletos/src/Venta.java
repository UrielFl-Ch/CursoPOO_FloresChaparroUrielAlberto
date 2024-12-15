/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Pc
 */
import java.io.Serializable;
import java.util.ArrayList;

public class Venta implements Serializable {
    private final ArrayList<Sala> salas;

    public Venta() {
        salas = new ArrayList<>();
        salas.add(new Sala("Normal"));
        salas.add(new Sala("3D"));
    }

    public double calcularPrecio(int categoria, String tipoSala, boolean esMiércoles, boolean esAntesDeLas18) {
        double precio = 0.0;
        if (tipoSala.equals("3D")) {
            precio = 80.0;
        } else {
            if (esMiércoles) {
                precio = (categoria == 1 || categoria == 2) ? 42.0 : 45.0;
            } else {
                precio = esAntesDeLas18 ? 52.0 : 65.0;
            }
        }
        return precio;
    }

    public void registrarVenta(String tipoSala, double precio) {
        for (Sala sala : salas) {
            if (sala.getTipo().equals(tipoSala)) {
                sala.venderBoleto(precio);
                break;
            }
        }
    }

    public ArrayList<Sala> getSalas() {
        return salas;
    }
}