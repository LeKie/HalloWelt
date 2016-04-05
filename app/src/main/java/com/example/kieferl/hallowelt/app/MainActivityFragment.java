package com.example.kieferl.hallowelt.app;

        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;

        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;

public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String [] beispiellisteArray ={
                "Milch",
                "Eier",
                "Käse",
                "Marmelade",
                "Honig",
                "Wurst",
                "Milch",
                "Eier",
                "Käse",
                "Marmelade",
                "Honig",
                "Wurst"
        };

        List<String> beispielliste=new ArrayList<>(Arrays.asList(beispiellisteArray));

        ArrayAdapter <String> beispiellisteAdapter =
                new ArrayAdapter<>(
                        getActivity(), // Die aktuelle Umgebung (diese Activity)
                        R.layout.list_item_beispielliste, // ID der XML-Layout Datei
                        R.id.list_item_beispielliste_textview, // ID des TextViews
                        beispielliste); // Beispieldaten in einer ArrayList

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        ListView aktienlisteListView = (ListView) rootView.findViewById(R.id.listview_beispielliste);
        aktienlisteListView.setAdapter(beispiellisteAdapter);

        return rootView;

    }
}

