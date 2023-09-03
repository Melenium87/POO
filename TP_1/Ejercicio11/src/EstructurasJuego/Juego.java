package EstructurasJuego;
import java.util.HashMap;
import java.util.Scanner;

public class Juego {
    private Jugador jugador1;
    private Jugador jugador2;
    private int turnos;
    private HashMap<String, Integer> diccionario;

    private void jugar(int turnos){

        for (int i=0;i<turnos;i++)
        {
            System.out.println("\n---"+ jugador1.getNombre()+"  Puntos: "+ jugador1.getPuntos()+"---");
            System.out.println("ingrese una palabra: ");
            Scanner sc =new Scanner(System.in);
            String palabra=sc.nextLine();
            if(diccionario.containsKey(palabra.toLowerCase()))
            {
                boolean res=jugador1.agregar(palabra.toLowerCase(),diccionario.get(palabra.toLowerCase()));
                if (!res){
                    System.out.println("Palabra repetida + 0 puntos");
                }
                System.out.println("Palabra agregada + "+diccionario.get(palabra.toLowerCase())+" puntos");
            }
            else
            {
                System.out.println("Palabra no existente + 0 puntos");
            }
            System.out.println("\n---"+ jugador2.getNombre()+"  Puntos: "+ jugador2.getPuntos()+"---");
            System.out.println("ingrese una palabra: ");
            sc =new Scanner(System.in);
            palabra=sc.nextLine();
            if(diccionario.containsKey(palabra.toLowerCase()))
            {
                boolean res=jugador2.agregar(palabra.toLowerCase(),diccionario.get(palabra.toLowerCase()));
                if (!res){
                    System.out.println("Palabra repetida + 0 puntos");
                }
                System.out.println("Palabra agregada + "+diccionario.get(palabra.toLowerCase())+" puntos");
            }
            else
            {
                System.out.println("Palabra no existente + 0 puntos");
            }

        }
        jugador1.ganador(jugador2);

    }
    public Juego(String player1,String player2,int turnos)
    {   diccionario=new HashMap<String, Integer>();
        jugador1=new Jugador(player1);
        jugador2=new Jugador(player2);
        System.out.println("Escriba las palabras que desea agregar al diccionario en el siguiente formato:");
        System.out.println("Palabra1/Palabra 2.../Palabra n");
        Scanner sc = new Scanner(System.in);
        String palas=sc.nextLine();
        Scanner p=new Scanner(palas).useDelimiter("/");
        while (p.hasNext())
        {
            String i=p.next();
            int contador=0;
            for (int x=0;x<i.length();x++)
            {
               Character c=i.charAt(x);
                    contador++;

                if (c.toString().equalsIgnoreCase("k") || c.toString().equalsIgnoreCase("y") || c.toString().equalsIgnoreCase("x") || c.toString().equalsIgnoreCase("z") || c.toString().equalsIgnoreCase("q") || c.toString().equalsIgnoreCase("2"))
                {
                    contador++;
                }


            }
            this.diccionario.put(i.toLowerCase(),contador);



        }
        jugar(turnos);

    }


}
