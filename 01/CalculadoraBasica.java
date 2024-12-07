import java.util.Scanner;
//se importa la clase 'scanner' para leer entrada.

public class CalculadoraBasica {
    //Se define la clase 'CalculadoraBasica' para trabajar en ella.
    public static void main(String[] args) {

        //Se definen las variables 'scanner' y 'opcion' para guardar los resultados de cada operacion
        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        //En este apartado se crea el menu, indicando que opcion corresponde a cada operacion.
        // Se incluye una opcion para salir del programa
        do {
            System.out.println("Seleccione una operación:");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicación");
            System.out.println("4. División");
            System.out.println("5. División con residuo");
            System.out.println("6. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            
            // La condicionante de opcion 1 al 5 entras a operaciones 
            //y te solicita los numeros a operar
            if (opcion >= 1 && opcion <= 5) {
                System.out.print("Ingrese el primer número: ");
                double num1 = scanner.nextDouble();
                System.out.print("Ingrese el segundo número: ");
                double num2 = scanner.nextDouble();
                
                //se evalua con 'switch' cada posible caso y el 'break' es para detenerlo en cada 'case'
                switch (opcion) {
                    case 1:
                        System.out.println("Resultado: " + (num1 + num2));
                        break;
                    case 2:
                        System.out.println("Resultado: " + (num1 - num2));
                        break;
                    case 3:
                        System.out.println("Resultado: " + (num1 * num2));
                        break;
                    //En caso de division se evalua la division por cero, como se solicito en carta descriptiva    
                    case 4:
                        if (num2 != 0) {
                            System.out.println("Resultado: " + (num1 / num2));
                        } else {
                            System.out.println("Error: División por cero.");
                        }
                        break;
                    //En la division con residuo se puede conocer el resultado y el residuo.    
                    case 5:
                        if (num2 != 0) {
                            System.out.println("Resultado: " + (num1 / num2) + " El Residuo es: " + (num1 % num2));
                        } else {

                            System.out.println("Error: División por cero.");
                        }
                        break;
                }
            // En caso de teclear otra opcion despues del 6, se hace invalida    
            } else if (opcion != 6) {
                System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 6);
        
        //Para cerrar el programa se activa la opcion 6 y despliega mensaje de salida.
        System.out.println("Gracias por usar la calculadora. ¡Hasta luego!");
        scanner.close();
    }
}