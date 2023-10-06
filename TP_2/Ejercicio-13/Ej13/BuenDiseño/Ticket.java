package Ej13.BuenDiseño;

public class Ticket {
    private String nro;
    private Vuelo vuelo;

    public Ticket(String nro, Vuelo vuelo){
        this.nro=nro;
        this.vuelo=vuelo;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }
}
