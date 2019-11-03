package com.sample.firstapp;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sample.myfirstapp.R;
import com.sample.firstapp.com.sample.myfirstapp.models.Departament;

public class JsonActivity extends AppCompatActivity {

    private EditText departamentName = null;
    private EditText  InaugurationYear = null;
    private EditText  Description = null;
    private Departament departament;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_json);

        departamentName = findViewById(R.id.departament_name);
        InaugurationYear = findViewById(R.id.edt_year);
        Description = findViewById(R.id.edt_description);

        try {
            FloatingActionButton floatButton = findViewById(R.id.flt_btn_show_json);
            floatButton.setOnClickListener(view -> {

                buildDepartamentObject();

                setJsonResult();
            });
        } catch (Exception e) {
            Toast toast = Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG);
            toast.show();
        }
    }

    private void setJsonResult() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String departmentJson = gson.toJson(departament);

        TextView result = findViewById(R.id.txt_json);

        result.setText(departmentJson);
    }

    private void buildDepartamentObject() {
        try {
            departament = new Departament();
            departament.Name = departamentName.getText().toString();
            departament.Descripion = Description.getText().toString();
            departament.InaugurationYear = Integer.parseInt(InaugurationYear.getText().toString());
        } catch (Exception e) {
            Toast toast = Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG);
            toast.show();
        }
    }

}
