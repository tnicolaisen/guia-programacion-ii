import Implementaciones.ImplementacionCola;
import Implementaciones.ImplementacionPila;
import Interfaces.ColaTDA;
import Interfaces.PilaTDA;
import Utilidades.HerramientasCola;
import Utilidades.HerramientasPila;

/* Cree e inicialice la cola ORIGEN y la pila DESTINO. Cargue la cola ORIGEN. Pase los elementos de la cola ORIGEN a la
* pila DESTINO */
public class Main {
    public static void main(String[] args) {

        // Creo la cola y pila solicitadas y las inicializo
        ColaTDA ORIGEN = new ImplementacionCola();
        PilaTDA DESTINO = new ImplementacionPila();
        ORIGEN.InicializarCola();
        DESTINO.InicializarPila();

        // Cargo ORIGEN por teclado
        System.out.println("Cargue la cola ORIGEN:");
        HerramientasCola.CargarCola(ORIGEN, false);

        // Muestro la cola origen previo al procesado
        System.out.println("Cola ORIGEN pre: " + HerramientasCola.StringCola(ORIGEN));
        System.out.println("Pila DESTINO pre: " + HerramientasPila.StringPila(DESTINO));

        // Cargo los elementos de la cola ORIGEN a la pila DESTINO
        while(!ORIGEN.EstaVacia()){
            DESTINO.Apilar(ORIGEN.Primero());
            ORIGEN.Desacolar();
        }

        System.out.println("Cola ORIGEN pos: " + HerramientasCola.StringCola(ORIGEN));
        System.out.println("Pila DESTINO pos: " + HerramientasPila.StringPila(DESTINO));
    }
}