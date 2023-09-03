import EstructuraPila.Pila;

import java.util.Scanner;

//Las validaciones deberian hacerse del lado del las llamadas, esto es simplemente para demostrar que funciona

public class MainEj3 {
    public static int menu()
    {

        System.out.println("\n1 - **Crear una Pila**");
        System.out.println("2 - **Consultar si la Pila está vacía**");
        System.out.println("3 - **Consultar la longitud de la pila**");
        System.out.println("4 - **Apilar un elemento**");
        System.out.println("5 - **Desapilar**");
        System.out.println("6 - **Recuperar tope**");
        System.out.println("7 - **Mostrar pila**");
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
        Pila pila=new Pila();
        int opcion =menu();
        while   (opcion<0||opcion>7)
        {
            opcion=menu();
        }
        while (opcion!=0)
        {
            switch (opcion) {
                case 1:
                    pila = new Pila();
                    System.out.println("Se ha creado una nueva Pila");
                    break;
                case 2:
                    boolean vacia=pila.pilaEsVacia();
                    System.out.println("La pila es vacia:"+ vacia);
                    break;
                case 3:
                    System.out.println("La pila es de:"+ pila.longitud() + "elementos");
                    break;
                case 4:

                    System.out.print("Que elemento desea apilar: ");
                    pila.apilar(scanner.nextLine());
                    break;

                case 5:

                    if(pila.pilaEsVacia()){
                        System.out.println("La pila esta vacia");
                    }
                    else
                    {

                        System.out.print("El elemento desapilado fue: "+ pila.desapilar());

                    }
                    break;
                case 6:
                    if(pila.pilaEsVacia()){
                        System.out.println("La pila esta vacia");
                    }
                    else
                    {

                    System.out.println("el tope de la pila es: "+pila.tope() );
                    }
                    break;

                case 7:
                    pila.mostrar();
                    break;



            }
            opcion=menu();
        }

    }
}