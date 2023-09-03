package EstructurasJuego;
import java.util.ArrayList;
public class Jugador {

    private String nombre;
    private ArrayList<String> palabras;
    private int puntos=0;

    public Jugador(String i)
    {
        palabras=new ArrayList<String>();
        nombre=i;
    }
    public void ganador(Jugador j2)
    {
        if (j2.puntos>puntos)
        {
            System.out.println("---GANADOR: "+j2.nombre.toUpperCase()+"---");
            System.out.println("\t--- "+j2.puntos+" : "+ puntos+"---");
        }
        if (j2.puntos==puntos){
            System.out.println("---EMPATE---");
        }
        if (j2.puntos<puntos)
        {
            System.out.println("---GANADOR: "+nombre.toUpperCase()+"---");
            System.out.println("\t--- "+puntos+" : "+ j2.puntos+"---");
        }
    }
    public int getPuntos() {
        return puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean agregar(String intento,int i)
    {
        if(palabras.contains(intento.toLowerCase()))
        {
            return false;
        }
        palabras.add(intento.toLowerCase());
        puntos+=i;
        return true;
    }
}

