package Punto2;

import Punto1.FakeProveedorDeFechas;
import Punto2.Restaurante.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PagoTest {

    @Test
    void calculoCostoConVisa() {
        Pedido pedido = new Pedido();
        var fakeRegistro = new FakeRegistroCobro();
        var fakeFecha = new FakeProveedorDeFechas();

        pedido.agregarBebida(new Bebida("Coca-Cola", 3.00,false));
        pedido.agregarPlatoPrincipal(new PlatoPrincipal("Hamburguesa", 10.00, "Principal"));

        Tarjeta visa = new Visa();
        Pago pago = new Pago(pedido, visa,fakeRegistro,fakeFecha);

        assertEquals(12.91, pago.calcularDescuento(), 0.01, "El costo total con Visa no es el esperado.");
        assertTrue(fakeRegistro.empiezaCon("07/04/2024 10:30:50 || 12.91"));
    }


    @Test
    void calculoCostoConMasterCard() {
        Pedido pedido = new Pedido();
        var fakeRegistro = new FakeRegistroCobro();
        var fakeFecha = new FakeProveedorDeFechas();

        pedido.agregarBebida(new Bebida("Fanta", 3.00, false));
        pedido.agregarPlatoPrincipal(new PlatoPrincipal("Pasta", 12.00, "Principal"));

        Tarjeta MasterCard = new MasterCard();
        Pago pago = new Pago(pedido, MasterCard, fakeRegistro, fakeFecha);

        assertEquals(14.76, pago.calcularDescuento(), 0.01, "El costo total con Comarca Plus no es el esperado.");
        assertTrue(fakeRegistro.empiezaCon("07/04/2024 10:30:50 || 14.76"));
    }

    @Test
    void calculoCostoConComarcaPlus() {
        Pedido pedido = new Pedido();
        var fakeRegistro = new FakeRegistroCobro();
        var fakeFecha = new FakeProveedorDeFechas();

        pedido.agregarBebida(new Bebida("Sprite", 3.00, false));
        pedido.agregarPlatoPrincipal(new PlatoPrincipal("Pizza", 15.00, "Principal"));

        Tarjeta comarcaPlus = new ComarcaPlus();
        Pago pago = new Pago(pedido, comarcaPlus,fakeRegistro,fakeFecha);

        assertEquals(17.64, pago.calcularDescuento(), 0.01, "El costo total con Comarca Plus no es el esperado.");
        assertTrue(fakeRegistro.empiezaCon("07/04/2024 10:30:50 || 17.64"));
    }



    @Test
    void calculoCostoConViedma(){
        Pedido pedido = new Pedido();
        var fakeRegistro = new FakeRegistroCobro();
        var fakeFecha = new FakeProveedorDeFechas();

        pedido.agregarBebida(new Bebida("Fernet", 5.00, true));
        pedido.agregarPlatoPrincipal(new PlatoPrincipal("Picada", 20.00, "Entrada"));

        Tarjeta viedma = new TarjetaGenerica();
        Pago pago = new Pago(pedido, viedma,fakeRegistro,fakeFecha);

        assertEquals(25.00, pago.calcularDescuento(), 0.01, "El costo total con Comarca Plus no es el esperado.");
        assertTrue(fakeRegistro.empiezaCon("07/04/2024 10:30:50 || 25.0"));
    }
}