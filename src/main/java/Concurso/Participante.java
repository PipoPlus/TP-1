package Concurso;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.PrintWriter;
public class Participante {

    private String nombre;
    private int puntos;


    public Participante(String name) {

        this.nombre = name;
        this.puntos = 0;

    }

    public int getPuntos() {
        return puntos;
    }

    private void guardarInscripcion(Concurso concurso) {
        String nombreArchivo = "inscripciones.txt";
        try (FileWriter fileWriter = new FileWriter(nombreArchivo, true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            LocalDateTime fechaHora = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            printWriter.println(formatter.format(fechaHora) + ", " + this.nombre + ", " + concurso.getNombreConcurso());
        } catch (IOException e) {
            System.err.println("Error al guardar la inscripción: " + e.getMessage());
        }
    }

    public void inscribirse(Concurso concurso) {
        if (!concurso.estaAbierto()) {
            throw new RuntimeException("El concurso está cerrado para inscripciones.");
        }
        puntos += concurso.calcularPuntos(this);
        concurso.listaParticipantes.add(this);
        guardarInscripcion(concurso);
    }




}