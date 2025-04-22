package Utilidades;
import Interfaces.Pila;
import Implementaciones.ImplementacionPila;
import java.util.Scanner;

public class HerramientasPila {

    static Scanner sc = new Scanner(System.in);

    /**
     * Genera un String con los elementos pertenecientes a una pila para que sea mas legible por consola
     * @param pila La pila que se pretende mostrar
     * @return String con los elementos pertenecientes a la pila separados por un espacio.
     */
    public static String MostrarStringPila(Pila pila){
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

    /**
     * Permite al usuario cargar una pila hasta que se pase como valor "-1".
     * @param pila  La pila que se pretende cargar.
     * @param puedeEstarVacia Determina si la pila puede estar vacía o no.
     */
    public static void CargarPila(Pila pila, boolean puedeEstarVacia){
        int elemento;
        if (puedeEstarVacia) {while ((elemento = sc.nextInt()) != -1) {pila.Apilar(elemento);}}
        else {
            while ((elemento = sc.nextInt()) == -1) {System.out.println("INFO: La pila no puede estar vacia. Intoduzca al menos un elemento.");}
            pila.Apilar(elemento);
            while ((elemento = sc.nextInt()) != -1) {pila.Apilar(elemento);}
        }
    }

    /**
     * Devuelve el valor entero de la longitud de una pila
     * @param pila Pila a evaluar
     * @return Longitud de la pila
     */
    public static int LongitudPila(Pila pila){
        //Creo una pila auxiliar para almacenar los valores de la pila original, y cuento su longitud
        Pila auxiliar = new ImplementacionPila();
        auxiliar.InicializarPila();
        int longitud = 0;
        while(!pila.EstaVacia()){
            auxiliar.Apilar(pila.Tope());
            pila.Desapilar();
            longitud++;
        }
        while (!auxiliar.EstaVacia()){
            pila.Apilar(auxiliar.Tope());
            auxiliar.Desapilar();
        }
        return longitud;
    }
}
