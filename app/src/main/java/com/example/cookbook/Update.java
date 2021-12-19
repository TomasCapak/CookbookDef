package com.example.cookbook;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update extends AppCompatActivity {

    String idRecept;
    String nazevrec;
    String popis;
    String postupVareni;
    String dobaVareniVMinutach;

    EditText recept_id_txt, recept_nazev_txt2, recept_popis_txt2, recept_postupVareni_txt2, recept_DobaVareni_txt2;
    Button update_button;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);




        recept_nazev_txt2 = findViewById(R.id.nazevRecept_input3);
        recept_popis_txt2 = findViewById(R.id.popis_input3);
        recept_postupVareni_txt2 = findViewById(R.id.postupVareni_input3);
        recept_DobaVareni_txt2 = findViewById(R.id.dobaVareniVMinutach_input3);
        update_button = findViewById(R.id.update_button);

        getIntentData2();

        update_button.bringToFront();
        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper mydb = new DBHelper(Update.this);

                nazevrec = recept_nazev_txt2.getText().toString().trim();
                popis = recept_popis_txt2.getText().toString().trim();
                postupVareni = recept_postupVareni_txt2.getText().toString().trim();
                dobaVareniVMinutach = recept_DobaVareni_txt2.getText().toString().trim();

                mydb.updateData(idRecept, nazevrec, popis, postupVareni, dobaVareniVMinutach );
            }
        });

        //getIntentData2();



    }


    void getIntentData2(){
        if(getIntent().hasExtra("id2") && getIntent().hasExtra("nazev2") && getIntent().hasExtra("popis2") && getIntent().hasExtra("postupVareni2") && getIntent().hasExtra("dobaVareniVMinutach2")) {
            //getting data from Intent

            idRecept = getIntent().getStringExtra("id2");
            nazevrec = getIntent().getStringExtra("nazev2");
            popis = getIntent().getStringExtra("popis2");
            postupVareni = getIntent().getStringExtra("postupVareni2");
            dobaVareniVMinutach = getIntent().getStringExtra("dobaVareniVMinutach2");

            //setting Intent Data

            recept_nazev_txt2.setText(nazevrec);
            recept_popis_txt2.setText(popis);
            recept_postupVareni_txt2.setText(postupVareni);
            recept_DobaVareni_txt2.setText(dobaVareniVMinutach);

        } else {
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }





}