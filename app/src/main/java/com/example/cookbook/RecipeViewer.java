package com.example.cookbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecipeViewer extends AppCompatActivity {

    DBHelper mydb;
    String idRecept;
    String nazevrec;
    String popis;
    String postupVareni;
    String dobaVareniVMinutach;
    CustomAdapter customAdapter;
    Button updateview_button;

    TextView recept_id_txt, recept_nazev_txt, recept_popis_txt, recept_postupVareni_txt, recept_DobaVareni_txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recipe_viewer);
        recept_id_txt = findViewById(R.id.recept_id_txt2);
        recept_nazev_txt = findViewById(R.id.recept_nazev_txt2);
        recept_popis_txt = findViewById(R.id.recept_popis_txt2);
        recept_postupVareni_txt = findViewById(R.id.recept_postupVareni_txt2);
        recept_DobaVareni_txt = findViewById(R.id.recept_DobaVareni_txt2);



        getIntentData();

    }

    void getIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("nazev") && getIntent().hasExtra("popis") && getIntent().hasExtra("postupVareni") && getIntent().hasExtra("dobaVareniVMinutach")) {
            //getting data from Intent
            idRecept = getIntent().getStringExtra("id");
            nazevrec = getIntent().getStringExtra("nazev");
            popis = getIntent().getStringExtra("popis");
            postupVareni = getIntent().getStringExtra("postupVareni");
            dobaVareniVMinutach = getIntent().getStringExtra("dobaVareniVMinutach");
            //setting Intent Data
            recept_id_txt.setText(idRecept);
            recept_nazev_txt.setText(nazevrec);
            recept_popis_txt.setText(popis);
            recept_postupVareni_txt.setText(postupVareni);
            recept_DobaVareni_txt.setText(dobaVareniVMinutach);

        } else {
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }




}