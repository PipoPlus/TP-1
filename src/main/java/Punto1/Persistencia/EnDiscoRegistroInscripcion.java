package Punto1.Persistencia;

import Punto1.Concurso.RegistroConcurso;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EnDiscoRegistroInscripcion implements RegistroConcurso {


    @Override
    public void registrar(String nombreParticipante, LocalDateTime fecha, String concurso) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String nombreYFecha = nombreParticipante + ", " + formatter.format(fecha)  + ", " + concurso;

        String nombreArchivo = "inscripciones.txt";
        try (FileWriter fileWriter = new FileWriter(nombreArchivo, true); PrintWriter printWriter = new PrintWriter(fileWriter))
        {
            printWriter.println(nombreYFecha);
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar la inscripción: " + e.getMessage());
        }
    }
}
