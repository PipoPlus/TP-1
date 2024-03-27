package Restaurante;

public class TarjetaGenerica extends Tarjeta {
    public TarjetaGenerica() {
        super("Generica");
    }

    @Override
    public double aplicarDescuentoBebidas(double montoBebidas) {
        return montoBebidas; // No se aplica descuento para tarjetas genéricas
    }

    @Override
    public double aplicarDescuentoPlatosPrincipales(double montoPlatos) {
        return montoPlatos; // No se aplica descuento para tarjetas genéricas
    }
}