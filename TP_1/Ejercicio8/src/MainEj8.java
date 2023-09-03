import EstructuraContraseña.*;

import java.util.ArrayList;
import java.util.Scanner;

public class MainEj8 {
    public static void main(String[] args) {
        System.out.println("Genero contraseña inicial: ");
        Contraseña c=new Contraseña(3);
        System.out.println("\n ------Genero una nueva contraseña con una distinta longitud------");
        c.cambiarLongitud(3);
        System.out.println("\n------Me aseguro que la siguiente contraseña sea segura------");
        c.generarPassword();
        ArrayList<Contraseña>contraseñas=new ArrayList<Contraseña>();
        Scanner sc=new Scanner(System.in);
        System.out.println("\n------Crear coleccion de contraseñas------");
        System.out.print("Cuantas contraseñas desea ingresar: ");
        int cantidad=sc.nextInt();
        for (int i=0;i<cantidad;i++)
        {
            System.out.print("\nQue longitud desea para la contraseña "+(i+1)+" (debe ser mayor o igual a 7) : ");
            int lon=sc.nextInt();
            while(lon<7){
                System.out.print("\nERROR\nQue longitud desea para la contraseña "+(i+1)+" (debe ser mayor o igual a 7) : ");
                 lon=sc.nextInt();
            }
            Contraseña contra=new Contraseña(lon);
            contraseñas.add(contra);
        }

    }
}
