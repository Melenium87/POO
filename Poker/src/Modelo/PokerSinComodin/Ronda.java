package Modelo.PokerSinComodin;

import java.util.ArrayList;


public class Ronda {

    private Integer apuestas=0;
    private Integer apuestaMin;
    private Integer apuestaActual;
    private boolean hayApuesta=false;
    private Integer inicio;
    private ArrayList<Jugador> jugadores;
    private ArrayList<Jugador> jugando;
    private Jugador jugadorAEliminar=null;
    private Jugador jugadorActual;
    private Baraja baraja=new Baraja();


    public Ronda(ArrayList<Jugador> jugadores,Integer inicio,Integer apuestaMin){
        this.jugadores=jugadores;
        this.inicio=inicio;
        this.apuestaMin=apuestaMin;
        apuestaActual=apuestaMin;

        jugadorActual=jugadores.get(inicio);

    }


    public void iniciar(){
        jugando = new ArrayList<>(jugadores);
        ArrayList<Jugador> jugadoresDescartados=new ArrayList<>();
        for (Jugador j:jugando){
            if (j.apuestaMinima(apuestaMin)){
                apuestas+=apuestaMin;
                j.recibirCartas(baraja.repartir());
            }
            else{
                jugadoresDescartados.add(j);
            }
        }
        jugando.removeAll(jugadoresDescartados);
        apuestas();
        if (jugando.size()==1){
            ganador();
            for (Jugador j:jugadores){
                j.limpiar();
            }
            return;
        }
        descarte();
        apuestas();
        if (jugando.size()==1){
            ganador();
            for (Jugador j:jugadores){
                j.limpiar();
            }
            return;
        }
        else {
            buscarGanador();
            for (Jugador j:jugadores){
                j.limpiar();
            }
        }

    }

    private void ganador(){
        Jugador ganador=jugando.get(0);
        if (ganador.getTotalApostado()==apuestaActual){
            ganador.recibirFichas(apuestas);
            for(Jugador j:jugadores){
                j.mostrarGanador(ganador);
            }
        }
        else{
            Jugador jugandorMasAposto=null;
            for(Jugador j:jugadores){
                if (jugandorMasAposto==null){
                    jugandorMasAposto=j;
                }
                if (jugandorMasAposto.getTotalApostado()<j.getTotalApostado()){
                    jugandorMasAposto=j;
                }
                j.mostrarGanador(ganador);
            }
            ganador.recibirFichas(ganador.getMontoGanable());
            jugandorMasAposto.recibirFichas(apuestas-ganador.getMontoGanable());

        }

    }
    private void empate(ArrayList<Jugador> jugas) {
        for(Jugador j:jugadores){
            j.mostrarGanador(jugas);
        }
        for (Jugador j:jugando){

            j.recibirFichas(apuestas/ jugando.size());
        }

    }

    private void buscarGanador(){
        Jugador actual;
        for (int i=0; i<jugando.size();i++){
            actual=jugando.get(i);
            if(i+1!=jugando.size()){
                int mejor=actual.mejorQue(jugando.get(i+1));
                if (mejor==0){
                    continue;
                }
                if (mejor==1){
                    jugando.remove(i+1);
                    i--;
                    continue;
                }
                if (mejor==-1){
                    jugando.remove(i);
                    i--;

                }
            }
        }
        if(jugando.size()==1){
            ganador();
        }
        else {
            empate(jugando);
        }
    }



    private void siguienteTurno(){
        int posicionActual=jugando.indexOf(jugadorActual);
        if(posicionActual==jugando.size()-1){
            jugadorActual=jugando.get(0);
        }
        else{
            jugadorActual= jugando.get(posicionActual+1);
        }
        if (jugadorAEliminar!=null){
            jugando.remove(jugadorAEliminar);
            jugadorAEliminar=null;
        }
    }
    public Jugador turno(){

        return jugadorActual;
    }

    private void apuestas()  {
        int contador=1;
        hayApuesta=false;
        while (!(contador== jugando.size())){
            if (jugando.size()==1){
                return;
            }
            int apuestaJugador=jugadorActual.apostar(apuestaActual,apuestas,hayApuesta);
            if (apuestaJugador==-1){
                jugadorAEliminar=jugadorActual;
                contador++;
            }
            else {

                apuestas+=apuestaJugador;
                if (apuestaJugador>apuestaActual){
                    apuestaActual=apuestaJugador;
                    hayApuesta=true;
                    contador=1;
                }
                else {
                    contador++;
                }
            }
            siguienteTurno();
        }

    }
    private void descarte(){
        for (Jugador j:jugando){
            int numCartasDescartadas=j.descartar();
            j.recibirCartas(baraja.darCartas(numCartasDescartadas));
        }
    }



}


