package Concurso;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ConcursoTest {

    @Test
    void inscribirParticipante_DentroDelPeriodoDeInscripcion() throws ParseException {
        LocalDateTime fechaInicio = LocalDateTime.now().minusDays(2);
        LocalDateTime fechaCierre = LocalDateTime.now().plusDays(2);

        Concurso concurso = new Concurso("Concurso1", fechaInicio, fechaCierre);
        Participante participante = new Participante("Juan");

        participante.inscribirse(concurso);

        assertTrue(concurso.listaParticipantes.contains(participante));
    }

    @Test
    void inscribirParticipante_FueraDelPeriodoDeInscripcion() throws ParseException {
        LocalDateTime fechaInicio = LocalDateTime.now().plusDays(2);
        LocalDateTime fechaCierre = LocalDateTime.now().plusDays(1);

        Concurso concurso = new Concurso("Concurso2", fechaInicio, fechaCierre);
        Participante participante = new Participante("Julian");

        assertThrows(RuntimeException.class, () -> {
            participante.inscribirse(concurso);
        });
    }

    @Test
    void inscribirParticipante_EnFechaInicioConPuntajeExtra() throws ParseException {
        LocalDateTime fechaInicio = LocalDateTime.now();
        LocalDateTime fechaCierre = LocalDateTime.now().plusDays(2);

        Concurso concurso = new Concurso("Concurso3", fechaInicio, fechaCierre);
        Participante participante = new Participante("Khalil");

        participante.inscribirse(concurso);

        assertEquals(10, participante.getPuntos());
    }



    @Test
    void participanteExiste_PorParticipanteExistente() throws ParseException {
        LocalDateTime fechaInicio = LocalDateTime.now();
        LocalDateTime fechaCierre = LocalDateTime.now().plusDays(2);
        Concurso concurso = new Concurso("Concurso4", fechaInicio, fechaCierre);
        Participante participante = new Participante("Leo");
        participante.inscribirse(concurso);


        assertTrue(concurso.participanteExiste(participante));
    }

    @Test
    void participanteExiste_PorParticipanteNoExistente() throws ParseException {
        LocalDateTime fechaInicio = LocalDateTime.now();
        LocalDateTime fechaCierre = LocalDateTime.now().plusDays(2);
        Concurso concurso = new Concurso("Concurso5", fechaInicio, fechaCierre);
        Participante participante = new Participante("Ana");


        assertFalse(concurso.participanteExiste(participante));
    }

}