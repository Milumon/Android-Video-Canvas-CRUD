package com.isil.mobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class DibujoActivity extends Activity implements View.OnClickListener {

    // ConstraintLayout canvasAlphabets;

    Button mbtnLimpiar;
    AreaDibujo areaDibujo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dibujo);
        mbtnLimpiar = findViewById(R.id.btnLimpiar);
        areaDibujo = new AreaDibujo(this, null);


        //canvasAlphabets = findViewById(R.id.mey);
        //canvasAlphabets.addView(areaDibujo);

        mbtnLimpiar.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
    }
}