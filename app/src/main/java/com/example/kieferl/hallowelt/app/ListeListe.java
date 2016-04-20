package com.example.kieferl.hallowelt.app;

import android.text.Editable;
import android.widget.EditText;

/**
 * Created by kieferl on 19.04.2016.
 */
public class ListeListe {
    private String text;
    private Integer prio;
    private String date;
    private long id;
    private long listId;
    private boolean isD;

    public ListeListe(String text, String date, long id, long listId, Integer prio, boolean isD) {
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

    public Integer getPrio(Integer prio) {
        return prio;
    }
    public void setPrio(Integer prio) {
        this.prio = prio;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public long getListId() {
        return listId;
    }
    public void setListeId(long listId) {
        this.listId = listId;
    }

    public boolean getIsD(boolean isD) {
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