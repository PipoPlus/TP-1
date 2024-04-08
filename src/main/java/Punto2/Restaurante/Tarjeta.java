package Punto2.Restaurante;

public abstract class Tarjeta {
    private String tipo;

    public Tarjeta(String tipo) {
        this.tipo = tipo;
    }



    public abstract double aplicarDescuentoBebidas(double montoBebidas);

    public abstract double aplicarDescuentoPlatosPrincipales(double montoPlatos);


}
