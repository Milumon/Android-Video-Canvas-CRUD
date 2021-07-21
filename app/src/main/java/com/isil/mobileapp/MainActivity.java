package com.isil.mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mbtnAuto = findViewById(R.id.btnAuto);
        Button mbtnDibujo = findViewById(R.id.btnDibujo);
        Button mbtnJuego = findViewById(R.id.btnJuegos);

        mbtnAuto.setOnClickListener(this);
        mbtnDibujo.setOnClickListener(this);
        mbtnJuego.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAuto:
                startActivity(new Intent(this, OperacionesActivity.class));
                break;
            case R.id.btnDibujo:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.btnJuegos:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }
}