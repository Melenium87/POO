import Ej5.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MainEj5 {
    private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    private Scanner leer = new Scanner(System.in);
    private ArrayList<BilleteraVirtual> billeteras = new ArrayList<>();
    public static void main(String[] args) throws ParseException {
        MainEj5 sistema = new MainEj5();
        sistema.menu();
    }
    public void menu() throws ParseException {
        boolean control = true;
        while(control) {
            int op;
            System.out.println("\tBienvenid@ al menú.");
            System.out.println("1-.Crear cliente.");
            System.out.println("2-.Habilitar cuenta de Credito a cliente");
            System.out.println("3-.Agregar saldo a cuenta normal.");
            System.out.println("4-.Agregar saldo a cuenta de credito.");
            System.out.println("5-.Pagar con cuenta normal.");
            System.out.println("6-.Pagar con cuenta de credito.");
            System.out.println("7-.Invertir dinero.");
            System.out.println("8-.Mostrar información completa de un cliente");
            System.out.println("0-.Salir.");
            System.out.print("Ingrese una opción: ");
            op = leer.nextInt();
            switch(op){
                case 1 -> crearCliente();
                case 2 -> crearCuentaCredito();
                case 3 -> agregarSaldo();
                case 4 -> pedirCredito();
                case 5 -> pagarSaldoNormal();
                case 6 -> pagarSaldoCredito();
                case 7 -> invertir();
                case 8 -> mostrarCliente();
                case 0 -> control=false;
                default ->
                        System.out.println("Ingrese una opcion valida.");
            }
        }
    }
    public void mostrarCliente(){
        int num;
        System.out.print("Ingrese numero de cliente: ");
        num = leer.nextInt();
        BilleteraVirtual billetera = billeteras.get(num-1);
        billetera.mostrarBilletera();
    }
    public void crearCliente(){
        String nombre, apellido, dni, email;
        //Aca se crea la billetera después de crear el cliente
        System.out.print("Ingrese el nombre: ");
        nombre = leer.nextLine();
        System.out.print("Ingrese apellido: ");
        apellido = leer.nextLine();
        System.out.print("Ingrese dni: ");
        dni = leer.nextLine();
        System.out.print("Ingrese email: ");
        email = leer.nextLine();
        Cliente nuevoCliente = new Cliente(nombre, apellido, dni, email);
        BilleteraVirtual billetera = new BilleteraVirtual(nuevoCliente);
        billeteras.add(billetera);
        System.out.printf("El número de indentificación del cliente generado es: " + billeteras.size());
    }
    public void crearCuentaCredito(){
        int num;
        System.out.print("Ingrese numero de cliente: ");
        num = leer.nextInt();
        BilleteraVirtual billetera = billeteras.get(num-1);
        billetera.crearCuentaCredito();
    }
    public void agregarSaldo(){
        int num;
        double monto;
        //Se paga la deuda de la cuenta credito
        System.out.print("Ingrese numero de cliente: ");
        num = leer.nextInt();
        BilleteraVirtual billetera = billeteras.get(num-1);
        System.out.print("Ingrese monto a agregar: ");
        monto = leer.nextInt();
        billetera.cargarSaldoNormal(monto);
    }
    public void pedirCredito(){
        int num;
        double monto;
        System.out.print("Ingrese numero de cliente: ");
        num = leer.nextInt();
        BilleteraVirtual billetera = billeteras.get(num-1);
        System.out.print("Ingrese monto a agregar: ");
        monto = leer.nextInt();
        billetera.cargarSaldoCredito(monto);
    }
    public void invertir() throws ParseException {
        Date fechaInicio;
        String fecha;
        int num;
        double monto;
        System.out.print("Ingrese numero de cliente: ");
        num = leer.nextInt();
        BilleteraVirtual billetera = billeteras.get(num-1);
        System.out.print("Ingrese monto a invertir: ");
        monto = leer.nextInt();
        System.out.print("Ingrese fecha de inicio (format:dd/MM/YYYY) : ");
        fecha = leer.nextLine();
        fechaInicio = formato.parse(fecha);
        System.out.print("Ingrese cantidad de días que durará la inversión: ");
        num = leer.nextInt();
        billetera.invertir(monto, fechaInicio, num);
    }
    public void pagarSaldoNormal(){
        int num;
        double monto;
        System.out.print("Ingrese numero de cliente: ");
        num = leer.nextInt();
        BilleteraVirtual billetera = billeteras.get(num-1);
        System.out.print("Ingrese monto a pagar: ");
        monto = leer.nextInt();
        billetera.pagarConNormal(monto);
    }
    public void  pagarSaldoCredito(){
        //Cada que se quita saldo del credito, a ese monto se le
        // agrega un 5% al saldo que debe devolver
        int num;
        double monto;
        System.out.print("Ingrese numero de cliente: ");
        num = leer.nextInt();
        BilleteraVirtual billetera = billeteras.get(num-1);
        System.out.print("Ingrese monto a pagar: ");
        monto = leer.nextInt();
        billetera.pagarConCredito(monto);
    }
}
