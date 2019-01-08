package com.example.consocio.bibliospaz.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.consocio.bibliospaz.BookItem;
import com.example.consocio.bibliospaz.R;

import java.util.ArrayList;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {
    private ArrayList<BookItem> bookList;
    private Context context;
    public RecycleAdapter(Context context,ArrayList<BookItem> bookList) {
        this.bookList = bookList;

        this.context = context;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_books,viewGroup,false);
        ViewHolder holder= new ViewHolder(v);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.title.setText(bookList.get(i).getTitolo());
        viewHolder.date.setText(bookList.get(i).getData());
        viewHolder.author.setText(bookList.get(i).getAutore());
        //viewHolder.preview.setImage(bookList.get(i).getUrlImg());
        viewHolder.category.setText(bookList.get(i).getCategoria());

        Log.i("title",bookList.get(0).getCategoria());


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title,author,date,category;
        private ImageView preview;

        public ViewHolder(View itemView){
            super (itemView);
            title=itemView.findViewById(R.id.book_title);
            author = itemView.findViewById(R.id.book_author);
            date = itemView.findViewById(R.id.book_published);
            category = itemView.findViewById(R.id.book_published);
            preview = itemView.findViewById(R.id.book_photo);



        }
    }


}
