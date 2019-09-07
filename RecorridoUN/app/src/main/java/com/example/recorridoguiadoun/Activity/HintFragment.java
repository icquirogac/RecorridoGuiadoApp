package com.example.recorridoguiadoun.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recorridoguiadoun.Controllers.GameController;
import com.example.recorridoguiadoun.R;

public class HintFragment extends Fragment {
    View myView;
    TextView hint;
    Button verifyBut;
    EditText pass;
    SharedPreferences preferences;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.hint,container,false);
        hint = (TextView) myView.findViewById(R.id.textHint);
        hint.setText(GameController.getHint());
        verifyBut = (Button) myView.findViewById(R.id.verifyButton);
        pass = (EditText) myView.findViewById(R.id.passText);
        preferences = this.getActivity().getPreferences(Context.MODE_PRIVATE);
        GameController.saveGame(preferences);
        final Context context = myView.getContext();
        hint.setMovementMethod(new ScrollingMovementMethod());


        verifyBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pass.getText().toString().compareTo("")!=0 && GameController.verifyPass(Integer.parseInt(pass.getText().toString()))){
                    GameController.saveGame(preferences);
                    Intent intent = new Intent(context, NavigationMenu.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }else {
                    GameController.saveGame(preferences);
                    Toast.makeText(context,"Contraseña Incorrecta, Penalizacion de 15 Segundos",Toast.LENGTH_LONG).show();
                }

            }
        });
        return myView;
    }
}
