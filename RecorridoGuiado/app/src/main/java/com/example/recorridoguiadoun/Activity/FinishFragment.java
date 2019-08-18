package com.example.recorridoguiadoun.Activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.recorridoguiadoun.Controllers.GameController;
import com.example.recorridoguiadoun.Models.Estacion;
import com.example.recorridoguiadoun.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FinishFragment extends Fragment {

    TextView textFinish;
    TextView textTiempo;
    TextView textPenalizacion;
    TextView textTotalTime;

    View myView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.finish,container,false);
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        textFinish = myView.findViewById(R.id.textTimeStamps);
        textTiempo = myView.findViewById(R.id.textTime);
        textPenalizacion = myView.findViewById(R.id.textPenalizaciones);
        textTotalTime = myView.findViewById(R.id.textTotalTime);
        Estacion estacion;
        textFinish.setMovementMethod(new ScrollingMovementMethod());

        String stamps = "";
        for (int i = 0 ; i < GameController.saver.ruta.length ; i++){
            estacion = GameController.saver.ruta[i];
            Date data = new Date(estacion.stamp.getTime()-GameController.saver.start.getTime());
            stamps += estacion.nombre + "\t\t\t" + dateFormat.format(data) + "\n";
        }
        textFinish.setText(stamps);
        Date time = new Date(GameController.saver.finish.getTime()-GameController.saver.start.getTime());
        textTiempo.setText(dateFormat.format(time));
        textPenalizacion.setText("+" + GameController.saver.penalizacion*15 + " Segundos");
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        cal.add(Calendar.SECOND, GameController.saver.penalizacion*15);
        textTotalTime.setText(dateFormat.format(cal.getTime()));
        return myView;
    }
}
