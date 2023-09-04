package Ej3.TP_2.POO;

import java.util.ArrayList;

public class Disciplina {
    private String nombre;
    private String programa;
    private ArrayList<Comision>comisiones = new ArrayList<>();
    private int asistTotales=0;
    private ArrayList<Alumno>alumnosAnotados=new ArrayList<>();
    private ArrayList<Credencial>credencialesValidas=new ArrayList<>();
    private Integer nroComs=1;


    public Disciplina(String nombre,String programa){
        this.nombre=nombre;
        this.programa=programa;
    }
    public void inscribir(Credencial cre,Alumno al){
        if(credencialesValidas.contains(cre)){
            System.out.println("La credencial ya esta registrada anteriormente");
            return;
        }
        credencialesValidas.add(cre);
        alumnosAnotados.add(al);

    }

    public  void regAsistencia(Credencial cre){
        if(credencialesValidas.contains(cre)){
            asistTotales++;
        }
    }
    public void reiniciarAsistencias(){
        asistTotales=0;
        for (Comision c:comisiones){
            c.reiniciarAsistencias();
        }
    }

    public void crearComision(String horario,Profesor tutor,String nivel,Salon salon){
        Comision com=new Comision(horario,tutor,nivel,salon,nombre,nroComs);
        comisiones.add(com);
        tutor.asignarComision(com);
        nroComs++;
    }

    public int getAsistTotales() {
        return asistTotales;
    }
}
