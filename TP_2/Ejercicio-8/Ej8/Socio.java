package Ej8;
import java.util.ArrayList;

public class Socio {
    private String nombre;
    private int id;
    private ArrayList<Publicacion> publicacionesPrestadas = new ArrayList<>();

    public Socio(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void prestarPublicacion(Publicacion publicacion) {
        publicacionesPrestadas.add(publicacion);
    }

    public void mostrarPublicacionesPrestadas() {
        System.out.println("Publicaciones prestadas a " + nombre + ":");
        for (Publicacion publicacion : publicacionesPrestadas) {
            System.out.println(publicacion.getNombre());
        }
    }
}
