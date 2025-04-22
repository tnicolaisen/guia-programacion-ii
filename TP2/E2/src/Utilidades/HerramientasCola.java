package Utilidades;
import Implementaciones.ImplementacionCola;
import Interfaces.ColaTDA;
import java.util.Scanner;

public class HerramientasCola {

    /**
     * Devuelve un String legible con todos los elementos de la cola.
     * @param cola La cola que se solicita el string.
     * @return String con los elementos de la cola.
     */
    public static String StringCola(ColaTDA cola){

        // Creo el String a devolver
        String stringCola = "";

        // Invoco una cola auxiliar
        ColaTDA aux = new ImplementacionCola();
        aux.InicializarCola();

        // Recorro la cola, añadiendo los valores de la misma al String, y la guardo en el auxiliar.
        while (!cola.EstaVacia()){
            stringCola = stringCola + " " + cola.Primero();
            aux.Acolar(cola.Primero());
            cola.Desacolar();
        }

        // Restauro la cola original
        while (!aux.EstaVacia()){
            cola.Acolar(aux.Primero());
            aux.Desacolar();
        }

        // Retorno el string final
        return stringCola;
    }

    /**
     * Carga la cola constantemente hasta que el usuario pase -1 por consola.
     * @param cola La cola a cargar.
     * @param puedeEstarVacia Si el usuario desea que la cola pueda estar vacía o no.
     */
    public static void CargarCola(ColaTDA cola, boolean puedeEstarVacia){

        // Creo las variables necesarias
        int entrada;
        Scanner sc = new Scanner(System.in);

        // Verifico si la cola puede estar vacía
        if (puedeEstarVacia){

            // Si puede estar vacía, simplemente dejo de agregar elementos cuando se introduzca -1
            while ((entrada = sc.nextInt()) != -1){cola.Acolar(entrada);}
        } else {

            // Si no, verifico que primero quse agrege un elemento y luego dejo de hacerlo hasta que se introduzca -1.
            while ((entrada = sc.nextInt()) == -1){System.out.println("INFO: La cola no puede estar vacía. Ingrese al menos un elemento:");}
            cola.Acolar(entrada);
            while ((entrada = sc.nextInt()) != -1){cola.Acolar(entrada);}
        }
    }

    /**
     * Devuelve el entero correspondiente a la longitud de la cola a evaluar.
     * @param cola Cola a evaluar.
     * @return Longitud de la cola evaluada.
     */
    public static int LongitudCola(ColaTDA cola){

        // Creo una cola auxiliar para rescatar a la cola original
        ColaTDA aux = new ImplementacionCola();
        aux.InicializarCola();

        // Con la ayuda de un contador, voy verificando cuantos elementos tiene la cola (su longitud).
        int longitud = 0;
        while(!cola.EstaVacia()){
            aux.Acolar(cola.Primero());
            cola.Desacolar();
            longitud++;
        }

        // Restauro la cola original
        while (!aux.EstaVacia()){
            cola.Acolar(aux.Primero());
            aux.Desacolar();
        }

        // Retorno la longitud de la cola
        return longitud;
    }
}
