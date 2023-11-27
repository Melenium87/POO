package Controlador;

import Modelo.PokerSinComodin.Carta;
import Modelo.PokerSinComodin.Jugador;

import Vistas.VistaApuesta;
import Vistas.VistaDescarte;

import java.util.ArrayList;

public class ControladorDescarte {
    private VistaDescarte vista;
    private ArrayList<Integer> cartasSeleccionadas;
    private Jugador modelo;

    public ControladorDescarte(Jugador modelo){
        this.modelo=modelo;
    }

    public void recibirDescartes(ArrayList<Integer> i){
        cartasSeleccionadas=i;
    }
    public ArrayList<Integer> descartarCartas() {
        if (vista==null){
            vista=new VistaDescarte();
            vista.setControlador(this);
        }
        vista.setImagenes(modelo.mostrarImagenesDeCartas());
        vista.setVisible(true);
        while (cartasSeleccionadas==null){

        }
        return cartasSeleccionadas;
    }
}
