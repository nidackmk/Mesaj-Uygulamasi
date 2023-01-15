package com.example.smsuygulama5.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.contentcapture.ContentCaptureCondition;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.smsuygulama5.Modals.GrupSecModals;
import com.example.smsuygulama5.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class GrupSecAdapter extends RecyclerView.Adapter<GrupSecAdapter.ViewHolder> {

    private ArrayList<GrupSecModals> grup_sec_item;
    private Context context;

    public GrupSecAdapter(ArrayList<GrupSecModals> grup_sec_item, Context context) {
        this.grup_sec_item = grup_sec_item;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.grup_sec_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(grup_sec_item.get(position).getImg()).into(holder.grupimg);
        holder.name.setText(grup_sec_item.get(position).getName());
        holder.description.setText(grup_sec_item.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return grup_sec_item.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView grupimg;
        TextView name, description;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            grupimg= itemView.findViewById(R.id.grup_sec_img);
            name= itemView.findViewById(R.id.grup_sec_name);
            description= itemView.findViewById(R.id.grup_sec_description);

        }
    }
}
