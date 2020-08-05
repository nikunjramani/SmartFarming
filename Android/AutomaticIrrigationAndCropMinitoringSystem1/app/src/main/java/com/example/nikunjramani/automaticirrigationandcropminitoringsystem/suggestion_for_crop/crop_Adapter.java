package com.example.nikunjramani.automaticirrigationandcropminitoringsystem.suggestion_for_crop;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nikunjramani.automaticirrigationandcropminitoringsystem.R;
import com.example.nikunjramani.automaticirrigationandcropminitoringsystem.crop_prize.cropAdapter;

import org.w3c.dom.Text;

import java.util.List;

public class crop_Adapter extends  RecyclerView.Adapter<crop_Adapter.cropViewHolder> {
    Context ctx;
    List<crops> cropsList;

    public crop_Adapter(Context ctx, List<crops> cropsList) {
        this.ctx = ctx;
        this.cropsList = cropsList;
    }

    @NonNull
    @Override
    public crop_Adapter.cropViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(ctx);
        View view=inflater.inflate(R.layout.crop_suggestion,null);
        return new cropViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull crop_Adapter.cropViewHolder holder, int position) {
        crops crops=cropsList.get(position);
        holder.crop_name.setText(crops.getCrop_name());
        holder.soil_type.setText("\nSoil Type="+crops.getSoil_type());
        holder.description.setText(crops.getDescription());
    }

    @Override
    public int getItemCount() {
        return cropsList.size();
    }
    class cropViewHolder extends RecyclerView.ViewHolder{

        TextView crop_name,description,soil_type;
        public cropViewHolder(View itemView) {
            super(itemView);
            crop_name=(TextView)itemView.findViewById(R.id.crop_name);
            description=(TextView)itemView.findViewById(R.id.description);
            soil_type=(TextView)itemView.findViewById(R.id.soil_type);
        }
    }
}
