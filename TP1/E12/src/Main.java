import Implementaciones.ImplementacionPila;
import Interfaces.Pila;
import Utilidades.HerramientasPila;
import java.util.Scanner;
/*
12: Cree e inicialice las pilas MOD y DADA. Cargue desde teclado la pila DADA y cargue la pila MOD con al menos un
elemento. Elimine de la pila DADA todos los elementos que sean iguales al tope de la pila MOD.
 */
public class Main {
    public static void main(String[] args) {
        // Creo e inicializo las pilas
        Pila MOD = new ImplementacionPila();
        Pila DADA = new ImplementacionPila();
        MOD.InicializarPila();
        DADA.InicializarPila();

        // Cargo ambas pilas
        System.out.println("Cargue la pila DADA:");
        HerramientasPila.CargarPila(DADA, false);
        System.out.println("Cargue la pila MOD:");
        HerramientasPila.CargarPila(MOD, true);

        // Imprimo DADA antes del proceso
        System.out.println("DADA previa: " + HerramientasPila.MostrarStringPila(DADA));

        /* Con el uso de una pila auxiliar, voy recorriendo la pila DADA y eliminando los objetos que sean iguales al
        tope de MOD. */
        Pila AUX = new ImplementacionPila();
        AUX.InicializarPila();
        while (!DADA.EstaVacia()){
            if (DADA.Tope() == MOD.Tope() ){
                DADA.Desapilar();
            } else {
                AUX.Apilar(DADA.Tope());
                DADA.Desapilar();
            }
        }
        while (!AUX.EstaVacia()){
            DADA.Apilar(AUX.Tope());
            AUX.Desapilar();
        }

        // Imprimo ahora todas las pilas restantes (excepto la auxiliar)
        System.out.println("DADA posterior: " + HerramientasPila.MostrarStringPila(DADA));
        System.out.println("MOD: " + HerramientasPila.MostrarStringPila(MOD));
    }
}