package com.example.kieferl.hallowelt.app;

import android.content.Context;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

import android.content.Intent;
import android.widget.ShareActionProvider;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import static android.app.PendingIntent.getActivity;

public class ListenUebersichtMainActivity extends ActionBarActivity {

    private Button button;
    private TextView listenName1;
    private TextView listenName2;
    private TextView listenName3;
    private TextView listenName4;
    private TextView listenName5;
    private TextView listenName6;
    private TextView listenName7;
    private TextView listenName8;
    private TextView listenName9;
    private TextView listenName10;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item_listenuebersicht);

        button = (Button) findViewById(R.id.button);
        listenName1 = (TextView) findViewById(R.id.listenName1);
        listenName2 = (TextView) findViewById(R.id.listenName2);
        listenName3 = (TextView) findViewById(R.id.listenName3);
        listenName4 = (TextView) findViewById(R.id.listenName4);
        listenName5 = (TextView) findViewById(R.id.listenName5);
        listenName6 = (TextView) findViewById(R.id.listenName6);
        listenName7 = (TextView) findViewById(R.id.listenName7);
        listenName8 = (TextView) findViewById(R.id.listenName8);
        listenName9 = (TextView) findViewById(R.id.listenName9);
        listenName10 = (TextView) findViewById(R.id.listenName10);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();


        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ListenUebersichtMainActivity.this, LeereListe.class);
                startActivity(i);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int idS = item.getItemId();
        if (idS == R.id.action_settings) {
            Toast.makeText(ListenUebersichtMainActivity.this,"Nicht so neugierig!", Toast.LENGTH_SHORT).show();
            return true;
        }
        int idTe = item.getItemId();
        if (idTe == R.id.liste_teilen) {
            Toast.makeText(ListenUebersichtMainActivity.this,"Mit Entwickler geteilt!", Toast.LENGTH_SHORT).show();
            return true;
        }
        int idTa = item.getItemId();
        if (idTa == R.id.action_taschenrechner) {
            Intent i = new Intent(ListenUebersichtMainActivity.this, TaschenrechnerActivity.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "ListenUebersichtMain Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.kieferl.hallowelt.app/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "ListenUebersichtMain Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.kieferl.hallowelt.app/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }


}