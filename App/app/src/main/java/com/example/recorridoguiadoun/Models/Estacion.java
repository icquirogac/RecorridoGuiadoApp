package com.example.recorridoguiadoun.Models;


import java.util.Date;

public class Estacion {

    public String srcImage;
    public String nombre;
    public String info;
    public String pista;
    public Pregunta[] pregunta;
    public boolean isBlocked;
    public Date stamp;
    public int password;
    public boolean preguntaIsBlocked;

    public Estacion(String image, String name, String information, String hint, Pregunta[] preg, int pass){
        this.srcImage = image;
        this.nombre = name;
        this.info = information;
        this.pista = hint;
        this.pregunta = preg;
        this.isBlocked = true;
        this.password = pass;
        this.preguntaIsBlocked = true;
    }
}
