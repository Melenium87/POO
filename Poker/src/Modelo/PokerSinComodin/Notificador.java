package Modelo.PokerSinComodin;

import Vistas.Observer;

import java.util.ArrayList;

public class Notificador implements Observado{
    private ArrayList<Observer> mirones=new ArrayList<>();
    private StringBuilder mensaje=new StringBuilder();
    @Override
    public void notificar(String str) {
        mensaje.append("\n");
        mensaje.append(str);
        for (Observer miron:mirones){
            miron.update();
        }
    }

    @Override
    public void agregarMiron(Observer o) {
        mirones.add(o);
    }

    @Override
    public void eliminarMiron(Observer o) {
        mirones.remove(o);
    }

    @Override
    public String getState() {
        return mensaje.toString();
    }
}
