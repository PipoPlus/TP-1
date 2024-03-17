package Concurso;

public class Participante {

    private String nombre;
    public int puntaje;


    public Participante(String name) {

        this.nombre = name;
        this.puntaje = 0;

    }


    public void sumarPuntaje(int puntos) {

        this.puntaje = +puntos;


    }


}