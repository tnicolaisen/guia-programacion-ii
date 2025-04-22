import Implementaciones.ImplementacionPila;
import Interfaces.Pila;
import Utilidades.HerramientasPila;
/*
Cree e inicialice las pilas A, B, VALOR, VERD, FALSO. Cargue desde el teclado las pilas
A y B. Cargue la pila VALOR con al menos un valor. Compare la cantidad de elementos de las
pilas A y B. Si son iguales, deje el tope de la pila VALOR en la pila VERD y si son
distintas en la pila FALSO.
 */
public class Main {
    public static void main(String[] args) {

        // Creo e inicializo todas las pilas necesarias
        Pila A = new ImplementacionPila();
        Pila B = new ImplementacionPila();
        Pila VALOR = new ImplementacionPila();
        Pila VERD = new ImplementacionPila();
        Pila FALSO = new ImplementacionPila();
        A.InicializarPila();
        B.InicializarPila();
        VALOR.InicializarPila();
        VERD.InicializarPila();
        FALSO.InicializarPila();

        // Cargo las pilas A, B y VALOR
        System.out.println("Cargue la pila A (-1 para finalizar):");
        HerramientasPila.CargarPila(A, true);
        System.out.println();
        System.out.println("Cargue la pila B (-1 para finalizar):");
        HerramientasPila.CargarPila(B, true);
        System.out.println();
        System.out.println("Cargue la pila VALOR (-1 para finalizar):");
        HerramientasPila.CargarPila(VALOR, false);

        // Comparo la cantidad de elementos de las pilas y aplico segun solicitado
        if (HerramientasPila.LongitudPila(A) == HerramientasPila.LongitudPila(B)) {
            VERD.Apilar(VALOR.Tope());
        } else {FALSO.Apilar(VALOR.Tope());}

        // Muestro todas las pilas restantes:
        System.out.println("-----------------------------------------------------");
        System.out.println("A: " + HerramientasPila.MostrarStringPila(A));
        System.out.println("B: " + HerramientasPila.MostrarStringPila(B));
        System.out.println("VALOR: " + HerramientasPila.MostrarStringPila(VALOR));
        System.out.println("VERD: " + HerramientasPila.MostrarStringPila(VERD));
        System.out.println("FALSO: " + HerramientasPila.MostrarStringPila(FALSO));
    }
}