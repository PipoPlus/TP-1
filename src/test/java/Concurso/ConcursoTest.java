package Concurso;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ConcursoTest {

    @Test
    void inscribirParticipante_DentroDelPeriodoDeInscripcion() throws ParseException {
        // Arrange
        Concurso concurso = new Concurso("Concurso1", "01/03/2024", "21/06/2024");
        Participante participante = new Participante("Juan");

        // Act
        concurso.inscribirParticipante(participante);

        // Assert
        assertTrue(concurso.listaParticipantes.contains(participante));
    }

    @Test
    void inscribirParticipante_FueraDelPeriodoDeInscripcion() throws ParseException {
        // Arrange
        Concurso concurso = new Concurso("Concurso1", "01/03/2024", "10/03/2024");
        Participante participante = new Participante("Juan");

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            concurso.inscribirParticipante(participante);
        });
    }

    @Test
    void inscribirParticipante_EnFechaInicioConPuntajeExtra() throws ParseException {
        // Arrange
        Concurso concurso = new Concurso("Concurso1", "01/03/2024", "21/06/2024");
        Participante participante = new Participante("Juan");
        concurso.fechaInicio = new Date(); // setting current date as start date

        // Act
        concurso.inscribirParticipante(participante);

        // Assert
        assertEquals(10, participante.puntaje);
    }

    @Test
    void esFechaValidaParaInscripcion_FechaDentroDelPeriodo() throws ParseException {
        // Arrange
        Concurso concurso = new Concurso("Concurso1", "01/03/2024", "21/06/2024");
        Date fechaInscripcion = new Date(); // current date

        // Act & Assert
        assertTrue(concurso.esFechaValidaParaInscripcion(fechaInscripcion));
    }

    @Test
    void esFechaValidaParaInscripcion_FechaFueraDelPeriodo() throws ParseException {
        // Arrange
        Concurso concurso = new Concurso("Concurso1", "01/03/2024", "10/03/2024");
        Date fechaInscripcion = new Date(System.currentTimeMillis() + 100000000); // Some future date

        // Act & Assert
        assertFalse(concurso.esFechaValidaParaInscripcion(fechaInscripcion));
    }

    @Test
    void participanteExiste_PorParticipanteExistente() throws ParseException {
        // Arrange
        Concurso concurso = new Concurso("Concurso1", "01/03/2024", "21/06/2024");
        Participante participante = new Participante("Juan");
        concurso.listaParticipantes.add(participante);

        // Act & Assert
        assertTrue(concurso.participanteExiste(participante));
    }

    @Test
    void participanteExiste_PorParticipanteNoExistente() throws ParseException {
        // Arrange
        Concurso concurso = new Concurso("Concurso1", "01/03/2024", "10/03/2024");
        Participante participante = new Participante("Juan");

        // Act & Assert
        assertFalse(concurso.participanteExiste(participante));
    }

}