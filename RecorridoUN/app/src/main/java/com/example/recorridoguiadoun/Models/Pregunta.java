package com.example.recorridoguiadoun.Models;


public class Pregunta {

    public String pregunta;
    public String[] respuestas;
    public int resCorrecta;

    public Pregunta(String pregun, String[] res, int posResCorrecta){
        this.pregunta = pregun;
        this.respuestas = res;
        this.resCorrecta = posResCorrecta;
    }


}
