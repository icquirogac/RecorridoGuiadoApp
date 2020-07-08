package com.example.primipreguntas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button facil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        facil = (Button)  findViewById(R.id.facil);

        facil.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Random rand = new Random();
                int random = rand.nextInt(Constants.facil.length);
                Constants.currentPregunta = Constants.facil[random];
                Intent i = new Intent(MainActivity.this, Ask.class);
                startActivity(i);
            }
        }

        );

    }
}
