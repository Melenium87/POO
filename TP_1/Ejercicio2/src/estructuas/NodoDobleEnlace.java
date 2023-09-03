package estructuas;

public class NodoDobleEnlace {
    private NodoDobleEnlace siguiente= null;
    private NodoDobleEnlace anterior=null;
    private Object datos= null;

    public void setSiguiente(NodoDobleEnlace siguiente) {
        this.siguiente = siguiente;
    }

    public void setAnterior(NodoDobleEnlace anterior) {
        this.anterior = anterior;
    }

    public NodoDobleEnlace getAnterior() {
        return anterior;
    }

    public void setDatos(Object datos) {
        this.datos = datos;
    }

    public NodoDobleEnlace getSiguiente() {
        return siguiente;
    }

    public Object getDatos() {
        return datos;
    }
}
