package com.example.kieferl.hallowelt.app;

import android.os.Bundle;
import android.widget.EditText;
import android.app.Activity;



public class LeereListe extends Activity {

    private EditText listenName;
    private EditText listenElement;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leere_liste);


    }
}
