package EstructurasTareas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Tarea
{
    private String titulo;
    private String descripcion;
    private LocalDate fechaLimite=null;

    private int prioridad;
    private int estado;

    public Tarea(String titulo, String descripcion,int prioridad)
    {
        this.titulo=titulo;
        this.descripcion=descripcion;
        this.prioridad=prioridad;
        estado=1;
    }
    public Tarea(String titulo, String descripcion,int prioridad,LocalDate fechaLimite)
    {
        this.titulo=titulo;
        this.descripcion=descripcion;
        this.prioridad=prioridad;
        estado=1;
        this.fechaLimite=fechaLimite;
    }
    private static String estado(int numero)
    {
        String esta="Error";
        switch (numero)
        {
            case 1:
                esta= "Pendiente";
                break;
            case 2:
                esta="Terminado";
                break;
            case 3:
                esta="Vencido";
        }
        return esta;
    }
    private static String prioridad(int numero)
    {
        String esta="Error";
        switch (numero)
        {
            case 1:
                esta= "Alta";
                break;
            case 2:
                esta="Media";
                break;
            case 3:
                esta="Baja";
        }
        return esta;
    }
    public void mostrarTarea(){
        comprobarVencimiento();
        System.out.println("Estado: " +estado(estado)+ " Prioridad: "+prioridad(prioridad));
        System.out.println("---------"+titulo+"---------");
        System.out.println(descripcion);
        if (fechaLimite!=null)
        {
            System.out.println("\nFecha limite: "+fechaLimite.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        }
    }

    public boolean comprobarVencimiento(){
        if (fechaLimite!=null&&(LocalDate.now().isEqual(fechaLimite)||LocalDate.now().isAfter(fechaLimite)))
        {
            estado=3;
            return true;
        }
        return false;
    }
    public void marcarTermida()
    {
        estado=2;
    }
    public String descripcion() {
        return descripcion;
    }

    public void cambiarDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void cambiarPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }



}


