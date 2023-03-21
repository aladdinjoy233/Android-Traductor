package com.example.traductor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel mv;
    private EditText palabra;
    private Button traducir;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);

        palabra = findViewById(R.id.etPalabra);
        traducir = findViewById(R.id.btTraducir);
        resultado = findViewById(R.id.tvResultado);

        mv.getResultado().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                resultado.setText(s);
            }
        });

        traducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mv.traducir(palabra.getText().toString().toLowerCase());
            }
        });
    }
}