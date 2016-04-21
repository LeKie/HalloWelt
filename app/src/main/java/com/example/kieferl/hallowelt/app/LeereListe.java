package com.example.kieferl.hallowelt.app;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.content.Intent;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ShareActionProvider;
import android.widget.Toast;

import android.database.Cursor;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.List;

public class LeereListe extends ActionBarActivity {

    private ListeDataSource dataSource;
    private ListDbHelper dbHelper;
    private int listId;
    private SQLiteDatabase database;
    private String[] columns = {
            ListDbHelper.COLUMN_ID,
            ListDbHelper.COLUMN_LIST_ID,
            ListDbHelper.COLUMN_PRIO,
            ListDbHelper.COLUMN_TEXT,
            ListDbHelper.COLUMN_DATE,
            ListDbHelper.COLUMN_IS_DONE

    };

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
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        initializeContextualActionBar();

        listId = getIntent().getIntExtra("listId", -1);

       // Toast.makeText(this, String.valueOf(listId), Toast.LENGTH_SHORT).show();
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                        Bundle saveInstanceState) {
        View rootView = inflater.inflate(R.layout.leere_liste, container, false);

        Intent empfangenerIntent = this.getIntent();
        if (empfangenerIntent != null && empfangenerIntent.hasExtra("listId")) {
            String listList = empfangenerIntent.getStringExtra("listId");
            ((TextView) rootView.findViewById(R.id.leere_liste_item_textview)).setText(listList);
        }
        return rootView;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_leere_liste, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
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


            LinearLayout ll = new LinearLayout(this);
            ll.setOrientation(LinearLayout.VERTICAL);
            ll.addView(eintragName);
            ll.addView(prioritätText);
            //ll.addView(datePicker);

            alertDialog.setView(ll);

            AlertDialog.Builder builder = alertDialog.setPositiveButton("OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            String text = eintragName.getText().toString();
                            Integer prio = Integer.valueOf(prioritätText.getText().toString());
                            String date = String.valueOf(datePicker.getDayOfMonth()+ "." + datePicker.getMonth() + "." + datePicker.getYear());
                            long listId = 0;
                            boolean isD = false;

                            try {
                                if (TextUtils.isEmpty(text)) {
                                    Toast.makeText(LeereListe.this, "Falsche eingabe", Toast.LENGTH_SHORT).show();
                                    dialog.cancel();
                                } else {
                                    eintragName.setText("");
                                    prioritätText.setText("");
                                    dataSource.createListList(text, prio, date, listId, isD);
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

    private void initializeContextualActionBar() {

        final ListView listListView = (ListView) findViewById(R.id.leere_liste);
        listListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);

        listListView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {

            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {

            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                getMenuInflater().inflate(R.menu.menu_contextual_a_b_leereliste, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.action_eintragLöschen:
                        SparseBooleanArray touchedListListsPositions = listListView.getCheckedItemPositions();
                        for (int i = 0; i < touchedListListsPositions.size(); i++) {
                            boolean isChecked = touchedListListsPositions.valueAt(i);
                            if (isChecked) {
                                int postitionInListView = touchedListListsPositions.keyAt(i);
                                ListeListe listList = (ListeListe) listListView.getItemAtPosition(postitionInListView);
                                dataSource.deleteElement(listList);
                            }
                        }
                        showAllListEntries();
                        mode.finish();
                        return true;

                    default:
                        return false;
                }
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });
    }

    private void showAllListEntries() {
        List<ListeListe> listList = dataSource.getAllListItems();

        ArrayAdapter<ListeListe> listeListeArrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_activated_1,
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
        showAllListEntries();

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
