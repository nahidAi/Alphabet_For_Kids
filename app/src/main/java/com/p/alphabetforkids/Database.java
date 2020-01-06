package com.p.alphabetforkids;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.IOException;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public static final String DBNAME = "Alphabetdb.sql";
      private Context mycontext;


    public Database(@Nullable Context context) {
        super(context, DBNAME, null, 1);
        mycontext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void copyDatabase()throws IOException{
        
    }
}
