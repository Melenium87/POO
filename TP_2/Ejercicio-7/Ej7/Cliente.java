package Ej7;

import Ej6.Venta;

import java.util.ArrayList;

public class Cliente {
    private String nombre;
    String patente;
    private String dni;
    private ArrayList<Venta> compras;
    private boolean topTen = false;

    public Cliente(String nombre, String patente, String dni){
        this.nombre = nombre;
        this.patente = patente;
        this.dni = dni;
        this.compras = new ArrayList<>();
    }

    public void nuevaCompra(Venta compra){
        this.compras.add(compra);
    }

    public double totalHistoricoCompras(){
        double totalHistorico = 0;
        for (Venta compra : compras){
            totalHistorico += compra.getTotal();
        }
        return totalHistorico;
    }

    public String getPatente(){
        return this.patente;
    }

    public boolean getTopTen(){
        return this.topTen;
    }

    public void entroTopTen(){
        this.topTen = true;
    }

}
