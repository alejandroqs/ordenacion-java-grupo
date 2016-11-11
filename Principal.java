package ordenar_vector;

import java.util.Scanner;

public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DatosEstadisticos de = new DatosEstadisticos();
        Ordenar1Vector ov = new Ordenar1Vector();
        
        Scanner reader = new Scanner(System.in);
        System.out.println("Introdizca tamaño del vector: ");
        int tam = reader.nextInt();
        
        int [] v = GeneraCaso.generaVector(tam, true);
        
        ov.ordena(v, de);
        
        System.out.print("El tiempo de ejecución del algoritmo "
                +ov.nombreMetodo()+" en Java para "+tam+" numeros es de "
                +de.dameTiempo()+" segundos.");
    }
    
}