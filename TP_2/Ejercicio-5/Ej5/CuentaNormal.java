package Ej5;

import java.util.Date;

public class CuentaNormal{
    /*Responsabilidades
        límite de giro en descubierto
            Si el limite de giro es >0 entonces si carga saldo se descontará
            de allí para volver a 0 hasta que sea 0 otra vez
        saldo total
        Inversión actual (1 a la vez)
     */
    private final double giroEnDescubierto;
    private double saldoDeuda = 0;
    private double saldo;
    private Inversion invertido;

    CuentaNormal(double monto){
        saldo = monto;
        giroEnDescubierto = monto + ((monto*35)/100);
    }
    public double saldo(){
        return saldo;
    }
    public double limitedeGiro(){
        return giroEnDescubierto;
    }
    public void agregarSaldo(double saldo){
        if(saldoDeuda <= saldo && saldoDeuda > 0){ //Si tengo deuda y es más chica que el saldo cargado
            double resto = Math.abs(saldoDeuda - saldo);
            saldoDeuda = 0;
            if(resto > 0){ //Si se cubre la deuda y queda dinero, se agrega al saldo
                this.saldo += resto;
            }
        } else if(saldoDeuda > saldo){//Si la deuda que tengo es mayor al saldo cargado
            saldoDeuda -= saldo;
        } else { //Si no hay deuda se suma al saldo
            this.saldo += saldo;
        }
    }
    public boolean realizarCompra(double monto){
        if(saldo == 0 && saldoDeuda == giroEnDescubierto){
            return false;
        } else {
            if(monto > saldo){ //Si el pago supera al saldo disponible
                if(monto < saldo + invertido.invertido()){ //Si el saldo mas lo invertido cubre el monto
                    double inversion = invertido.finalizarInversion();
                    double resto = Math.abs(inversion - monto);
                    saldo -= resto;
                } else if(monto > saldo + (giroEnDescubierto - saldoDeuda) && monto < invertido.invertido() + saldo + (giroEnDescubierto - saldoDeuda)){//precancelar inversión
                    //Si el saldo necesita hacer un giro más el saldo más lo invertido
                    double inversion = invertido.finalizarInversion();
                    double resto = Math.abs(inversion - monto);
                    resto = Math.abs(saldo - resto);
                    saldo = 0;
                    System.out.printf("Se generó un giro en descubierto de :" + resto + "\n");
                    saldoDeuda += resto;
                } else {
                    double resto = Math.abs(saldo - monto);
                    saldo = 0;
                    saldoDeuda += resto;
                    System.out.printf("Se generó un giro en descubierto de :" + (saldoDeuda-resto) + "\n");
                }
            } else { //si es pago es igual o menor al saldo disponible
                saldo -= monto;
            }
        }
        return true;
    }
    public double montoInvertido(){
        return invertido.invertido();
    }
    public void invertir(Date fechaInicio, double monto, int cantDias){
        if(monto <= saldo){//Si me alcanza el saldo para invertir
            invertido = new Inversion(monto, fechaInicio, cantDias);
            saldo -= monto;
            System.out.println("Inversión realizada.");
        } else {
            System.out.print("No le alcanza el saldo para realizar la inversión.");
        }
    }
    public void finalizarInversion(){
        if(invertido.finalizarInversion() != -1){
            agregarSaldo(invertido.finalizarInversion());
        }
    }
}
