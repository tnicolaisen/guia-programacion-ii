import Implementaciones.ImplementacionPila;
import Interfaces.Pila;
import Utilidades.HerramientasPila;
/*
13: Cree e inicialice las pilas MOD y DADA. Cargue desde teclado las pilas DADA y MOD. Elimine de la pila DADA todos los
elementos que sean iguales a los elementos de la pila MOD.
 */
public class Main {
    public static void main(String[] args) {

        // Creo e inicializo las pilas
        Pila DADA = new ImplementacionPila();
        Pila MOD = new ImplementacionPila();
        DADA.InicializarPila();
        MOD.InicializarPila();

        // Cargo ambas pilas
        System.out.println("Cargue la pila DADA:");
        HerramientasPila.CargarPila(DADA, false);
        System.out.println("Cargue la pila MOD:");
        HerramientasPila.CargarPila(MOD, true);

        System.out.println("DADA pre: " + HerramientasPila.MostrarStringPila(DADA));
        System.out.println("MOD pre: " + HerramientasPila.MostrarStringPila(MOD));

        /* Voy recorriendo MOD verificando que cada elemento de DADA sea o no igual al tope de MOD. Para ello, uso dos
        pilas auxiliares. */

        Pila AUXDADA = new ImplementacionPila();
        Pila AUXMOD = new ImplementacionPila();
        AUXDADA.InicializarPila();
        AUXMOD.InicializarPila();

        while (!MOD.EstaVacia()){
            while (!DADA.EstaVacia()){
                if (DADA.Tope() != MOD.Tope()){
                    AUXDADA.Apilar(DADA.Tope());
                    DADA.Desapilar();
                } else {
                    DADA.Desapilar();
                }
            }
            while (!AUXDADA.EstaVacia()){
                DADA.Apilar(AUXDADA.Tope());
                AUXDADA.Desapilar();
            }
            AUXMOD.Apilar(MOD.Tope());
            MOD.Desapilar();
        }
        while (!AUXMOD.EstaVacia()){
            MOD.Apilar(AUXMOD.Tope());
            AUXMOD.Desapilar();
        }

        // Imprimo las pilas restantes
        System.out.println("DADA post: " + HerramientasPila.MostrarStringPila(DADA));
        System.out.println("MOD post: " + HerramientasPila.MostrarStringPila(MOD));
    }
}