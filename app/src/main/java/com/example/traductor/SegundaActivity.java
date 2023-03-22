package com.example.traductor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        resultado = findViewById(R.id.tvResultado);

        Intent recuperar = getIntent();

        String palabra = recuperar.getStringExtra("palabra");
        resultado.setText(palabra);
    }
}