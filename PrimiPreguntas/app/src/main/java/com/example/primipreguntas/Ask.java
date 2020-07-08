package com.example.primipreguntas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Ask extends AppCompatActivity {
    Button facil;
    Button medio;
    Button dificil;
    TextView ask;
    TextView answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask);
        ask = findViewById(R.id.askText);
        answer = findViewById(R.id.answerText);
        ask.setMovementMethod(new ScrollingMovementMethod());
        answer.setMovementMethod(new ScrollingMovementMethod());
        ask.setText(Constants.currentPregunta.pregunta);
        answer.setText(Constants.currentPregunta.respuesta);
        facil = (Button)  findViewById(R.id.easy);
        medio = (Button)  findViewById(R.id.medium);
        dificil = (Button)  findViewById(R.id.hard);

        facil.setOnClickListener(new View.OnClickListener() {

                                     @Override
                                     public void onClick(View v) {
                                         Random rand = new Random();
                                         int random = rand.nextInt(Constants.facil.length);
                                         Constants.currentPregunta = Constants.facil[random];
                                         ask.setText(Constants.currentPregunta.pregunta);
                                         answer.setText(Constants.currentPregunta.respuesta);
                                     }
                                 }

        );

        medio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rand = new Random();
                int random = rand.nextInt(Constants.medio.length);
                Constants.currentPregunta = Constants.medio[random];
                ask.setText(Constants.currentPregunta.pregunta);
                answer.setText(Constants.currentPregunta.respuesta);
            }
        });

        dificil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rand = new Random();
                int random = rand.nextInt(Constants.dificil.length);
                Constants.currentPregunta = Constants.dificil[random];
                ask.setText(Constants.currentPregunta.pregunta);
                answer.setText(Constants.currentPregunta.respuesta);
                }
        });
    }
}
