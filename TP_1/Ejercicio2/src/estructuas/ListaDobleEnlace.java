package estructuas;

public class ListaDobleEnlace
{
    private NodoDobleEnlace inicio=null;


    public NodoDobleEnlace getInicio() {
        return inicio;
    }

    private void setInicio(NodoDobleEnlace inicio) {
        this.inicio = inicio;
    }

   public void mostrar()
   {
       NodoDobleEnlace aux;
       aux=inicio;
       if(aux==null)
       {

       }
       else
       {
           while (aux!=null)
           {
               System.out.print(aux.getDatos()+ " / ");
               aux= aux.getSiguiente();
           }
       }
   }
    public void agregar(Object datos)
    {
        NodoDobleEnlace nodo = new NodoDobleEnlace();
        nodo.setDatos(datos);
        if (getInicio()==null)
        {
            inicio=nodo;
        }
        else
        {
            NodoDobleEnlace aux ;
            aux=inicio;
            while(aux.getSiguiente()!=null)
            {
                aux=aux.getSiguiente();
            }
            aux.setSiguiente(nodo);
            nodo.setAnterior(aux);
        }
    }
    public boolean listaEsVacia()
    {
        if(getInicio()==null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public int longitud()
    {
        int contador=0;
        NodoDobleEnlace nodo;
        nodo=getInicio();
        while (nodo!=null)
        {
            contador++;
            nodo=nodo.getSiguiente();
        }
        return contador;
    }
    public void eliminar(int pos)
    {
        if (listaEsVacia())
        {

        }
        else {
            NodoDobleEnlace aux;
            aux = inicio;
            if (pos>0 &&pos <=longitud())
            {
                if (pos==1)
                {
                    inicio=aux.getSiguiente();
                }

                else
                {
                    for(int i=1;i<pos-1;i++)
                    {
                        aux=aux.getSiguiente();
                    }
                    NodoDobleEnlace aux2=aux.getSiguiente();
                    aux.setSiguiente(aux2.getSiguiente());
                    if(aux2.getSiguiente()!=null)
                    {
                        aux2=aux2.getSiguiente();
                        aux2.setAnterior(aux);
                    }

                }
            }
        }
    }



    public Object recuperar(int posicion)
    {
        if (posicion>=1&& posicion<=longitud())
        {

            if(posicion==1)
            {
                return (getInicio().getDatos());
            }
            else
            {
                NodoDobleEnlace nod;
                nod=inicio;
                for(int i=1;i<posicion;i++)
                {
                    if (nod.getSiguiente()==null)
                    {
                        return null;
                    }
                    nod=nod.getSiguiente();
                }
                return nod.getDatos();
            }

        }
        System.out.println("No existe esa posicion");
        return null ;
    }
    public Object recuperarAnterior(int posicion)
    {
        if (posicion>=1&& posicion<=longitud())
        {

            if(posicion==1)
            {
                return null;
            }
            else
            {
                NodoDobleEnlace nod;
                nod=inicio;
                for(int i=1;i<posicion;i++)
                {
                    if (nod.getSiguiente()==null)
                    {
                        return null;
                    }
                    nod=nod.getSiguiente();
                }
                nod=nod.getAnterior();
                return nod.getDatos();
            }

        }
        System.out.println("No existe esa posicion");
        return null ;
    }
    public void insertar(Object dato, int posicion)
    {
        if(posicion>=1&&posicion <= ( longitud()+1 ) )
        {
            if(posicion == ( longitud()+1))
            {
                agregar(dato);

            }
            else
            {
                if (posicion==1)
                {
                    NodoDobleEnlace aux=inicio;
                    NodoDobleEnlace nod=new NodoDobleEnlace();
                    nod.setDatos(dato);
                    setInicio(nod);
                    nod.setSiguiente(aux);
                    return;
                }
                else
                {

                    NodoDobleEnlace nod=new NodoDobleEnlace();
                    nod.setDatos(dato);
                    NodoDobleEnlace aux=inicio;

                    for(int i=1;i<posicion-1;i++)
                    {
                        aux=aux.getSiguiente();
                    }
                    NodoDobleEnlace aux2=aux.getSiguiente();
                    aux.setSiguiente(nod);
                    nod.setSiguiente(aux2);
                    nod.setAnterior(aux);
                    aux2.setAnterior(nod);
                }
            }
        }
        System.out.println("Posicion no valida");
    }
}

