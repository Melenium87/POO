package Ej10;

import java.time.LocalDate;

public class ConSalarioBase extends PorComision{

    public ConSalarioBase(String nombre, String apellido, String telefono, String CUIT, LocalDate cumpleaños, double salarioBase){
        super(nombre, apellido, telefono, CUIT, cumpleaños);
        this.sueldo = salarioBase;
    }

    public double calcularSueldo(){
        return super.calcularSueldo() + this.sueldo;
    }

    public double bonoCumpleaños(){
        return super.bonoCumpleaños() + 1000;
    }
}
