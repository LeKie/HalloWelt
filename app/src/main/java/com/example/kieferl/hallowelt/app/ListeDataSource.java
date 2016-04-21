package com.example.kieferl.hallowelt.app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kieferl on 20.04.2016.
 */
public class ListeDataSource {

    private SQLiteDatabase database;
    private ListDbHelper dbHelper;

    private String[] columns = {
            ListDbHelper.COLUMN_ID,
            ListDbHelper.COLUMN_LIST_ID,
            ListDbHelper.COLUMN_PRIO,
            ListDbHelper.COLUMN_TEXT,
            ListDbHelper.COLUMN_DATE,
            ListDbHelper.COLUMN_IS_DONE
    };

    public ListeDataSource(Context context) {
        dbHelper = new ListDbHelper(context);
    }
    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public ListeListe createListList(String text, int prio, String date, long listId, boolean isD) {
        ContentValues values = new ContentValues();
        values.put(ListDbHelper.COLUMN_TEXT, text);
        values.put(ListDbHelper.COLUMN_PRIO, prio);
        values.put(ListDbHelper.COLUMN_DATE, date);
        values.put(ListDbHelper.COLUMN_LIST_ID, listId);
        values.put(ListDbHelper.COLUMN_IS_DONE, isD);

        long insertId = database.insert(ListDbHelper.TABLE_LIST_LIST, null, values);

        Cursor cursor = database.query(ListDbHelper.TABLE_LIST_LIST,
                columns, ListDbHelper.COLUMN_ID + "=" + insertId,
                null, null, null, null);

        cursor.moveToFirst();
        ListeListe listList = cursorToListList(cursor);
        cursor.close();

        return listList;
    }

    private ListeListe cursorToListList(Cursor cursor) {
        int idIndex = cursor.getColumnIndex(ListDbHelper.COLUMN_ID);
        int idListId = cursor.getColumnIndex(ListDbHelper.COLUMN_LIST_ID);
        int idText = cursor.getColumnIndex(ListDbHelper.COLUMN_TEXT);
        int idDate = cursor.getColumnIndex(ListDbHelper.COLUMN_DATE);
        int idPrio = cursor.getColumnIndex(ListDbHelper.COLUMN_PRIO);
        int idIsD = cursor.getColumnIndex(ListDbHelper.COLUMN_IS_DONE);

        String text = cursor.getString(idText);
        String date = cursor.getString(idDate);
        long id = cursor.getInt(idIndex);
        long listId = cursor.getInt(idListId);
        int prio = cursor.getInt(idPrio);
        boolean isD = cursor.equals(idIsD);

        ListeListe listList = new ListeListe(text, date, id, listId, prio, isD);

        return listList;
    }

    public void deleteElement(ListeListe listList) {
        long id = listList.getId();

        database.delete(ListDbHelper.TABLE_LIST_LIST,
                ListDbHelper.COLUMN_ID + "=" + id,
                null);
    }

    public List<ListeListe> getAllListItems() {
        List<ListeListe> listList = new ArrayList<>();

        Cursor cursor = database.query(ListDbHelper.TABLE_LIST_LIST,
                columns, null, null, null, null, null);

        cursor.moveToFirst();
        ListeListe listlist;

        while (!cursor.isAfterLast()) {
            listlist = cursorToListList(cursor);
            listList.add(listlist);
            cursor.moveToNext();
        }
        cursor.close();

        return listList;
    }
}
