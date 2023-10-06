package Ej4;

public class CuentaCredito{
    /*Responsabilidades
        agrega un 5% al hacer una compra
        tiene limite de gasto(fijo)
            Se decrementa según el monto a gastar
            Se incrementa al realizar un pago de un crédito

        Excepcion: Compro algo de 10 pesos, se agrega 0.5 (5%fijo)
        Al pagar esa deuda de 10.5 el limite de gasto vuelve a su máximo, no se le suma un 5%
     */
    private final double limiteTotal = 10000; //Podría ser el 35%
    private double limiteActual = limiteTotal;
    private double credito = 0;
    public boolean realizarCompra(double monto){
        if(monto > limiteActual){
            return false;
        } else {
            limiteActual -= monto;
            credito += ((monto*5)/100);
            return true;
        }
    }
    public void agregarSaldo(double monto){
        double resto = ((monto * 5)/100);
        monto -= resto;
        credito -= resto;
        if(monto + limiteActual > limiteTotal){
            limiteActual = limiteTotal;
        } else {
            limiteActual += monto;
        }
    }
    public double limiteDisponible(){
        return limiteActual;
    }
    public double deuda(){
        return credito;
    }
}
