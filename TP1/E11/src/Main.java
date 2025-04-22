import Implementaciones.ImplementacionPila;
import Interfaces.Pila;
import Utilidades.HerramientasPila;
/*
Cree e inicialice las pias A, B, VALOR, VERD y FALSO. Cargue desde el teclado las pilas A y B. Cargue VALOR
con al menos un valor. Compare los elementos de las pilas A y B. Si son iguales, deje el tope de la pila VALOR
en VERD. Si son distintas, deje el tope de VALOR en FALSO.
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

        // Verifico si ambas pilas, A y B son iguales, y actúo según lo pedido.
        if (HerramientasPila.PilasIguales(A, B)){VERD.Apilar(VALOR.Tope());} else {FALSO.Apilar(VALOR.Tope());}

        // Verifico los resultados en consola
        System.out.println("-----------------------------------------------------");
        System.out.println("A: " + HerramientasPila.MostrarStringPila(A));
        System.out.println("B: " + HerramientasPila.MostrarStringPila(B));
        System.out.println("VALOR: " + HerramientasPila.MostrarStringPila(VALOR));
        System.out.println("VERD: " + HerramientasPila.MostrarStringPila(VERD));
        System.out.println("FALSO: " + HerramientasPila.MostrarStringPila(FALSO));
    }
}