package Ej7;
public class Venta {
    private Cliente cliente;
    private Expendedor expendedor;
    private double litros;
    private Combustible combustible;
    private double total;
    private Empleado empleado;

    public Venta(Cliente cliente, Expendedor expendedor, double litros, double total, Empleado empleado){
        this.cliente = cliente;
        this.expendedor = expendedor;
        this.litros = litros;
        this.combustible = expendedor.getCombustible();
        if (cliente.getTopTen()){
            this.total = total * 0.95;
        } else {
            this.total = total;
        }
        this.empleado = empleado;

        this.combustible.totalVentas += this.total;
        this.expendedor.totalVentas += this.total;
        this.expendedor.litrosExpendidos += this.litros;
        this.empleado.totalVentas += this.total;
    }

    public Venta(Cliente cliente, Expendedor expendedor, double litros, double total, Empleado empleado, boolean aplicarDescuento){
        this.cliente = cliente;
        this.expendedor = expendedor;
        this.litros = litros;
        this.combustible = expendedor.getCombustible();
        if (cliente.getTopTen()){
            this.total = total * 0.95;
        } else {
            this.total = total;
        }
        if (empleado.getTopTen() && aplicarDescuento){
            this.total = this.total * 0.90;
        }
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
