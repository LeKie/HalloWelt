package com.example.kieferl.hallowelt.app;

        import android.app.Activity;
        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;

        import android.view.Menu;
        import android.view.MenuInflater;
        import android.view.MenuItem;
        import android.content.Intent;

        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;
        import android.widget.Toast;

        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;

public class BeispiellistenFragment extends Fragment {

    public BeispiellistenFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Menü bekannt geben, dadurch kann unser Fragment Menü-Events verarbeiten
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_beispiellistenfragment, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Wir prüfen, ob Menü-Element mit der ID "action_daten_aktualisieren"
        // ausgewählt wurde und geben eine Meldung aus
        int id = item.getItemId();
        if (id == R.id.liste_teilen) {
            Toast.makeText(getActivity(), "Mit Entwickler geteilt!", Toast.LENGTH_LONG).show();

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String [] beispiellisteArray ={
                "Einkaufsliste",
                "Wunschliste",
                "Beispielliste",
                "To-Do-Liste",
                "NochMehrListen",
                "Taschenrechner",
                "Einkaufsliste",
                "Wunschliste",
                "Beispielliste",
                "To-Do-Liste",
                "NochMehrListen",
                "Taschenrechner"
        };

        List<String> beispielliste=new ArrayList<>(Arrays.asList(beispiellisteArray));

        ArrayAdapter <String> beispiellisteAdapter =
                new ArrayAdapter<>(
                        getActivity(), // Die aktuelle Umgebung (diese Activity)
                        R.layout.list_item_beispielliste, // ID der XML-Layout Datei
                        R.id.list_item_beispielliste_textview, // ID des TextViews
                        beispielliste); // Beispieldaten in einer ArrayList

        View rootView = inflater.inflate(R.layout.fragment_liste, container, false);

        ListView beispielListView = (ListView) rootView.findViewById(R.id.listview_beispielliste);
        beispielListView.setAdapter(beispiellisteAdapter);

        beispielListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent taschenrechnerIntent = new Intent(getActivity(), TaschenrechnerActivity.class);
                startActivity(taschenrechnerIntent);
            }
        });
        return rootView;
    }
}

