
import Ej8.*;

public class MainEj8 {
    public static void main(String[] args) {
        // Crear publicaciones
        Libro libro1 = new Libro("El arte de la guerra", "Sun Tzu", "12345", "ISBN123", 152, 10);
        Revista revista1 = new Revista("National Geographic", "Editorial NatGeo", "67890", "ISSN123", 100, 2023, 5);
        Libro libro2 = new Libro("Breve historia del tiempo", "Stephen Hawking", "67891", "ISBN456", 216, 1);
        Revista revista2 = new Revista("Scientific American", "Scientific American, Inc.", "67892", "ISSN456", 50, 2023, 6);
        Tesis tesis1 = new Tesis("Tesis de Física Cuántica", "John Doe", "78901", "Autor Anónimo", "Septiembre 2023");
        Diario diario1 = new Diario("The New York Times", "The New York Times Company", "12346", "2023-09-25");

        // creo socios
        Socio socio1 = new Socio("Einstein", 1);
        Socio socio2 = new Socio("María", 2);

        // creo la biblioteca y le agrego las publicaciones y los socios a ella
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.agregarPublicacion(libro1);
        biblioteca.agregarPublicacion(revista1);
        biblioteca.agregarPublicacion(libro2);
        biblioteca.agregarPublicacion(revista2);
        biblioteca.agregarPublicacion(tesis1);
        biblioteca.agregarPublicacion(diario1);

        biblioteca.agregarSocio(socio1);
        biblioteca.agregarSocio(socio2);

        // Presto libros y revistas a los socios de la biblioteca
        System.out.println("\n");
        biblioteca.prestarLibroPorIsbn(libro1.getIsbn(), socio1.getNombre());
        biblioteca.prestarLibroPorIsbn(libro1.getIsbn(), socio2.getNombre());
        biblioteca.prestarLibroPorIsbn(libro2.getIsbn(), socio2.getNombre());
        biblioteca.prestarRevistaPorIssn(revista1.getIssn(), socio2.getNombre());
        biblioteca.prestarRevistaPorIssn(revista2.getIssn(), socio2.getNombre());
        System.out.println("\n");


        // Muestro los ejemplares prestados
        biblioteca.mostrarEjemplaresPrestados(libro1.getNombre());
        biblioteca.mostrarEjemplaresPrestados(revista1.getNombre());
        biblioteca.mostrarEjemplaresPrestados(libro2.getNombre());
        biblioteca.mostrarEjemplaresPrestados(revista2.getNombre());

        // Muestro los ejemplares prestados por socios
        System.out.println("\n");
        socio1.mostrarPublicacionesPrestadas();
        System.out.println("\n");
        socio2.mostrarPublicacionesPrestadas();
    }
}