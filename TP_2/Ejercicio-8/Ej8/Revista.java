package Ej8;

public class Revista extends Publicacion {
    private String issn;
    private int numero;
    private int anioPublicacion;
    private int ejemplaresDisponibles;
    private int ejemplaresPrestados = 0;

    public Revista(String nombre, String editor, String telefonoProveedor, String issn, int numero, int anioPublicacion, int ejemplaresDisponibles) {
        super(nombre, editor, telefonoProveedor);
        this.issn = issn;
        this.numero = numero;
        this.anioPublicacion = anioPublicacion;
        this.ejemplaresDisponibles = ejemplaresDisponibles;
    }

    public void prestarEjemplares(int cant,Socio socio,Revista revista) {
        if (ejemplaresDisponibles <= 1) {
            System.out.println("No se puede prestar ejemplares ya que solo queda 1 copia del mismo");
        } else {
            while (ejemplaresDisponibles > 1 && cant > 0) {
                ejemplaresPrestados++; // Actualizar el seguimiento individual
                ejemplaresDisponibles--;
                cant--;
                socio.prestarPublicacion(revista);
            }
        }
    }

    public String getIssn(){
        return issn;
    }

    public int getTotalPrestados() {
        return ejemplaresPrestados;
    }

    public void reiniciarTotalPrestados() {
        ejemplaresPrestados = 0;
    }

    public int getEjemplaresDisponibles() {
        return ejemplaresDisponibles;
    }
}