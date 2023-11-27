package Modelo.PokerSinComodin;

import Vistas.Observer;

public interface Observado {

    void notificar(String mensaje);
    void agregarMiron(Observer o);
    void eliminarMiron(Observer o);
    String getState();

}
