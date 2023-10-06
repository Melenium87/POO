package Ej3;

import java.util.ArrayList;
import java.util.Objects;

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

    public String getNombre() {
        return nombre;
    }

    public void reiniciarAsistencias(){
        asistTotales=0;
        for (Comision c:comisiones){
            c.reiniciarAsistencias();
        }
    }

    public void crearComision(ArrayList<String> dias,ArrayList<String> horario,Profesor tutor,String nivel,Salon salon){
        Comision com=new Comision(dias,horario,tutor,nivel,salon,nombre,nroComs);
        comisiones.add(com);
        tutor.asignarComision(com);
        nroComs++;
    }
    public Comision buscarComision(Integer comision){
        if(comisiones.isEmpty()){
            return null;
        }
        for (Comision c:comisiones){
            if (Objects.equals(c.getId(), nombre + "_" + comision.toString())){
                return c;
            }
        }
        return null;
    }

    public int getAsistTotales() {
        return asistTotales;
    }
}

