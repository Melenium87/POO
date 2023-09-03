package EstructuraTareasEj13;

import java.util.Objects;

public class Colaborador {
    private String nombre=null;
    private int poyectosTerminados=0;
    private String contra;

    public Colaborador(String nombre,String contra)
    {
        this.nombre=nombre;
        this.contra=contra;
    }
    public Colaborador()
    {
    }

    public void sumarProyecto(){
        poyectosTerminados++;
    }
    public String getNombre() {
        return nombre;
    }
    public boolean verificarContra(String s)
    {
        return Objects.equals(s, contra);
    }
}

