package EstructuraTareasEj12;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;


public class TareaEj12 implements Comparable<TareaEj12>
{
    private String titulo;
    private String descripcion;
    private LocalDate fechaLimite=null;
    private LocalDate recordatorio=null;

    private int prioridad;
    private int estado;

    public int getEstado() {
        return estado;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public TareaEj12(String titulo, String descripcion, int prioridad)
    {
        this.titulo=titulo;
        this.descripcion=descripcion;
        this.prioridad=prioridad;
        estado=1;
    }
    public TareaEj12(String titulo, String descripcion,int prioridad,LocalDate fechaLimite)
    {
        this.titulo=titulo;
        this.descripcion=descripcion;
        this.prioridad=prioridad;
        estado=1;
        this.fechaLimite=fechaLimite;
    }

    public boolean tituloDeTarea(String i)
    {
        if (Objects.equals(titulo, i))
        {
            return true;
        }
        return false;
    }
    public TareaEj12(String titulo, String descripcion,int prioridad,LocalDate fechaLimite,LocalDate recordatorio)
    {
        this.titulo=titulo;
        this.descripcion=descripcion;
        this.prioridad=prioridad;
        estado=1;
        this.fechaLimite=fechaLimite;
        this.recordatorio=recordatorio;
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
                break;
            case 4:
                esta="Por Vencer";
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

    public LocalDate getFechaLimite() {
        return fechaLimite;
    }

    private boolean comprobarVencimiento(){
        if (fechaLimite!=null&&recordatorio!=null)
        {

            if (fechaLimite!=null&&(LocalDate.now().isEqual(fechaLimite)||LocalDate.now().isAfter(fechaLimite)))
            {
                estado=3;
            }
            if (recordatorio!=null&&(LocalDate.now().isEqual(recordatorio)||LocalDate.now().isAfter(recordatorio)))
            {
                prioridad=1;
                estado=4;
            }
            return true;
        }

        return false;
    }

    public void modificarTarea()
    {
        opciones();
        Scanner scanner=new Scanner(System.in);
        int opcion= scanner.nextInt();
        if(opcion==0)
        {
            return;
        }
        Scanner sc;
        while (opcion!=0)
        {
            if(opcion>3||opcion<0){
                scanner=new Scanner(System.in);
                opcion= scanner.nextInt();
            }
            switch (opcion) {


                case 1:
                    sc=new Scanner(System.in);
                    System.out.print("Nueva descripcion: \n\t");
                    descripcion=sc.nextLine();
                    break;

                case 2:
                    marcarTermida();
                    System.out.println("Tarea Terminada");
                    break;
                case 3:
                    sc=new Scanner(System.in);
                    System.out.print("A que prioridad quiere cambiar la tarea: \n1-Alta 2-Media 3-Baja\n");
                    int numero=sc.nextInt();
                    while (numero<1||numero>3)
                    {
                        System.out.println(("Error\n"));
                        System.out.print("A que prioridad quiere cambiar la tarea: 1-Alta 2-Media 3-Baja\n");
                        numero=sc.nextInt();
                    }
                    prioridad =numero;
                    System.out.println("Prioridad cambiada");
                    break;

            }
            opciones();
            scanner=new Scanner(System.in);
            opcion=scanner.nextInt();
        }
    }

    private void opciones() {
        mostrarTarea();

        System.out.println("\nQue desea hacer?");

        System.out.println("1 - **Cambiar descripcion**");
        System.out.println("2 - **Marcar como terminada**");
        System.out.println("3 - **Cambiar prioridad**");
        System.out.println("0 - **Salir**");
        System.out.println("");
        System.out.print("Opcion: ");
    }

    public String getTitulo() {
        return titulo;
    }

    public void marcarTermida()
    {
        estado=2;
    }
    public String descripcion() {
        return descripcion;
    }



    @Override
    public int compareTo(@NotNull TareaEj12 o) {
        if (this.fechaLimite==null&&o.fechaLimite!=null)
        {
            return 1;
        }
        if (this.fechaLimite!=null&&o.fechaLimite==null)
        {
            return 1;
        }
        if (this.fechaLimite==null&&o.fechaLimite==null)
        {
            return 0;
        }

        return this.fechaLimite.compareTo(o.fechaLimite);
    }
}


