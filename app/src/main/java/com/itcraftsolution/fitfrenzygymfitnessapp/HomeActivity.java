package com.itcraftsolution.fitfrenzygymfitnessapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private CartAdapter adapter;
    private ArrayList<FitnessItem> list;
    private RecyclerView rvFitnessItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        list = new ArrayList<>();

        list.add(new FitnessItem(R.drawable.splashdemo, "Body Building", 2300));
        list.add(new FitnessItem(R.drawable.splashdemo, "Body Building", 2300));
        list.add(new FitnessItem(R.drawable.splashdemo, "Body Building", 2300));
        list.add(new FitnessItem(R.drawable.splashdemo, "Body Building", 2300));
        list.add(new FitnessItem(R.drawable.splashdemo, "Body Building", 2300));
        list.add(new FitnessItem(R.drawable.splashdemo, "Body Building", 2300));
        list.add(new FitnessItem(R.drawable.splashdemo, "Body Building", 2300));
        list.add(new FitnessItem(R.drawable.splashdemo, "Body Building", 2300));
        list.add(new FitnessItem(R.drawable.splashdemo, "Body Building", 2300));
        list.add(new FitnessItem(R.drawable.splashdemo, "Body Building", 2300));
        list.add(new FitnessItem(R.drawable.splashdemo, "Body Building", 2300));
        list.add(new FitnessItem(R.drawable.splashdemo, "Body Building", 2300));
        list.add(new FitnessItem(R.drawable.splashdemo, "Body Building", 2300));
        list.add(new FitnessItem(R.drawable.splashdemo, "Body Building", 2300));
        list.add(new FitnessItem(R.drawable.splashdemo, "Body Building", 2300));
        list.add(new FitnessItem(R.drawable.splashdemo, "Body Building", 2300));
        list.add(new FitnessItem(R.drawable.splashdemo, "Body Building", 2300));
        list.add(new FitnessItem(R.drawable.splashdemo, "Body Building", 2300));
        adapter = new CartAdapter(this, list);

        rvFitnessItem = findViewById(R.id.rvFitnessItems);
        rvFitnessItem.setAdapter(adapter);
        rvFitnessItem.setLayoutManager(new LinearLayoutManager(this ));

    }
}
