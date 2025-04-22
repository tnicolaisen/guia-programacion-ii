package Interfaces;

public interface Pila {
    public void inicializarPila();
    public void apilar(int objeto);
    public void desapilar();
    public int tope();
    public boolean estaVacia();

    // SE AGREGARON LOS SIGUIENTES METODOS PARA EL EJERCICIO
    public String mostrarPila();
    public boolean estaLlena();
}
