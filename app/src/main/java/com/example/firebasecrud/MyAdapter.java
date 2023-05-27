package com.example.firebasecrud;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private Context context;
    private List<DataClass> dataClassList;

    public MyAdapter(Context context, List<DataClass> dataClassList) {
        this.context = context;
        this.dataClassList = dataClassList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context).load(dataClassList.get(position).getDataImage()).into(holder.recImage);
        holder.recTitle.setText(dataClassList.get(position).getDataTitle());
        holder.recDesc.setText(dataClassList.get(position).getDataDesc());
        holder.recLang.setText(dataClassList.get(position).getDataLang());


        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("image", dataClassList.get(holder.getAdapterPosition()).getDataImage());
                intent.putExtra("title", dataClassList.get(holder.getAdapterPosition()).getDataTitle());
                intent.putExtra("description", dataClassList.get(holder.getAdapterPosition()).getDataDesc());
                intent.putExtra("lang", dataClassList.get(holder.getAdapterPosition()).getDataLang());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataClassList.size();
    }


    public void searchDataList(ArrayList<DataClass> searchList){
        dataClassList = searchList;
        notifyDataSetChanged();
    }
}


class MyViewHolder extends RecyclerView.ViewHolder{

    ImageView recImage;
    TextView recTitle,recDesc,recLang;
    CardView recCard;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        recImage = itemView.findViewById(R.id.recImage);
        recTitle = itemView.findViewById(R.id.recTitle);
        recDesc = itemView.findViewById(R.id.recDesc);
        recLang = itemView.findViewById(R.id.recLang);
        recCard = itemView.findViewById(R.id.recCard);
    }
}
