import Estructuras.Lista;

import java.util.Scanner;

//Las validaciones deberian hacerse del lado del las llamadas, esto es simplemente para demopstrar que funciona

public class MainEj1 {
    public static int menu()
    {

        System.out.println("\n1 - **Crear una lista**");
        System.out.println("2 - **Consultar si la lista está vacía**");
        System.out.println("3 - **Consultar la longitud de la lista**");
        System.out.println("4 - **Agregar elemento al final de la lista**");
        System.out.println("5 - **Eliminar elemento de la lista**");
        System.out.println("6 - **Recuperar elemento de la lista**");
        System.out.println("7 - **Insertar elemento en la lista en una posición específica**");
        System.out.println("8 - **Mostrar lista**");
        System.out.println("0 - **Salir**");
        System.out.println("");
        System.out.print("Opcion: ");
        Scanner scanner=new Scanner(System.in);
        int opcion= scanner.nextInt();
        return opcion;

    }
    public static void main(String[] args)
    {
        Scanner scanner= new Scanner(System.in);
        Lista lista=new Lista();
        int opcion =menu();
        while   (opcion<0||opcion>8)
        {
            opcion=menu();
        }
        while (opcion!=0)
        {
            switch (opcion) {
                case 1:
                    lista= new Lista();
                    System.out.println("Se ha creado una nueva lista");
                    break;
                case 2:
                    boolean vacia=lista.listaEsVacia();
                    System.out.println("La lista es vacia:"+ vacia);
                    break;
                case 3:
                    System.out.println("La lista es de:"+ lista.longitud() + "elementos");
                    break;
                case 4:

                    System.out.print("Que elemento desea agregar: ");
                    lista.agregar(scanner.nextLine());
                    break;

                case 5:

                    System.out.print("Que posicion desea eliminar: ");
                    lista.eliminar(scanner.nextInt());
                    break;
                case 6:
                    System.out.print("En que posicion desea recuperar: ");
                    int pos = scanner.nextInt();
                    Object dato=lista.recuperar(pos);
                    System.out.println("El dato recuperado fue: "+ dato);
                    break;

                case 7:
                    Object dat;
                    Scanner scanerDato = new Scanner(System.in);
                    System.out.print("Que desea agregar: ");
                    dat= scanerDato.nextLine();
                    System.out.print("En que posicion desea agregarlo: ");
                    int posicion = scanner.nextInt();
                    lista.insertar(dat,posicion);
                    break;

                case 8:
                    lista.mostrar();
            }
            opcion=menu();
        }

    }
}