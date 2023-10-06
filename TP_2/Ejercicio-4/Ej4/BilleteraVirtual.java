package Ej4;

import java.util.Date;

public class BilleteraVirtual {
    /*Respondabilidades
        Hace movimientos de las cuentas (normal y credito) de un cliente
        Conocer al cliente?
     */
    private final Cliente cliente;
    private CuentaNormal cuentaNormal;
    private CuentaCredito cuentaCredito;
    private boolean credito = false;
    public BilleteraVirtual(Cliente cliente){
        this.cliente = cliente;
    }
    public void crearCuentaNormal(double monto){
        cuentaNormal = new CuentaNormal(monto);
    }
    public void crearCuentaCredito(){
        cuentaCredito = new CuentaCredito();
        credito = true;
    }
    public void cargarSaldoNormal(double monto){
        cuentaNormal.agregarSaldo(monto);
    }
    public void pagarConNormal(double monto){
        if(cuentaNormal.realizarCompra(monto)){
            System.out.println("Se realizó la compra con éxito.");
        } else {
            System.out.println("No se pudo realizar la compra con el saldo disponible.");
        }
    }
    public void invertir(double monto, Date fechaInicio, int cantDias){
        cuentaNormal.invertir(fechaInicio, monto, cantDias);
    }
    public void cargarSaldoCredito(double monto){
        if(credito){
            cuentaCredito.agregarSaldo(monto);
        } else {
            System.out.println("El cliente no tiene una cuenta de credito.");
        }
    }
    public void pagarConCredito(double monto){
        if(cuentaCredito.realizarCompra(monto)){
            System.out.println("Compra realizada.");
        } else{
            System.out.println("No se pudo realizar la compra, crédito insuficiente.");
        }
    }
    public void mostrarBilletera(){
        /*Saldo de la cuenta,
        límite de giro en descubierto,
        monto invertido (si existe inversión),
        monto disponible para compras a crédito y
        saldo deudor teniendo en cuenta todas las compras a crédito realizadas
         */
        System.out.println(cliente);
        System.out.println("\tInformación de la cuenta normal: ");
        System.out.print("Saldo de la cuenta normal: "+ cuentaNormal.saldo());
        System.out.printf("Limite de giro en descubierto de la cuenta: "+ cuentaNormal.limitedeGiro());
        if(cuentaNormal.montoInvertido() > 0) {
            System.out.printf("Monto invertido: "+ cuentaNormal.montoInvertido());
        }
        if(credito){
            System.out.println("\tInformación de la cuenta de crédito: ");
            System.out.printf("Monto disponible para compras a crédito: "+ cuentaCredito.limiteDisponible());
            System.out.printf("Saldo deudor: "+cuentaCredito.deuda());
        }
    }
}
