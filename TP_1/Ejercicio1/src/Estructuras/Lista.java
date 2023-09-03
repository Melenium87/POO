package Estructuras;



public class Lista
{
    private Nodo inicio=null;


    public Nodo getInicio() {
        return inicio;
    }


   public void mostrar()
   {
       Nodo aux;
       aux=inicio;
       if(aux==null)
       {
           return;
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
        Nodo nodo = new  Nodo();
        nodo.setDatos(datos);
        if (getInicio()==null)
        {
            inicio=nodo;
        }
        else
        {
            Nodo aux = new Nodo();
            aux=inicio;
            while(aux.getSiguiente()!=null)
            {
                aux=aux.getSiguiente();
            }
            aux.setSiguiente(nodo);
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
        Nodo nodo=new Nodo();
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
            Nodo aux;
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
                    Nodo aux2=aux.getSiguiente();
                    aux.setSiguiente(aux2.getSiguiente());
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
                Nodo nod= new Nodo();
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
                    Nodo aux=inicio;
                    Nodo nod=new Nodo();
                    nod.setDatos(dato);
                    inicio=nod;
                    nod.setSiguiente(aux);
                    return;
                }
                else
                {

                    Nodo nod=new Nodo();
                    nod.setDatos(dato);
                    Nodo aux=inicio;

                    for(int i=1;i<posicion-1;i++)
                    {
                        aux=aux.getSiguiente();
                    }
                    Nodo aux2=aux.getSiguiente();
                    aux.setSiguiente(nod);
                    nod.setSiguiente(aux2);
                }
            }
        }
        System.out.println("Posicion no valida");
    }
}

