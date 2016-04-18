package com.example.kieferl.hallowelt.app;

import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ShareActionProvider;
import android.widget.Toast;

public class LeereListe extends ActionBarActivity {

    private CheckBox done;
    private EditText listenelement;
    private TextView kategorie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leere_liste);

        done = (CheckBox) findViewById(R.id.done);
        listenelement = (EditText) findViewById(R.id.listenelement);
        kategorie = (TextView) findViewById(R.id.kategorie);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_leere_liste, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int idTe = item.getItemId();
        if (idTe == R.id.liste_teilen) {
            Toast.makeText(LeereListe.this, "Mit Entwickler geteilt!", Toast.LENGTH_SHORT).show();
            return true;
        }
        int idLe = item.getItemId();
        if (idLe == R.id.liste_leeren) {
            Toast.makeText(LeereListe.this, "Liste nicht geleert!", Toast.LENGTH_SHORT).show();
            return true;
        }
        int idUm = item.getItemId();
        if (idUm == R.id.liste_umbenennen) {
            Toast.makeText(LeereListe.this, "Listenname schon schön genug!", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
