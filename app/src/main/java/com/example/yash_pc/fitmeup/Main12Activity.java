package com.example.yash_pc.fitmeup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class Main12Activity extends AppCompatActivity {
    public RecyclerView diets;
    public dietetianAdapter dietetianAdapter;
    public List<dietetian> dietetians;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);
        diets=findViewById(R.id.diets);
        diets.setLayoutManager(new LinearLayoutManager(this));
        dietetians = new ArrayList<>();
        diets = findViewById(R.id.diets);
        diets.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        diets.setLayoutManager(layoutManager);

        setdietetianAdapterData(); //adding data to array list
        dietetianAdapter= new dietetianAdapter(Main12Activity.this, dietetians) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                return null;
            }
        };
        diets.setAdapter(dietetianAdapter);
    }

    private void setdietetianAdapterData() {
        dietetians.add(new dietetian("MAYURESH","9978961964", "Transform","4"));
        dietetians.add(new dietetian("MAYURESH","9978961964", "Transform","4"));
        dietetians.add(new dietetian("MAYURESH","9978961964", "Transform","4"));
        dietetians.add(new dietetian("MAYURESH","9978961964", "Transform","4"));
        dietetians.add(new dietetian("MAYURESH","9978961964", "Transform","4"));
        dietetians.add(new dietetian("MAYURESH","9978961964", "Transform","4"));


    }
}
