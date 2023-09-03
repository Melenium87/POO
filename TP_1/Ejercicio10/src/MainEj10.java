import java.time.LocalDate;
import java.util.Scanner;


import EstructurasTareasEj10.*;


public class MainEj10
{


    public static void menuTarea(TareaEj10 tarea)
    {

        tarea.mostrarTarea();

        System.out.println("\nQue desea hacer?");

        System.out.println("1 - **Cambiar descripcion**");
        System.out.println("2 - **Marcar como terminada**");
        System.out.println("3 - **Cambiar prioridad**");
        System.out.println("0 - **Salir**");
        System.out.println("");
        System.out.print("Opcion: ");
        Scanner scanner=new Scanner(System.in);
        int opcion= scanner.nextInt();
        if(opcion==0)
        {
            return;
        }
        Scanner sc=new Scanner(System.in);
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
                    tarea.cambiarDescripcion(sc.nextLine());
                    break;

                case 2:
                    tarea.marcarTermida();
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
                    tarea.cambiarPrioridad(numero);
                    System.out.println("Prioridad cambiada");
                    break;

            }
            tarea.mostrarTarea();

            System.out.println("\nQue desea hacer?");

            System.out.println("1 - **Cambiar descripcion**");
            System.out.println("2 - **Marcar como terminada**");
            System.out.println("3 - **Cambiar prioridad**");
            System.out.println("0 - **Salir**");
            System.out.println("");
            System.out.print("Opcion: ");
            scanner=new Scanner(System.in);
            opcion=scanner.nextInt();
        }

    }
    public static TareaEj10 menu()
    {



        Scanner sc=new Scanner(System.in);

        System.out.print("Elige un titulo: ");
        String titulo= sc.nextLine();
        
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

                TareaEj10 tarea=new TareaEj10(titulo,descripcion,prio,fecha,recordatorio);
                return tarea;
            }
            else
            {
                TareaEj10 tarea=new TareaEj10(titulo,descripcion,prio,fecha);
                return tarea;
            }
        }
        else {

            TareaEj10 tarea=new TareaEj10(titulo,descripcion,prio);
            return tarea;

        }




    }
    public static void main(String[] args)
    {
        System.out.println("\n------Primera tarea------\n");
        TareaEj10 t1=menu();

        System.out.println("\n------Segunda tarea------\n");

        TareaEj10 t2=menu();
        System.out.println("\n------Tercera tarea------\n");

        TareaEj10 t3=menu();
        menuTarea(t1);
        menuTarea(t2);
        menuTarea(t3);

    }
}
