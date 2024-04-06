package Restaurante;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pago {
    private Pedido pedido;
    private Tarjeta tarjeta;

    public Pago(Pedido pedido, Tarjeta tarjeta) {
        this.pedido = pedido;
        this.tarjeta = tarjeta;
    }
    public double calcularDescuento() {
        double montoDescontado = obtenerMonto();

        pedido.confirmarPedido();

        guardarCobro();
        return montoDescontado;

    }

    private double obtenerMonto() {

        double descuentoBebidas = tarjeta.aplicarDescuentoBebidas(pedido.calcularCostoTotalBebidas());
        double descuentoPlatos = tarjeta.aplicarDescuentoPlatosPrincipales(pedido.calcularCostoTotalPlatosPrincipales());
        double montoDescontado = descuentoBebidas + descuentoPlatos;

        return montoDescontado;
    }

    private void guardarCobro() {
        String nombreArchivo = "cobros.txt";
        try (FileWriter fileWriter = new FileWriter(nombreArchivo,true);
            PrintWriter printWriter = new PrintWriter(fileWriter)) {

            LocalDateTime fechaAhora = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            printWriter.println(formatter.format(fechaAhora) + " || " + obtenerMonto());

            } catch (IOException e){
            System.err.println("Error al guardar la inscripción: " + e.getMessage());
        }

    }

}
