import java.util.Scanner; // Se importa la clase 'scanner' para leer las netradas del usuario.

public class Promedio { // Se crea la clase publca 'PromedioPositivosNegativos' en la que se trabajara.

    public static void main(String[] args) {  // Entrada del programa, Es el metodo principal para ejecutar el codigo. 

         // Variables.
        Scanner scanner = new Scanner(System.in); // Se crea el objeto 'scanner' para lectura de entradas del usuario.
        int[] numeros = new int[10]; // Creacion del array con nombre'numeros' de tipo entero y con longitud de 10 entradas.
        int sumaPositivos = 0, sumaNegativos = 0; // Variables para almacenar la suma de positivos y suma de negativos.
        int contadorPositivos = 0, contadorNegativos = 0; // Variable que almacena el contador total de positivos y negativos.

        // Lectura de 10 números enteros
        for (int i=0; i < 10; i++) { // Bucle de iteracion de 10 veces que solicita un numero en cada ocasion.
            while (true) { // Condicion para la validacion que el numero introducion sea de tipo entero.
                System.out.println("Introduce el numero " + (i + 1) + ": "); // Impresion para introducir el numero.
                if (scanner.hasNextInt()) { // Verifica el tipo 'entero' del numero.
                    numeros[i] = scanner.nextInt(); // Si el numero es 'true' lo guarda en el array. 
                    break; // Salir del bucle si se introduce un número válido.
                } else {
                    System.out.println("Por favor, introduce un numero entero valido."); // En caso de que no sea valido el numero, desglosa el mensaje.
                    scanner.next(); // Limpiar el buffer.
                }
                
            }
        }

        // Para calcular sumas y contadores un nuevo bucle que verifique la cantidad de positivos y negativos y sus sumas.
        for (int numero : numeros) {
            if (numero > 0) {
                sumaPositivos += numero;
                contadorPositivos++;
            } else if (numero < 0) {
                sumaNegativos += numero;
                contadorNegativos++;
            }
        }

        // Calcular promedios, indica que si hay numeros positivos o negativos se realice el calculo, de lo contrario se le asigna un 0.
        double promedioPositivos = (contadorPositivos > 0) ? (double) sumaPositivos / contadorPositivos : 0;
        double promedioNegativos = (contadorNegativos > 0) ? (double) sumaNegativos / contadorNegativos : 0;

        // Se imprimen los resultados.
        System.out.println("Promedio de numeros positivos: " + promedioPositivos);
        System.out.println("Promedio de numeros negativos: " + promedioNegativos);

        scanner.close(); //se cierra el objeto para finalizar.
    }   
}