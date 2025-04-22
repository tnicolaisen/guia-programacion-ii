import Implementaciones.ImplementacionPila;
import Interfaces.Pila;
import java.util.Scanner;

/* Cree e inicialice la pila DADA. Cargue desde el teclado DADA con al menos un elemento.
Pase el último elemento (el de la base) de DADA a su primera posición (tope), dejando los restantes en el mismo orden.*/
public class Main {
    public static void main(String[] args) {

        // Creo, inicializo, y cargo DADA
        Pila DADA = new ImplementacionPila();
        DADA.InicializarPila();

        Scanner sc = new Scanner(System.in);
        System.out.print("¿Cuántos elementos quiere que tenga su pila? (Mín: 1/Máx. 100): ");
        int cantElementos = sc.nextInt();
        while (cantElementos > 100 || cantElementos < 1) {
            System.out.println("¡Cantidad de elementos introducida incorrecta!");
            System.out.print("Vuelva a introducir la cantidad de elementos deseada (Mín: 1/Máx. 100):");
            cantElementos = sc.nextInt();
        }
        System.out.println("Cargando la pila...");

        for (int i = 0; i < cantElementos; i++) {
            System.out.print("Elemento " + (i + 1) + ":");
            DADA.Apilar(sc.nextInt());
        }

        // Muestro la pila DADA cargada
        System.out.println("------------------------------------------------------");
        System.out.println("DADA original: " + ((ImplementacionPila)DADA).MostrarPila());
        System.out.println("------------------------------------------------------");

        // Similar a la resolucion del ejercicio anterior, nada mas que ahora dejo el la base en el tope.
        Pila pilaAux = new ImplementacionPila();
        pilaAux.InicializarPila();
        for(int i = 0; i < cantElementos - 1; i++) {
            pilaAux.Apilar(DADA.Tope());
            DADA.Desapilar();
        }
        int elementoAux = DADA.Tope();
        DADA.Desapilar();
        for(int i = 0; i < cantElementos - 1; i++) {
            DADA.Apilar(pilaAux.Tope());
            pilaAux.Desapilar();
        }
        DADA.Apilar(elementoAux);

        // Muestro la DADA resultante
        System.out.println("------------------------------------------------------");
        System.out.println("DADA resultante: " + ((ImplementacionPila)DADA).MostrarPila());
        System.out.println("------------------------------------------------------");
    }
}