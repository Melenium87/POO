package EstructuraFecha;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Fecha
{
   private LocalDate fecha;


    public Fecha(String fechax, DateTimeFormatter formato)
    {
      fecha= LocalDate.parse(fechax,formato);
    }

    public Fecha(String fechax)
    {
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd/MM/yyyy");
        fecha= LocalDate.parse(fechax,formatter);
    }

    public boolean mayorQue(Fecha fe)
    {
        return this.fecha.isBefore(fe.fecha);



    }
    public boolean menorQue(Fecha fe)
    {
        return this.fecha.isAfter(fe.fecha);
    }
    public boolean entre(Fecha fe1,Fecha fe2)
    {
        if((this.fecha.isAfter(fe1.fecha)&&this.fecha.isBefore(fe2.fecha))||(this.fecha.isAfter(fe2.fecha)&&this.fecha.isBefore(fe1.fecha)))
        {
            return true;
        }
        return false;
    }

    public void mostrar()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Elije uno de los 2 formatos: \n1- dd/MM/yyyy   2- MM/dd/yyyy");
        int p=sc.nextInt();
        while (p<0||p>2)
        {
            System.out.println("ERROR\nElije uno de los 2 formatos: \n1- dd/MM/yyyy   2- MM/dd/yyyy");
            p=sc.nextInt();
        }
        if (p==1)
        {
            System.out.println(fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        }
        if(p==2)
        {
            System.out.println(fecha.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        }

    }

}