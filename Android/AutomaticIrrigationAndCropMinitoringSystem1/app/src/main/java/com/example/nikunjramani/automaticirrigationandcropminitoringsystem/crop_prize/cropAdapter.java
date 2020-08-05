package com.example.nikunjramani.automaticirrigationandcropminitoringsystem.crop_prize;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nikunjramani.automaticirrigationandcropminitoringsystem.R;

import java.util.List;
import java.util.zip.Inflater;

public class cropAdapter extends RecyclerView.Adapter<cropAdapter.ContactsAdapter> {
    private List<crop> crop_list;
    Context ctx;

    public cropAdapter(Context  ctx,List<crop> cropList) {
        this.ctx=ctx;
        this.crop_list=cropList;
    }


    @NonNull
    @Override
    public ContactsAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       LayoutInflater inflater=LayoutInflater.from(ctx);
       View view=inflater.inflate(R.layout.crop_list,null);
        return new ContactsAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsAdapter holder, int position) {
        crop crop=crop_list.get(position);
        holder.crop_name.setText(crop.getCrop_name());
        holder.crop_prize.setText(crop.getCrop_prize());

    }


    @Override
    public int getItemCount() {
        return crop_list.size();
    }
    class ContactsAdapter extends RecyclerView.ViewHolder{

        TextView crop_prize,crop_name;
        public ContactsAdapter(View itemView) {
            super(itemView);
            crop_name=(TextView)itemView.findViewById(R.id.crop_name);
            crop_prize=(TextView)itemView.findViewById(R.id.crop_prize);
        }
    }
}
