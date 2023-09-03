package EstructuraEcuacion;
import static java.lang.Math.sqrt;

public class EcuacionSegundoGrado
{
    private double a;
    private double b;
    private double c;
    public EcuacionSegundoGrado(double a,double b,double c)
    {
        this.a=a;
        this.b=b;
        this.c=c;
    }

    public double[] raices()
    {


        double raiz= (((b*b) - 4 * a * c));

        if (raiz==0)
        {
            double[] raices= {(-b)/2*a};
            return raices;

        }
        else
        {
            if (raiz<0)
            {
                double[] raices;
                raices=null;
                return raices;
            }

        }
        double[] raices= {(((-b)+sqrt(raiz))/(2*a)),(((-b)-sqrt(raiz))/(2*a))};
        return raices;
    }

    public double calcularParaX(double x)
    {
        double resultado= (a*(x*x)+(b*x)+c);
        return resultado;
    }
}

