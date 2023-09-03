import estructuas.ListaDobleEnlace;
import java.util.Scanner;


//Las validaciones deberian hacerse del lado del las llamadas, esto es simplemente para demopstrar que funciona

public class MainEj2 {
    public static int menu()
    {

        System.out.println("\n1 - **Crear una ListaDobleEnlace**");
        System.out.println("2 - **Consultar si la ListaDobleEnlace está vacía**");
        System.out.println("3 - **Consultar la longitud de la ListaDobleEnlace**");
        System.out.println("4 - **Agregar elemento al final de la ListaDobleEnlace**");
        System.out.println("5 - **Eliminar elemento de la ListaDobleEnlace**");
        System.out.println("6 - **Recuperar elemento de la ListaDobleEnlace**");
        System.out.println("7 - **Recuperar elemento anterior de la ListaDobleEnlace**");
        System.out.println("8 - **Insertar elemento en la ListaDobleEnlace en una posición específica**");
        System.out.println("9 - **Mostrar ListaDobleEnlace**");
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
        ListaDobleEnlace ListaDobleEnlace=new ListaDobleEnlace();
        int opcion =menu();
        while   (opcion<0||opcion>9)
        {
            opcion=menu();
        }
        while (opcion!=0)
        {
            switch (opcion) {
                case 1:
                    ListaDobleEnlace= new ListaDobleEnlace();
                    System.out.println("Se ha creado una nueva ListaDobleEnlace");
                    break;
                case 2:
                    boolean vacia=ListaDobleEnlace.listaEsVacia();
                    System.out.println("La ListaDobleEnlace es vacia:"+ vacia);
                    break;
                case 3:
                    System.out.println("La ListaDobleEnlace es de:"+ ListaDobleEnlace.longitud() + "elementos");
                    break;
                case 4:

                    System.out.print("Que elemento desea agregar: ");
                    ListaDobleEnlace.agregar(scanner.nextLine());
                    break;

                case 5:

                    System.out.print("Que posicion desea eliminar: ");
                    ListaDobleEnlace.eliminar(scanner.nextInt());
                    break;
                case 6:
                    System.out.print("En que posicion desea recuperar: ");
                    int pos = scanner.nextInt();
                    Object dato=ListaDobleEnlace.recuperar(pos);
                    System.out.println("El dato recuperado fue: "+ dato);
                    break;

                case 7:
                    System.out.print("En que posicion desea recuperar: ");
                    int posix = scanner.nextInt();
                    Object datox=ListaDobleEnlace.recuperarAnterior(posix);
                    if(datox==null)
                    {
                        System.out.println("La posicion ingresada no tiene un dato anterior: ");
                    }
                    else
                    {
                        System.out.println("El dato recuperado fue: "+ datox);
                    }
                    break;

                case 8:
                    Object dat;
                    Scanner scanerDato = new Scanner(System.in);
                    System.out.print("Que desea agregar: ");
                    dat= scanerDato.nextLine();
                    System.out.print("En que posicion desea agregarlo: ");
                    int posicion = scanner.nextInt();
                    ListaDobleEnlace.insertar(dat,posicion);
                    break;

                case 9:
                    ListaDobleEnlace.mostrar();
            }
            opcion=menu();
        }

    }
}