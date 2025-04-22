import Implementaciones.ImplementacionCola;
import Interfaces.ColaTDA;
import Utilidades.HerramientasCola;

/* Cree e inicialice la cola DADA. Cargue desde el teclado la cola DADA Con al menos un elemento. Pase el último
* último elemento de la cola DADA a la primera posición, dejando los restantes elementos en el orden original. */
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

        // Guardo todos los datos (excepto el último) en una cola auxiliar y reordeno la cola como se solicita
        int ultimoElemento;
        ColaTDA AUX = new ImplementacionCola();
        AUX.InicializarCola();
        int longitudDADA = HerramientasCola.LongitudCola(DADA);
        for (int i = 1; i <= longitudDADA - 1; i++) {
            AUX.Acolar(DADA.Primero());
            DADA.Desacolar();
        }
        while (!AUX.EstaVacia()){
            DADA.Acolar(AUX.Primero());
            AUX.Desacolar();
        }

        // Muestro DADA obtenida
        System.out.println("Cola DADA pos: " + HerramientasCola.StringCola(DADA));
    }
}