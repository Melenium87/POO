package Ej8;

public class Libro extends Publicacion {
    private String isbn;
    private int numPaginas;
    private int ejemplaresDisponibles;
    private int ejemplaresPrestados = 0;

    public Libro(String nombre, String editor, String telefonoProveedor, String isbn, int numPaginas, int ejemplaresDisponibles) {
        super(nombre, editor, telefonoProveedor);
        this.isbn = isbn;
        this.numPaginas = numPaginas;
        this.ejemplaresDisponibles = ejemplaresDisponibles;
    }

    public void prestarEjemplares(int cant,Socio socio,Libro libro) {
        if (ejemplaresDisponibles <= 1) {
            System.out.println("No se puede prestar ejemplares ya que solo queda 1 copia del mismo");
        } else {
            while (ejemplaresDisponibles > 1 && cant > 0) {
                ejemplaresPrestados++; // Actualizar el seguimiento individual
                ejemplaresDisponibles--;
                cant--;
                socio.prestarPublicacion(libro);
            }
        }
    }

    public void recuperarEjemplares(int cant) {
        while (cant <= 0) {
            if (ejemplaresPrestados <= 0) {
                ejemplaresPrestados--;
            }
            ejemplaresDisponibles++;
            cant--;
        }
    }

    public String getIsbn() {
        return isbn;
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

    public void mostrarLibro() {
        System.out.println("El libro " + getNombre() + " creado por el editor " + getEditor() + " tiene " + numPaginas + " páginas, quedan " + ejemplaresDisponibles + " ejemplares disponibles y se prestaron " + ejemplaresPrestados);
    }
}