package Ej2;

public class Venta {
    private int nroVenta=0;
    private int nroCliente;
    private int nroPaquete;
    public Venta(int nroCliente, int nroPaquete){
        this.nroCliente = nroCliente;
        this.nroPaquete = nroPaquete;
        nroVenta++;
    }
    public int nroCliente(){ return nroCliente; }
    public int nroPaquete(){ return nroPaquete; }
}
