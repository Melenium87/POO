package Ej10;
import java.time.LocalDate;
import java.util.ArrayList;

public class PorComision extends Empleado {
    private ArrayList<Venta> ventas = new ArrayList<Venta>();
    private double porcentaje;

    public PorComision(String nombre, String apellido, String telefono, String CUIT, LocalDate cumpleaños){
        super(nombre, apellido, telefono, CUIT, cumpleaños);
    }

    private double totalBruto(){
        double total = 0;
        for (Venta venta : ventas) {
            total += venta.bruto;
        }
        return total;
    }

    public double calcularSueldo(){
        return totalBruto() * porcentaje;
    }

    public double bonoCumpleaños(){
        return bonoCumpleaños + totalBruto() * 0.05;
    }
}
