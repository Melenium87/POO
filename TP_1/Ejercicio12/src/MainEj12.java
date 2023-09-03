import EstructuraTareasEj12.*;

import java.util.ArrayList;
import java.util.Scanner;

public class MainEj12 {
    public static void main(String[] args)
    {
        AdministradorTareas adm=new AdministradorTareas();
        System.out.println("---Agregar primera tarea---");
        adm.agregarTarea();
        System.out.println("---Agregar segunda tarea---");
        adm.agregarTarea();
        System.out.println("---Agregar tercera tarea---");
        adm.agregarTarea();
        System.out.println("---Buscar tarea por titulo---");
        Scanner sc=new Scanner(System.in);
        System.out.print("Cual es el titulo de la tarea que deseas buscar: ");
        adm.modificarTarea(sc.nextLine());
        System.out.println("\n---Tareas No Vencidas ordenadas---");
        ArrayList<TareaEj12>list=adm.tareasNoVencidas();

        for(TareaEj12 i:list)
        {
            i.mostrarTarea();
        }
    }
}
