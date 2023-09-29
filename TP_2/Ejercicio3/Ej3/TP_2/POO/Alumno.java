package Ej3.TP_2.POO;

import java.util.ArrayList;

public class Alumno {
    private String nombre;
    private String apellido;
    private String dni;
    private ArrayList<Credencial> credenciales=new ArrayList<>();

    public Alumno(String nombre,String apellido,String dni){
        this.dni= dni;
        this.apellido= apellido;
        this.nombre=nombre;
    }

    public String getDni() {
        return dni;
    }
    public Boolean registrarAsist(Comision c){
        for (Credencial cre:credenciales){
            if(cre.getComision()==c){
                cre.regAsistencia();
                return true;
            }
        }
        return false;
    }

    public void inscrbiir(Alumno alumno, Disciplina d, Comision c){
        Credencial credencial=new Credencial(c,d);
        d.inscribir(credencial,this);
        c.nuevoAlumno(credencial);

    }
}
