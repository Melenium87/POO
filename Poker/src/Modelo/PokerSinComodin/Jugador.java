package Modelo.PokerSinComodin;

import Controlador.ControladorApuesta;
import Controlador.ControladorDescarte;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Jugador {
    public void mostrarGanador(Jugador jugas) {

    }

    public void mostrarGanador(ArrayList<Jugador> jugas) {

    }

    enum Juegos{
        CARTAMAYOR,
        PAREJA,
        DOBLEPAREJA,
        TRIO,
        ESCALERA,
        COLOR,
        FULLHOUSE,
        POKER,
        ESCALERACOLOR,
        REPOKER

    };
    private String nombre;



    private int puntosJugada;
    private Juegos jugada;
    private ArrayList<Carta> cartas=new ArrayList<>();
    private int fichas;
    private int fichasInicioRonda;

    private int totalApostado=0;

    private int montoGanable=0;
    private ControladorDescarte descarte;
    private ControladorApuesta apuesta;

    public void setControladores (ControladorApuesta apuesta, ControladorDescarte descarte){
        this.descarte=descarte;
        this.apuesta=apuesta;
    }

    public int getMontoGanable() {
        return montoGanable;
    }
    public String getNombre() {
        return nombre;
    }

    public int getTotalApostado() {
        return totalApostado;
    }

    public Jugador(String nombre, Integer fichas){
        this.nombre=nombre;
        this.fichas=fichas;
        fichasInicioRonda=fichas;
    }

    public ArrayList<Carta> mostrarCartas(){
        return cartas;
    }
    public ArrayList<String> mostrarImagenesDeCartas(){
        ArrayList<String> direcciones=new ArrayList<String>();
        String direcicionBase="D:/Uni/Poker/Poker/Images/";
        String formato=".png";
        StringBuilder dir=new StringBuilder();
        String direccionFinal;
        dir.append(direcicionBase);
        for (Carta carta:cartas) {
            dir.append("" + carta.getTipo() + "-" + carta.getValor() + formato);
            direccionFinal = dir.toString();
            direcciones.add(direccionFinal);
            direccionFinal = null;
            dir = new StringBuilder();
            dir.append(direcicionBase);
        }
        return direcciones;
    }
    public void verCartas(){
        int car=1;
        for (Carta c:cartas){
            System.out.println("------------------ "+car+" ------------------");
            System.out.println(c);
            System.out.println("-------------------------");
        }
    }
    public void recibirCartas(ArrayList<Carta> c){
        cartas.addAll(c);
        Collections.sort(cartas);
        System.out.println("\n\n");
        verCartas();
        buscarJugada();
    }
    public Integer descartar(){

        ArrayList<Carta> cartasDescartadas=new ArrayList<>();

        return cartasDescartadas.size();
    }

    public Integer apostar(int apuestaMin,int apuestaActual,boolean hayApuesta){

            int apuestaHecha= apuesta.apostar(apuestaMin,fichas);
            if (apuestaHecha==-1){
                return -1;
            }
            if (apuestaHecha==0&& !hayApuesta){
                return 0;
            }
            if (apuestaHecha+totalApostado>apuestaMin){
                totalApostado+=apuestaHecha;
                fichas-=apuestaHecha;
                return apuestaHecha;
            }
            if(apuestaHecha+totalApostado==fichasInicioRonda){
                fichas=0;
                return fichasInicioRonda;
            }


            return apuestaHecha;
    }
    public Boolean apuestaMinima(int apuesta){
        if (fichas>=apuesta){
            fichas-=apuesta;
            return true;
        }
        else {
            System.out.println("No tenes fichas capo");
            return false;
        }

    }

    void devolverCartas() {
        if (!cartas.isEmpty()) {
            cartas.clear();
        }
    }
    public int verFichas(){
        return fichas;
    }
    public void recibirFichas(int fichas){
        this.fichas+=fichas;
    }

    public int mejorQue(Jugador j2){
        if(jugada.compareTo(j2.jugada)==0){
            if (puntosJugada>j2.puntosJugada){
                return 1;
            }
            if (puntosJugada<j2.puntosJugada){
                return -1;
            }
            if (puntosJugada==j2.puntosJugada){
                return 0;
            }
        }
         return jugada.compareTo(j2.jugada);

    }

    private void buscarJugada(){
        boolean color=color();
        int puntos=escalera();
        if (puntos!=0){
            puntosJugada=puntos;
            if(color){
                jugada=Juegos.ESCALERACOLOR;
            }
            else {
                jugada=Juegos.ESCALERA;
            }
        }
        else buscarIguales();

    }





    private void buscarIguales(){
        Carta carta= cartas.get(0);
        int ant;
        int actual;
        int valor1=-1;
        boolean recienCambiadov1=false;
        int valor2=-1;
        int contador1=0;
        int contador2=0;
        ArrayList<Integer> valores=new ArrayList<>();
        valores.add(carta.getValor());
        for(int i=1;i<cartas.size();i++){
            carta=cartas.get(i);
            valores.add(carta.getValor());
        }
        valores.sort(Integer::compareTo);
        ant=valores.get(0);
        for(int i=1;i<valores.size();i++){
            actual= valores.get(i);
            if (actual==valor1){
                contador1++;
            }
            if (actual==valor2){
                contador2++;
            }
            if(valor1==-1&&actual==ant){
                contador1=2;
                valor1=actual;
                recienCambiadov1=true;
            }
            if(valor2!=-1&&actual==ant&&recienCambiadov1!=true){
                contador2=2;
                valor2=actual;

            }
            recienCambiadov1=false;
            ant=actual;
        }

        if ((contador1==2&&contador2==3)||(contador1==3&&contador2==2)){
            jugada=Juegos.FULLHOUSE;
            if (contador1==3){
                puntosJugada=valor1;
            }
            else {
                puntosJugada=valor2;
            }
        }
        if (contador1==4){
            jugada=Juegos.POKER;
            puntosJugada=valor1;
        }
        if ((contador1==3&&contador2==0)||(contador1==0&&contador2==3)){
            jugada=Juegos.TRIO;
            if (contador1==3){
                puntosJugada=valor1;
            }
            else {
                puntosJugada=valor2;
            }
        }
        if ((contador1==2&&contador2==0)||(contador1==0&&contador2==2)){
            jugada=Juegos.PAREJA;
            if (contador1==2){
                puntosJugada=valor1;
            }
            else {
                puntosJugada=valor2;
            }
        }
        if (contador1==2&&contador2==2){
            jugada=Juegos.DOBLEPAREJA;
            puntosJugada=valor1;
        }
        if (contador1==0&&contador2==0){
            jugada=Juegos.CARTAMAYOR;
            puntosJugada=valores.get(valores.size()-1);
        }

    }

    private boolean color(){
        Carta cartaAnterior= cartas.get(0);


        for(int i=1;i<cartas.size();i++){
            if (!(cartaAnterior.igualTipo(cartas.get(i)))){
                return false;
            }
            cartaAnterior=cartas.get(i);
        }
    return true;
    }

    private Integer escalera(){
        Carta carta= cartas.get(0);

        Carta.Tipo tipo=carta.getTipo();
        ArrayList<Integer> valores=new ArrayList<>();
        valores.add(carta.getValor());
        for(int i=1;i<cartas.size();i++){
            carta=cartas.get(i);
            valores.add(carta.getValor());
        }
        valores.sort(Integer::compareTo);
        int comparar= valores.get(0);
        int total=comparar;
        boolean as = false;
        if(comparar==1&&valores.get(4)==12){
            as=true;
            total=14;
        }
        for(int i=1;i<valores.size();i++) {
            if (comparar!= valores.get(i)+1|| as){
                return 0;
            }
            comparar= valores.get(i);
            total+=comparar;
        }
        
        return total;
    }





    public void limpiar(){
        puntosJugada=0;
        jugada=null;
        cartas.clear();
        montoGanable=0;
        totalApostado=0;
    }
}
