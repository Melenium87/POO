package EstructuraCola;

public class Cola {
    private Nodo primero = null;
    private int cantidad;


    private void setPrimero(Nodo inicio)
    {
        this.primero = inicio;
    }

    // La el mostrar cola lo hago de la parte de funciones pero no se muestra como si fuera una lista
    //y asi no destruir la cola
    public void mostrar()
    {

        Nodo aux=primero;
        if(aux==null)
        {
            System.out.println("La cola esta vacia:");
        }
        else
        {
            while (aux!=null)
            {
                System.out.print("| " + aux.getDatos()+ " |");
                aux= aux.getSiguiente();
            }
        }
    }

    public void encolar(Object datos)
    {
        Nodo nodo = new Nodo();
        nodo.setDatos(datos);
        if (primero == null)
        {
            primero = nodo;
            cantidad++;
        }
        else
        {
            Nodo aux ;
            aux=primero;
            while(aux.getSiguiente()!=null)
            {
                aux=aux.getSiguiente();
            }
            aux.setSiguiente(nodo);
            cantidad++;

        }
    }


    public Object desencolar()
    {
        if (colaEsVacia() == false) {
            Object dato = primero.getDatos();
            primero = primero.getSiguiente();
            cantidad=cantidad-1;
            return dato;
        }
        return null;
    }

    public boolean colaEsVacia()
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

    public Object primero() {
        if (primero == null) {

            return null;
        } else {
            return primero.getDatos();
        }
    }
}


