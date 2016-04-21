package com.example.kieferl.hallowelt.app;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;

/**
 * Created by kieferl on 19.04.2016.
 */
public class ListDbHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "list_list.db";
    public static final int DB_VERSION = 1;

    public static final String TABLE_OVERVIEW_LIST = "overviewList";
    public static final String TABLE_LIST_LIST = "listList";

    public static final String COLUMN_LIST_ID = "listId";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TEXT = "text";
    public static final String COLUMN_PRIO = "prio";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_IS_DONE = "isD";

    private SQLiteDatabase mDatabase;

    public static final String CREATE_TABLE_UEBERSICHT =
            "CREATE TABLE " + TABLE_OVERVIEW_LIST +
                    "(" + COLUMN_LIST_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT NOT NULL" + ")";

    public static final String CREATE_TABLE_LIST =
            "CREATE TABLE " + TABLE_LIST_LIST +
                    "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "FOREIGN KEY(" + COLUMN_LIST_ID + ") REFERENCES " + TABLE_OVERVIEW_LIST + "_id"+
                    COLUMN_TEXT + " TEXT NOT NULL, " +
                    COLUMN_PRIO + " INTEGER NOT NULL, " +
                    COLUMN_DATE + " DATETIME, " +
                    COLUMN_IS_DONE + " BOOLEAN " + ")";

    public ListDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_TABLE_UEBERSICHT);
            db.execSQL(CREATE_TABLE_LIST);
        }
        catch (Exception ex) {
        }

    }

    public synchronized SQLiteDatabase openDatabase() {
        mDatabase =  getWritableDatabase();
        return  mDatabase;
    }

    public synchronized  void closeDatabase() {
        mDatabase.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + CREATE_TABLE_UEBERSICHT);
        db.execSQL("DROP TABLE IF EXISTS" + CREATE_TABLE_LIST);

        onCreate(db);
    }
}
