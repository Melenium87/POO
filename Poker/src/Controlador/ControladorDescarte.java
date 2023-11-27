package Controlador;

import Modelo.PokerSinComodin.Carta;
import Modelo.PokerSinComodin.Jugador;

import Vistas.VistaDescarte;

import java.util.ArrayList;

public class ControladorDescarte {
    VistaDescarte vista;

    Jugador modelo;

    public ControladorDescarte(Jugador modelo){
        this.modelo=modelo;
    }


    public void descartarCartas() {
        vista=new VistaDescarte();

        return ;
    }
}
