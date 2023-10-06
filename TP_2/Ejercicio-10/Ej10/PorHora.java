package Ej10;

import java.time.LocalDate;

public class PorHora extends Empleado {
    private int cantidadHoras;

    public PorHora(String nombre, String apellido, String telefono, String CUIT, LocalDate cumpleaños, double montoPorHora, int cantidadHoras){
        super(nombre, apellido, telefono, CUIT, cumpleaños);
        this.sueldo = montoPorHora;
        this.cantidadHoras = cantidadHoras;
    }

    public double calcularSueldo(){
        if (cantidadHoras>40){
            return this.sueldo * cantidadHoras * 1.2;
        }
        return this.sueldo * cantidadHoras;
    }

    public double bonoCumpleaños(){
        return bonoCumpleaños;
    }
}
