import java.util.Scanner;
import Implementaciones.ImplementacionPila;
import Interfaces.Pila;

/* Cree e inicialice la pila DADA. Cargue desde el teclado la pila DADA con almenos un  elemento. Pase el primer elemento (tope) de la pila DADA  asu última
prosición (base), dejando los elementos restantes en su ubicación original. */

public class Main {
    public static void main(String[] args) {
        // Inicializo la pila DADA
        Pila DADA = new ImplementacionPila();
        DADA.InicializarPila();

        // Lleno la pila con 10 elementos
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i<10; i++){
            DADA.Apilar(sc.nextInt());
            System.out.println(((ImplementacionPila)DADA).MostrarPila());
        }
        sc.close();

        System.out.println("--------------------------------------------------");
        System.out.println("DADA original: " + ((ImplementacionPila)DADA).MostrarPila());

        // Guardo el primer elemento de la pila en un INT auxiliar, y el resto, lo guardo en otra pila auxiliar
        int topeDADA = DADA.Tope();
        DADA.Desapilar();
        Pila pilaAux = new ImplementacionPila();
        pilaAux.InicializarPila();
        while (!DADA.EstaVacia()){
            pilaAux.Apilar(DADA.Tope());
            DADA.Desapilar();
        }

        // Vuelvo a armar DADA, pero con el tope ahora primero
        DADA.Apilar(topeDADA);
        for (int i = 0; i < 9; i++){
            DADA.Apilar(pilaAux.Tope());
            pilaAux.Desapilar();
        }

        // Imprimo la pila DADA
        System.out.println("DADA nueva: " + ((ImplementacionPila)DADA).MostrarPila());
    }
}