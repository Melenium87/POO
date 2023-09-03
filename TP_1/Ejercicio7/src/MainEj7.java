import EstructuraEcuacion.*;
public class MainEj7
{
    public static void main(String[] args)
    {
            System.out.println("\n Ecuacuion 1:\n");
            EcuacionSegundoGrado ecua=new EcuacionSegundoGrado(1,2,-3);
            double []raices= ecua.raices();
        if (raices==null)
        {
            System.out.println("La funcion no tiene raices");
        }
        else
        {
            if (raices.length == 2)
            {
                System.out.println("la primera raiz es: " + raices[0] + "\nLa segunda raiz es: " + raices[1]);

            }
            if (raices.length == 1)
            {

                System.out.println("la unica raiz es: " + raices[0]);

            }
        }
        System.out.println("Si la x fuera 2 el resultado de la funcion seria: " + ecua.calcularParaX(2));
        System.out.println("\n Ecuacuion 2:\n");
        ecua= new EcuacionSegundoGrado(1,2,1);
        raices= ecua.raices();
        if (raices==null)
        {
            System.out.println("La funcion no tiene raices");
        }
        else
        {
            if (raices.length == 2)
            {
                System.out.println("la primera raiz es: " + raices[0] + "\nLa segunda raiz es: " + raices[1]);

            }
            if (raices.length == 1)
            {

                System.out.println("la unica raiz es: " + raices[0]);System.out.println("Si la x fuera 2 el resultado de la funcion seria: " + ecua.calcularParaX(2));
            }
        }
        System.out.println("Si la x fuera 2 el resultado de la funcion seria: " + ecua.calcularParaX(2));
        System.out.println("\n Ecuacuion 3:\n");
        ecua=new EcuacionSegundoGrado(9,-8,3);
        raices= ecua.raices();
        if (raices==null)
        {
            System.out.println("La funcion no tiene raices");
        }
        else
        {
            if (raices.length == 2)
            {
                System.out.println("la primera raiz es: " + raices[0] + "\nLa segunda raiz es: " + raices[1]);
            }
            if (raices.length == 1)
            {

                System.out.println("la unica raiz es: " + raices[0]);

            }

        }
        System.out.println("Si la x fuera 2 el resultado de la funcion seria: " + ecua.calcularParaX(2));





    }
}
