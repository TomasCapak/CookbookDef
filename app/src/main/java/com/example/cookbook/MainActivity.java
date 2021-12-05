package com.example.cookbook;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.database.Cursor;
public class MainActivity extends AppCompatActivity {


    DBHelper mydb;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        mydb = new DBHelper(this);
        mydb.pridejKategorii("Maso");
        mydb.pridejObtiznost("Lehka");
        mydb.pridejJedotku("Kilo");
        mydb.pridejSurovinu("Brambory");
        Cursor vysledek = mydb.getKategorie();

        vysledek.moveToFirst();
        while (vysledek.moveToNext()) {
            //System.out.println(vysledek.getString(1));
        }

        Cursor sur = mydb.getSurovina();

        sur.moveToFirst();
        while (sur.moveToNext()) {
            //System.out.println(sur.getString(1));
        }

        Cursor obt = mydb.getObtiznost();

        obt.moveToFirst();
        while (obt.moveToNext()) {
            //System.out.println(obt.getString(1));

        }

        Cursor jed = mydb.getJednotka();

        jed.moveToFirst();
        while (jed.moveToNext()) {
            //System.out.println(jed.getString(1));

        }

        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
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

        return super.onOptionsItemSelected(item);
    }
}
