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

//        list.add(new FitnessItem(R.drawable.first, "Body Building", 2300));
//        list.add(new FitnessItem(R.drawable.splashdemo, "Hand Building", 2300));
//        list.add(new FitnessItem(R.drawable.splashdemo, "Body Building", 2300));
//        list.add(new FitnessItem(R.drawable.splashdemo, "Body Building", 2300));
//        list.add(new FitnessItem(R.drawable.splashdemo, "Body Building", 2300));
//        list.add(new FitnessItem(R.drawable.splashdemo, "Body Building", 2300));
//        list.add(new FitnessItem(R.drawable.splashdemo, "Body Building", 2300));
//        list.add(new FitnessItem(R.drawable.splashdemo, "Body Building", 2300));
//        list.add(new FitnessItem(R.drawable.splashdemo, "Body Building", 2300));
//        list.add(new FitnessItem(R.drawable.splashdemo, "Body Building", 2300));
//        list.add(new FitnessItem(R.drawable.splashdemo, "Body Building", 2300));
//        list.add(new FitnessItem(R.drawable.splashdemo, "Body Building", 2300));
//        list.add(new FitnessItem(R.drawable.splashdemo, "Body Building", 2300));
//        list.add(new FitnessItem(R.drawable.splashdemo, "Body Building", 2300));
//        list.add(new FitnessItem(R.drawable.splashdemo, "Body Building", 2300));
//        list.add(new FitnessItem(R.drawable.splashdemo, "Body Building", 2300));
//        list.add(new FitnessItem(R.drawable.splashdemo, "Body Building", 2300));
//        list.add(new FitnessItem(R.drawable.splashdemo, "Body Building", 2300));
        list = new ArrayList<>();

        list.add(new FitnessItem(R.drawable.first, "Body Building", 2300, "https://i.pinimg.com/originals/18/27/be/1827be178c019b1dc6f8a8d8b4a7b0b8.gif"));
        list.add(new FitnessItem(R.drawable.splashdemo, "Hand Building", 2300, "https://example.com/second.gif"));
        list.add(new FitnessItem(R.drawable.splashdemo, "Body Building", 2300, "https://example.com/third.gif"));

        adapter = new CartAdapter(this, list);

        rvFitnessItem = findViewById(R.id.rvFitnessItems);
        rvFitnessItem.setAdapter(adapter);
        rvFitnessItem.setLayoutManager(new LinearLayoutManager(this ));

    }
}
