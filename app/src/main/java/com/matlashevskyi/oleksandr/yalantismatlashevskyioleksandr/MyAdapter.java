package com.matlashevskyi.oleksandr.yalantismatlashevskyioleksandr;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

/**
 * Created by Санек on 20.03.2016. //[Comment] Don't use kirillic symbols
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Integer []integers; //[Comment] Use google code style
    private Context context; //[Comment] Use google code style

    public MyAdapter(Integer[] integers, Context context) {
        this.integers = integers;
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.imageViewItem);
        }
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        ViewHolder vh = new ViewHolder(v);

        return vh;

    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, final int position) {

        Glide
                .with(context)
                .load(integers[position])
                .crossFade()
                .override(200,200) //[Comment] Magic numbers
                .into(holder.mImageView);

        holder.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Ви натиснули на: \n" + position + "-й елемент списку", Toast.LENGTH_SHORT).show(); //[Comment] Wrong info. Show controlname
            }
        });

    }

    @Override
    public int getItemCount() {
        return integers.length;
    }



}
