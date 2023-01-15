package com.example.smsuygulama5.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smsuygulama5.Modals.MesajSecHomeModals;
import com.example.smsuygulama5.R;

import java.util.ArrayList;

public class MesajSecHomeAdapter extends RecyclerView.Adapter<MesajSecHomeAdapter.ViewHolder>{

    Context context;
    ArrayList<MesajSecHomeModals> mesajlar;

    public MesajSecHomeAdapter(Context context, ArrayList<MesajSecHomeModals> mesajlar) {
        this.context = context;
        this.mesajlar = mesajlar;
    }

    @NonNull
    @Override
    public MesajSecHomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.mesaj_sec_home_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MesajSecHomeAdapter.ViewHolder holder, int position) {
        holder.name.setText(mesajlar.get(position).getName());
        holder.description.setText(mesajlar.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return mesajlar.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView name, description;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name= itemView.findViewById(R.id.MesajName);
            description=itemView.findViewById(R.id.MesajDescription);
        }
    }
}
