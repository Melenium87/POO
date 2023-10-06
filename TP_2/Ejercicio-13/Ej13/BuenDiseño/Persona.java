package Ej13.BuenDiseño;

import java.util.ArrayList;

public class Persona {
    private String nombre;
    private String numeroDeTelefono;
    private String direccion;
    private ArrayList<Rol> roles=new ArrayList<>();

    public Persona(String nombre,String numeroDeTelefono,String direccion){
        this.nombre=nombre;
        this.numeroDeTelefono=numeroDeTelefono;
        this.direccion=direccion;
    }
    public void rolVuelo(Vuelo vuelo){
        boolean valor=false;
        for (Rol rol:roles){
            valor= rol.parcipoEn(vuelo);
            if (valor){
                System.out.print("\nEsta persona participo en el vuelo como un: ");
                break;
            }
        }

    }
    public void establecerRol(Rol rol){
        roles.add(rol);
    }
}

