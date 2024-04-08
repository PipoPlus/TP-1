package Punto2.Restaurante;

public class ComarcaPlus extends Tarjeta {
    public ComarcaPlus() {
        super("ComarcaPlus");
    }
    @Override
    public double aplicarDescuentoBebidas(double montoBebidas) {

        double descuento = montoBebidas * 0.02;

        double total = montoBebidas - descuento;

        return total;
    }

    @Override
    public double aplicarDescuentoPlatosPrincipales(double montoPlatos) {
        double descuento = montoPlatos * 0.02;

        double total = montoPlatos - descuento;

        return total;
    }

}
