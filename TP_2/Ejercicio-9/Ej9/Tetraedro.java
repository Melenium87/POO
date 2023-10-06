package Ej9;

public class Tetraedro extends Figura3d{
    private final double arista;
    public Tetraedro(double arista){
        this.arista = arista;
    }
    @Override
    public double getVolumen() {
        return (Math.pow(arista,3) * Math.sqrt(2))/12;
    }

    @Override
    public double getArea() {
        return Math.pow(arista,2) * Math.sqrt(3);
    }
}
