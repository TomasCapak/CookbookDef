package com.example.cookbook;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import android.database.Cursor;



public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context c){
        super( c,"cookbookdbsqlite.db",null,1);
    }
    public void onCreate(SQLiteDatabase db) {}
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {}

    public Cursor getKategorie() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor res =  db.rawQuery( "select * from Kategorie", null );
        return res;
    }
public void pridejKategorii(String kat){

    SQLiteDatabase db = this.getWritableDatabase();

    db.execSQL("INSERT INTO Kategorie VALUES(kat);");
    System.out.println("ok");
}



}
