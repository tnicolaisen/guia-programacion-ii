package Implementaciones;
import Intefaces.interfazPila;

public class Pila implements interfazPila{

    int[] pila;
    int cursor;

    @Override
    public void IncializarPila() {
        pila = new int[10];
        cursor = 0;
    }

    @Override
    public void Apilar(int x) {
        pila[cursor] = x;
        cursor++;
    }

    @Override
    public void Desapilar() {
        cursor--;
        pila[cursor] = 0;
    }

    @Override
    public boolean PilaVacia() {
        return cursor == 0;
    }

    @Override
    public int Tope() {
        if (cursor > 0) {
            return pila[cursor - 1];
        } else{
            return pila[0];
        }
    }

    @Override
    public void mostrarElementos() {
        for (int i=cursor;i>=0;i--){
            System.out.print(pila[i] + " ");
        }
        System.out.println();
    }
}