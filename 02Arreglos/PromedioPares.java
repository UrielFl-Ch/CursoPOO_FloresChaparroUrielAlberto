import java.util.Scanner; // Importar la clase 'Scanner' para la lectura de entrada del usuario.

public class PromedioPares { // Definicion de la clase a utilizar.
    public static void main(String[] args) { // Inicio del metodo principal
        
        // Variables.
        Scanner scanner = new Scanner(System.in); // Creacion del objeto 'scanner' para lectura de la entrada del usuario.
        int[] numeros = new int[10]; // Se crea el array con el nombre 'numeros' de tipo entero con almacenamiento de 10 valores.
        int suma = 0; // Variable para almacenar la suma de los numeros en posicion par del array.
        int contadorPares = 0; // Almacena la cantidad de numeros en posicion par del array 
        
        // Lectura de los numeros ingresados.
        System.out.println("Ingrese 10 numeros enteros: "); // Despliegue del mensaje para ingresar numeros.
        for (int i = 0; i < 10; i++) { // Se agrega un bucle para ingresar 10 numeros.
            while (true) { // Condicion para la validacion que el numero introducion sea de tipo entero.
                System.out.println("Numero " + (i + 1 ) + ": "); // Mensaje para ingresar los numeros del 1 al 10 aunque se conoce que el array es de 0 a 9.
                if (scanner.hasNextInt()) { // Verifica el tipo 'entero' del numero.
                    numeros[i] = scanner.nextInt(); // Si el numero es 'true' lo guarda en el array. 
                    break; // Salir del bucle si se introduce un número válido.
                } else {
                    System.out.println("Por favor, introduce un numero entero valido."); // En caso de que no sea valido el numero, desglosa el mensaje.
                    scanner.next(); // Limpiar el buffer.
                }
            }    
        }

        // Calcular la suma y los numeros en posiciones pares.
        System.out.print("Los números en posiciones pares son: "); // Impresion de los numeros en posicion par.
        for (int i = 0; i < numeros.length; i += 2) { // Bucle para las posiciones pares del array (0,2,4,6,8).
            suma += numeros[i]; // Calcula la suma de los numeros pares
            contadorPares++; // Calcula cantidad de numeros pares.
            System.out.print(numeros[i] + " "); // Imprimir solo los números en posiciones pares
        }

        // Calculo del promedio.
        if (contadorPares > 0) {
            if (suma != 0) { // Condicion para poder calcular el promedio.
                double promedio = (double) suma / contadorPares;
                System.out.println("El promedio de los números en posiciones pares es: " + promedio);
            } else {
                System.out.println("No hay números en posiciones pares para calcular el promedio.");
            }
        }

        scanner.close(); // Cierre del objeto para finalizar.

    }     
}