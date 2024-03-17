package Concurso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Concurso {

    String nombreConcurso;
    Date fechaInicio, fechaCierre;
    List<Participante> listaParticipantes = new ArrayList<>();


    public Concurso(String nombre, String fechaI, String fechaC) throws ParseException {

        this.nombreConcurso = nombre;


        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        this.fechaInicio = formato.parse(fechaI);
        this.fechaCierre = formato.parse(fechaC);

    }

    public void inscribirParticipante(Participante participante) {

        Date fechaInscripcion = new Date();
        if (esFechaValidaParaInscripcion(fechaInscripcion)) {

            listaParticipantes.add(participante);
            if (fechaInscripcion.compareTo(fechaInicio) == 0) {

                participante.sumarPuntaje(10);

            }

        } else {

            throw new IllegalArgumentException("La fecha de inscripción no está dentro del período permitido.");

        }

    }

    public boolean esFechaValidaParaInscripcion(Date fechaInscripcion) {
        return fechaInscripcion.compareTo(fechaInicio) >= 0 && fechaInscripcion.compareTo(fechaCierre) <= 0;
    }

    public boolean participanteExiste(Participante participante) {
        return listaParticipantes.contains(participante);
    }


}
