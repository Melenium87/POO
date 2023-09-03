import EstructurasLibros.Libro;
import EstructurasLibros.Bilbioteca;
import java.util.ArrayList;
public class MainEj6
{
    public static void main(String[] args)
    {

        Bilbioteca bilbioteca =new Bilbioteca();
        Libro libro1=new Libro("Juan el trepa muros","Juan el que trepa los muros",200,10);
        Libro libro2=new Libro("Pepito grillo","un grillo","1102034491",256,1);
        bilbioteca.agregarLibro(libro1);
        bilbioteca.agregarLibro(libro2);
        bilbioteca.compararLibros(libro1,libro2);
        System.out.println("La cantidad de libros prestados fue de: "+ bilbioteca.cantidadPrestados());
        if(libro1.prestar()){
            System.out.println("libro1 prestado con exito");
        }
        else
        {
            System.out.println("No se pudo prestar el libro1");
        }
        if(libro2.prestar()){
            System.out.println("libro2 prestado con exito");
        }
        else
        {
            System.out.println("No se pudo prestar el libro2");
        }
        libro2.agregarEjemplares(2);
        if(libro2.prestar()){
            System.out.println("libro2 prestado con exito");
        }
        else
        {
            System.out.println("No se pudo prestar el libro2");
        }
        bilbioteca.cantidadPrestados();
        System.out.println("La cantidad de libros prestados fue de: "+ bilbioteca.cantidadPrestados());

        Libro li=new Libro();
        li=bilbioteca.buscar("un grillo");
        li.mostrar();
    }
}
