package Ej6;

public class Combustible {
    private String nombre;
    private double precio;
    protected double totalVentas;

    public Combustible(String nombre, double precio){
        this.nombre = nombre;
        this.precio = precio;
        this.totalVentas = 0;
    }

    public String getNombre(){
        return nombre;
    }
}
