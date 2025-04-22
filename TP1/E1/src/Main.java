import Implementaciones.Pila;

import javax.security.sasl.SaslClient;
import java.util.Scanner;

// Cree las pilas DADA, CJTO1 y CJTO2 e inicialícelas (dejarlas vacías). Cargue desde el teclado la pila DADA con 4 elementos cualesquiera. Luego pase los tres primeros elementos a la pila CJTO1 y el restante a la pila CJTO2
public class Main {
    public static void main(String[] args) {
        // Creo e inicializo todas las pilas
        Pila DADA = new Pila();
        DADA.IncializarPila();
        Pila CJTO1 = new Pila();
        CJTO1.IncializarPila();
        Pila CJTO2 = new Pila();
        CJTO2.IncializarPila();

        // Cargo DADA con los datos de teclado
        Scanner sc = new Scanner(System.in);
        for (int i=0; i<4; i++) {
            DADA.Apilar(sc.nextInt());
        }
        sc.close();

        // Cargo los 3 primeros datos de DADA a CJTO1
        for (int i=0; i<3; i++) {
            CJTO1.Apilar(DADA.Tope());
            DADA.Desapilar();
        }

        // Cargo los datos restantes a CJTO2
        while(!DADA.PilaVacia()){
            CJTO2.Apilar(DADA.Tope());
            DADA.Desapilar();
        }

        // Muestro los elementos de la pila
        System.out.println("Elementos de DADA:");
        DADA.mostrarElementos();
        System.out.println("Elementos de CJTO1:");
        CJTO1.mostrarElementos();
        System.out.println("Elementos de CJTO2:");
        CJTO2.mostrarElementos();
    }
}