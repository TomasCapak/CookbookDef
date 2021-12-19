package com.example.cookbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText nazevRecept_input, postupVareni_input, dobaVareniVMinutach_input, popis_input;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        nazevRecept_input = findViewById(R.id.nazevRecept_input);
        postupVareni_input = findViewById(R.id.postupVareni_input);
        dobaVareniVMinutach_input = findViewById(R.id.dobaVareniVMinutach_input);
        popis_input = findViewById(R.id.popis_input);
        add_button = findViewById(R.id.add_button);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper mydb = new DBHelper(AddActivity.this);
                mydb.addRecipe(nazevRecept_input.getText().toString().trim(),
                        postupVareni_input.getText().toString().trim(),
                        popis_input.getText().toString().trim(),
                        Integer.valueOf(dobaVareniVMinutach_input.getText().toString().trim()));

            }
        });
    }
}