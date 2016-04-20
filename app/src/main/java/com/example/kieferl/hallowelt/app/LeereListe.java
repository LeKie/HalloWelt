package com.example.kieferl.hallowelt.app;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.content.Intent;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ShareActionProvider;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.List;

public class LeereListe extends ActionBarActivity {

    private ListeDataSource dataSource;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leere_liste);

        dataSource = new ListeDataSource(this);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
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
        int idNE = item.getItemId();
        if (idNE == R.id.neues_element) {
            final AlertDialog.Builder alertDialog = new AlertDialog.Builder(LeereListe.this);
            alertDialog.setTitle("Neuen Eintrag erstellen");

            final EditText eintragName = new EditText(LeereListe.this);
            eintragName.setHint("Eintrag");
            final EditText prioritätText = new EditText(LeereListe.this);
            prioritätText.setHint("Priorität (1-3)");
            final DatePicker datePicker = new DatePicker(LeereListe.this);
            datePicker.getFirstDayOfWeek();

            LinearLayout ll = new LinearLayout(this);
            ll.setOrientation(LinearLayout.VERTICAL);
            ll.addView(eintragName);
            ll.addView(prioritätText);
            ll.addView(datePicker);

            alertDialog.setView(ll);

            AlertDialog.Builder builder = alertDialog.setPositiveButton("OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            String text = eintragName.getText().toString();
                            Integer prio = Integer.valueOf(prioritätText.getText().toString());
                            String date = String.valueOf(datePicker.getDayOfMonth()+ "." + datePicker.getMonth() + 1 + "." + datePicker.getYear());
                            try {
                                if (TextUtils.isEmpty(text)) {
                                    Toast.makeText(LeereListe.this, "Falsche eingabe", Toast.LENGTH_SHORT).show();
                                    dialog.cancel();
                                } else {
                                    eintragName.setText("");
                                    prioritätText.setText("");
                                    dataSource.createListList(text, prio, date);
                                }

                                showAllListEntries();
                            } catch (NumberFormatException ex) {
                                Toast.makeText(LeereListe.this, "Falsche eingabe", Toast.LENGTH_SHORT).show();
                                dialog.cancel();
                            }
                            showAllListEntries();
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

    private void showAllListEntries() {
        List<ListeListe> listList = dataSource.getAllListItems();

        ArrayAdapter<ListeListe> listeListeArrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_selectable_list_item,
                listList);

        ListView listItemsListView = (ListView) findViewById(R.id.leere_liste);
        if (listItemsListView != null) {
            listItemsListView.setAdapter(listeListeArrayAdapter);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        dataSource.open();


    }

    @Override
    protected void onPause() {
        super.onPause();

        dataSource.close();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "LeereListe Page", // TODO: Define a title for the content shown.
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
                "LeereListe Page", // TODO: Define a title for the content shown.
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
