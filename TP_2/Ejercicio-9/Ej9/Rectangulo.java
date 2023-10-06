package Ej9;

public class Rectangulo extends Figura2d{
    private double base;
    private double altura;
    public Rectangulo(double base, double altura){
        this.base = base;
        this.altura = altura;
    }
    @Override
    public double getPerimetro() {
        return (base*2) + (altura*2);
    }

    @Override
    public double getArea() {
        return base * altura;
    }
}
