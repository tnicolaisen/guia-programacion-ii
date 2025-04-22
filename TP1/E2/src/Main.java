import Implementaciones.implenetacionPila;
import Interfaces.Pila;
import java.util.Scanner;

// Cree las pilas ORIGEN y DESTINO e inicialícelas. Cargue desde el teclado la pila ORIGEN. Pase todos los elementos de la pila ORIGEN a DESTINO.
public class Main {
    public static void main(String[] args) {
        Pila ORIGEN = new implenetacionPila();
        ORIGEN.inicializarPila();
        Pila DESTINO = new implenetacionPila();
        DESTINO.inicializarPila();

        // Cargo ORIGEN por teclado
        Scanner sc = new Scanner(System.in);
        while (!ORIGEN.estaLlena()) {
            System.out.print("Ingrese el siguiente valor de la pila: ");
            ORIGEN.apilar(sc.nextInt());
        }
        System.out.println("---------------------------------------------------------------");
        sc.close();

        // Cargo los elementos en orden
        int contador = 1;
        while (!ORIGEN.estaVacia()) {
            DESTINO.apilar(ORIGEN.tope());
            ORIGEN.desapilar();
            System.out.println("Paso " + contador + ":");
            System.out.println("ORIGEN: " + ORIGEN.mostrarPila());
            System.out.println("DESTINO: " + DESTINO.mostrarPila());
            System.out.println("------------------------------");
            contador++;
        }
    }
}