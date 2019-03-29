package com.example.yash_pc.fitmeup;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Main10Activity extends AppCompatActivity {

    public RecyclerView recyclerView;
    public RecyclerAdapter adapter;
    ProgressBar progressBar;
    public List<Friend> friendArraylist;
    public FloatingActionButton fab;
    DatabaseReference databasecalorie;
    int total=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        friendArraylist = new ArrayList<>();
        recyclerView = findViewById(R.id.recycle_view);
        fab = findViewById(R.id.fab);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        databasecalorie=FirebaseDatabase.getInstance().getReference().child("Friend");

        setRecyclerViewData(); //adding data to array list
        adapter = new RecyclerAdapter(this, friendArraylist) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                return null;
            }
        };
        recyclerView.setAdapter(adapter);

        fab.setOnClickListener(onAddingListener());
        progressBar.setMax(3500);
        progressBar.setProgress(total);
    }
/*
    @Override
    protected void onStart()
    {
        super.onStart();
        databasecalorie.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                friendArraylist.clear();
                for(DataSnapshot calorieSnapshot : dataSnapshot.getChildren()){
                    Friend friend=calorieSnapshot.getValue(Friend.class);
                    friendArraylist.add(friend);
                }
                //setRecyclerViewData(); //adding data to array list
                adapter = new RecyclerAdapter(Main10Activity.this, friendArraylist) {
                    @Override
                    public View getView(int position, View convertView, ViewGroup parent) {
                        return null;
                    }
                };
                recyclerView.setAdapter(adapter);
                //FriendArrayList friendArrayList=new FriendArrayList(Main10Activity.this,friendArraylist);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }*/
    private void setRecyclerViewData() {
        friendArraylist.add(new Friend("101","Poha", "125"));
        friendArraylist.add(new Friend("101","Orange juice", "75"));
        friendArraylist.add(new Friend("101","Idli", "245"));
        friendArraylist.add(new Friend("101","Masala Dosa", "175"));
        friendArraylist.add(new Friend("101","Paneer Tikka", "455"));
        friendArraylist.add(new Friend("101","Noodles", "265"));
        friendArraylist.add(new Friend("101","Paneer Chilly", "355"));
        total=125+75+245+175+455+265+355;
    }

    private View.OnClickListener onAddingListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(Main10Activity.this);
                dialog.setContentView(R.layout.dialog_add); //layout for dialog
                dialog.setTitle("Add a new record");
                dialog.setCancelable(false); //none-dismiss when touching outside Dialog

                // set the custom dialog components - texts and image
                EditText foodname = (EditText) dialog.findViewById(R.id.name);
                EditText cal = (EditText) dialog.findViewById(R.id.job);

                View btnAdd = dialog.findViewById(R.id.btn_ok);
                View btnCancel = dialog.findViewById(R.id.btn_cancel);

                btnAdd.setOnClickListener(onConfirmListener(foodname,cal,dialog));
                btnCancel.setOnClickListener(onCancelListener(dialog));

                dialog.show();
            }
        };
    }

    private View.OnClickListener onConfirmListener(final EditText foodname, final EditText cal,final Dialog dialog) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id;

                id=databasecalorie.push().getKey();
                total=total+Integer.parseInt(cal.getText().toString());
                progressBar.setProgress(total);
                Friend friend = new Friend(id,foodname.getText().toString().trim(),cal.getText().toString().trim());
                databasecalorie.child("Friend").setValue(friend);
                Toast.makeText(Main10Activity.this,"DATA RECORDED",Toast.LENGTH_SHORT).show();
                //adding new object to arraylist
                friendArraylist.add(friend);
                //notify data set changed in RecyclerView adapter
                adapter.notifyDataSetChanged();
                dialog.dismiss();
            }
        };
    }





    private View.OnClickListener onCancelListener(final Dialog dialog) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        };
    }
}
