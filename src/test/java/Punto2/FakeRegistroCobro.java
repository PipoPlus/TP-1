package Punto2;

import Punto2.Restaurante.RegistroCobro;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FakeRegistroCobro implements RegistroCobro {



    String content;


    public boolean empiezaCon(String iniciar){
        return this.content.startsWith(iniciar);
    }

    @Override
    public void registro(LocalDateTime fecha, double monto) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        this.content = formatter.format(fecha) + " || " + monto;

    }
}
