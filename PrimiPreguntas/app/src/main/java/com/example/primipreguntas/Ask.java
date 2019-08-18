package com.example.primipreguntas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class Ask extends AppCompatActivity {

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
    }
}
