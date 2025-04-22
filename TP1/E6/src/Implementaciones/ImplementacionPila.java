package Implementaciones;
import Interfaces.Pila;

public class ImplementacionPila implements Pila {

    int cursor;
    int[] pila;

    // Inicializa la pila con 100 espacios disponibles
    @Override
    public void InicializarPila() {
        cursor = 0;
        pila = new int[100];
    }

    // En caso de que la pila todavia no este llena, apila el elemento que se le pase
    @Override
    public void Apilar(int objeto) {
        if (!EstaLlena()){
            pila[cursor] = objeto;
            cursor++;
        } else {
            System.out.println("ATENCION: ¡La pila ya está llena!");
        }
    }

    // Elimina primer elemento de la pila (en orden de selección)
    @Override
    public void Desapilar() {
        cursor--;
        pila[cursor] = 0;
    }

    // Devuelve el primer elemento de la pila (también en orden de selección de pila)
    @Override
    public int Tope() {return (pila[cursor-1]);}

    // Devuelve el condicional si la pila está vacía o no.
    @Override
    public boolean EstaVacia() {return(cursor==0);}

    // Devuelve un String con todos los elementos de la pila
    public String MostrarPila(){
        String stringPila = "";
        for (int i = cursor - 1; i >= 0; i--) {
            stringPila += (pila[i] + " ");
        }
        return stringPila;
    }

    // Verifica si la pila está llena (a traves del cursor). Se usa para prevenir que se salga de rango al escribir la pila
    private boolean EstaLlena(){return(cursor==100);}
}