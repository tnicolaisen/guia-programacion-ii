import Interfaces.Pila;
import Implementaciones.ImplementacionPila;
import java.util.Scanner;

// Cree e inicialice la pila DADA. Cargue desde el teclado DADA. Inviert los datos cargados en DADA de manera que mantenga lso elementos cargados originalmente en ella, pero en orden inverso.
public class Main {
    public static void main(String[] args) {
        // Creo la pila DADA y la inicializo
        Pila DADA = new ImplementacionPila();
        DADA.InicializarPila();

        // Cargo datos en la pila dada
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            DADA.Apilar(sc.nextInt());
            System.out.println(((ImplementacionPila) DADA).MostrarPila());
        }

        // Descargo la pila en un array auxiliar y le introduzco los datos de la manera solicitada
        System.out.println("----------------------------------------------");
        System.out.println("DADA original: " + ((ImplementacionPila) DADA).MostrarPila());
        int[] aux = new int[10];
        for (int i = 0; i < 10; i++) {
            aux[i] = DADA.Tope();
            DADA.Desapilar();
        } for (int i = 0; i < 10; i++) {
            DADA.Apilar(aux[i]);
        }
        System.out.println("DADA invertida: " + ((ImplementacionPila) DADA).MostrarPila());
    }
}