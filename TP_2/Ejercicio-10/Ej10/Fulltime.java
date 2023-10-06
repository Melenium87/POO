package Ej10;
import java.time.LocalDate;

public class Fulltime extends Empleado {

    public Fulltime(String nombre, String apellido, String telefono, String CUIT, LocalDate cumpleaños, double salario){
        super(nombre, apellido, telefono, CUIT, cumpleaños);
        this.sueldo = salario;
    }
    public double calcularSueldo(){
        return this.sueldo;
    }

    public double bonoCumpleaños(){
        return bonoCumpleaños + 1000;
    }
}
