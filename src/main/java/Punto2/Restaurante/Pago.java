package Punto2.Restaurante;

import Punto1.Concurso.ProveedorDeFechas;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pago {
    private Pedido pedido;
    private Tarjeta tarjeta;

    private RegistroCobro registro;

    private ProveedorDeFechas  proovedorFecha;

    public Pago(Pedido pedido, Tarjeta tarjeta, RegistroCobro registro,ProveedorDeFechas proovedorFecha) {
        this.pedido = pedido;
        this.tarjeta = tarjeta;
        this.registro = registro;
        this.proovedorFecha = proovedorFecha;

    }
    public double calcularDescuento() {
        double montoDescontado = obtenerMonto();

        pedido.confirmarPedido();

        guardarPago();
        return montoDescontado;

    }

    private double obtenerMonto() {

        double descuentoBebidas = tarjeta.aplicarDescuentoBebidas(pedido.calcularCostoTotalBebidas());
        double descuentoPlatos = tarjeta.aplicarDescuentoPlatosPrincipales(pedido.calcularCostoTotalPlatosPrincipales());
        double montoDescontado = descuentoBebidas + descuentoPlatos;

        return montoDescontado;
    }

    private void guardarPago() {

        this.registro.registro(this.proovedorFecha.fecha(), obtenerMonto());

    }

}
