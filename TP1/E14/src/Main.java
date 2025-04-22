import Interfaces.Pila;
import Implementaciones.ImplementacionPila;
import Utilidades.HerramientasPila;
import java.util.Scanner;

/* 14: Cree e inicialice las pilas DADA y ANTERIORES. Cargue una pila DADA con al menos un elemento de valor 8 y pase a
* la pila ANTERIORES todos aquellos elementos que lo precedan (elementos entre el tope y el primer 8.) */
public class Main {
    public static void main(String[] args) {

        // Creo e inicializo las pilas solicitadas
        Pila DADA = new ImplementacionPila();
        Pila ANTERIORES = new ImplementacionPila();
        DADA.InicializarPila();
        ANTERIORES.InicializarPila();

        /* Dado que tengo que verificar si en algún momento se ingresa un 8, en vez de usar la herramienta cargarPila
        de Utilidades, lo haré manualmente para DADA.*/
        Scanner sc = new Scanner(System.in);
        int elemento;
        boolean hayOcho = false;
        while ((elemento = sc.nextInt()) != -1 || !hayOcho) {
            if (elemento == 8) { hayOcho = true;}
            if (elemento != -1){
                DADA.Apilar(elemento);
            } else {
                System.out.println("Atención: Debe existir almenos un elemento que sea 8.");
            }
        }

        // Imprimo la DADA previa a su procesado.
        System.out.println("DADA pre: " + HerramientasPila.MostrarStringPila(DADA));

        // Paso todos los elementos desde el tope hasta el 8 (incluído) a la pila ANTERIORES
        while (DADA.Tope() != 8){
            ANTERIORES.Apilar(DADA.Tope());
            DADA.Desapilar();
        }
        // (tengo que hacerlo fuera del bucle para incluir al 8)
        ANTERIORES.Apilar(DADA.Tope());
        DADA.Desapilar();

        // Imprimo todas las pilas
        System.out.println("DADA pos: " + HerramientasPila.MostrarStringPila(DADA));
        System.out.println("ANTERIORES: " + HerramientasPila.MostrarStringPila(ANTERIORES));
    }
}