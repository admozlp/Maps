package com.ademozalp.mapsjava.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ademozalp.mapsjava.databinding.RcyclerRowBinding;
import com.ademozalp.mapsjava.model.Place;
import com.ademozalp.mapsjava.view.MapsActivity;

import java.util.List;

public class placeAdapter extends RecyclerView.Adapter<placeAdapter.PlaceHolder>{
    List<Place> placeList;
    public placeAdapter(List<Place> placeList){
        this.placeList = placeList;
    }
    @NonNull
    @Override
    public PlaceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RcyclerRowBinding rcyclerRowBinding = RcyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new PlaceHolder(rcyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceHolder holder, int position) {
        holder.rcyclerRowBinding.rcyclerViewTextView.setText(placeList.get(position).name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), MapsActivity.class);
                intent.putExtra("info","detail");
                intent.putExtra("selectPlace",placeList.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return placeList.size();
    }

    public class PlaceHolder extends RecyclerView.ViewHolder{
        RcyclerRowBinding rcyclerRowBinding;
        public PlaceHolder(RcyclerRowBinding rcyclerRowBinding) {
            super(rcyclerRowBinding.getRoot());
            this.rcyclerRowBinding = rcyclerRowBinding;
        }
    }
}
