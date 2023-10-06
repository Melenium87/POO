package Ej9;

public class Cuadrado extends Figura2d{
    private final double lado;

    public Cuadrado(double lado){
        this.lado = lado;
    }
    @Override
    public double getPerimetro() {
        return lado*4;
    }

    @Override
    public double getArea() {
        return lado*lado;
    }
}
