package com.example.kieferl.hallowelt.app;

import android.text.Editable;
import android.widget.EditText;

/**
 * Created by kieferl on 19.04.2016.
 */
public class ListeListe {
    private String text;
    private int prio;
    private String date;
    private int id;
    private int listId;
    private boolean isD;

    public ListeListe(String text, String date, int id, int listId, int prio, boolean isD) {
        this.text = text;
        this.prio = prio;
        this.date = date;
        this.id = id;
        this.listId = listId;
        this.isD = isD;
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public int getPrio() {
        return prio;
    }
    public void setPrio(int prio) {
        this.prio = prio;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getListId() {
        return listId;
    }
    public void setListeId(int listId) {
        this.listId = listId;
    }

    public boolean getIsD() {
        return isD;
    }
    public void setIsD(boolean isD) {
        this.isD = isD;
    }

    @Override
    public String toString() {
        String output = text;

        return output;
    }
}