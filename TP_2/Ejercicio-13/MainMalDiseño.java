import Ej13.MalDiseño.*;
public class MainMalDiseño {
    public static void main(String[] args) {
        System.out.println("Pepe es el piloto de un vuelo");
        Vuelo vuelo1=new Vuelo();
        Tripulante pepeTripuVer=new Tripulante("pepe","1128733008","Av corrientes 278","Piloto");
        vuelo1.add(pepeTripuVer);
        System.out.println("Ahora Pepe se quiere ir de vacaciones a MAIAMEEEEEEE entonces compra un ticket");
        //El ticket solo esta relacionado con pasajero por lo que pepe necesita registrarse
        //nuevamente, pero esta vez como pasajero
        Vuelo vuelo2=new Vuelo();
        Ticket ticket = new Ticket(10,vuelo2);
        Pasajero pepePasajeroVer=new Pasajero("pepe","1128733008","Av corrientes 278 ",987,ticket);
        vuelo2.add(pepePasajeroVer);
        System.out.println("Hay 2 versiones de la persona pepe, una como pasajero y otra como tripulante");

    }
}
