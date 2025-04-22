import Implementaciones.ImplementacionPila;
import Interfaces.Pila;
import java.util.Random;
import java.util.Scanner;

/* Cree e inicialice las pilas DADA, VALOR, PAR e IMPAR. Cargue desde el teclado la pila DADA.
* Cargue la pila VALOR con al menos un valor. Determine si la cantidad de elementos de la pila DADA
* es par. Si es par, pase el elemento del tope de la pila VALOR a la pila PAR y sino páselo
* a la pila IMPAR. */
public class Main {
    public static void main(String[] args) {

        // Creo e inicializo las pilas solicitadas
        Pila DADA = new ImplementacionPila();
        Pila VALOR = new ImplementacionPila();
        Pila PAR = new ImplementacionPila();
        Pila IMPAR = new ImplementacionPila();
        DADA.InicializarPila();
        VALOR.InicializarPila();
        PAR.InicializarPila();
        IMPAR.InicializarPila();

        // Cargo por teclado la pila DADA
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de elementos que desea en la pila DADA (Mín. 1 | Máx. 100): ");
        int cantElementos = sc.nextInt();
        while (cantElementos < 1 || cantElementos > 100) {
            System.out.println();
            System.out.println("¡Atención!: La cantidad de elementos solicitados es inválida.");
            System.out.print("Ingrese una cantidad de elementos válida (Mín. 1 | Máx. 100):");
            cantElementos = sc.nextInt();
        }
        for (int i = 0; i < cantElementos; i++) {
            System.out.print("Elemento N° " + (i + 1) + ": ");
            DADA.Apilar(sc.nextInt());
            System.out.println("DADA: " + ((ImplementacionPila) DADA).MostrarPila());
        }
    }
}