package Ej7;

public class Empleado {
    private String nombre;
    private String CUIT;
    protected double totalVentas;
    private boolean topTen = false;

    public Empleado(String nombre, String CUIT){
        this.nombre = nombre;
        this.CUIT = CUIT;
        this.totalVentas = 0;
    }

    public void entroTopTen(){
        this.topTen = true;
    }

    public boolean getTopTen(){
        return topTen;
    }
}
