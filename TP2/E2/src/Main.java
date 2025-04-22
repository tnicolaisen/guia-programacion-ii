import Implementaciones.ImplementacionCola;
import Interfaces.ColaTDA;
import Utilidades.HerramientasCola
        ;
/* 2: Cree e inicialice la cola DADA. Cargue desde el teclado la cola DADA con al menos un elemento. Pase el primer elemento
* de la cola DADA a su última posición, dejando los restantes elementos en su orden original. */
public class Main {
    public static void main(String[] args) {

        // Creo e inicializo DADA
        ColaTDA DADA = new ImplementacionCola();
        DADA.InicializarCola();

        // Cargo DADA con al menos un elemento
        System.out.println("Cargue la cola DADA con al menos un elemento: ");
        HerramientasCola.CargarCola(DADA, false);

        // Imprimo DADA previo al proceso
        System.out.println("Cola DADA pre: " + HerramientasCola.StringCola(DADA));

        // Guardo el primer elemento en una variable temporal y restauro el restante en la cola auxiliar.
        int primeroDADA = DADA.Primero();
        DADA.Desacolar();
        ColaTDA aux = new ImplementacionCola();
        aux.InicializarCola();
        while(!DADA.EstaVacia()){
            aux.Acolar(DADA.Primero());
            DADA.Desacolar();
        }
        while (!aux.EstaVacia()){
            DADA.Acolar(aux.Primero());
            aux.Desacolar();
        }
        DADA.Acolar(primeroDADA);

        // Imprimo DADA luego del proceso
        System.out.println("Cola DADA pos: " + HerramientasCola.StringCola(DADA));
    }
}