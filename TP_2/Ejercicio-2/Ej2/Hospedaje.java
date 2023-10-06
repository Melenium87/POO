package Ej2;

import java.util.ArrayList;
import java.util.Arrays;

public class Hospedaje {
    private String tipo;
    private ArrayList<String> tipos = new ArrayList<>();
    private void setTipo(String tipo){
        if(tipos.contains(tipo.toLowerCase())){
            this.tipo = tipo;
        }
    }
    private String getTipo(){ return tipo; }
    public Hospedaje(String tipo){
        tipos.addAll(Arrays.asList("Hotel", "Hosteria", "Bungalos"));
        setTipo(tipo);
    }
    public Hospedaje(){
        tipos.addAll(Arrays.asList("Hotel", "Hosteria", "Bungalos"));
    }
    public String toString(){
        String cadena = "\tTipos de hospedajes: \n";
        for(String tipo : tipos){
            cadena += "\t-"+tipo+".\n";
        }
        return cadena;
    }
    public String tipo(){ return getTipo(); }
    public String nombre(){ return "hospedaje"; }
    public boolean tipoExiste(String tipo){ return tipos.contains(tipo); }
}
