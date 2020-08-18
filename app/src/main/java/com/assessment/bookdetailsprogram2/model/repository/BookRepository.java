package com.assessment.bookdetailsprogram2.model.repository;

import android.annotation.SuppressLint;
import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.assessment.bookdetailsprogram2.model.bookmodel.Book;
import com.assessment.bookdetailsprogram2.model.bookmodel.BookDetails;
import com.assessment.bookdetailsprogram2.model.webservice.ApiService;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookRepository {
    private ArrayList<BookDetails> BookDetails = new ArrayList<>();
    private MutableLiveData<List<BookDetails>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public BookRepository(Application application) {
        this.application = application;
        Log.d("bookRepository: ","default constructor call");
    }

    @SuppressLint("LongLogTag")
    public MutableLiveData<List<BookDetails>> getBookMutableLivedata(ApiService apiService)
    {
        Call<Book> call = apiService.callApiToGetBookDetails("http://206.189.128.26/api/getAllAvailableBooks/");
        call.enqueue(new Callback<Book>() {
            @Override
            public void onResponse(Call<Book> call, Response<Book> response) {
                Book book=response.body();
                if(book!=null&&book.getData()!=null)
                {
                    Log.d("bookRepository MutableLiveData: ","getbookdata and set value to notify observer in view");
                    BookDetails = (ArrayList<BookDetails>) book.getData();
                    mutableLiveData.setValue(BookDetails);
                }

            }

            @Override
            public void onFailure(Call<Book> call, Throwable t) {
                Log.d("bookRepository MutableLiveData: ","onFailure() call");
            }
        });
        return mutableLiveData;
    }
}
