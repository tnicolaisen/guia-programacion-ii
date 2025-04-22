package Implementaciones;
import Interfaces.InterfazPila;

public class Pila implements InterfazPila {

    int cursor;
    int[] pila;

    @Override
    public void InicializarPila() {
        cursor = 0;
        pila= new int[10];
    }

    @Override
    public void Apilar(int elemento) {
        pila[cursor] = elemento;
        cursor++;
    }

    @Override
    public void Desapilar() {
        cursor--;
        pila[cursor] = 0;
    }

    @Override
    public int Tope() {return (pila[cursor-1]);}

    @Override
    public boolean Vacia() {return (cursor==0);}

    public String MostrarPila(){
        String stringPila="";
        for (int i= cursor-1; i>=0; i--) {
            stringPila += (pila[i] + " ");
        }
        return stringPila;
    }

    public boolean Llena(){return (cursor==10);}
}