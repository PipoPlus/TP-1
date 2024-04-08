package Punto2.Restaurante;

public class MasterCard extends Tarjeta {
    public MasterCard() {
        super("MasterCard");
    }

    @Override
    public double aplicarDescuentoBebidas(double montoBebidas) {
        return montoBebidas;
    }

    @Override
    public double aplicarDescuentoPlatosPrincipales(double montoPlatos) {

        double descuento = montoPlatos * 0.02;
        double total = montoPlatos - descuento;

        return total;
    }

}
