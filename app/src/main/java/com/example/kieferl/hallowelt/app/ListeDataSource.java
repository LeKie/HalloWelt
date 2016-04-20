package com.example.kieferl.hallowelt.app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import android.content.ContentValues;
import android.database.Cursor;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kieferl on 20.04.2016.
 */
public class ListeDataSource {

    private SQLiteDatabase database;
    private ListeDbHelper dbHelper;

    private String[] columns = {
        ListeDbHelper.COLUMN_ID,
        ListeDbHelper.COLUMN_LIST_ID,
        ListeDbHelper.COLUMN_PRIO,
        ListeDbHelper.COLUMN_TEXT,
        ListeDbHelper.COLUMN_DATE,
        ListeDbHelper.COLUMN_IS_DONE
    };

    public ListeDataSource(Context context) {

        dbHelper = new ListeDbHelper(context);
    }
    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public ListeListe createListList(String text, int prio, String date, int listId, boolean isD) {
        ContentValues values = new ContentValues();
        values.put(ListeDbHelper.COLUMN_TEXT, text);
        values.put(ListeDbHelper.COLUMN_PRIO, prio);
        values.put(ListeDbHelper.COLUMN_DATE, date);
        values.put(ListeDbHelper.COLUMN_LIST_ID, listId);
        values.put(ListeDbHelper.COLUMN_IS_DONE, isD);

        int insertId = (int) database.insert(ListeDbHelper.TABLE_LIST_LIST, null, values);

        Cursor cursor = database.query(ListeDbHelper.TABLE_LIST_LIST,
                columns, ListeDbHelper.COLUMN_ID + "=" + insertId,
                null, null, null, null);

        cursor.moveToFirst();
        ListeListe listList = cursorToListList(cursor);
        cursor.close();

        return listList;
    }

    private ListeListe cursorToListList(Cursor cursor) {
        int idIndex = cursor.getColumnIndex(ListeDbHelper.COLUMN_ID);
        int idListId = cursor.getColumnIndex(ListeDbHelper.COLUMN_LIST_ID);
        int idText = cursor.getColumnIndex(ListeDbHelper.COLUMN_TEXT);
        int idDate = cursor.getColumnIndex(ListeDbHelper.COLUMN_DATE);
        int idPrio = cursor.getColumnIndex(ListeDbHelper.COLUMN_PRIO);
        int idIsD = cursor.getColumnIndex(ListeDbHelper.COLUMN_IS_DONE);

        String text = cursor.getString(idText);
        String date = cursor.getString(idDate);
        int id = cursor.getInt(idIndex);
        int listId = cursor.getInt(idListId);
        int prio = cursor.getInt(idPrio);
        boolean isD = cursor.equals(idIsD);

        ListeListe listList = new ListeListe(text, date, id, listId, prio, isD);

        return listList;
    }

    public void deleteElement(ListeListe listList) {
        long id = listList.getId();

        database.delete(ListeDbHelper.TABLE_LIST_LIST,
                ListeDbHelper.COLUMN_ID + "=" + id,
                null);
    }

    public List<ListeListe> getAllListItems() {
        List<ListeListe> listList = new ArrayList<>();

        Cursor cursor = database.query(ListeDbHelper.TABLE_LIST_LIST,
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
