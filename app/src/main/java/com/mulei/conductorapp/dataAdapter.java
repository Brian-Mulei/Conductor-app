package com.mulei.conductorapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class dataAdapter extends RecyclerView.Adapter<dataAdapter.MyViewHolder> {

    Context context;
    ArrayList<data> list;

    public dataAdapter(Context context, ArrayList<data> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
   View v = LayoutInflater.from(context).inflate(R.layout.receipts_card,parent,false);
   return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        data data=list.get(position);
        holder.email.setText(data.getEmail());
        holder.numberplate.setText(data.getNumberplate());
        holder.trip.setText(data.getTrip());
        holder.sacco.setText(data.getSacco());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class  MyViewHolder extends  RecyclerView.ViewHolder{
        TextView email,numberplate,trip,sacco;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            email =itemView.findViewById(R.id.email);
            numberplate=itemView.findViewById(R.id.numberplate);
            trip=itemView.findViewById(R.id.trip);
            sacco=itemView.findViewById(R.id.sacco);
        }
    }

}