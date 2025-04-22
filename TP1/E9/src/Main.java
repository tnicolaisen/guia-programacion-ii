import Implementaciones.ImplementacionPila;
import Interfaces.Pila;
import java.util.Scanner;

/*
Cree e inicialice las pilas LIMITE, DADA, MAY, y MEN. Cargue desde teclado la pila DADA y
cargue la pila LIMITE con al menos un elemento válido. Pase los elementos de la pila DADA
que sean mayores o iguales al tope de LIMITE, a la pila MAY, y los elementos menores a la
pila MEN.
 */
public class Main {

    public static String MostrarPila(Pila pila){
        // Creo una pila auxiliar y el String que se devolverá
        Pila auxiliar = new ImplementacionPila();
        auxiliar.InicializarPila();
        String stringPila = "";

        while (!pila.EstaVacia()) {
            stringPila = stringPila + " " + pila.Tope();
            auxiliar.Apilar(pila.Tope());
            pila.Desapilar();
        }
        while (!auxiliar.EstaVacia()) {
            pila.Apilar(auxiliar.Tope());
            auxiliar.Desapilar();
        }
        return stringPila;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int elemento;

        // Creo e inicializo las pilas solicitadas
        Pila LIMITE = new ImplementacionPila();
        Pila DADA = new ImplementacionPila();
        Pila MAY = new ImplementacionPila();
        Pila MEN = new ImplementacionPila();
        LIMITE.InicializarPila();
        DADA.InicializarPila();
        MAY.InicializarPila();
        MEN.InicializarPila();

        // Cargo DADA
        System.out.println("-------------------------------------------------------------");
        System.out.println("CARGA DE DADA");
        System.out.println("Ingrese los elementos de DADA (finalizar con -1):");
        while ((elemento = sc.nextInt()) != -1){DADA.Apilar(elemento);}
        System.out.println("-------------------------------------------------------------");
        System.out.println("DADA: " + MostrarPila(DADA));
        System.out.println("DADA: " + MostrarPila(DADA));
        System.out.println();

        // Cargo límte (se asume que por teclado)
        System.out.println("-------------------------------------------------------------");
        System.out.println("CARGA DE LIMITE");
        System.out.println("Ingrese los elementos de LIMITE. (finalizar con -1):");
        System.out.println("NOTA: El tope de esta pila sera seleccionado como limite para el ejercicio.");
        while ((elemento = sc.nextInt()) != -1){LIMITE.Apilar(elemento);}
        System.out.println("-------------------------------------------------------------");
        System.out.println("LIMITE (pila): " + MostrarPila(LIMITE));
        System.out.println("Tope de LIMITE: " + LIMITE.Tope());
        System.out.println();

        while (!DADA.EstaVacia()){
            if (DADA.Tope() >= LIMITE.Tope()){
                MAY.Apilar(DADA.Tope());
                DADA.Desapilar();
            } else {
                MEN.Apilar(DADA.Tope());
                DADA.Desapilar();
            }
        }
        System.out.println("/////////////////////////////////////////////////");
        System.out.println("MAY: " + MostrarPila(MAY));
        System.out.println("MEN: " + MostrarPila(MEN));
    }
}