package Ej2;

import java.util.ArrayList;
import java.util.Arrays;

public class Excursion {
    private String nombre = "excursion";
    private ArrayList<String> tipo = new ArrayList<>();
    private final ArrayList<String> tipos = new ArrayList<>();
    public Excursion(ArrayList<String> tipo){
        tipos.addAll(Arrays.asList("Cientifica", "Cultural", "Deportiva", "Educativa", "Recreativa", "Turismo"));
        for(String t : tipo){
            if(tipoExiste(t)){
                tipo.add(t);
            }
        }
    }
    public Excursion(){
        tipos.addAll(Arrays.asList("Cientifica", "Cultural", "Deportiva", "Educativa", "Recreativa", "Turismo"));
    }
    private void setNombre(String nombre){ this.nombre = nombre; }
    private String getNombre(){ return nombre; }
    public String nombre(){ return getNombre(); }
    public String toString(){
        String cadena = "\tTipos de hospedaje: \n";
        for(String tipo : tipos){
            cadena += "\t-"+tipo+".\n";
        }
        return cadena;
    }
    public String tipo(){ return "excursion"; }
    public boolean tipoExiste(String tipo){ return tipos.contains(tipo); }
    public String excursiones(){
        String cadena ="";
        for(String tipo: this.tipo){
            cadena += "\t-"+tipo+"\n";
        }
        return cadena;
    }
}
