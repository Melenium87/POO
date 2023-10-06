package Ej10;

import java.time.LocalDate;

public abstract class Empleado {
    private String nombre;
    private String apellido;
    private String telefono;
    private String CUIT;
    private LocalDate cumpleaños;
    double sueldo;
    double bonoCumpleaños = 2000;

    public Empleado(String nombre, String apellido, String telefono, String CUIT, LocalDate cumpleaños){
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.CUIT = CUIT;
        this.cumpleaños = cumpleaños;
    }

    public abstract double calcularSueldo();

    public abstract double bonoCumpleaños();
}
