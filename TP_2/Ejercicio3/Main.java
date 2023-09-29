import Ej3.TP_2.POO.Secretaria;
import java.util.Scanner;

public class Main {

    public static int menu()
    {

        System.out.println("\n1 - **Crear un salon**");
        System.out.println("2 - **Dar de alta un profesor**");
        System.out.println("3 - **Dar de alta un alumno**");
        System.out.println("4 - **Dar de alta una disciplina**");
        System.out.println("5 - **Dar de alta una comision**");
        System.out.println("6 - **Inscribir un alumno a una comision**");
        System.out.println("7 - **Registrar asistencia**");
        System.out.println("8 - **Reiniciar mes**");
        System.out.println("0 - **Salir**");
        System.out.println("");
        System.out.print("Opcion: ");
        Scanner scanner=new Scanner(System.in);
        int opcion= scanner.nextInt();
        return opcion;

    }
    public static void main(String[] args)
    {
        Secretaria sec= new Secretaria();
        Scanner sc= new Scanner(System.in);

        int opcion =menu();
        while   (opcion<0||opcion>8)
        {
            opcion=menu();
        }
        while (opcion!=0)
        {
            switch (opcion) {
                case 1:
                    System.out.println("------Crear salon------");
                    System.out.print("Ingresa el id del salon: ");
                    sc= new Scanner(System.in);
                    sec.darAltaSalon(sc.nextLine());
                    break;
                case 2:
                    System.out.println("------Dar de alta profesor------");
                    System.out.print("Ingresar nombre del profesor: ");
                    String nombre;
                    sc= new Scanner(System.in);
                    nombre=sc.nextLine();
                    System.out.print("\nIngresar apellido del profesor: ");
                    sc= new Scanner(System.in);
                    String apellido=sc.nextLine();
                    System.out.print("\nIngresar DNI del profesor: ");
                    sc= new Scanner(System.in);
                    String dni=sc.nextLine();
                    sec.darAltaProfesor(nombre,apellido,dni);

                    break;
                case 3:
                    System.out.println("------Dar de alta alumno------");
                    System.out.print("Ingresar nombre del alumno: ");
                    sc= new Scanner(System.in);
                    nombre=sc.nextLine();
                    System.out.print("\nIngresar apellido del alumno: ");
                    sc= new Scanner(System.in);
                    apellido=sc.nextLine();
                    System.out.print("\nIngresar DNI del alumno: ");
                    sc= new Scanner(System.in);
                    dni=sc.nextLine();
                    sec.darAltaAlumno(nombre,apellido,dni);
                    break;
                case 4:
                    System.out.println("------Dar de alta disciplina------");
                    System.out.print("Ingresar nombre de la disciplina: ");
                    sc= new Scanner(System.in);
                    nombre=sc.nextLine();
                    System.out.print("\nIngresar programa de la disciplina: ");
                    sc= new Scanner(System.in);
                    String programa=sc.nextLine();
                    sec.darAltaDisciplina(nombre,programa);
                    break;

                case 5:
                    System.out.println("------Dar de alta comision------");
                    System.out.print("Ingresar nombre de la disciplina: ");
                    sc= new Scanner(System.in);
                    nombre=sc.nextLine();
                    System.out.print("\nIngresar horario: ");
                    sc= new Scanner(System.in);
                    String horario=sc.nextLine();
                    System.out.print("\nIngresar dni del tutor: ");
                    sc= new Scanner(System.in);
                    String tutor=sc.nextLine();
                    System.out.print("\nIngresar nivel de la asignatura (inicial, intermedio o avanzado): ");
                    sc= new Scanner(System.in);
                    String nivel=sc.nextLine();
                    while (!((nivel.equalsIgnoreCase("inicial"))|| (nivel.equalsIgnoreCase("intermedio") )|| (nivel.equalsIgnoreCase("avanzado")))){
                        System.out.print("\n ERROR Ingresar nivel de la asignatura (inicial, intermedio o avanzado): ");
                        sc= new Scanner(System.in);
                        nivel=sc.nextLine();
                    }
                    System.out.print("\nIngresar salon: ");
                    sc= new Scanner(System.in);
                    String salon=sc.nextLine();
                    sec.darAltaComision(nombre,horario,salon,nivel,tutor);
                    break;
                case 6:
                    System.out.println("------Inscribir un alumno------");
                    System.out.print("Ingresar DNI del alumno: ");
                    sc= new Scanner(System.in);
                    String alumno=sc.nextLine();
                    System.out.print("\nIngresar disciplina: ");
                    sc= new Scanner(System.in);
                    String disciplina=sc.nextLine();
                    System.out.print("\n:Ingresar comision "+disciplina+"_");
                    sc= new Scanner(System.in);
                    Integer com=sc.nextInt();
                    sec.inscribirAlumno(alumno,disciplina,com);
                    break;

                case 7:
                    System.out.println("------Registrar asistencia------");
                    System.out.print("Ingresar DNI del alumno: ");
                    sc= new Scanner(System.in);
                    alumno=sc.nextLine();
                    System.out.print("\nIngresar disciplina: ");
                    sc= new Scanner(System.in);
                    disciplina=sc.nextLine();
                    System.out.print("\n:Ingresar comision "+disciplina+"_");
                    sc= new Scanner(System.in);
                    com=sc.nextInt();
                    sec.registrarAsistencia(alumno,disciplina,com);

                    break;

                case 8:
                    sec.finMes();
                    break;

            }
            opcion=menu();
        }

    }
}
