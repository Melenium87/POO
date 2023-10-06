package Ej6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ModuloInformes {
    private ArrayList<Venta> ventas;
    private ArrayList<Empleado> empleados;
    private ArrayList<Cliente> clientes;

    private ArrayList<Double> listadoPV(){
        if (ventas.isEmpty()){
            return null;
        } else {
            ArrayList<Combustible> combustibles = new ArrayList<>();
            double totalVentas = 0;
            for (Venta venta : ventas) {
                totalVentas += venta.getTotal();
                Combustible combustible = venta.getCombustible();
                if (!combustibles.contains(combustible)) {
                    combustibles.add(combustible);
                }
            }
            ArrayList<Double> proporciones = new ArrayList<>();
            for (Combustible combustible : combustibles){
                double proporcion = totalVentas / combustible.totalVentas * 100;
                proporciones.add(proporcion);
                System.out.println("Las ventas del combustible " + combustible.getNombre() + " representan el %" + proporcion + " de las ventas.");
            }
            return proporciones;
        }
    }

    private ArrayList<Expendedor> listadoEV(){
        if (ventas.isEmpty()){
            return null;
        } else {
            ArrayList<Expendedor> listaVentasExpendedores = new ArrayList<>();
            for (Venta venta : ventas){
                Expendedor expendedor = venta.getExpendedor();
                if (!listaVentasExpendedores.contains(expendedor)) {
                    listaVentasExpendedores.add(expendedor);
                }

                listaVentasExpendedores.sort(Comparator.comparing(e -> e.totalVentas));
            }
            return listaVentasExpendedores;
        }
    }

    private ArrayList<Expendedor> listadoEL(){
        if (ventas.isEmpty()){
            return null;
        } else {
            ArrayList<Expendedor> listaLitrosExpendedores = new ArrayList<>();
            for (Venta venta : ventas){
                Expendedor expendedor = venta.getExpendedor();
                if (!listaLitrosExpendedores.contains(expendedor)) {
                    listaLitrosExpendedores.add(expendedor);
                }

                listaLitrosExpendedores.sort(Comparator.comparing(e -> e.litrosExpendidos));
            }
            return listaLitrosExpendedores;
        }
    }

    private ArrayList<Empleado> listaEmpV(){
        if (ventas.isEmpty()){
            return null;
        } else {
            ArrayList<Empleado> listaVentasEmpleados = new ArrayList<>(empleados);
            listaVentasEmpleados.sort(Comparator.comparing(emp -> emp.totalVentas));
            return listaVentasEmpleados;
        }
    }

    private List<Cliente> rankingClientes(){
        if (clientes.isEmpty()){
            return null;
        } else {
            ArrayList<Cliente> topTen = new ArrayList<>(clientes);
            topTen.sort(Comparator.comparing(Cliente::totalHistoricoCompras));
            return topTen.subList(0,9);
        }
    }



}
