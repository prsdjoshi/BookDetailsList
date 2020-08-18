package com.assessment.bookdetailsprogram2.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.assessment.bookdetailsprogram2.R;
import com.assessment.bookdetailsprogram2.model.bookmodel.BookDetails;
import com.bumptech.glide.Glide;


import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private List<BookDetails> bookDetailsList;
    public BookAdapter(List<BookDetails> bookDetailsList) {
        this.bookDetailsList = bookDetailsList;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
            holder.onBind(position);
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        if (bookDetailsList != null && bookDetailsList.size() > 0) {
            return bookDetailsList.size();
        } else {
            return 0;
        }
    }
    public class ViewHolder extends BaseViewHolder {

        ImageView ivThumbnail;
        TextView tvName,tvDesc, tvAuthor,tvPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.label_name);
            tvDesc = itemView.findViewById(R.id.label_desc);
            tvAuthor = itemView.findViewById(R.id.label_author);
            tvPrice = itemView.findViewById(R.id.label_price);
            ivThumbnail = itemView.findViewById(R.id.image_emp);
        }

        @Override
        protected void clear() {
            ivThumbnail.setImageDrawable(null);
            tvName.setText("");
            tvAuthor.setText("");
            tvDesc.setText("");
            tvPrice.setText("");
        }

        @Override
        public void onBind(int position) {
            super.onBind(position);

            BookDetails bookDetails = bookDetailsList.get(position);
            if (bookDetails.getBook_img_url() != null) {
                Glide.with(itemView.getContext())
                        .load(bookDetails.getBook_img_url())
                        .into(ivThumbnail);
            }
            if (bookDetails.getBook_name() != null) {
                tvName.setText(bookDetails.getBook_name());
            }
            if (bookDetails.getBook_desc() != null) {
                tvDesc.setText(bookDetails.getBook_desc());
            }
            if (bookDetails.getBook_author() != null) {
                tvAuthor.setText("Author: "+bookDetails.getBook_author());
            }
            if (bookDetails.getBook_price() != null) {
                tvPrice.setText("Price: Rs."+bookDetails.getBook_price());
            }

        }
    }
}

abstract class BaseViewHolder extends RecyclerView.ViewHolder {
    private int mCurrentPosition;

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }
    protected abstract void clear();
    public void onBind(int position)
    {
        mCurrentPosition = position;
        clear();
    }
    public int getCurrentPosition() {
        return mCurrentPosition;
    }
}
