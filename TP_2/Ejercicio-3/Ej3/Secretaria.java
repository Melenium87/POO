package Ej3;

import java.util.ArrayList;
import java.util.Objects;

public class Secretaria {
    private ArrayList<Alumno>alumnos =new ArrayList<>();
    private ArrayList<Profesor>profesores =new ArrayList<>();
    private ArrayList<Disciplina>disciplinas =new ArrayList<>();
    private ArrayList<Salon>salonesLibres =new ArrayList<>();

    //dar de alta un salon
    public void darAltaSalon(String id_salon){

        Salon salon=new Salon(id_salon);
        if (!salonesLibres.contains(salon)){
            salonesLibres.add(salon);
            System.out.println("Salon agregado");
            return;
        }
        System.out.println("Error: Salon repetido");
    }
    //dar de alta un profesor
    public void darAltaProfesor(String nombre,String apellido,String dni){

        if(buscarProfesor(dni)!=null){
                System.out.println("Error Profesor ya existente");
                return;

        }
        Profesor profe=new Profesor(nombre, apellido, dni);
        profesores.add(profe);
        System.out.println("Profesor agregado");
    }
    //dar de alta un alumno
    public void darAltaAlumno(String nombre,String apellido,String dni){
        if(buscarAlumno(dni)!=null)
        {
            System.out.println("Error alumno ya existente");
            return;
        }

        Alumno alumno=new Alumno(nombre, apellido, dni);
        alumnos.add(alumno);
        System.out.println("Alumno agregado");

    }
    //dar de alta una disciplina
    public void darAltaDisciplina(String nombre, String programa){
        if(buscarDisciplina(nombre)==null){
            Disciplina d=new Disciplina(nombre, programa);
            disciplinas.add(d);
            System.out.println("Disciplina agregada correctamente");
            return;
        }
        System.out.println("Disciplina ya existente");
    }
    //dar de alta una comision de una disciplina
    public void darAltaComision(String disciplina, ArrayList<String> dias,ArrayList<String> horario, String salon, String nivel, String dniProfesor){
        Disciplina d= buscarDisciplina(disciplina);
        if (d!=null){
            Salon s=buscarSalon(salon);
            if (s!=null){
                Profesor prof=buscarProfesor(dniProfesor);
                if (prof!=null){
                    d.crearComision(dias,horario,prof,nivel,s);
                    System.out.println("Comision agregada con exito");
                    return;
                }
                System.out.println("Profesor inexistente");
                return;

            }
            System.out.println("Salon inexistente");
            return;
        }
        System.out.println("Disciplina inexistente");

    }
    //inscribir a un alumno
    public void inscribirAlumno(String dni,String disciplina,Integer comision){
        Alumno alumno=buscarAlumno(dni);
        if(alumno!=null){
            Disciplina d=buscarDisciplina(disciplina);
            if (d!=null){
                Comision c=d.buscarComision(comision);
                if (c != null) {
                    alumno.inscrbiir(d,c);
                    System.out.println("Alumno inscripto correctamente");
                    return;
                }
                System.out.println("Comision inexistente");
                return;
            }
            System.out.println("Disciplina inexistente");
        }
    }
    //registrar asistencia
    public void registrarAsistencia(String dni,String disciplina,Integer comision){
        Alumno alumno=buscarAlumno(dni);
        if (alumno!=null){
            Disciplina d=buscarDisciplina(disciplina);
            if (d!=null){
                Comision c=buscarComision(d,comision);
                if (c!=null){
                    if(alumno.registrarAsist(c)){
                        System.out.println("Asistencia registrada");
                        return;
                    }
                    System.out.println("El alumno no pertenece a esa comision");
                    return;
                }
                System.out.println("La comision no existe");
                return;
            }
            System.out.println("Disciplina inexistente");
            return;
        }
        System.out.println("Alumno inexistente");
    }


    //reiniciar mes ---> (calcular no se que de los profes)
    //                   (calcular la disciplina mas rentable)
    //                   (pone todos los contadores en 0)
    public void finMes(){
        for (Profesor profesor:profesores){
            profesor.calcularPaga();
        }

    }

    private void disciplinaMasRentable(){
        Disciplina masRentable=disciplinas.iterator().next();
        for (Disciplina d:disciplinas){
            if (d.getAsistTotales()>=masRentable.getAsistTotales()){
                masRentable=d;
            }
        }
        System.out.println("La disciplina mas rentabe es: "+masRentable+" con: "+masRentable.getAsistTotales()+" asistencias");
    }
    private void reiniciar(){
        for (Disciplina d:disciplinas){
            d.reiniciarAsistencias();
        }
    }

    private Alumno buscarAlumno(String dni){
        if (alumnos.isEmpty()){
            return null;
        }
        for (Alumno p:alumnos){
            if(Objects.equals(p.getDni(), dni)){
                System.out.println("Alumno encontrado");
                return p;
            }
        }
        return  null;
    }
    private Salon buscarSalon(String salon){
        if(salonesLibres.isEmpty()){
            return null;
        }
        for (Salon s:salonesLibres){
            if (Objects.equals(s.getId(), salon)){
                return s;
            }
        }
        return null;
    }
    private Profesor buscarProfesor(String dni){
        if(profesores.isEmpty()){
            return null;
        }
        for (Profesor p:profesores){
            if(Objects.equals(p.getDni(), dni)) {
                return p;

            }
        }
        return null;
    }
    private Disciplina buscarDisciplina(String nombre){
        if (disciplinas.isEmpty()){
            return null;
        }
        for (Disciplina d:disciplinas){
            if(Objects.equals(d.getNombre(), nombre)) {
                return d;
            }
        }
        return null;
    }

    private Comision buscarComision(Disciplina disciplina,Integer comision){
        return disciplina.buscarComision(comision);
    }
}


