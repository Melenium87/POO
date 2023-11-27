package Controlador;

import Modelo.PokerSinComodin.Jugador;
import Vistas.VistaApuesta;

import java.util.ArrayList;

public class ControladorApuesta {
    VistaApuesta vista=null;

    Jugador modelo;
    private int apuesta=-1000;
    public ControladorApuesta(Jugador modelo){

        this.modelo=modelo;
    }

    public void ocultar(){
        vista.ocultarjPanel2();
    }
    public int apostar(int apuestaMin,int fichas){
        if (vista==null){
            vista=new VistaApuesta();
            vista.setControlador(this);
        }


        vista.setApuestaMin(apuestaMin);
        vista.setCantidadeFichas(modelo.verFichas());
        vista.setVisible(true);
        vista.setImagenes(modelo.mostrarImagenesDeCartas());
        vista.setNombre(modelo.getNombre());
        vista.apostar();

        int apuestaRecibida=apuesta;
        apuesta=-1000;
        return apuestaRecibida;

    }

    public void recibirApuesta(int apuesta){
        this.apuesta=apuesta;
    }
}

