package Ej13.MalDiseño;
import java.util.ArrayList;

public class Tripulante extends Persona{
    private String cargo;
    private ArrayList<ReciboSueldo> recibos=new ArrayList<>();
    public Tripulante(String nombre, String numeroDeTelefono, String direccion,String cargo) {
        super(nombre, numeroDeTelefono, direccion);
        this.cargo=cargo;
    }
}
