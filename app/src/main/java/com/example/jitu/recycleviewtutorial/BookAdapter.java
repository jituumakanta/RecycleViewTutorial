package com.example.jitu.recycleviewtutorial;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Lucky on 2/13/2016.
 */
public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private List<Book> bookList;
    public Context context;

    public BookAdapter(List<Book> bookList,Context context) {
        this.bookList = bookList;
        this.context=context;
    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_list_row, parent, false);

        return new BookViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {
        holder.title.setText(bookList.get(position).getTitle());
        holder.author.setText(bookList.get(position).getAuthor());
        Picasso.with(context)
                .load("http://www.thehindu.com/news/national/tamil-nadu/article18198551.ece/alternates/FREE_660/Kodanad")
                // optional
                .into(holder.imageview);
    }

    @Override
    public int getItemCount()
    {
        System.out.println("gggggggggggggggggggggggggggggggggggggg");
        return bookList.size();
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView author;
        ImageView imageview;

        public BookViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            author = (TextView) view.findViewById(R.id.author);
            imageview = (ImageView) view.findViewById(R.id.imageView);
        }
    }
}
