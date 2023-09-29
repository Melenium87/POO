package Ej3.TP_2.POO;

import java.util.ArrayList;

public class Profesor {
    private String nombre;
    private String apellido;
    private String dni;
    private ArrayList<Comision> cargoDe=new ArrayList<>();

    public Profesor(String nombre,String apellido,String dni){
        this.dni= dni;
        this.apellido= apellido;
        this.nombre=nombre;
    }

    public String getDni() {
        return dni;
    }

    public void calcularPaga(){
        Integer monto=0;
        System.out.println("******************************************************");
        System.out.println("Profesor: "+nombre+"  DNI: "+dni);
        for(Comision c:cargoDe){
            System.out.println("Comision: "+c.getId()+"  Asistencias: "+c.getAsistencias()+ " Pago de ------> "+ c.getAsistencias()*10);
            monto+=c.getAsistencias()*10;
        }
        System.out.println("--------------------------------------------------------");
        System.out.println("Monto total: "+monto);
        System.out.println("--------------------------------------------------------");
        System.out.println("******************************************************");
    }
    public void asignarComision(Comision c){
        if (!cargoDe.contains(c)){
            cargoDe.add(c);
            return;
        }
        System.out.println("El profesor ya esta a cargo de esa comision");
    }
}
