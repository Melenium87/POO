package Ej6;

public class Venta {
    private String patente;
    private Expendedor expendedor;
    private double litros;
    private Combustible combustible;
    private double total;
    private Empleado empleado;

    public Venta(String patente, Expendedor expendedor, double litros, double total, Empleado empleado){
        this.patente = patente;
        this.expendedor = expendedor;
        this.litros = litros;
        this.combustible = expendedor.getCombustible();
        this.total = total;
        this.empleado = empleado;

        this.combustible.totalVentas += this.total;
        this.expendedor.totalVentas += this.total;
        this.expendedor.litrosExpendidos += this.litros;
        this.empleado.totalVentas += this.total;
    }

    public double getTotal(){
        return this.total;
    }

    public Expendedor getExpendedor(){
        return this.expendedor;
    }

    public Combustible getCombustible(){
        return this.combustible;
    }
}
