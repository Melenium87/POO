package Ej2;

import java.util.ArrayList;

public class PaqueteTurismo {
    private static int contadorPaquetes=1;
    private int nroPaquete;
    private String destino;
    private Transporte transporte = new Transporte();
    private Hospedaje hospedaje = new Hospedaje();
    private Excursion excursiones = new Excursion();
    public PaqueteTurismo(String destino, String transporte, String hospedaje, ArrayList<String> excursiones){
        if(existeT(transporte) && existeH(hospedaje) && existeE(excursiones)){
            this.destino = destino;
            this.transporte = new Transporte(transporte);
            this.hospedaje = new Hospedaje(hospedaje);
            this.excursiones = new Excursion(excursiones);
            nroPaquete = contadorPaquetes;
            contadorPaquetes++;
        }

    }
    public String destino(){
        return destino;
    }
    private boolean existeT(String tipo){
        transporte = new Transporte();
        return transporte.tipoExiste(tipo);
    }
    private boolean existeH(String tipo){
        hospedaje = new Hospedaje();
        return hospedaje.tipoExiste(tipo);
    }
    private boolean existeE(ArrayList<String> tipos){
        for(String tipo : tipos){
            if(!excursiones.tipoExiste(tipo)) {return false;}
        }
        return true;
    }
    public String toString(){
        String cadena = "\nContenido del paquete nro "+nroPaquete+":\n";
        cadena += "Destino: "+destino;
        cadena += ".\nTransporte: "+transporte.tipo();
        cadena += ".\nHospedaje: "+hospedaje.tipo();
        cadena += ".\nExcursion/es: "+excursiones.excursiones();
        return cadena;
    }
}
