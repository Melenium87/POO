import Ej13.BuenDiseño.*;
public class MainBuenDiseño {

    public static void main(String[] args) {
        Persona pepe=new Persona("pepe","12378912","Av.Corrientes 823");
        System.out.println("Pepe es el piloto de un vuelo");
        Vuelo vuelo1=new Vuelo();
        //Se crea el rol
        Tripulante rol=new Tripulante("Piloto",vuelo1);
        //se lo establece a una persona
        pepe.establecerRol(rol);
        //se lo añade a la lista de miembros del vuelo
        vuelo1.add(pepe);

        System.out.println("Ahora Pepe se quiere ir de vacaciones a MAIAMEEEEEEE entonces compra un ticket");
        //En esta ocacion a pepe simplemente se le crea un nuevo rol que sera como pasajero para este vuelo en especifico
        Vuelo vuelo2=new Vuelo();
        //Se crea el ticket
        Ticket ticket=new Ticket("120",vuelo2);
        //Se crea el rol pasajero el cual tendra este ticket asociado
        Pasajero pasajero=new Pasajero("220",ticket);
        //ahora a pepe le asignamos el rol de pasajero para el vuelo 2
        pepe.establecerRol(pasajero);
        //se añade a pepe a la lista de miembros de ese vuelo
        vuelo2.add(pepe);
        System.out.println("Ya no se necesitan 2 versiones de pepe para asignarlo tanto de tripulante o de pasajero");

    }
}
