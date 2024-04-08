package Punto2.Persistencia;

import Punto2.Restaurante.RegistroCobro;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EnDiscoRegistroCobro implements RegistroCobro {

    @Override
    public void registro(LocalDateTime fecha, double monto) {
        String nombreArchivo = "cobros.txt";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String fechaYCobro = (formatter.format(fecha) + " || " + monto);

        try (FileWriter fileWriter = new FileWriter(nombreArchivo, true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.println(fechaYCobro);

        } catch (IOException e){
            throw new RuntimeException("Error al guardar el cobro: " + e.getMessage());
        }

    }
}
