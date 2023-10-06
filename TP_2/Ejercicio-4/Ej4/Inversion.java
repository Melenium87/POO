package Ej4;

import java.util.Calendar;
import java.util.Date;

public class Inversion {
    /*Responsabilidades
        Tiene el monto total invertido (Se le agrega un %40)
        Tiene fecha de inicio
        Tiene cant días de duración de inversión
     */
    private double monto = 0;
    private Date fechaInicio;
    private int cantDias;
    Inversion(double monto, Date fechaInicio, int cantDias){
        this.monto = monto + ((monto*40)/100); //Guardo el monto con el %40
        this.fechaInicio = fechaInicio;
        this.cantDias = cantDias;
    }
    public double invertido(){
        return monto - ((monto*40)/100);
    }
    public double finalizarInversion(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaInicio);
        calendar.add(Calendar.DAY_OF_YEAR, cantDias);
        Date fecha = new Date();
        if(calendar.getTime().before(fecha)){//Controla que hayan pasado la cant de días establecidos
            return monto;
        } else {
            System.out.println("Aún no se puede retirar la inversion.");
            return -1;
        }
    }
}
