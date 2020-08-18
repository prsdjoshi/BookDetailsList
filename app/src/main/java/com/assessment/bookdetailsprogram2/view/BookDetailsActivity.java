package com.assessment.bookdetailsprogram2.view;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.assessment.bookdetailsprogram2.R;
import com.assessment.bookdetailsprogram2.model.bookmodel.BookDetails;
import com.assessment.bookdetailsprogram2.viewmodel.BookViewModel;

import java.util.List;

public class BookDetailsActivity extends AppCompatActivity {

    private SwipeRefreshLayout swipeRefresh;
    RecyclerView mRecyclerView;
    public BookViewModel bookViewModel;
    public BookAdapter bookAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_bookdetails);
        initializationViews();
        bookViewModel = ViewModelProviders.of(this).get(BookViewModel.class);
        getBookList();
        swipeRefresh.setOnRefreshListener(() -> {
            getBookList();
        });
    }


    private void initializationViews() {
        Log.d("BookActivity: ","initializationViews() call");
        Toolbar toolbar = findViewById(R.id.book_toolbar);
        setSupportActionBar(toolbar);
        swipeRefresh = findViewById(R.id.swiperefresh);
        mRecyclerView = findViewById(R.id.blogRecyclerView);
    }
    private void getBookList() {
        Log.d("BookActivity: ","initializationViews() call and observe active");
        swipeRefresh.setRefreshing(true);
        bookViewModel.getAllBook().observe(this, new Observer<List<BookDetails>>() {
            @SuppressLint("LongLogTag")
            @Override
            public void onChanged(List<BookDetails> bookDetailsList) {
                Log.d("BookActivity observe Livedata: ","onChanged() call");
                swipeRefresh.setRefreshing(false);
                prepareRecycleview(bookDetailsList);
            }
        });
    }

    private void prepareRecycleview(List<BookDetails> bookDetailsList) {
        Log.d("prepareRecycleview: ","create Adapter");
        bookAdapter = new BookAdapter(bookDetailsList);
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        } else {
            mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        }
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        Log.d("prepareRecycleview: ","set Adapter");
        mRecyclerView.setAdapter(bookAdapter);
        bookAdapter.notifyDataSetChanged();
    }

}
