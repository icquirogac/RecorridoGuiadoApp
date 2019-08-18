package com.example.recorridoguiadoun.Models;

import java.util.Calendar;
import java.util.Date;

public class Saver {
    public Date start,finish;
    public Estacion[] ruta;
    public int penalizacion;
    public int pos;
    public boolean won;
    public Estacion estacionActual;
    public String estadoActual;     //"Hint" "Info" "Finish"


    public Saver(Estacion[] rut){
        start = Calendar.getInstance().getTime();
        ruta = rut;
        penalizacion = 0;
        pos = 0;
        won = false;
        estadoActual = "Hint";
    }
}
