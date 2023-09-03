package EstructuraTareasEj12;
import EstructuraTareasEj13.TareaEj13;

import java.util.Collections;
import java.time.LocalDate;
import java.util.*;

public class AdministradorTareas
{
    private ArrayList<TareaEj12> tareas;

    public AdministradorTareas()
    {
        tareas=new ArrayList<TareaEj12>();

    }

    public void agregarTarea()
    {

            Scanner sc=new Scanner(System.in);

            System.out.print("Elige un titulo: ");
            String titulo= sc.nextLine();
            for(TareaEj12 t:tareas){
            if (Objects.equals(t.getTitulo(), titulo))
            {
                System.out.println("Error la ya hay una tarea con ese titulo");
                return;
            }
        }
            System.out.println("\n Descripcion: ");
            String descripcion=sc.nextLine();
            System.out.println("establecer prioridad\n1-Alta 2-Media 3-Baja");
            int prio=sc.nextInt();
            while (prio<1||prio>3)
            {
                System.out.println(("Error\n"));
                System.out.println("establecer prioridad\n1-Alta 2-Media 3-Baja");
                prio=sc.nextInt();
            }
            System.out.println("desea establecer una fecha limite: \n 1- Si  2- No");
            int resp= sc.nextInt();
            while (resp<1||resp>2)
            {
                System.out.println(("Error\n"));
                System.out.println("desea establecer una fecha limite: \n 1- Si  2- No");resp=sc.nextInt();
            }
            if(resp==1)
            {
                System.out.println("formato: dd MM yyyy");
                int dia=0,mes=0,anio=0;
                System.out.print("dia: ");
                resp= sc.nextInt();
                while (resp<1||resp>31)
                {
                    System.out.println(("Error\n"));
                    System.out.print("dia:");
                    resp=sc.nextInt();
                }
                dia=resp;
                System.out.print("mes: ");
                resp= sc.nextInt();
                while (resp<1||resp>12)
                {
                    System.out.println(("Error\n"));
                    System.out.print("mes:");
                    resp=sc.nextInt();
                }
                mes=resp;
                System.out.print("anio: ");
                resp= sc.nextInt();
                while (resp<1000)
                {
                    System.out.println(("Error\n"));
                    System.out.print("anio: ");
                    resp=sc.nextInt();
                }
                anio=resp;
                LocalDate fecha = LocalDate.of(anio, mes, dia);

                System.out.println("desea establecer un recordatorio: \n 1- Si  2- No");
                resp= sc.nextInt();
                while (resp<1||resp>2)
                {
                    System.out.println(("Error\n"));
                    System.out.println("desea establecer un recordatorio: \n 1- Si  2- No");
                    resp=sc.nextInt();
                }
                if(resp==1)
                {
                    System.out.println("formato: dd MM yyyy");
                    dia=0;
                    mes=0;
                    anio=0;
                    System.out.print("dia: ");
                    resp= sc.nextInt();
                    while (resp<1||resp>31)
                    {
                        System.out.println(("Error\n"));
                        System.out.print("dia:");
                        resp=sc.nextInt();
                    }
                    dia=resp;
                    System.out.print("mes: ");
                    resp= sc.nextInt();
                    while (resp<1||resp>12)
                    {
                        System.out.println(("Error\n"));
                        System.out.print("mes:");
                        resp=sc.nextInt();
                    }
                    mes=resp;
                    System.out.print("anio: ");
                    resp= sc.nextInt();
                    while (resp<1000)
                    {
                        System.out.println(("Error\n"));
                        System.out.print("anio: ");
                        resp=sc.nextInt();
                    }

                    anio=resp;
                    LocalDate recordatorio = LocalDate.of(anio, mes, dia);
                    while  (fecha.isBefore(recordatorio)) {
                        System.out.println("ERROR: el recordatorio es de una fecha posterior a la fecha limite\n");

                        System.out.println("formato: dd MM yyyy");
                        dia = 0;
                        mes = 0;
                        anio = 0;
                        System.out.print("dia: ");
                        resp = sc.nextInt();
                        while (resp < 1 || resp > 31) {
                            System.out.println(("Error\n"));
                            System.out.print("dia:");
                            resp = sc.nextInt();
                        }
                        dia = resp;
                        System.out.print("mes: ");
                        resp = sc.nextInt();
                        while (resp < 1 || resp > 12) {
                            System.out.println(("Error\n"));
                            System.out.print("mes:");
                            resp = sc.nextInt();
                        }
                        mes = resp;
                        System.out.print("anio: ");
                        resp = sc.nextInt();
                        while (resp < 1000) {
                            System.out.println(("Error\n"));
                            System.out.print("anio: ");
                            resp = sc.nextInt();
                        }

                        anio = resp;
                        recordatorio = LocalDate.of(anio, mes, dia);
                    }

                    TareaEj12 tarea=new TareaEj12(titulo,descripcion,prio,fecha,recordatorio);
                    tareas.add(tarea);
                }
                else
                {
                    TareaEj12 tarea=new TareaEj12(titulo,descripcion,prio,fecha);
                    tareas.add(tarea);
                }
            }
            else {

                TareaEj12 tarea=new TareaEj12(titulo,descripcion,prio);
                tareas.add(tarea);

            }

    }

    public void modificarTarea(String titulo)
    {
        for(int i=0;i<tareas.size();i++)
        {
            if (tareas.get(i).tituloDeTarea(titulo))
            {
                System.out.println("Tarea encontrada");
                 tareas.get(i).modificarTarea();
            }
        }
        System.out.println("Tarea no encontrada");
    }
    public ArrayList<TareaEj12> tareasNoVencidas()
    {
        //Ordenamiento por prioridad y fecha
        ArrayList<TareaEj12> tareas=new ArrayList<>();
        Collections.sort(this.tareas);

        int h;
        for (h=1;h<4;h++)
        {
            for (TareaEj12 i:this.tareas) {

                if (i.getEstado() == 3) {
                    continue;

                }
                if (i.getPrioridad() == h)
                {
                    tareas.add(i);
                }
            }
        }

        return tareas;
    }



}

