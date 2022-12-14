package com.example.bankcontact;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class rvAdapter extends RecyclerView.Adapter<rvAdapter.ViewData>{

    Activity activity;
    List<Modeldata> l1 =new ArrayList<>();

    public rvAdapter(MainActivity mainActivity, List<Modeldata> l1) {

        activity=mainActivity;
        this.l1=l1;
    }

    @NonNull
    @Override
    public ViewData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.list_iitem,parent,false);
        return new  ViewData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewData holder, @SuppressLint("RecyclerView") int position) {
        holder.imgbank.setImageResource(l1.get(position).getImg());

        holder.imgbank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(activity,Bankdetail.class);
                intent.putExtra("txtname",l1.get(position).getName());
                intent.putExtra("txtnumber",l1.get(position).getNumber());
                intent.putExtra("imglogo",l1.get(position).getImg());
                activity.startActivity(intent);

            }
        });

    }

    @Override
    
    public int getItemCount() {
        return l1.size();
    }

    class ViewData extends RecyclerView.ViewHolder
    {
        ImageView imgbank;

        public ViewData(@NonNull View itemView) {
            super(itemView);

            imgbank=itemView.findViewById(R.id.imgbank);

        }
    }


}
