package com.example.cookbook;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import android.database.Cursor;
import android.widget.Toast;

import androidx.annotation.Nullable;


public class DBHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "cookbook.db";
    private static final int DATABASE_VERSION = 15;

    private static final String OBTIZNOST = "Obtiznosttxt";
    private static final String ID_OBTIZNOST = "idObtiznost";
    private static final String UROVEN = "uroven";

    private static final String KATEGORIE = "Kategorie";
    private static final String ID_KATEGORIE = "idKategorie";
    private static final String NAZEVKATEGORIE = "nazevkat";

    private static final String JEDNOTKA = "Jednotka";
    private static final String ID_JEDNOTKA = "idJednotka";
    private static final String NAZEVJEDNOTKA = "nazevjed";
    private static final String ZKRATKA = "zkratka";

    private static final String SUROVINA = "Surovina";
    private static final String ID_SUROVINA = "idSurovina";
    private static final String NAZEVSUROVINA = "nazevsur";
    private static final String KALORIE = "kalorie";
    private static final String JEDNOTKA_ID_JEDNOTKA = "Jednotka_idJednotka";

    private static final String RECEPT = "Recept";
    private static final String ID_RECEPT = "idRecept";
    private static final String NAZEVRECEPT = "nazevrec";
    private static final String POPIS = "popis";
    private static final String POSTUP_VARENI = "postupVareni";
    private static final String DOBAVARENI = "dobaVareniVMinutach";
    private static final String OBTIZNOST_ID_OBTIZNOST = "Obtiznost_idObtiznost" ;
    private static final String KATEGORIE_ID_KATEGORIE = "Kategorie_idKategorie";


    private static final String SUROVINA_HAS_RECEPT = "Surovina_has_Recept";
    private static final String MNOZSTVI = "mnozstvi";
    private static final String RECEPT_IDRECEPT = "Recept_idRecept";
    private static final String SUROVINA_IDSUROVINA = "Surovina_idSurovina";



    /*String queryShR = "CREATE TABLE " + SUROVINA_HAS_RECEPT +

            " ("  + MNOZSTVI + " integer, " +

            SUROVINA_IDSUROVINA + "integer, " +
            RECEPT_IDRECEPT + " integer, " +


            " FOREIGN KEY ("+SUROVINA_IDSUROVINA+") REFERENCES "+SUROVINA+"("+ID_SUROVINA+"), " +

            " FOREIGN KEY ("+RECEPT_IDRECEPT+") REFERENCES "+RECEPT+" ("+ID_RECEPT+"));";*/


    String queryRec = "CREATE TABLE " + RECEPT +
            " ("  + ID_RECEPT + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            NAZEVRECEPT	+ " TEXT, " +
            POPIS	+ " TEXT, " +
            POSTUP_VARENI	+ " TEXT, " +
            DOBAVARENI	+ " integer, " +
            KATEGORIE_ID_KATEGORIE + " integer, " +
            OBTIZNOST_ID_OBTIZNOST + " integer, " +

            " FOREIGN KEY ("+KATEGORIE_ID_KATEGORIE+") REFERENCES "+KATEGORIE+"("+ID_KATEGORIE+"), " +

            " FOREIGN KEY ("+OBTIZNOST_ID_OBTIZNOST+") REFERENCES "+OBTIZNOST+" ("+ID_OBTIZNOST+"));";


    String querySur = "CREATE TABLE " + SUROVINA +
            " ("  + ID_SUROVINA + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            NAZEVSUROVINA	+ " TEXT, " +
            KALORIE	+ " integer, " +
            JEDNOTKA_ID_JEDNOTKA + " integer, " +
            "FOREIGN KEY ("+JEDNOTKA_ID_JEDNOTKA+") REFERENCES "+JEDNOTKA+" ("+ID_JEDNOTKA+") )";

    String queryJed = "CREATE TABLE " + JEDNOTKA +
            " ("  + ID_JEDNOTKA + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            NAZEVJEDNOTKA	+ " TEXT, " +
            ZKRATKA	+ " TEXT);";

    String queryObt = "CREATE TABLE " + OBTIZNOST +
            " ("  + ID_OBTIZNOST + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            UROVEN	+ " TEXT);";

    String queryKat = "CREATE TABLE " + KATEGORIE +
            " ("  + ID_KATEGORIE + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            NAZEVKATEGORIE	+ " TEXT);";



    public DBHelper(@Nullable Context context){

        super( context,"cookbook.db",null, DATABASE_VERSION);
        this.context = context;


    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        /*String queryKat = "CREATE TABLE " + KATEGORIE +
                 " ("  + ID_KATEGORIE + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NAZEV	+ " TEXT);";


        String queryObt = "CREATE TABLE " + OBTIZNOST +
                " ("  + ID_OBTIZNOST + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                UROVEN	+ " TEXT);";*/
        //db.execSQL(queryShR);
        db.execSQL(queryRec);
        db.execSQL(querySur);
        db.execSQL(queryJed);
        db.execSQL(queryObt);
        db.execSQL(queryKat);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + RECEPT);
        db.execSQL("DROP TABLE IF EXISTS " + SUROVINA);
        db.execSQL("DROP TABLE IF EXISTS " + JEDNOTKA);
        db.execSQL("DROP TABLE IF EXISTS " + KATEGORIE);
        db.execSQL("DROP TABLE IF EXISTS " + OBTIZNOST);
        onCreate(db);
    }

    public void addRecipe(String nazevrec, String popis, String postupVareni, int dobaVareni) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(NAZEVRECEPT, nazevrec);
        cv.put(POPIS, popis);
        cv.put(POSTUP_VARENI, postupVareni);
        cv.put(DOBAVARENI, dobaVareni);
        long result = db.insert(RECEPT, null, cv);
        if (result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }
    public void insertEntryKategorie(SQLiteDatabase db, int ID_KATEGORIE,String NAZEV) {

        ContentValues newValues = new ContentValues();
        newValues.put("ID_KATEGORIE", ID_KATEGORIE);
        newValues.put("NAZEVKATEGORIE", NAZEV);
        db.insert("kategorie", null, newValues);
    }

    public void insertEntryObtiznost(SQLiteDatabase db, int ID_OBTIZNOST,String UROVEN) {

        ContentValues newValues = new ContentValues();
        newValues.put("ID_OBTIZNOST", ID_OBTIZNOST);
        newValues.put("UROVEN", UROVEN);
        db.insert("obtiznost", null, newValues);
    }


    /*public Cursor getKategorie() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =    db.rawQuery( "select * from Kategorie", null );
        return res;
    }

    public Cursor getObtiznost() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery( "select * from Obtiznosttxt", null );
        return res;
    }

    public Cursor getJednotka() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery( "select * from Jednotka", null );
        return res;
    }

    public Cursor getSurovina() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery( "select * from Surovina", null );
        return res;
    }



    public void pridejKategorii(String kat){

    SQLiteDatabase db = this.getWritableDatabase();

    db.execSQL("INSERT INTO Kategorie (nazev) VALUES('"+ kat +"');");

    System.out.println("ok");
}

    public void pridejObtiznost(String obt){

        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("INSERT INTO Obtiznosttxt (uroven) VALUES('"+ obt +"');");
        System.out.println("done");

    }

    public void pridejJedotku(String jed){

        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("INSERT INTO Jednotka (nazev) VALUES('"+ jed +"');");
        System.out.println("??");

    }

    public void pridejSurovinu(String sur){

        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("INSERT INTO Surovina (nazev) VALUES('"+ sur +"');");
        System.out.println("--");

    }*/

//asd
    Cursor readAllData(){
    String query = "SELECT * FROM  " + RECEPT;
    SQLiteDatabase db = this.getReadableDatabase();
    Cursor cursor = null;
    if (db != null) {
        cursor = db.rawQuery(query, null);
    }
    return cursor;
    }

    void updateData(String row_id, String nazevrec, String popis, String postupVareni, String dobaVareniVMincutach) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(NAZEVRECEPT, nazevrec);
        cv.put(POPIS, popis);
        cv.put(POSTUP_VARENI, postupVareni);
        cv.put(DOBAVARENI, dobaVareniVMincutach);

        long result = db.update(RECEPT, cv, "idRecept=?", new String[]{row_id});
        if(result == -1) {
            Toast.makeText(context, "Failed to Update.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Successfully Updated!", Toast.LENGTH_SHORT).show();

        }
    }


    void deleteOneRow(String row_id) {
        SQLiteDatabase db = getWritableDatabase();
        long result = db.delete(RECEPT, "idRecept=?", new String[]{row_id});
        if(result == -1) {
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show();
        }

    }

    void deleteAllData() {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + RECEPT);

    }

}
