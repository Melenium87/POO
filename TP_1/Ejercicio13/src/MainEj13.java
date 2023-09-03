import EstructuraPila.Pila;
import EstructuraTareasEj13.AdministradorTareasEj13;
import EstructuraTareasEj13.TareaEj13;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class MainEj13 {
    public static int menu() {

        System.out.println("\n1 - **Agregar colaborador**");
        System.out.println("2 - **Agregar tarea**");
        System.out.println("3 - **Buscar y modificar tarea por titulo**");
        System.out.println("4 - **Consultar tareas**");
        System.out.println("5 - **Ver proyectos de colaboradores**");
        System.out.println("0 - **Salir**");
        System.out.println("");
        System.out.print("Opcion: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AdministradorTareasEj13 adm=new AdministradorTareasEj13();
        int opcion = menu();
        while (opcion < 0 || opcion > 5) {
            opcion = menu();
        }
        while (opcion != 0) {
            switch (opcion) {
                case 1:
                    adm.agregarColaboradores();
                    break;
                case 2:
                    adm.agregarTarea();
                    break;
                case 3:
                    Scanner sc=new Scanner(System.in);
                    System.out.print("Cual es el titulo de la tarea que deseas buscar: ");
                    adm.modificarTarea(sc.nextLine());
                    break;
                case 4:
                    ArrayList<TareaEj13> list= adm.tareasNoVencidas();
                    for (TareaEj13 t:list)
                    {
                        t.mostrarTarea();
                    }
                    break;

                case 5:
                    System.out.println("Que colaborador desea buscar: ");
                    sc=new Scanner(System.in);
                    String s= sc.nextLine();
                    if(adm.buscarColaborador(s)){
                        System.out.println("Las tareas realizadas por el colaborador son: ");
                        ArrayList<TareaEj13> listas=adm.verProyectosDelColaborador(s);
                        if (listas==null){
                            System.out.println("El colaborador no termino ninguna tarea");
                            break;
                        }
                        for (TareaEj13 t:listas){

                            if(Objects.equals(t.getColaborador().getNombre(), s)){

                                t.mostrarTarea();
                            }
                        }
                    }

                    else System.out.println("Colaborador inexistente");
                    break;

            }
            opcion = menu();
        }
    }
}
