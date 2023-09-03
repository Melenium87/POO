import EstructuraFecha.Fecha;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MainEj9
{
    public static void main(String[] args)
    {
        System.out.println("----- Crea una fecha -----\n");
        Scanner sc=new Scanner(System.in);
        System.out.println("Elije uno de los 2 formatos: \n1- dd/MM/yyyy   2- MM/dd/yyyy");
        int p=sc.nextInt();
        while (p<0||p>2)
        {
            System.out.println("ERROR\nElije uno de los 2 formatos: \n1- dd/MM/yyyy   2- MM/dd/yyyy");
            p=sc.nextInt();
        }
        Fecha fecha1;
        if (p==1)
        {
            Scanner palabra=new Scanner(System.in);
            System.out.println("Ingrese una fecha en el formato (dd/MM/yyyy)");
            String valorIngresado=palabra.nextLine();
             fecha1=new Fecha(valorIngresado);
        }
        else
        {
            Scanner palabra=new Scanner(System.in);
            DateTimeFormatter formatter= DateTimeFormatter.ofPattern("MM/dd/yyyy");
            System.out.println("Ingrese una fecha en el formato (MM/dd/yyyy)");
            String valorIngresado=palabra.nextLine();
            fecha1=new Fecha(valorIngresado,formatter);
        }

        System.out.println("----- Mayor o menor -----\n");
        sc=new Scanner(System.in);
        System.out.println("Elije uno de los 2 formatos: \n1- dd/MM/yyyy   2- MM/dd/yyyy");
        p=sc.nextInt();
        while (p<0||p>2)
        {
            System.out.println("ERROR\nElije uno de los 2 formatos: \n1- dd/MM/yyyy   2- MM/dd/yyyy");            p=sc.nextInt();
        }
        Fecha fecha2;
        if (p==1)
        {
            Scanner palabra=new Scanner(System.in);
            System.out.println("Ingrese una fecha en el formato (dd/MM/yyyy)");
            String valorIngresado=palabra.nextLine();
            fecha2=new Fecha(valorIngresado);
        }
        else
        {
            Scanner palabra=new Scanner(System.in);
            DateTimeFormatter formatter= DateTimeFormatter.ofPattern("MM/dd/yyyy");
            System.out.println("Ingrese una fecha en el formato (MM/dd/yyyy)");
            String valorIngresado=palabra.nextLine();
            fecha2=new Fecha(valorIngresado,formatter);
        }

        System.out.println("La primera fecha es mayor a la segunda: " + fecha1.mayorQue(fecha2));
        System.out.println("La primera fecha es menor a la segunda: " + fecha1.menorQue(fecha2));

        System.out.println("----- Fecha entre -----\n");
        sc=new Scanner(System.in);
        System.out.println("Elije uno de los 2 formatos: \n1- dd/MM/yyyy   2- MM/dd/yyyy");
        p=sc.nextInt();
        while (p<0||p>2)
        {
            System.out.println("ERROR\nElije uno de los 2 formatos: \n1- dd/MM/yyyy   2- MM/dd/yyyy");            p=sc.nextInt();
        }
        Fecha fecha3;
        if (p==1)
        {
            Scanner palabra=new Scanner(System.in);
            System.out.println("Ingrese una fecha en el formato (dd/MM/yyyy)");
            String valorIngresado=palabra.nextLine();
            fecha3=new Fecha(valorIngresado);
        }
        else
        {
            Scanner palabra=new Scanner(System.in);
            DateTimeFormatter formatter= DateTimeFormatter.ofPattern("MM/dd/yyyy");
            System.out.println("Ingrese una fecha en el formato (MM/dd/yyyy)");
            String valorIngresado=palabra.nextLine();
            fecha3=new Fecha(valorIngresado,formatter);
        }

        System.out.println("La primera fecha esta entre la 2da y 3ra fecha: " + fecha1.entre(fecha2,fecha3));
        System.out.println("La segunda fecha esta entre la 1da y 3ra fecha: " + fecha2.entre(fecha1,fecha3));
        System.out.println("La tercera fecha esta entre la 1da y 2ra fecha: " + fecha3.entre(fecha1,fecha2));

        System.out.println("----- Mostrar fecha en distintos formatos -----\n");
        System.out.println("Mostrando fecha 1 en distintos formatos");
        fecha1.mostrar();
        fecha1.mostrar();

    }
}
