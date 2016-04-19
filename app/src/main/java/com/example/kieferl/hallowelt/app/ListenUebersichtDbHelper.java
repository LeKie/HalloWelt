package com.example.kieferl.hallowelt.app;

import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by kieferl on 19.04.2016.
 */
public class ListenUebersichtDbHelper  extends SQLiteOpenHelper {

    public static final String DB_NAME = "overview_list.db";
    public static final int DB_VERSION = 1;

    public static final String TABLE_OVERVIEW_LIST = "overview_list";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";

    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_OVERVIEW_LIST +
                    "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT NOT NULL);";

    public ListenUebersichtDbHelper(Context context) {
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
