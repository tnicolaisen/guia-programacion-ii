package Implementaciones;
import Interfaces.Pila;

public class implenetacionPila implements Pila {

    int cursor;
    int pila[];

    // Inicializa la pila con una longitud de 10
    @Override
    public void inicializarPila() {
        cursor = 0;
        pila = new int[10];
    }

    // Apila el objeto dado como parametro
    @Override
    public void apilar(int objeto) {
        pila[cursor] = objeto;
        cursor++;
    }

    // Desapila el primer objeto de la pila (según el orden FIFO)
    @Override
    public void desapilar() {
        cursor--;
        pila[cursor] = 0;
    }

    // Devuelve el primer elemento de la pila (según el orden FIFO)
    @Override
    public int tope() {return (pila[cursor - 1]);}

    // Devuelve el valor si la pila está vacía o no (en base a la posición del cursor)
    @Override
    public boolean estaVacia() {return (cursor == 0);}

    // NOTA: Los siguientes métodos se agregaron para este ejercicio

    // Devuelve un string con todos los elementos de la pila (con el orden correcto)
    @Override
    public String mostrarPila() {
        String pilaString = "";
        for (int i = cursor - 1; i >=0; i--){
            pilaString = pilaString + (pila[i] + " ");
        }
        return pilaString;
    }

    // Devuelve si la pila está llena o no (también en base al cursor)
    @Override
    public boolean estaLlena() {return (cursor == 10);}
}