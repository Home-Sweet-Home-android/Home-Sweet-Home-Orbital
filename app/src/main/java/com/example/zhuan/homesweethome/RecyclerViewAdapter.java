package com.example.zhuan.homesweethome;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Furniture> mData;

    public RecyclerViewAdapter(Context mContext, List<Furniture> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.card_view_item_furniture, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv_furniture_cat.setText(mData.get(position).getCategory());
        //holder.iv_furniture.setImageResource(mData.get(position).getThumbnail());

        //using Glide for smoother scrolling
        Glide.with(mContext).load(mData.get(position).getThumbnail()).into(holder.iv_furniture);

        //click listener

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_furniture_cat;
        ImageView iv_furniture;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_furniture_cat = itemView.findViewById(R.id.furniture_name_id);
            iv_furniture = itemView.findViewById(R.id.furniture_image_id);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
