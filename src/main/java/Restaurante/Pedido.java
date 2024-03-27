package Restaurante;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Bebida> bebidas;
    private List<PlatoPrincipal> platosPrincipales;
    private boolean confirmado;

    public Pedido() {
        this.bebidas = new ArrayList<>();
        this.platosPrincipales = new ArrayList<>();
        this.confirmado = false;
    }

    public void agregarBebida(Bebida bebida) {
        if (!confirmado) {
            bebidas.add(bebida);
        } else {
            throw new IllegalStateException("No se pueden agregar bebidas a un pedido confirmado.");
        }
    }

    public void agregarPlatoPrincipal(PlatoPrincipal platoPrincipal) {
        if (!confirmado) {
            platosPrincipales.add(platoPrincipal);
        } else {
            throw new IllegalStateException("No se pueden agregar platos principales a un pedido confirmado.");
        }
    }

    public void confirmarPedido() {
        confirmado = true;
    }

    public double calcularCostoTotalBebidas() {
        double costoTotalBebidas = 0.0;
        for (Bebida bebida : bebidas) {
            costoTotalBebidas += bebida.getPrecio();
        }
        return costoTotalBebidas;
    }

    public double calcularCostoTotalPlatosPrincipales() {
        double costoTotalPlatosPrincipales = 0.0;
        for (PlatoPrincipal platoPrincipal : platosPrincipales) {
            costoTotalPlatosPrincipales += platoPrincipal.getPrecio();
        }
        return costoTotalPlatosPrincipales;
    }


}
