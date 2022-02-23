package com.mulei.conductorapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class payments extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    dataAdapter dataAdapter;
    ArrayList<data> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments);

        recyclerView=findViewById(R.id.recycler1);
        databaseReference= FirebaseDatabase.getInstance().getReference("Receipts");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        dataAdapter= new dataAdapter(this,list);
        recyclerView.setAdapter(dataAdapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
              for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                  data data=dataSnapshot.getValue(data.class);
                  list.add(data);
              }
              dataAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
}