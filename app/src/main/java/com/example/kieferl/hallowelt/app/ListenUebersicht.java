package com.example.kieferl.hallowelt.app;

import android.widget.AdapterView;

/**
 * Created by kieferl on 19.04.2016.
 */
public class ListenUebersicht {
    private String name;
    private long id;


    public ListenUebersicht(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        String output = name;

        return output;
    }
}
