package com.example.recorridoguiadoun.Controllers;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

import com.example.recorridoguiadoun.Models.Constants;
import com.example.recorridoguiadoun.Models.Estacion;
import com.example.recorridoguiadoun.Models.Saver;
import com.example.recorridoguiadoun.R;
import com.google.gson.Gson;

import java.util.Calendar;
import java.util.Date;


public class GameController {

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
        Saver tmp = gson.fromJson(json, Saver.class);
        if(tmp!=null) saver = tmp;
    }

    public static String[] getPregunta(){
        Estacion est = saver.ruta[saver.pos];
        String salida[] = new String[5];
        int i = (int)(Math.random()*(est.pregunta.length-1));
        nPregunta = i;
        salida[0] = est.pregunta[i].pregunta;
        for (int j = 0; j <est.pregunta[i].respuestas.length ; j++) {
            salida[j+1] = est.pregunta[i].respuestas[j];
        }
        return salida;
    }

    public static boolean setRuta(String password){
        switch (password){
            case "ingenieria":  saver = new Saver(Constants.r1);    break;
            case "bienestar":   saver = new Saver(Constants.r2);    break;
            case "universidadnacional": saver = new Saver(Constants.r3);    break;
            case "sedebogota":  saver = new Saver(Constants.r4);    break;
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
    public static int getImgSrc(String name){
        switch (name){
            case "CADE":
                return R.drawable.cade;
            case "225 - Rogelio Salmona":
                return R.drawable.salmona;
            case "214 - Antonio Nariño":
                return R.drawable.e214;
            case "103 - Polideportivo":
                return R.drawable.polideportivo;
            case "426 - Instituto de Genética":
                return R.drawable.genetica;
            case "404 - Yu Takeuchi":
                return R.drawable.yutake;
            case "411 - Laboratorios de Ingeniería":
                return R.drawable.patios;
            case "451 - Edificio de Química":
                return R.drawable.quimica;
            case "571 - Hemeroteca Nacional Universitaria Carlos Lleras Restrepo":
                return R.drawable.hemeroteca;
            case "102 - Biblioteca Central Gabriel García Márquez":
                return R.drawable.biblioteca;
            case "477 - Sala Central de Informática":
                return R.drawable.computadores;
        }
        return -1;
    }
    public static void won(){
        saver.won = true;
        saver.pos = -1;
        saver.finish = Calendar.getInstance().getTime();
        saver.estadoActual = "Finish";
    }

    public static boolean verifyAnswer(int intento){
        Estacion est = saver.ruta[saver.pos];
        if (est.pregunta[nPregunta].resCorrecta==intento){
            est.preguntaIsBlocked=true;

            //updateMenuItems();

            if (saver.pos==saver.ruta.length-1) {
                won();
            }else{
                saver.pos++;
                saver.estadoActual = "Hint";
            }
            return true;
        }
        saver.penalizacion++;
        return false;
    }

    public static boolean verifyPass(int pass){
        if (saver.ruta[saver.pos].password == pass){
            Log.println(10,"-------------------","Contraseña Correcta");
            saver.ruta[saver.pos].stamp = Calendar.getInstance().getTime();
            saver.ruta[saver.pos].preguntaIsBlocked = false;
            saver.ruta[saver.pos].isBlocked = false;
            saver.estadoActual = "Info";
            saver.estacionActual = saver.ruta[saver.pos];

            return true;
        }
        saver.penalizacion++;
        return false;
    }

    public static String[] updateMenuItems(){
        String[] exit = new String[saver.ruta.length];

        for(int i = 0; i < exit.length; i++){
            if(!saver.ruta[i].isBlocked) exit[i] = saver.ruta[i].nombreCorto;
        }

        return exit;
    }
}
