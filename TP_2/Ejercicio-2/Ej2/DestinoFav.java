package Ej2;

import java.util.ArrayList;

public class DestinoFav {
    private ArrayList<String> destinos = new ArrayList<>();
    private ArrayList<Integer> cantidades = new ArrayList<>();
    public void agregarDestino(String destino){
        if(existeDestino(destino)){
            cantidades.set(destinos.indexOf(destino),+1);
        } else {
            destinos.add(destino);
            cantidades.add(destinos.indexOf(destino),1);
        }
    }
    private boolean existeDestino(String destino){
        for(String d : destinos){
            if(d.equalsIgnoreCase(destino)){
                return true;
            }
        }
        return false;
    }
    public String toString(){
        String cadena ="Destino favorito: ";
        int mayor=0, indexMayor=0;
        for(Integer cantidad : cantidades){
            if(cantidad>mayor){
                mayor = cantidad;
                indexMayor++;
            }
        }
        cadena += destinos.get(indexMayor)+".\nCantidad de viajes al destino: "+mayor+".\n";
        return cadena;
    }
}
