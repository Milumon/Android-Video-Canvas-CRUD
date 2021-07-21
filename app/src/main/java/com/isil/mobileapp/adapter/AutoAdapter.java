package com.isil.mobileapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.isil.mobileapp.R;
import com.isil.mobileapp.model.Auto;

import java.util.List;

public class AutoAdapter extends RecyclerView.Adapter<AutoAdapter.AutoViewHolder> {

    Context context;


    List<Auto> autolist;

    public AutoAdapter(Context context, List<Auto> autolist) {
        this.context = context;
        this.autolist = autolist;
    }


    @NonNull
    @Override
    public AutoAdapter.AutoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AutoAdapter.AutoViewHolder(LayoutInflater.from(context).inflate(R.layout.item_autos , parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull AutoAdapter.AutoViewHolder holder, int position) {
        holder.itemId.setText(autolist.get(position).getIdAuto());
        holder.itemMarca.setText(autolist.get(position).getMarca());
        holder.itemModelo.setText(autolist.get(position).getModelo());
        holder.itemPlaca.setText(autolist.get(position).getPlaca());
        holder.itemPropietario.setText(autolist.get(position).getPropietario());
    }

    @Override
    public int getItemCount() {
        return autolist.size();
    }

    public static final class AutoViewHolder extends RecyclerView.ViewHolder{

        TextView itemId, itemMarca, itemModelo, itemPlaca, itemPropietario;

        public AutoViewHolder(@NonNull View itemView) {
            super(itemView);

            itemId = itemView.findViewById(R.id.tvAutoId);
            itemMarca = itemView.findViewById(R.id.tvMarca);
            itemModelo = itemView.findViewById(R.id.tvModelo);
            itemPlaca = itemView.findViewById(R.id.tvPlaca);
            itemPropietario = itemView.findViewById(R.id.tvPropietario);
        }
    }

}
