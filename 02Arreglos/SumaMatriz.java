import java.util.Scanner; // Se importa la clase ´Scanner' para la lectura de entrada del usuario

public class SumaMatriz { //Se define la clase 'SumaMatriz'
     public static void main(String[] args) { // Metodo principal para la netrada del codigo.
        Scanner scanner = new Scanner(System.in); // Se crea el objeto 'scanner' para lectura de entradas.
        
        // Definir las dimensiones de las matrices
        final int FILAS = 3;
        final int COLUMNAS = 3;
        
        // Declaracion de las matrices bidimensionales.
        int[][] A = new int[FILAS][COLUMNAS];
        int[][] B = new int[FILAS][COLUMNAS];
        int[][] S = new int[FILAS][COLUMNAS];
        
        // Leer la matriz A
        System.out.println("Ingrese los elementos de la matriz A (3x3):");
        leerMatriz(scanner, A);
        
        // Leer la matriz B
        System.out.println("Ingrese los elementos de la matriz B (3x3):");
        leerMatriz(scanner, B);
        
        // Sumar las matrices A y B
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                S[i][j] = A[i][j] + B[i][j];
            }
        }
        
        // Mostrar las matrices
        System.out.println("Matriz A:");
        mostrarMatriz(A);
        
        System.out.println("Matriz B:");
        mostrarMatriz(B);
        
        System.out.println("Matriz S (A + B):");
        mostrarMatriz(S);
        
        scanner.close();
    }
    
    // Método para leer una matriz
    private static void leerMatriz(Scanner scanner, int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }
    }
    
    // Método para mostrar una matriz
    private static void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }
}