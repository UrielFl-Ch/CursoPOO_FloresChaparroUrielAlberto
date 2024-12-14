/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Pc
 */
public class Empleado {
  private final int id_empleado;
    private final String nombre_empleado;
    private final String puesto;
    private final double[] sueldo_quincenal;

    public Empleado(int id_empleado, String nombre_empleado, String puesto) {
        this.id_empleado = id_empleado;
        this.nombre_empleado = nombre_empleado;
        this.puesto = puesto;
        this.sueldo_quincenal = new double[2]; // Para almacenar dos quincenas
    }

    public int getIdEmpleado() {
        return id_empleado;
    }

    public String getNombreEmpleado() {
        return nombre_empleado;
    }

    public String getPuesto() {
        return puesto;
    }

    public double[] getSueldoQuincenal() {
        return sueldo_quincenal;
    }

    public void calcularSueldo(int horasExtrasDiurnas, int horasExtrasNocturnas) {
        if (puesto.equalsIgnoreCase("Empleado")) {
            double sueldoBase = 5000;
            double pagoHorasExtras = (horasExtrasDiurnas * 50) + (horasExtrasNocturnas * 60);
            sueldo_quincenal[0] = sueldoBase + pagoHorasExtras; // Quincena 1
            sueldo_quincenal[1] = sueldo_quincenal[0]; // Quincena 2 (puedes cambiarlo si es necesario)
        } else if (puesto.equalsIgnoreCase("Supervisor")) {
            double sueldoBase = 8000;
            double deducciones = sueldoBase * (0.002 + 0.001 + 0.0016);
            double sueldoConDeducciones = sueldoBase - deducciones; // Sueldo después de deducciones
            double pagoHorasExtras = (horasExtrasDiurnas * 50) + (horasExtrasNocturnas * 60);
            sueldo_quincenal[0] = sueldoConDeducciones + pagoHorasExtras; // Quincena 1
            sueldo_quincenal[1] = sueldo_quincenal[0]; // Quincena 2 (puedes cambiarlo si es necesario)
        }
    }
}
