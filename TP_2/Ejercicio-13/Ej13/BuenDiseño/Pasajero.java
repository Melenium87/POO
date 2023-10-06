package Ej13.BuenDiseño;


public class Pasajero implements Rol {
    private String numeroPasajero;
    private Ticket ticket;

    public Pasajero(String numeroPasajero,Ticket ticket) {
        this.numeroPasajero=numeroPasajero;
        this.ticket=ticket;
    }


    @Override
    public Boolean parcipoEn(Vuelo vuelo) {
        if (ticket.getVuelo()==vuelo){
            return true;
        }
        return false;
    }
}
