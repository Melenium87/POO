package EstructurasLibros;
import java.util.ArrayList;


public class Bilbioteca
{
    private ArrayList<Libro> libros=new ArrayList<Libro>();

    public Bilbioteca() {

    }

    public boolean agregarLibro(Libro l)
    {
       for (Libro libro:libros)
       {
           if (libro.igualA(l)){
               return false;
           }
       }
       libros.add(l);
        return true;
    }

    public Libro buscar(String clave)
    {
        for (Libro l:libros)
        {
            if(l.encontrar(clave))
            {
                return l;
            }
        }
        return null;
    }

    public int cantidadPrestados()
    {
        int contador=0;
        for (Libro l:libros)
        {
            contador=contador+l.getPrestados();
        }
        return contador;
    }

    public void compararLibros(Libro l1, Libro l2)
    {
        l1.mostrar();
        System.out.println("\n----------------------------------------------\n");
        l2.mostrar();
        if (l1.getNumeroPaginas()> l2.getNumeroPaginas())
        {
            System.out.println("\n--------------------El libro"+ l1.getTitulo()+" "+ l1.getAutor()+"--------------------\n");
        }
        if (l2.getNumeroPaginas()>l1.getNumeroPaginas())
        {
            System.out.println("\n--------------------El libro"+ l2.getTitulo()+" "+ l2.getAutor()+"--------------------\n");
        }
        if (l2.getNumeroPaginas()==l1.getNumeroPaginas()){
            System.out.println("\n--------------------Los libros tienen la misma cantidad de paginas--------------------\n");
        }
    }
}
