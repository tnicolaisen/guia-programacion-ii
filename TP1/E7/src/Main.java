import java.util.Scanner;
import Implementaciones.ImplementacionPila;
import Interfaces.Pila;

/* Cree e inicialice las pilas POZO, JUG1 y JUG2. Cargue desde el teclado la pila POZO. Reparta los elementos
de POZO en las pilas JUG1 y JUG2 en forma alternativa. La pila POZO puede contener: Una cantidad par de
elementos, una cantidad impar de elementos, o ningún elemento */
public class Main {
    public static void main(String[] args) {
        // Creo e inicializo las pilas necesarias
        Pila POZO = new ImplementacionPila();
        Pila JUG1 = new ImplementacionPila();
        Pila JUG2 = new ImplementacionPila();
        POZO.InicializarPila();
        JUG1.InicializarPila();
        JUG2.InicializarPila();

        // Solicito la cantidad de elementos deseados y la cargo en POZO
        Scanner sc = new Scanner(System.in);
        System.out.print("¿Cuántos elementos desea que tenga su POZO? (Mín 0/ Máx 100): ");
        int elementosPozo = sc.nextInt();
        while (elementosPozo < 0 || elementosPozo > 100) {
            System.out.println("¡Cantidad de elementos inválida!");
            System.out.print("Ingrese una cantidad de elementos válida para pozo (Mín 0/ Máx 100): ");
            elementosPozo = sc.nextInt();
        } for (int i = 0; i < elementosPozo; i++){
            System.out.print("Elemento " + (i + 1) + ": ");
            POZO.Apilar(sc.nextInt());
        }

        // Imprimo en pantalla el POZO resultante
        System.out.println("------------------------------------------------");
        System.out.println("POZO: " + ((ImplementacionPila) POZO).MostrarPila());
        System.out.println("------------------------------------------------");

        // Verifico qué caso ocurre, y opero en consecuencia
        // NOTA (decido usar a propósito el Switch para poder ejercitarlo)
        int caso;
        if (elementosPozo == 0) {caso = 0;} else {caso = 1;}
        switch (caso){
            case 0:
                System.out.println("Como el pozo no tiene elementos, no se ha repartido ningún elemento hacia ningun jugador.");
                break;
            case 1:
                System.out.println("Se repartirán los elementos...");
                System.out.println();
                for (int i = 0; i < elementosPozo; i++){
                    if (i%2==0){
                        System.out.println("POZO: " + ((ImplementacionPila) POZO).MostrarPila());
                        System.out.println("INFO: Se le da el elemento '" + POZO.Tope() + "' a JUG1.");
                        JUG1.Apilar(POZO.Tope());
                        POZO.Desapilar();
                        System.out.println("POZO: " + ((ImplementacionPila) POZO).MostrarPila());
                        System.out.println("JUG1: " + ((ImplementacionPila) JUG1).MostrarPila());
                        System.out.println();
                    } else {
                        System.out.println("POZO: " + ((ImplementacionPila) POZO).MostrarPila());
                        System.out.println("INFO: Se le da el elemento '" + POZO.Tope() + "' a JUG2.");
                        JUG2.Apilar(POZO.Tope());
                        POZO.Desapilar();
                        System.out.println("POZO: " + ((ImplementacionPila) POZO).MostrarPila());
                        System.out.println("JUG2: " + ((ImplementacionPila) JUG2).MostrarPila());
                        System.out.println();
                    }
                }
                System.out.println("-----------------------------------------------------");
                System.out.println("Resultado final:");
                System.out.println("JUG1: " + ((ImplementacionPila) JUG1).MostrarPila());
                System.out.println("JUG2: " + ((ImplementacionPila) JUG2).MostrarPila());
                System.out.println("-----------------------------------------------------");
                break;
        }
        System.out.println("Fin.");
    }
}