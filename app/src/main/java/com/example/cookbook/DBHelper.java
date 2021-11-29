package com.example.cookbook;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import android.database.Cursor;

import androidx.annotation.Nullable;


public class DBHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "cookbook.db";
    private static final int DATABASE_VERSION = 1;

    private static final String OBTIZNOST = "Obtiznost";
    private static final String ID_OBTIZNOST = "idObtiznost";
    private static final String UROVEN = "uroven";


    private static final String KATEGORIE = "Kategorie";
    private static final String ID_KATEGORIE = "idkategorie";
    private static final String NAZEV = "nazev";

    public DBHelper(@Nullable Context context){

        super( context,"cookbook.db",null, DATABASE_VERSION);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryKat = "CREATE TABLE " + KATEGORIE +
                 " ("  + ID_KATEGORIE + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NAZEV	+ " TEXT);";
        db.execSQL(queryKat);

        String queryObt = "CREATE TABLE " + OBTIZNOST +
                " ("  + ID_OBTIZNOST + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                UROVEN	+ " TEXT);";
        db.execSQL(queryObt);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + KATEGORIE);
        db.execSQL("DROP TABLE IF EXISTS " + OBTIZNOST);
        onCreate(db);
    }



    public Cursor getKategorie() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor res =  db.rawQuery( "select * from Kategorie", null );
        return res;
    }




    public void pridejKategorii(String kat){

    SQLiteDatabase db = this.getWritableDatabase();

    db.execSQL("INSERT INTO Kategorie (nazev) VALUES('"+ kat +"');");

    System.out.println("ok");
}

//asd

}
