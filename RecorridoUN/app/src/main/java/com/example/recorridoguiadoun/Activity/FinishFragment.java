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
import java.util.TimeZone;

public class FinishFragment extends Fragment {

    TextView textFinish;
    TextView textStart;
    TextView textTiempo;
    TextView textPenalizacion;
    TextView textTotalTime;

    View myView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.finish,container,false);
        textFinish = myView.findViewById(R.id.textTimeStamps);
        textTiempo = myView.findViewById(R.id.textTime);
        textPenalizacion = myView.findViewById(R.id.textPenalizaciones);
        textTotalTime = myView.findViewById(R.id.textTotalTime);
        textFinish.setMovementMethod(new ScrollingMovementMethod());
        textStart = myView.findViewById(R.id.textTimeStart);

        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
        dateFormat.setTimeZone(TimeZone.getTimeZone("America/Bogota"));

        textStart.setText(dateFormat.format(GameController.saver.start));

        String stamps = "", timeS, nameS, full;
        long h, m, s, diff,initialDiff;

        for (Estacion estacion: GameController.saver.ruta){
            diff = estacion.stamp.getTime() - GameController.saver.start.getTime();
            diff /= 1000;
            s = diff % 60;
            diff /= 60;
            m = diff % 60;
            h = diff / 60;
            timeS = String.format("%02d:%02d:%02d", h, m, s);
            nameS = String.format("%-25s", estacion.nombreCorto);
            full = String.format("%s%20s\n", nameS, timeS);

            stamps += full;
        }
        textFinish.setText(stamps);

        initialDiff = GameController.saver.finish.getTime()-GameController.saver.start.getTime();
        diff = initialDiff;
        diff /= 1000;
        s = diff % 60;
        diff /= 60;
        m = diff % 60;
        h = diff / 60;
        timeS = String.format("%02d:%02d:%02d", h, m, s);
        textTiempo.setText(timeS);
        textPenalizacion.setText("+" + GameController.saver.penalizacion*15 + " Segundos");
        initialDiff += GameController.saver.penalizacion*15*1000;
        diff = initialDiff;
        diff /= 1000;
        s = diff % 60;
        diff /= 60;
        m = diff % 60;
        h = diff / 60;
        timeS = String.format("%02d:%02d:%02d", h, m, s);
        textTotalTime.setText(timeS);
        return myView;
    }
}
