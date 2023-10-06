package Ej10;



import java.time.LocalDate;

public class Pasante extends Empleado {

    public Pasante(String nombre, String apellido, String telefono, String CUIT, LocalDate cumpleaños){
        super(nombre, apellido, telefono, CUIT, cumpleaños);
        this.sueldo = 0;
        this.bonoCumpleaños = 0;
    }

    public double calcularSueldo() {
        return sueldo;
    }

    @Override
    public double bonoCumpleaños() {
        return bonoCumpleaños;
    }
}
