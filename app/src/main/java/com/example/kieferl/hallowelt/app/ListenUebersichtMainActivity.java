package com.example.kieferl.hallowelt.app;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;

import android.widget.Toast;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.database.Cursor;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.List;
import android.util.Log;
import android.content.DialogInterface;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import static android.app.PendingIntent.getActivity;

public class ListenUebersichtMainActivity extends ActionBarActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public static final String LOG_TAG = ListenUebersichtMainActivity.class.getSimpleName();

    private GoogleApiClient client;
    private ListenUebersichtDataSource dataSource;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_listenuebersicht_main);

        showAllListEntries();
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

        @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int idS = item.getItemId();
        if (idS == R.id.action_settings) {
            Toast.makeText(ListenUebersichtMainActivity.this, "Nicht so neugierig!", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(ListenUebersichtMainActivity.this, LeereListe.class);
            startActivity(i);
            return true;
        }
        int idTa = item.getItemId();
        if (idTa == R.id.action_taschenrechner) {
            Intent i = new Intent(ListenUebersichtMainActivity.this, TaschenrechnerActivity.class);
            startActivity(i);
            return true;
        }
        int idNL = item.getItemId();
        if (idNL == R.id.action_neueListe) {
            final AlertDialog.Builder alertDialog = new AlertDialog.Builder(ListenUebersichtMainActivity.this);
            alertDialog.setTitle("Neue Liste erstellen");

            final EditText listName = new EditText(ListenUebersichtMainActivity.this);
            listName.setHint("Listenname");

            LinearLayout ll = new LinearLayout(this);
            ll.setOrientation(LinearLayout.VERTICAL);
            ll.addView(listName);

            alertDialog.setView(ll);

            alertDialog.setPositiveButton("OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            String name = listName.getText().toString();
                            if(TextUtils.isEmpty(name)) {
                                listName.setError(getString(Integer.parseInt("Error")));
                                return;
                            } else {
                                listName.setText("");
                                dataSource.createListOverview(name);
                            }
                            showAllListEntries ();
                        }
                    });
            alertDialog.setNegativeButton("Beenden",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

            alertDialog.show();
        }
        return super.onOptionsItemSelected(item);
    }
    /**button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ListenUebersichtMainActivity.this, LeereListe.class);
                startActivity(i);
            }
        });*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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

    private void showAllListEntries() {
        List<ListenUebersicht> overviewList = dataSource.getAllListNames();

        ArrayAdapter<ListenUebersicht> listenUebersichtArrayAdapter = new ArrayAdapter<> (
                this,
                android.R.layout.simple_list_item_multiple_choice,
                overviewList);

        ListView listNamesListView = (ListView) findViewById(R.id.list_listenuebersicht_main);
        if (listNamesListView != null) {
            listNamesListView.setAdapter(listenUebersichtArrayAdapter);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        dataSource.open();

        showAllListEntries();
    }

    @Override
    protected void onPause() {
        super.onPause();


        dataSource.close();
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