package com.sample.firstapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sample.firstapp.com.sample.myfirstapp.models.Departament;
import com.sample.myfirstapp.R;

import java.util.ArrayList;

public class DepartamentRecycleViewAdapter extends RecyclerView.Adapter<DepartamentRecycleViewAdapter.DepartamentViewHolder> {
    private ArrayList<Departament> departaments;
    private Context context;

    public DepartamentRecycleViewAdapter(ArrayList<Departament> departaments, Context context) {
        this.departaments = departaments;
        this.context = context;
    }

    @NonNull
    @Override
    public DepartamentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_item_recycle_view, viewGroup, false);
        return new DepartamentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DepartamentViewHolder departamentViewHolder, int position) {

        Departament departament = departaments.get(position);

        int resourceCode = (position % 2 == 0) ? android.R.drawable.ic_lock_lock : android.R.drawable.presence_audio_online;
        departamentViewHolder.img.setImageResource(resourceCode);
        departamentViewHolder.textView.setText(departament.Name);
    }

    @Override
    public int getItemCount() {
        return departaments.size();
    }

    public class DepartamentViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView textView;

        public DepartamentViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.image_list);
            textView = itemView.findViewById(R.id.text_view_list);
        }
    }
}
