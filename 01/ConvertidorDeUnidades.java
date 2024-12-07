import java.util.Scanner; //se importa la clase 'Scanner' para leer entrdasdel usuario.

public class ConvertidorDeUnidades { // Se crea la clase 'ConvertidorDeUnidades' para trabajar en el codigo.

    public static void main(String[] args) {
        //Creacion de variables.
        Scanner scanner = new Scanner(System.in); //Se crea el objeto 'scanner' para leer entradas.
        int opcion; // Esta variable almacena la opcion que se elige.
        
        // Creacion del menu.
        do {
            System.out.println("----- Convertidor de Unidades -----");
            System.out.println("1. Longitud (Metro a Centímetro y Pulgada)");
            System.out.println("2. Masa (Kilogramo a Libra y Gramo)");
            System.out.println("3. Velocidad (Metro/segundo a Kilómetros/hora)");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            
            // Estructura para seleccionar una opcion.
            switch (opcion) {
                case 1:
                    convertirLongitud(scanner);
                    break;
                case 2:
                    convertirMasa(scanner);
                    break;
                case 3:
                    convertirVelocidad(scanner);
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo."); // No es valida la opcion.
            }
        } while (opcion != 4);

        scanner.close();
    }
    
    // Estructura para la conversion de Unidades.
    private static void convertirLongitud(Scanner scanner) { //Longitud
        System.out.print("Ingrese la longitud en metros: ");
        double metros = scanner.nextDouble();
        double centimetros = metros * 100; // 1 metro = 100 centímetros
        double pulgadas = metros * 39.3701; // 1 metro = 39.3701 pulgadas

        System.out.printf("%.2f metros son %.2f centímetros.\n", metros, centimetros);
        System.out.printf("%.2f metros son %.2f pulgadas.\n", metros, pulgadas);
    }

    private static void convertirMasa(Scanner scanner) { // Masa
        System.out.print("Ingrese la masa en kilogramos: ");
        double kilogramos = scanner.nextDouble();
        double libras = kilogramos * 2.20462; // 1 kilogramo = 2.20462 libras
        double gramos = kilogramos * 1000; // 1 kilogramo = 1000 gramos

        System.out.printf("%.2f kilogramos son %.2f libras.\n", kilogramos, libras);
        System.out.printf("%.2f kilogramos son %.2f gramos.\n", kilogramos, gramos);
    }

    private static void convertirVelocidad(Scanner scanner) { // Velocidad
        System.out.print("Ingrese la velocidad en metros/segundo: ");
        double metrosPorSegundo = scanner.nextDouble();
        double kilometrosPorHora = metrosPorSegundo * 3.6; // 1 m/s = 3.6 km/h

        System.out.printf("%.2f metros/segundo son %.2f kilómetros/hora.\n", metrosPorSegundo, kilometrosPorHora);
    }
}