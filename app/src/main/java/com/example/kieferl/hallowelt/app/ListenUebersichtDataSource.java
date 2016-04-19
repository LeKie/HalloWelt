package com.example.kieferl.hallowelt.app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import android.content.ContentValues;
import android.database.Cursor;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by kieferl on 19.04.2016.
 */
public class ListenUebersichtDataSource {

    private SQLiteDatabase database;
    private ListenUebersichtDbHelper dbHelper;

    private String[] columns = {
            ListenUebersichtDbHelper.COLUMN_ID,
            ListenUebersichtDbHelper.COLUMN_NAME,
    };


    public ListenUebersichtDataSource(Context context) {
        dbHelper = new ListenUebersichtDbHelper(context);
    }
    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }
    public ListenUebersicht createListOverview(String name) {
        ContentValues values = new ContentValues();
        values.put(ListenUebersichtDbHelper.COLUMN_NAME, name);

        long insertId = database.insert(ListenUebersichtDbHelper.TABLE_OVERVIEW_LIST, null, values);

        Cursor cursor = database.query(ListenUebersichtDbHelper.TABLE_OVERVIEW_LIST,
                columns, ListenUebersichtDbHelper.COLUMN_ID + "=" + insertId,
                null, null, null, null);

        cursor.moveToFirst();
        ListenUebersicht overviewList = cursorToListenUebersicht(cursor);
        cursor.close();

        return overviewList;
    }

    private ListenUebersicht cursorToListenUebersicht(Cursor cursor) {
        int idIndex = cursor.getColumnIndex(ListenUebersichtDbHelper.COLUMN_ID);
        int idName = cursor.getColumnIndex(ListenUebersichtDbHelper.COLUMN_NAME);

        String name = cursor.getString(idName);
        long id = cursor.getLong(idIndex);

        ListenUebersicht listenUebersicht = new ListenUebersicht(name, id);

        return listenUebersicht;
    }

    public List<ListenUebersicht> getAllListNames() {
        List<ListenUebersicht> listenUebersicht = new ArrayList<>();

        Cursor cursor = database.query(ListenUebersichtDbHelper.TABLE_OVERVIEW_LIST,
                columns, null, null, null, null, null);
        
            cursor.moveToFirst();
            ListenUebersicht overviewList;

            while (!cursor.isAfterLast()) {
                overviewList = cursorToListenUebersicht(cursor);
                listenUebersicht.add(overviewList);
                cursor.moveToNext();
            }

        cursor.close();
        return listenUebersicht;
    }
}
