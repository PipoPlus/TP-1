package Punto2.Restaurante;

public class Visa extends Tarjeta {
    public Visa() {
        super("Visa");
    }

    @Override
    public double aplicarDescuentoBebidas(double montoBebidas) {
        // Calcular el descuento
        double descuento = montoBebidas * 0.03;

        // Restar el descuento al monto original
        double total = montoBebidas - descuento;

        // Retornar el total
        return total;
    }

    @Override
    public double aplicarDescuentoPlatosPrincipales(double montoPlatos) {
        return montoPlatos; // Visa no ofrece descuento en platos principales
    }

}