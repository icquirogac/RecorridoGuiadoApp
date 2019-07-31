package com.example.recorridoguiadoun.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.recorridoguiadoun.Controllers.gameController;
import com.example.recorridoguiadoun.R;

public class prueba extends AppCompatActivity {

    Button bot1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String pregunta[] = gameController.getPregunta();
        setContentView(R.layout.activity_prueba);
        bot1 = (Button) findViewById(R.id.button3);
        bot1.setText(pregunta[1]);

        bot1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameController.verifyAnswer(0);
            }
        });
    }
    @Override
    public void onBackPressed() {

    }
}
