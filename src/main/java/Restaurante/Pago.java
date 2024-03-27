package Restaurante;

public class Pago {
    private Pedido pedido;
    private Tarjeta tarjeta;

    public Pago(Pedido pedido, Tarjeta tarjeta) {
        this.pedido = pedido;
        this.tarjeta = tarjeta;
    }
    public double calcularDescuento() {
        double descuentoBebidas = tarjeta.aplicarDescuentoBebidas(pedido.calcularCostoTotalBebidas());
        double descuentoPlatos = tarjeta.aplicarDescuentoPlatosPrincipales(pedido.calcularCostoTotalPlatosPrincipales());
        double montoDescontado = descuentoBebidas + descuentoPlatos;

        pedido.confirmarPedido();

        return montoDescontado;

    }


}
