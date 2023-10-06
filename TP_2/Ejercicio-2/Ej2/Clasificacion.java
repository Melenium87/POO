package Ej2;

import java.util.ArrayList;

public class Clasificacion {
    private int tipo;
    private Transporte tipoT = new Transporte();
    private Hospedaje tipoH = new Hospedaje();
    private Excursion tipoE = new Excursion();
    public Clasificacion(String tipoCla, String tipo){
        if(tipoCla.equalsIgnoreCase(tipoH.nombre())){
            setTipo(2);
            tipoH = new Hospedaje(tipo);
        } else {
            setTipo(1);
            tipoT = new Transporte(tipo);
        }
    }
    public Clasificacion(String tipoCla, ArrayList<String> tipo){
        if(tipoCla.equalsIgnoreCase(tipoE.tipo())) {
            setTipo(3);
            tipoE = new Excursion(tipo);
        }
    }
    private void setTipo(int i){ tipo = i; }
    private int getTipo(){ return tipo; }
    public String toString(){
        if(tipo==1){
            return "Clasificacion: "+tipoT.nombre()+".\nTipo:"+tipoT.tipo()+".\n";
        } else if(tipo==2){
            return  "Clasificacion: "+tipoH.nombre()+".\nTipo:"+tipoH.nombre()+".\n";
        } else {
            return "Clasificacion: "+tipoE.nombre()+".\nTipos:"+tipoE+".\n";
        }
    }
}
