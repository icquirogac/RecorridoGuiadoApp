package com.example.recorridoguiadoun.Models;


import java.util.Date;

public class Estacion {

    public int srcImage;         //Direccion de la imagen de la estacion
    public String nombre;           //Nombre del edificio 401 - hdsa
    public String nombreCorto;      // Nombre del edificio, longitud <= 25 caracteres
    public String info;             //Historia
    public String pista;            //Como llegar a la estacion
    public Pregunta[] pregunta;     //5 Preguntas del lugar
    public boolean isBlocked;           //
    public Date stamp;                  //La hora en la que llego
    public int password;                //eL Año en el que el edifico se inauguro
    public boolean preguntaIsBlocked;

    public Estacion(int image, String name, String shortName, String information, String hint, Pregunta[] preg, int pass){
        this.srcImage = image;
        this.nombre = name;
        this.nombreCorto = shortName;
        this.info = information;
        this.pista = hint;
        this.pregunta = preg;
        this.isBlocked = true;
        this.password = pass;
        this.preguntaIsBlocked = true;
    }
}
