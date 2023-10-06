package Ej9;

public class Circulo extends Figura2d{
    private final double radio;
    public Circulo(double radio){
        this.radio = radio;
    }

    @Override
    public double getPerimetro() {
        return 2 * Math.PI * radio;
    }

    @Override
    public double getArea() {
        return Math.PI * (Math.pow(radio,2));
    }
}
