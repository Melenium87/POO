import EstructuraCola.Cola;

import java.util.Scanner;

//Las validaciones deberian hacerse del lado del las llamadas, esto es simplemente para demostrar que funciona

public class MainEj4 {
    public static int menu()
    {

        System.out.println("\n1 - **Crear una Cola**");
        System.out.println("2 - **Consultar si la Cola está vacía**");
        System.out.println("3 - **Consultar la longitud de la Cola**");
        System.out.println("4 - **Enecolar un elemento**");
        System.out.println("5 - **Desencolar**");
        System.out.println("6 - **Recuperar frente**");
        System.out.println("7 - **Mostrar Cola**");
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
        Cola cola=new Cola();
        int opcion =menu();
        while   (opcion<0||opcion>7)
        {
            opcion=menu();
        }
        while (opcion!=0)
        {
            switch (opcion) {
                case 1:
                    cola = new Cola();
                    System.out.println("Se ha creado una nueva Cola");
                    break;
                case 2:
                    boolean vacia=cola.colaEsVacia();
                    System.out.println("La Cola es vacia:"+ vacia);
                    break;
                case 3:
                    System.out.println("La Cola es de:"+ cola.longitud() + "elementos");
                    break;
                case 4:

                    System.out.print("Que elemento desea encolar: ");
                    cola.encolar(scanner.nextLine());
                    break;

                case 5:

                    if(cola.colaEsVacia()){
                        System.out.println("La Cola esta vacia");
                    }
                    else
                    {

                        System.out.print("el elemento desencolado fue: "+cola.desencolar());

                    }
                    break;
                case 6:
                    if(cola.colaEsVacia()){
                        System.out.println("La Cola esta vacia");
                    }
                    else
                    {

                    System.out.println("el frente de la cola es: "+cola.primero() );
                    }
                    break;

                case 7:
                    cola.mostrar();
                    break;
            }
            opcion=menu();
        }

    }
}