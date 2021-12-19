package com.example.cookbook;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.database.Cursor;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    DBHelper mydb;
    RecyclerView recyclerView;
    FloatingActionButton add_button;
    ArrayList<String> idRecept, nazevrec, popis, postupVareni,  dobaVareniVMinutach;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add_button = findViewById(R.id.add_button);
        recyclerView = findViewById(R.id.recyclerView);
        add_button.bringToFront();
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);

            }
        });

        mydb = new DBHelper(MainActivity.this);
        idRecept = new ArrayList<>();
        nazevrec = new ArrayList<>();
        popis = new ArrayList<>();
        postupVareni = new ArrayList<>();
        dobaVareniVMinutach = new ArrayList<>();

        storeDataInArrays();

        customAdapter = new CustomAdapter(MainActivity.this, idRecept, nazevrec, popis, postupVareni,
                 dobaVareniVMinutach);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

    }
        void storeDataInArrays() {

            Cursor cursor = mydb.readAllData();
            if (cursor.getCount() == 0) {
                Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
            } else {
                while (cursor.moveToNext()) {
                    idRecept.add(cursor.getString(0));
                    nazevrec.add(cursor.getString(1));
                    popis.add(cursor.getString(2));
                    postupVareni.add(cursor.getString(3));
                    dobaVareniVMinutach.add(cursor.getString(4));

                }
            }
        }


        //mydb.pridejKategorii("Maso");
        //mydb.pridejObtiznost("Lehka");
        //mydb.pridejJedotku("Kilo");
        //mydb.pridejSurovinu("Brambory");


        //Cursor vysledek = mydb.getKategorie();

        /*vysledek.moveToFirst();
        while (vysledek.moveToNext()) {
            //System.out.println(vysledek.getString(1));
        }*/

        /*Cursor sur = mydb.getSurovina();

        sur.moveToFirst();
        while (sur.moveToNext()) {
            //System.out.println(sur.getString(1));
        }*/

        /*Cursor obt = mydb.getObtiznost();

        obt.moveToFirst();
        while (obt.moveToNext()) {
            //System.out.println(obt.getString(1));

        }*/

        /*Cursor jed = mydb.getJednotka();

        jed.moveToFirst();
        while (jed.moveToNext()) {
            //System.out.println(jed.getString(1));

        }*/

        /*setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);*/

}
