package Punto1;

import Punto1.Concurso.Concurso;
import Punto1.Concurso.FechaActual;
import Punto1.Concurso.Participante;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ConcursoTest {

    @Test
    void inscribirParticipante_DentroDelPeriodoDeInscripcion(){
        var fakeFecha = new FakeProveedorDeFechas();
        var fakeRegistro = new FakeRegistroConcurso();
        var fechaInicioFake = fakeFecha.fecha();
        var fechaCierreFake = fakeFecha.fecha().plusDays(2);



        Concurso concurso = new Concurso("Crea y Gana", fechaInicioFake, fechaCierreFake, fakeRegistro, fakeFecha);
        Participante participante = new Participante("Juan");

        concurso.inscribirseAlConcurso(participante);

        assertTrue(concurso.inscripto(participante));
        var str = "Juan, 07/04/2024 10:30:50, Crea y Gana";
        assertTrue(fakeRegistro.empiezaCon(str));
    }

    @Test
    void inscribirParticipante_FueraDelPeriodoDeInscripcion() {
        LocalDateTime fechaInicio = LocalDateTime.now().plusDays(2);
        LocalDateTime fechaCierre = LocalDateTime.now().plusDays(1);
        var fechaActual = new FechaActual();
        var fakeRegistro = new FakeRegistroConcurso();

        Concurso concurso = new Concurso("Concurso2", fechaInicio, fechaCierre, fakeRegistro,fechaActual);
        Participante participante = new Participante("Julian");

        assertThrows(RuntimeException.class, () -> {
            concurso.inscribirseAlConcurso(participante);
        });
    }

    @Test
    void inscribirParticipante_EnFechaInicioConPuntajeExtra()  {
        var fakeRegistro = new FakeRegistroConcurso();
        var fakeFecha = new FakeProveedorDeFechas();

        var fechaInicioFake = fakeFecha.fecha();
        var fechaCierreFake = fakeFecha.fecha().plusDays(1);

        Concurso concurso = new Concurso("Desafío Creativo", fechaInicioFake, fechaCierreFake, fakeRegistro, fakeFecha);
        Participante participante = new Participante("Khalil");

        concurso.inscribirseAlConcurso(participante);

        var str = "Khalil, 07/04/2024 10:30:50, Desafío Creativo";

        assertEquals(10,participante.calcularPuntos(concurso));
        assertTrue(fakeRegistro.empiezaCon(str));
    }



    @Test
    void participanteExiste_PorParticipanteExistente() {
        var fakeFecha = new FakeProveedorDeFechas();
        var fakeRegistro = new FakeRegistroConcurso();
        var fechaInicioFake = fakeFecha.fecha();
        var fechaCierreFake = fakeFecha.fecha().plusDays(2);



        Concurso concurso = new Concurso("Estrellas Emergentes", fechaInicioFake, fechaCierreFake, fakeRegistro,fakeFecha);
        Participante participante = new Participante("Leo");
        concurso.inscribirseAlConcurso(participante);


        assertTrue(concurso.inscripto(participante));
        var str = "Leo, 07/04/2024 10:30:50, Estrellas Emergentes";
        assertTrue(fakeRegistro.empiezaCon(str));
    }

    @Test
    void participanteExiste_PorParticipanteNoExistente() {
        LocalDateTime fechaInicio = LocalDateTime.now();
        LocalDateTime fechaCierre = LocalDateTime.now().plusDays(2);
        var fakeRegistro = new FakeRegistroConcurso();
        var fechaActual = new FechaActual();

        Concurso concurso = new Concurso("Concurso5", fechaInicio, fechaCierre, fakeRegistro,fechaActual);
        Participante participante = new Participante("Ana");


        assertFalse(concurso.inscripto(participante));
    }

    @Test
    void participanteExiste_DentroDeLaBase(){
        var fakeFecha = new FakeProveedorDeFechas();
        var fakeRegistro = new FakeRegistroConcurso();
        var fechaInicioFake = fakeFecha.fecha();
        var fechaCierreFake = fakeFecha.fecha().plusDays(2);

        Concurso concurso = new Concurso("Concurso de Maestría", fechaInicioFake, fechaCierreFake, fakeRegistro,fakeFecha);
        Participante participante = new Participante("Pepe");

        concurso.inscribirseAlConcurso(participante);

        var str = "Pepe, 07/04/2024 10:30:50, Concurso de Maestría";
        assertTrue(fakeRegistro.empiezaCon(str));
    }

}