package com.example.traductor;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.*;

import java.util.HashMap;

public class MainActivityViewModel extends AndroidViewModel {

    private Context context;
    private HashMap<String, String> dictionary;

    private MutableLiveData<String> resultado = null;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.context = application.getApplicationContext();

//        Generar diccionario con palabras
        dictionary = new HashMap<>();
        dictionary.put("hola", "hello");
        dictionary.put("adiós", "goodbye");
        dictionary.put("gato", "cat");
        dictionary.put("perro", "dog");
        dictionary.put("casa", "house");
        dictionary.put("computadora", "computer");
        dictionary.put("monitor", "monitor");
        dictionary.put("agua", "water");
        dictionary.put("celular", "cellphone");
        dictionary.put("teclado", "keyboard");
    }

    public LiveData<String> getResultado() {
        if (resultado == null) {
            resultado = new MutableLiveData<>();
        }
        return resultado;
    }

    public void traducir(String palabra) {
        String traduccion = dictionary.get(palabra);

        if (traduccion != null)
        {
            resultado.setValue(traduccion);
        }
        else
        {
            resultado.setValue("No encontrada");
        }
    }
}
