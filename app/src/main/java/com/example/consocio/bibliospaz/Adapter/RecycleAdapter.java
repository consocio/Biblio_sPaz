package com.example.consocio.bibliospaz.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.consocio.bibliospaz.BookItem;
import com.example.consocio.bibliospaz.R;

import java.util.ArrayList;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {
    private ArrayList<BookItem> mDataset;

    private Context context;
    private int position = 0;

    public RecycleAdapter(Context context,ArrayList<BookItem> mDataset) {

        this.mDataset = mDataset;
        this.context = context;
    }

    @Override
    public RecycleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_books, parent, false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    public void remove(int position){
        mDataset.remove(position);
        notifyItemRemoved(position);




    }

    @Override
    public void onBindViewHolder(final RecycleAdapter.ViewHolder holder, final int position) {



        holder.titolo.setText(mDataset.get(position).getTitolo());
        //holder.imgResource.setImageResource(mDataset.get(position).getImgUrl());
        holder.data.setText(mDataset.get(position).getData());
        holder.autore.setText(mDataset.get(position).getAutore());
        holder.cat.setText(mDataset.get(position).getCategoria());
        holder.rel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,position+"",Toast.LENGTH_SHORT).show();
            }
        });

        this.position = position;

    }


    public int getPosition() {
        return position;
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView titolo;
        private TextView autore;
        private ImageView img;
        private TextView data;
        private TextView cat;
        private RelativeLayout rel;


        public ViewHolder(final View itemView) {
            super(itemView);
            titolo = (TextView) itemView.findViewById(R.id.book_title);
            data = (TextView) itemView.findViewById(R.id.book_published);
            img = (ImageView) itemView.findViewById(R.id.book_photo);
            autore = itemView.findViewById(R.id.book_author);
            cat =  itemView.findViewById(R.id.book_category);
            rel = itemView.findViewById(R.id.rel);








        }

    }


}
