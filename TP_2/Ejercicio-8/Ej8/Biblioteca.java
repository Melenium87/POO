package Ej8;
import java.util.*;

public class Biblioteca {
    private ArrayList<Publicacion> publicaciones = new ArrayList<>();
    private Map<String, Socio> socios = new HashMap<>();

    public void agregarPublicacion(Publicacion publicacion) {
        publicaciones.add(publicacion);
    }

    public void agregarSocio(Socio socio) {
        socios.put(socio.getNombre(), socio);
    }

    public Publicacion buscarPublicacionPorIssn(String issn) {
        for (Publicacion publicacion : publicaciones) {
            if (publicacion instanceof Revista) {
                Revista revista = (Revista) publicacion;
                if (revista.getIssn().equals(issn)) {
                    return revista;
                }
            }
        }
        System.out.println("No se encuentra ninguna revista con ese ISSN en la biblioteca");
        return null;
    }

    public Publicacion buscarPublicacionPorIsbn(String isbn) {
        for (Publicacion publicacion : publicaciones) {
            if (publicacion instanceof Libro) {
                Libro libro = (Libro) publicacion;
                if (libro.getIsbn().equals(isbn)) {
                    return libro;
                }
            }
        }
        System.out.println("No se encuentra ningún libro con ese ISBN en la biblioteca");
        return null;
    }

    public Socio getSocio(String nombre) {
        return socios.get(nombre);
    }

    public void prestarRevistaPorIssn(String issn, String nombreSocio) {
        Revista revista = (Revista) buscarPublicacionPorIssn(issn);
        Socio socio = socios.get(nombreSocio);

        if (revista != null && socio != null) {
            revista.prestarEjemplares(1,socio,revista);
        }
    }

    public void prestarLibroPorIsbn(String isbn, String nombreSocio) {
        Libro libro = (Libro) buscarPublicacionPorIsbn(isbn);
        Socio socio = socios.get(nombreSocio);

        if (libro != null && socio != null) {
            libro.prestarEjemplares(1,socio,libro);
        }
    }

    public void mostrarEjemplaresPrestados(String nombrePublicacion) {
        Publicacion publicacion = null;
        for (Publicacion p : publicaciones) {
            if (p.getNombre().equals(nombrePublicacion)) {
                publicacion = p;
                break;
            }
        }

        if (publicacion != null) {
            if (publicacion instanceof Libro) {
                System.out.println("Ejemplares prestados del libro " + publicacion.getNombre() + ": " + ((Libro) publicacion).getTotalPrestados());
            } else if (publicacion instanceof Revista) {
                System.out.println("Ejemplares prestados de la revista " + publicacion.getNombre() + ": " + ((Revista) publicacion).getTotalPrestados());
            } else {
                System.out.println("Esta publicación no tiene seguimiento de ejemplares prestados.");
            }
        }
    }
}