package com.example.recorridoguiadoun.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recorridoguiadoun.Controllers.GameController;
import com.example.recorridoguiadoun.Models.Estacion;
import com.example.recorridoguiadoun.R;

import java.util.ArrayList;
import java.util.List;

public class InfoFragment extends Fragment {

    View myView;
    ImageView imagen;
    TextView titulo;
    TextView info;
    TextView pregunta;
    ListView respuestas;
    SharedPreferences preferences;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.info,container,false);
        imagen = (ImageView) myView.findViewById(R.id.imageSrc);
        titulo = (TextView) myView.findViewById(R.id.textName);
        info = (TextView) myView.findViewById(R.id.textInfo);
        pregunta = (TextView) myView.findViewById(R.id.textAsk);
        respuestas = (ListView) myView.findViewById(R.id.listRespuestas);

        Estacion estacion = GameController.saver.estacionActual;
        Resources resources = getResources();
        imagen.setImageDrawable(resources.getDrawable(GameController.getImgSrc(estacion.nombre)));
        titulo.setText(estacion.nombre);
        info.setText(estacion.info);

        preferences = this.getActivity().getPreferences(Context.MODE_PRIVATE);


        if (GameController.saver.estacionActual.preguntaIsBlocked) {
            respuestas.setVisibility(View.GONE);
            pregunta.setVisibility(View.GONE);
        }else{
            String preguntas[] = GameController.getPregunta();
            pregunta.setText(preguntas[0]);
            List<String> dataList = new ArrayList<String>();
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(myView.getContext(), android.R.layout.simple_list_item_1,dataList);
            dataList.add(preguntas[1]);
            dataList.add(preguntas[2]);
            dataList.add(preguntas[3]);
            dataList.add(preguntas[4]);
            respuestas.setAdapter(arrayAdapter);
        }

        respuestas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
                if (GameController.verifyAnswer(index)){
                    GameController.saveGame(preferences);
                    Intent intent = new Intent(myView.getContext(), NavigationMenu.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }else {
                    Toast.makeText(myView.getContext(),"Respuesta Incorrecta, Penalización de 15 Segundos",Toast.LENGTH_LONG).show();
                    String preguntas[] = GameController.getPregunta();
                    pregunta.setText(preguntas[0]);
                    List<String> dataList = new ArrayList<String>();
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(myView.getContext(), android.R.layout.simple_list_item_1,dataList);
                    dataList.add(preguntas[1]);
                    dataList.add(preguntas[2]);
                    dataList.add(preguntas[3]);
                    dataList.add(preguntas[4]);
                    respuestas.setAdapter(arrayAdapter);
                    GameController.saveGame(preferences);
                }
            }
        });


        return myView;
    }
}
