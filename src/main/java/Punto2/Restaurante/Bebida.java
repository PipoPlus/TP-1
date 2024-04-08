package Punto2.Restaurante;

public class Bebida extends Item {
    private boolean alcoholica;

    public Bebida(String nombre, double precio, boolean alcoholica) {
        super(nombre, precio);
        this.alcoholica = alcoholica;
    }

}