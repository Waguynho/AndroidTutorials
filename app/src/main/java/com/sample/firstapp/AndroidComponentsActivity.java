package com.sample.firstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sample.firstapp.adapters.DepartamentRecycleViewAdapter;
import com.sample.firstapp.com.sample.myfirstapp.models.Departament;
import com.sample.myfirstapp.R;

import java.util.ArrayList;

public class AndroidComponentsActivity extends AppCompatActivity {
    RecyclerView recyclerViewDepartament;
    DepartamentRecycleViewAdapter departamentRecycleViewAdapter;
    ArrayList<Departament> departaments;
    Button btnReverseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_components);

        getDataDepartaments();

        prepareListRecycleView();

        btnReverseList = findViewById(R.id.btn_lists);
        btnReverseList.setOnClickListener(this::reverseList);
    }

    private void prepareListRecycleView() {
        initializeAdapter();

        initializeRecycleViewDepartament();
    }

    private void reverseList(View view) {
        if (departaments != null && !departaments.isEmpty()) {
            ArrayList<Departament> listClone = (ArrayList<Departament>) departaments.clone();
            departaments.clear();
            int index;
            for(index = listClone.size() -1 ; index >= 0; index--){

                departaments.add(listClone.get(index));
            }
            initializeRecycleViewDepartament();
        }
    }

    private void initializeAdapter() {
        departamentRecycleViewAdapter = new DepartamentRecycleViewAdapter(departaments, this);
    }

    private void initializeRecycleViewDepartament() {
        recyclerViewDepartament = findViewById(R.id.recycler_view_departament);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerViewDepartament.setLayoutManager(linearLayoutManager);
        recyclerViewDepartament.setItemAnimator(new DefaultItemAnimator());
        recyclerViewDepartament.setHasFixedSize(false);
        recyclerViewDepartament.setAdapter(departamentRecycleViewAdapter);
    }

    private void getDataDepartaments() {
        departaments = new ArrayList<>(5);
        departaments.add(new Departament("Departament A"));
        departaments.add(new Departament("Departament B"));
        departaments.add(new Departament("Departament C"));
        departaments.add(new Departament("Departament D"));
        departaments.add(new Departament("Departament E"));
    }
}
