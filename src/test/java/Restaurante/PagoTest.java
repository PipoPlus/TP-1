package Restaurante;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PagoTest {

    @Test
    void calculoCostoConVisa() {
        Pedido pedido = new Pedido();
        pedido.agregarBebida(new Bebida("Coca-Cola", 3.00,false));
        pedido.agregarPlatoPrincipal(new PlatoPrincipal("Hamburguesa", 10.00, "Principal"));

        Tarjeta visa = new Visa();
        Pago pago = new Pago(pedido, visa);

        assertEquals(12.91, pago.calcularDescuento(), 0.01, "El costo total con Visa no es el esperado.");
    }


    @Test
    void calculoCostoConMasterCard() {
        Pedido pedido = new Pedido();
        pedido.agregarBebida(new Bebida("Fanta", 3.00, false));
        pedido.agregarPlatoPrincipal(new PlatoPrincipal("Pasta", 12.00, "Principal"));

        Tarjeta MasterCard = new MasterCard();
        Pago pago = new Pago(pedido, MasterCard);

        assertEquals(14.76, pago.calcularDescuento(), 0.01, "El costo total con Comarca Plus no es el esperado.");
    }

    @Test
    void calculoCostoConComarcaPlus() {
        Pedido pedido = new Pedido();
        pedido.agregarBebida(new Bebida("Sprite", 3.00, false));
        pedido.agregarPlatoPrincipal(new PlatoPrincipal("Pizza", 15.00, "Principal"));

        Tarjeta comarcaPlus = new ComarcaPlus();
        Pago pago = new Pago(pedido, comarcaPlus);

        assertEquals(17.64, pago.calcularDescuento(), 0.01, "El costo total con Comarca Plus no es el esperado.");
    }



    @Test
    void calculoCostoConViedma(){
        Pedido pedido = new Pedido();
        pedido.agregarBebida(new Bebida("Fernet", 5.00, true));
        pedido.agregarPlatoPrincipal(new PlatoPrincipal("Picada", 20.00, "Entrada"));

        Tarjeta viedma = new TarjetaGenerica();
        Pago pago = new Pago(pedido, viedma);

        assertEquals(25.00, pago.calcularDescuento(), 0.01, "El costo total con Comarca Plus no es el esperado.");
    }
}