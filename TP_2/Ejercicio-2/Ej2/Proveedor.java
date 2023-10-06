package Ej2;

import java.util.ArrayList;

public class Proveedor {
    private String nombre;
    private final Clasificacion tipo;
    public Proveedor(String nombre, String tipoCla, String tipo){
        this.tipo = new Clasificacion(tipoCla, tipo);
        setNombre(nombre);
    }
    public Proveedor(String nombre, String tipoCla, ArrayList<String> tipo){
        this.tipo = new Clasificacion(tipoCla, tipo);
        setNombre(nombre);
    }
    private void setNombre(String nombre){ this.nombre = nombre; }
    public String toString(){
        return "Nombre del proveedor: " + nombre + "\n" + tipo;
    }
}
