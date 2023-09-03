package EstructurasLibros;

public class Libro
{
    private String titulo;
    private String autor;
    private String isbn=null;
    private int numeroPaginas=0;
    private int ejemplaresDisponibles=0;
    private int prestados=0;

    public Libro(String titulo, String autor, String isbn, int numeroPaginas, int ejemplares)
    {
        this.titulo=titulo;
        this.autor=autor;
        this.isbn=isbn;
        this.numeroPaginas=numeroPaginas;
        this.ejemplaresDisponibles=ejemplares;
    }
    public Libro(String titulo, String autor, int numeroPaginas, int ejemplares)
    {
        this.titulo=titulo;
        this.autor=autor;
        this.isbn=isbn;
        this.numeroPaginas=numeroPaginas;
        this.ejemplaresDisponibles=ejemplares;
    }

    public Libro() {

    }

    public String getTitulo()
    {
        return titulo;
    }

    public String getIsbn()
    {
        return isbn;
    }

    public int getNumeroPaginas()
    {
        return numeroPaginas;
    }

    public String getAutor()
    {
        return autor;
    }

    public void agregarEjemplares(int cantidad)
    {
        ejemplaresDisponibles=ejemplaresDisponibles+cantidad;
    }

    public boolean eliminarEjemplares(int cantidad)
    {
        if (ejemplaresDisponibles>=cantidad)
        {
            ejemplaresDisponibles=ejemplaresDisponibles-cantidad;
            return true;
        }
        return false;
    }

    public boolean prestar()
    {
        if(ejemplaresDisponibles!=1)
        {
            ejemplaresDisponibles=ejemplaresDisponibles-1;
            prestados=prestados+1;
            return true;
        }
        return false;
    }

    public boolean devolver()
    {
        if(prestados!=0)
        {
            ejemplaresDisponibles=ejemplaresDisponibles+1;
            prestados=prestados-1;
            return true;
        }
        return false;
    }

    public boolean encontrar(String clave)
    {
        if (titulo==clave||autor==clave||isbn==clave)
        {
            return true;
        }
        return false;
    }

    public boolean igualA(Libro l)
    {
        if(l.titulo==titulo&&autor==l.autor||(isbn!=null&&isbn==l.isbn)){
            return true;
        }
        return false;
    }

    public void mostrar()
    {
        System.out.println("El libro " +titulo+ " creado por el autor "+autor+" tiene "+numeroPaginas+"\npáginas, quedan "+ejemplaresDisponibles+" disponibles y se prestaron "+prestados+".");
    }

    public int getPrestados() {
        return prestados;
    }
}


