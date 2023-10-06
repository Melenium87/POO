package Ej2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Agencia {
    public static void main(String[] args) {
        Agencia sistema = new Agencia();
        sistema.iniciarSistema();
    }
    private DestinoFav destinoFav;
    private ArrayList<Cliente> clientes;
    private ArrayList<Proveedor> proveedores;
    private ArrayList<PaqueteTurismo> paquetesDeTurismo;
    //private ArrayList<Ej6.Ej7.Ej10.Venta> ventas;
    private HashMap<String,Venta> ventas;
    private final Scanner leer = new Scanner(System.in);

    public void iniciarSistema(){
        sistema();
    }
    private void sistema(){
        destinoFav = new DestinoFav();
        clientes = new ArrayList<>();
        proveedores = new ArrayList<>();
        paquetesDeTurismo = new ArrayList<>();
        ventas = new HashMap<>();
        boolean control;
        do{
            control = menu();
        }while(control);
    }
    private boolean menu(){
        System.out.println("\tBienvenid@ al menú.");
        System.out.println("1-.Crear cliente.");
        System.out.println("2-.Crear paquete de turismo.");
        System.out.println("3-.Crear proveedor.");
        System.out.println("4-.Realizar venta de paquete.");
        System.out.println("5-.Ver proveedores.");
        System.out.println("6-.Ver paquetes de turismo.");
        System.out.println("7-.Ver ventas.");
        System.out.println("8-.Ver destino favorito de los clientes.");
        System.out.println("9-.Ver clientes.");
        System.out.println("0-.Salir.");
        System.out.println("Ingrese una opcion: ");
        int op = leer.nextInt();
        switch (op) {
            case 0 -> {
                return false;
            }
            case 1 -> agregarCliente();
            case 2 -> agregarPaquete();
            case 3 -> agregarProveedor();
            case 4 -> agregarVenta();
            case 5 -> verProveedores();
            case 6 -> verPaquetes();
            case 7 -> verVentas();
            case 8 -> destinoFavorito();
            case 9 -> verClientes();
        }
        return true;
    }
    private void agregarCliente(){
        System.out.print("Ingrese el nombre del nuevo cliente: ");
        String nombre = leer.nextLine();
        System.out.print("Ingrese el email del nuevo cliente: ");
        String email = leer.nextLine();
        System.out.print("Ingrese el dni del nuevo cliente");
        String dni = leer.nextLine();
        Cliente nuevo_cliente = new Cliente(nombre,email,dni);
        clientes.add(nuevo_cliente);
    }
    private void agregarPaquete(){
        Transporte transporte = new Transporte();
        Hospedaje hospedaje = new Hospedaje();
        Excursion excursion = new Excursion();
        System.out.print("Ingrese el destino del paquete: ");
        leer.nextLine();
        String destino = leer.nextLine();
        String trans, hos, exc;
        ArrayList<String> excs = new ArrayList<>();
        do{
            System.out.println(transporte);
            System.out.print("Ingrese el medio de transporte del paquete: ");
            trans = leer.nextLine();
        }while(!transporte.tipoExiste(trans));
        do{
            System.out.println(hospedaje);
            System.out.print("Ingrese el hospedaje del paquete: ");
            hos = leer.nextLine();
        }while(hospedaje.tipoExiste(hos));
        do{
            System.out.println(excursion);
            System.out.print("Ingrese el tipo o los tipos de excursiones a agregar: (0-salir)");
            exc = leer.nextLine();
            excs.add(exc);
        }while(exc.equals("0"));
        PaqueteTurismo nuevo_paquete = new PaqueteTurismo(destino, trans, hos, excs);
        paquetesDeTurismo.add(nuevo_paquete);
    }
    private void agregarProveedor(){
        Transporte transporte = new Transporte();
        Hospedaje hospedaje = new Hospedaje();
        Excursion excursion = new Excursion();
        System.out.print("Ingrese el nombre del proveedor: ");
        leer.nextLine();
        String nombre = leer.nextLine();
        System.out.println("tipos de clasificación: transporte, hospedaje y excursion.");
        System.out.print("Ingrese alguno de los tipos mensionados: ");
        String tipoCla;
        tipoCla = leer.nextLine();
        tipoCla = tipoCla.toLowerCase();
        switch(tipoCla){
            case "transporte" -> System.out.println(transporte);
            case "hospedaje" -> System.out.println(hospedaje);
            case "excursion" -> System.out.println(excursion);
        }
        Proveedor nuevo_p;
        if(tipoCla.equals("excursion")){
            ArrayList<String> excs = new ArrayList<>();
            String aux;
            do{
                System.out.println("Ingrese un tipo de los mostrados(0-salir)");
                aux = leer.nextLine();
                excs.add(aux);
            }while(!aux.equals("0"));
            nuevo_p = new Proveedor(nombre, tipoCla, excs);
        } else {
            System.out.print("Ingrese un tipo de los mostrados:");
            String tipo = leer.nextLine();
            nuevo_p = new Proveedor(nombre, tipoCla, tipo);
        }
        proveedores.add(nuevo_p);
    }
    private void agregarVenta(){
        System.out.println("Ingrese nro de paquete a vender: ");
        int nroPaquete = leer.nextInt();
        System.out.println("Ingrese nro cliente para venderle: ");
        int nroCliente = leer.nextInt();
        Venta nueva_venta = new Venta(nroCliente, nroPaquete);
        PaqueteTurismo paquete = paquetesDeTurismo.get(nroPaquete-1);
        destinoFav.agregarDestino(paquete.destino());
        ventas.put(paquete.destino(), nueva_venta);
    }
    private void verProveedores(){
        for(Proveedor proveedor : proveedores){
            System.out.println(proveedor);
        }
    }
    private void verPaquetes(){
        for(PaqueteTurismo paquete : paquetesDeTurismo){
            System.out.println(paquete);
        }
    }
    private void  verVentas(){
        System.out.println("\tVentas: \n");
        for(Map.Entry venta : ventas.entrySet()){
            Venta aux = (Venta) venta.getValue();
            String cadena = "Destino: "+venta.getKey()+".\nInformacion de la venta: ";
            cadena += clientes.get(aux.nroCliente()-1)+"\n"+paquetesDeTurismo.get(aux.nroPaquete()-1);
            System.out.println(cadena);
        }
    }
    private void destinoFavorito(){
        System.out.println(destinoFav);
    }
    private void verClientes(){
        for(Cliente cliente : clientes){
            System.out.println(cliente);
        }
    }
}
