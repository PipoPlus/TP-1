package Concurso;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Concurso {

    String nombreConcurso;
    LocalDateTime fechaInicio, fechaCierre;
    List<Participante> listaParticipantes = new ArrayList<>();

    private static final int PUNTOS_EXTRA = 10;


    public Concurso(String nombre, LocalDateTime fechaI, LocalDateTime fechaC) throws ParseException {

        this.nombreConcurso = nombre;

        this.fechaInicio = fechaI;
        this.fechaCierre = fechaC;

    }

    public String getNombreConcurso() {
        return nombreConcurso;
    }

    public int calcularPuntos(Participante participante) {
        LocalDateTime fechaActual = LocalDateTime.now();
        if (fechaActual.isEqual(fechaInicio)) {
            return 10;
        } else {
            return 0;
        }
    }


    public boolean estaAbierto() {
        LocalDateTime fechaActual = LocalDateTime.now();
        return !fechaActual.isBefore(fechaInicio) && !fechaActual.isAfter(fechaCierre);
    }

    public boolean participanteExiste(Participante participante) {
        return listaParticipantes.contains(participante);
    }


}
