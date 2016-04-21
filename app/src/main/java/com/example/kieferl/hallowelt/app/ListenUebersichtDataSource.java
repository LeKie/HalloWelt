package com.example.kieferl.hallowelt.app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by kieferl on 19.04.2016.
 */
public class ListenUebersichtDataSource {

    private SQLiteDatabase database;
    private ListDbHelper dbHelper;

    private String[] columns = {
            ListDbHelper.COLUMN_LIST_ID,
            ListDbHelper.COLUMN_NAME,
    };


    public ListenUebersichtDataSource(Context context) {
        dbHelper = new ListDbHelper(context);
    }
    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public ListenUebersicht createListOverview(String name) {
        ContentValues values = new ContentValues();
        values.put(ListDbHelper.COLUMN_NAME, name);

        long insertId = database.insert(ListDbHelper.TABLE_OVERVIEW_LIST, null, values);

        Cursor cursor = database.query(ListDbHelper.TABLE_OVERVIEW_LIST,
                columns, ListDbHelper.COLUMN_LIST_ID + "=" + insertId,
                null, null, null, null);

        cursor.moveToFirst();
        ListenUebersicht overviewList = cursorToListenUebersicht(cursor);
        cursor.close();

        return overviewList;
    }

    private ListenUebersicht cursorToListenUebersicht(Cursor cursor) {
        int idIndex = cursor.getColumnIndex(ListDbHelper.COLUMN_LIST_ID);
        int idName = cursor.getColumnIndex(ListDbHelper.COLUMN_NAME);

        String name = cursor.getString(idName);
        long id = cursor.getLong(idIndex);

        ListenUebersicht listenUebersicht = new ListenUebersicht(name, id);

        return listenUebersicht;
    }
    public void deleteListeName(ListenUebersicht overviewList) {
        long id = overviewList.getId();

        database.delete(ListDbHelper.TABLE_OVERVIEW_LIST,
                ListDbHelper.COLUMN_LIST_ID + "=" + id,
                null);
    }
    public ListenUebersicht updateListenUebersicht (long id, String newName) {
        ContentValues values = new ContentValues();
        values.put(ListDbHelper.COLUMN_NAME, newName);

        database.update(ListDbHelper.TABLE_OVERVIEW_LIST,
                values,
                ListDbHelper.COLUMN_LIST_ID + "=" + id,
                null);

        Cursor cursor = database.query(ListDbHelper.TABLE_OVERVIEW_LIST,
                columns, ListDbHelper.COLUMN_LIST_ID + "=" + id,
                null, null, null, null);

        cursor.moveToFirst();
        ListenUebersicht overviewList = cursorToListenUebersicht(cursor);
        cursor.close();

        return overviewList;
    }

    public List<ListenUebersicht> getAllListNames() {
        List<ListenUebersicht> listenUebersicht = new ArrayList<>();

        Cursor cursor = database.query(ListDbHelper.TABLE_OVERVIEW_LIST,
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
