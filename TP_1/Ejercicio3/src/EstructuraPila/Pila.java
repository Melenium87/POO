package EstructuraPila;

public class Pila {
    private Nodo tope = null;
    private int cantidad;


    private void setTope(Nodo inicio)
    {
        this.tope = inicio;
    }

    // La el mostrar pila lo hago de la parte de funciones pero no se muestra como si fuera una lista
    //y asi no destruir la pila
    public void mostrar()
    {

        Nodo aux=tope;
        if(aux==null)
        {

        }
        else
        {
            System.out.println("-----");
            while (aux!=null)
            {
                System.out.println("| " + aux.getDatos()+ " |");
                aux= aux.getSiguiente();
            }
            System.out.println("-----");
        }
    }

    public void apilar(Object datos)
    {
        Nodo nodo = new Nodo();
        nodo.setDatos(datos);
        if (tope == null) {
            tope = nodo;
            cantidad++;
        } else {
            Nodo aux;
            aux = tope;
            nodo.setSiguiente(aux);
            tope = nodo;
            cantidad++;
        }
    }


    public Object desapilar()
    {
        if (pilaEsVacia() == false) {
            Object dato = tope.getDatos();
            tope = tope.getSiguiente();
            cantidad=cantidad-1;
            return dato;
        }

        return null;
    }

    public boolean pilaEsVacia()
    {
        if (cantidad == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int longitud() {
        return cantidad;
    }

    public Object tope() {
        if (tope == null) {

            return null;
        } else {
            return tope.getDatos();
        }
    }
}


