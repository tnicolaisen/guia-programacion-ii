package Utilidades;
import Interfaces.PilaTDA;
import Implementaciones.ImplementacionPila;
import java.util.Scanner;

public class HerramientasPila {

    static Scanner sc = new Scanner(System.in);

    /**
     * Genera un String con los elementos pertenecientes a una pila para que sea mas legible por consola
     * @param pila La pila que se pretende mostrar
     * @return String con los elementos pertenecientes a la pila separados por un espacio.
     */
    public static String StringPila(PilaTDA pila){
        // Creo una pila auxiliar y el String que se devolverá
        PilaTDA auxiliar = new ImplementacionPila();
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
     *
     * @param pila  La pila que se pretende cargar.
     * @param puedeEstarVacia Determina si la pila puede estar vacía o no.
     */
    public static void CargarPila(PilaTDA pila, boolean puedeEstarVacia){
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
    public static int LongitudPila(PilaTDA pila){
        //Creo una pila auxiliar para almacenar los valores de la pila original, y cuento su longitud
        PilaTDA auxiliar = new ImplementacionPila();
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

    /**
     * Compara dos pilas distintas y devuelve si las pilas son iguales (en orden y contenido) o no.
     * @param pila1 Pila 1 a comparar.
     * @param pila2 Pila 2 a comparar.
     * @return Valor booleano que refiere a si ambas pila son iguales.
     */
    public static boolean PilasIguales(PilaTDA pila1, PilaTDA pila2){
        // Primero verifico que las pilas tengan la misma longitud (de caso contrario, claramente ambas pilas son diferentes).
        if (LongitudPila(pila1) != LongitudPila(pila2)) {return false;}
        // Luego, usando dos pilas auxiliares para guardar los datos, voy evaluando uno a uno.
        else {
            boolean iguales = true;
            PilaTDA auxiliar1 = new ImplementacionPila();
            PilaTDA auxiliar2 = new ImplementacionPila();
            auxiliar1.InicializarPila();
            auxiliar2.InicializarPila();
            while (!pila1.EstaVacia()) {
                if (pila1.Tope() != pila2.Tope()) {
                    iguales = false;
                }
                auxiliar1.Apilar(pila1.Tope());
                auxiliar2.Apilar(pila2.Tope());
                pila1.Desapilar();
                pila2.Desapilar();
            }
            while (!auxiliar1.EstaVacia()){
                pila1.Apilar(auxiliar1.Tope());
                pila2.Apilar(auxiliar2.Tope());
                auxiliar1.Desapilar();
                auxiliar2.Desapilar();
            }
            return iguales;
        }
    }
}
