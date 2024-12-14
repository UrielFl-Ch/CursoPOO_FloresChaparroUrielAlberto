/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;
/**
 *
 * @author Pc
 */
public class SueldoEmpleado {
   private static final int MAX_EMPLEADOS = 100;
    private static final Empleado[] empleados = new Empleado[MAX_EMPLEADOS];
    private static int contadorEmpleados = 0;

    public static void main(String[] args) {
       try (Scanner scanner = new Scanner(System.in)) {
           while (true) {
               System.out.println("Ingrese ID del empleado (0 para salir): ");
               int id = scanner.nextInt();
               if (id == 0) break;
               
               scanner.nextLine(); // Limpiar el buffer
               System.out.println("Ingrese nombre del empleado: ");
               String nombre = scanner.nextLine();
               
               System.out.println("Ingrese puesto del empleado (Empleado/Supervisor): ");
               String puesto = scanner.nextLine();
               
               if (validarDatos(id, nombre)) {
                   System.out.println("Ingrese horas extras diurnas: ");
                   int horasExtrasDiurnas = scanner.nextInt();
                   System.out.println("Ingrese horas extras nocturnas: ");
                   int horasExtrasNocturnas = scanner.nextInt();
                   
                   Empleado empleado = new Empleado(id, nombre, puesto);
                   empleado.calcularSueldo(horasExtrasDiurnas, horasExtrasNocturnas);
                   empleados[contadorEmpleados++] = empleado;
                   
                   System.out.println("Sueldo quincenal calculado para " + nombre + ": " +
                           empleado.getSueldoQuincenal()[0]);
               } else {
                   System.out.println("Datos inválidos. Intente de nuevo.");
               }
           }
       }
    }

    private static boolean validarDatos(int id, String nombre) {
        return (id > 0 && esIdUnico(id) && !nombre.isEmpty() && esNombreUnico(nombre));
    }

    private static boolean esIdUnico(int id) {
        for (int i = 0; i < contadorEmpleados; i++) {
            if (empleados[i].getIdEmpleado() == id) {
                return false; // ID ya existe
            }
        }
        return true; // ID es único
    }

    private static boolean esNombreUnico(String nombre) {
        for (int i = 0; i < contadorEmpleados; i++) {
            if (empleados[i].getNombreEmpleado().equalsIgnoreCase(nombre)) {
                return false; // Nombre ya existe
            }
        }
        return true; // Nombre es único
    }

}
