package com.example.recorridoguiadoun.Activity;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recorridoguiadoun.Controllers.gameController;
import com.example.recorridoguiadoun.Models.Constants;
import com.example.recorridoguiadoun.Models.Estacion;
import com.example.recorridoguiadoun.R;

public class MainActivity extends AppCompatActivity {

    public SharedPreferences mPrefs = getPreferences(MODE_PRIVATE);
    Button startBut;
    TextView pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startBut = (Button) findViewById(R.id.startButton);
        pass = (TextView) findViewById(R.id.pass);
        startBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = pass.getText().toString();
                password = password.toLowerCase().replaceAll(" ","");

                if (gameController.setRuta(password)){
                    gameController.saveGame(mPrefs);
                    //Intent
                }else{
                    //Toast diciendo que contraseña invalida, intente de nuevo
                }
            }
        });
        gameController.saveGame(mPrefs);

    }

}
