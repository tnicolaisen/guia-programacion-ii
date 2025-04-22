import Implementaciones.Pila;
import Interfaces.InterfazPila;

import java.util.Scanner;

// Cree e inicialice las pilas ORIGEN y DESTINO. Cargue desde el teclado la pila ORIGEN. Pase los elementos de la pila ORIGEN a la pila DESTINO, pero dejándolos en su orden original.
public class Main {
    public static void main(String[] args) {
        // Creo e inicializo las pilas
        Pila ORIGEN = new Pila();
        ORIGEN.InicializarPila();
        Pila DESTINO = new Pila();
        DESTINO.InicializarPila();

        // Cargo ORIGEN por consola
        Scanner teclado = new Scanner(System.in);
        while (!ORIGEN.Llena()){
            System.out.print("Cargue el siguiente elemento de ORIGEN: ");
            ORIGEN.Apilar(teclado.nextInt());
        }
        teclado.close();
        System.out.println("----------------------------------------------------------------");

        // Paso la pila de ORIGEN a DESTINO de la misma forma, usando una pila auxiliar para ello
        Pila AUXILIAR = new Pila();
        AUXILIAR.InicializarPila();
        System.out.println("Llenado de AUXILIAR");
        int contador = 1;
        while (!ORIGEN.Vacia()){
            System.out.print("Paso " + contador + ": ");
            AUXILIAR.Apilar(ORIGEN.Tope());
            ORIGEN.Desapilar();
            contador++;
            System.out.println("ORIGEN: " + ORIGEN.MostrarPila());
            System.out.println("AUXILIAR: " + AUXILIAR.MostrarPila());
            System.out.println("--------------------");
        }
        contador = 1;
        System.out.println("---------------------------------------------------");
        System.out.println("Llenado de DESTINO");
        while (!AUXILIAR.Vacia()){
            System.out.print("Paso " + contador + ": ");
            DESTINO.Apilar(AUXILIAR.Tope());
            AUXILIAR.Desapilar();
            contador++;
            System.out.println("AUXILIAR: " + AUXILIAR.MostrarPila());
            System.out.println("DESTINO: " + DESTINO.MostrarPila());
            System.out.println("--------------------");
        }
    }
}