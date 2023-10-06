package Ej2;

import java.util.ArrayList;
import java.util.Arrays;

public class Transporte {
    private String tipo;
    private ArrayList<String> tipos = new ArrayList<>();
    public Transporte(String tipo){
        tipos.addAll(Arrays.asList("aerea", "maritima", "terrestre"));
        setTipo(tipo);
    }
    public Transporte(){
        tipos.addAll(Arrays.asList("aerea", "maritima", "terrestre"));
    }
    private void setTipo(String tipo){ this.tipo = tipo; }
    private String getTipo(){ return tipo; }
    public String tipo(){ return getTipo(); }
    public String toString(){
        String cadena = "\tTipos de transporte: \n";
        for(String tipo : tipos){
            cadena += "\t-"+tipo+".\n";
        }
        return cadena;
    }
    public String nombre(){ return "transporte"; }
    public void nuevoTipo(String tipo){ setTipo(tipo); }
    public boolean tipoExiste(String tipo){ return tipos.contains(tipo); }
}
