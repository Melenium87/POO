package Ej2;

public class Cliente {
    private static int contadorClientes=1;
    private int nroCliente;
    private String nombre;
    private String email;
    private String dni;
    public Cliente(String nombre, String email, String dni){
        nroCliente = contadorClientes;
        contadorClientes++;
        this.nombre = nombre;
        this.dni = dni;
        this.email = email;
    }
    public String toString(){
        String cadena ="\nnroCliente: "+nroCliente;
        cadena += ".\n\tNombre: "+nombre;
        cadena += ".\n\tDNI: "+dni;
        cadena+= ".\n\tE-mail: "+email;
        return cadena;
    }
}
