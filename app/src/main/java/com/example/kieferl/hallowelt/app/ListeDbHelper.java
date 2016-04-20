package com.example.kieferl.hallowelt.app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kieferl on 20.04.2016.
 */
public class ListeDbHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "list_list.db";
    public static final int DB_VERSION = 1;

    public static final String TABLE_LIST_LIST = "list_list";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_LIST_ID = "listId";
    public static final String COLUMN_TEXT = "text";
    public static final String COLUMN_PRIO = "prio";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_IS_DONE = "isD";

    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_LIST_LIST +
                    "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_LIST_ID + " FREMDSCHLÜSSEL " +
                    COLUMN_TEXT + " TEXT NOT NULL " +
                    COLUMN_PRIO + " INTEGER NOT NULL " +
                    COLUMN_DATE + " TEXT NOT NULL " +
                    COLUMN_IS_DONE + " TEXT NOT NULL);";

    public ListeDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(SQL_CREATE);
        }
        catch (Exception ex) {
        }

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
