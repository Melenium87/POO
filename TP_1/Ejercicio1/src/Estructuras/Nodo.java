package Estructuras;

public class Nodo {
    private Nodo siguiente= null;

    private Object datos= null;

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public void setDatos(Object datos) {
        this.datos = datos;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public Object getDatos() {
        return datos;
    }
}
