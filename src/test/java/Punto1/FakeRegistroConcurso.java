package Punto1;

import Punto1.Concurso.RegistroConcurso;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FakeRegistroConcurso implements RegistroConcurso {

    private String content;
    @Override
    public void registrar(String nombreParticipante, LocalDateTime fecha, String concurso) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        this.content = nombreParticipante + ", " + formatter.format(fecha)  + ", " + concurso;
    }

    public boolean empiezaCon(String iniciar){
        return this.content.startsWith(iniciar);
    }
}
