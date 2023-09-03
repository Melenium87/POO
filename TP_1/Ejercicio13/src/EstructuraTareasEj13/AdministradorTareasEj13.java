package EstructuraTareasEj13;

import java.util.Collections;
import java.time.LocalDate;
import java.util.*;

public class AdministradorTareasEj13
{
    private ArrayList<TareaEj13> tareas;
    private ArrayList<Colaborador> colabs;
    public AdministradorTareasEj13()
    {
        tareas=new ArrayList<TareaEj13>();
        colabs=new ArrayList<Colaborador>();
    }
    public void agregarColaboradores(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Elige un nombre de usuario: ");
        String usuario= sc.nextLine();

        System.out.print("\n Elige una contraseña: ");
        String contrase=sc.nextLine();
        colabs.add(new Colaborador(usuario,contrase));
    }

    public Boolean buscarColaborador(String s){
        for (Colaborador c : colabs){
            if (Objects.equals(c.getNombre(), s))
            {
                return true;
            }
        }
        return false;
    }
    public void agregarTarea()
    {

        Scanner sc=new Scanner(System.in);

        System.out.print("Elige un titulo: ");
        String titulo= sc.nextLine();
        for(TareaEj13 t:tareas){
            if (Objects.equals(t.getTitulo(), titulo))
            {
                System.out.println("Error la ya hay una tarea con ese titulo");
                return;
            }
        }

        System.out.println("\n Descripcion: ");
        String descripcion=sc.nextLine();
        System.out.println("establecer prioridad\n1-Alta 2-Media 3-Baja");
        int prio=sc.nextInt();
        while (prio<1||prio>3)
        {
            System.out.println(("Error\n"));
            System.out.println("establecer prioridad\n1-Alta 2-Media 3-Baja");
            prio=sc.nextInt();
        }
        System.out.println("desea establecer una fecha limite: \n 1- Si  2- No");
        int resp= sc.nextInt();
        while (resp<1||resp>2)
        {
            System.out.println(("Error\n"));
            System.out.println("desea establecer una fecha limite: \n 1- Si  2- No");resp=sc.nextInt();
        }
        if(resp==1)
        {
            System.out.println("formato: dd MM yyyy");
            int dia=0,mes=0,anio=0;
            System.out.print("dia: ");
            resp= sc.nextInt();
            while (resp<1||resp>31)
            {
                System.out.println(("Error\n"));
                System.out.print("dia:");
                resp=sc.nextInt();
            }
            dia=resp;
            System.out.print("mes: ");
            resp= sc.nextInt();
            while (resp<1||resp>12)
            {
                System.out.println(("Error\n"));
                System.out.print("mes:");
                resp=sc.nextInt();
            }
            mes=resp;
            System.out.print("anio: ");
            resp= sc.nextInt();
            while (resp<1000)
            {
                System.out.println(("Error\n"));
                System.out.print("anio: ");
                resp=sc.nextInt();
            }
            anio=resp;
            LocalDate fecha = LocalDate.of(anio, mes, dia);

            System.out.println("desea establecer un recordatorio: \n 1- Si  2- No");
            resp= sc.nextInt();
            while (resp<1||resp>2)
            {
                System.out.println(("Error\n"));
                System.out.println("desea establecer un recordatorio: \n 1- Si  2- No");
                resp=sc.nextInt();
            }
            if(resp==1)
            {
                System.out.println("formato: dd MM yyyy");
                dia=0;
                mes=0;
                anio=0;
                System.out.print("dia: ");
                resp= sc.nextInt();
                while (resp<1||resp>31)
                {
                    System.out.println(("Error\n"));
                    System.out.print("dia:");
                    resp=sc.nextInt();
                }
                dia=resp;
                System.out.print("mes: ");
                resp= sc.nextInt();
                while (resp<1||resp>12)
                {
                    System.out.println(("Error\n"));
                    System.out.print("mes:");
                    resp=sc.nextInt();
                }
                mes=resp;
                System.out.print("anio: ");
                resp= sc.nextInt();
                while (resp<1000)
                {
                    System.out.println(("Error\n"));
                    System.out.print("anio: ");
                    resp=sc.nextInt();
                }

                anio=resp;
                LocalDate recordatorio = LocalDate.of(anio, mes, dia);
                while  (fecha.isBefore(recordatorio)) {
                    System.out.println("ERROR: el recordatorio es de una fecha posterior a la fecha limite\n");

                    System.out.println("formato: dd MM yyyy");
                    dia = 0;
                    mes = 0;
                    anio = 0;
                    System.out.print("dia: ");
                    resp = sc.nextInt();
                    while (resp < 1 || resp > 31) {
                        System.out.println(("Error\n"));
                        System.out.print("dia:");
                        resp = sc.nextInt();
                    }
                    dia = resp;
                    System.out.print("mes: ");
                    resp = sc.nextInt();
                    while (resp < 1 || resp > 12) {
                        System.out.println(("Error\n"));
                        System.out.print("mes:");
                        resp = sc.nextInt();
                    }
                    mes = resp;
                    System.out.print("anio: ");
                    resp = sc.nextInt();
                    while (resp < 1000) {
                        System.out.println(("Error\n"));
                        System.out.print("anio: ");
                        resp = sc.nextInt();
                    }

                    anio = resp;
                    recordatorio = LocalDate.of(anio, mes, dia);
                }

                TareaEj13 tarea=new TareaEj13(titulo,descripcion,prio,fecha,recordatorio);
                tareas.add(tarea);
            }
            else
            {
                TareaEj13 tarea=new TareaEj13(titulo,descripcion,prio,fecha);
                tareas.add(tarea);
            }
        }
        else {

            TareaEj13 tarea=new TareaEj13(titulo,descripcion,prio);
            tareas.add(tarea);

        }

    }
    public void modificarTarea(String titulo)
    {
        for(int i=0;i<tareas.size();i++)
        {
            if (tareas.get(i).tituloDeTarea(titulo))
            {
                Scanner sc=new Scanner(System.in);
                System.out.println("Tarea encontrada");
                System.out.println("Identifiquese");
                System.out.println("Usuario: ");
                String usuario=sc.nextLine();
                Colaborador col=new Colaborador();
                if(buscarColaborador(usuario)) {
                    for (Colaborador c : colabs)
                    {
                        if (Objects.equals(c.getNombre(), usuario))
                        {
                            col = c;
                            break;
                        }
                    }
                    System.out.println("Contraseña: ");

                    String contra=sc.nextLine();
                    while (!col.verificarContra(contra))
                    {
                        System.out.println("ERROR\nContraseña: ");

                        contra=sc.nextLine();
                    }

                    tareas.get(i).modificarTarea(col);

                }
                else {

                    System.out.println("El usuario no existe");

                }


            }
        }
        System.out.println("Tarea no encontrada");
    }
    public ArrayList<TareaEj13> tareasNoVencidas()
    {
        //Ordenamiento por prioridad y fecha
        ArrayList<TareaEj13> tareas=new ArrayList<>();
        Collections.sort(this.tareas);

        int h;
        for (h=1;h<4;h++)
        {
            for (TareaEj13 i:this.tareas) {

                if (i.getEstado() == 3) {
                    continue;

                }
                if (i.getPrioridad() == h)
                {
                    tareas.add(i);
                }
            }
        }

        return tareas;
    }

    public ArrayList<TareaEj13> verProyectosDelColaborador(String s){
        ArrayList<TareaEj13> tareax=new ArrayList<TareaEj13>();
        for (TareaEj13 t:tareas)
        {
            if (t.getEstado()==2){
                if (t.getColaborador()!=null&&t.getColaborador().getNombre().equalsIgnoreCase(s))
                {
                    tareax.add(t);
                }
            }
        }
        if(tareax.isEmpty()){
            return null;
        }
        return tareax;
    }

}

