package com.example.recorridoguiadoun.Controllers;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.example.recorridoguiadoun.Models.Constants;
import com.example.recorridoguiadoun.Models.Estacion;
import com.example.recorridoguiadoun.Models.Saver;
import com.google.gson.Gson;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;


public class gameController {

    public static Saver saver;
    public static int nPregunta;

    public static void saveGame(SharedPreferences sharedPreferences){
        Editor prefsEditor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(saver);
        prefsEditor.putString("Saver", json);
        prefsEditor.commit();
    }
    public static void loadGame(SharedPreferences sharedPreferences){
        Gson gson = new Gson();
        String json = sharedPreferences.getString("Saver", "");
        saver = gson.fromJson(json, Saver.class);
    }

    public static String getPregunta(){
        Estacion est = saver.ruta[saver.pos];

        int i = (int)(Math.random()*(est.pregunta.length-1));
        nPregunta = i;
        return est.pregunta[i].pregunta;
    }

    public static boolean setRuta(String password){
        switch (password){
            case "vivalaun":
                Estacion[] ruta = new Estacion[11];
                ruta[0] = Constants.estaciones[0];
                saver = new Saver(ruta);
                break;
            case "ingenieria":
                break;
            case "induccion":
                break;
            case "bienestar":
                break;

                default: return false;
        }
        saver.penalizacion = 0;
        saver.start = Calendar.getInstance().getTime();
        saver.pos=0;
        return true;
    }

    public static String getHint(){
        if (saver.pos==-1) return "No hay mas pistas";
        Estacion est = saver.ruta[saver.pos];
        return est.pista;
    }

    public static void won(){
        saver.won = true;
        saver.pos = -1;
        saver.finish =  Calendar.getInstance().getTime();
    }

    public static boolean verifyAnswer(int intento){
        Estacion est = saver.ruta[saver.pos];
        if (est.pregunta[nPregunta].resCorrecta==intento){
            est.preguntaIsBlocked=false;
            if (saver.pos==saver.ruta.length-1) {
                won();
            }else{
                saver.pos++;
            }
            return true;
        }
        saver.penalizacion++;
        return false;
    }

    public static boolean verifyPass(int pass){
        if (saver.ruta[saver.pos].password==pass){
            saver.ruta[saver.pos].stamp = Calendar.getInstance().getTime();
            saver.ruta[saver.pos].preguntaIsBlocked = false;
            return true;
        }
        saver.penalizacion++;
        return false;
    }
}
