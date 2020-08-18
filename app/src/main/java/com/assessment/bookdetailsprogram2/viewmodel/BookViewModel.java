package com.assessment.bookdetailsprogram2.viewmodel;

import android.annotation.SuppressLint;
import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.assessment.bookdetailsprogram2.MyApplication;
import com.assessment.bookdetailsprogram2.model.bookmodel.BookDetails;
import com.assessment.bookdetailsprogram2.model.repository.BookRepository;
import com.assessment.bookdetailsprogram2.model.webservice.ApiService;

import java.util.List;

public class BookViewModel extends AndroidViewModel {

    BookRepository bookRepository;
    public BookViewModel(@NonNull Application application) {
        super(application);
        Log.d("BookViewModel: ","default constructor call and create repository");
        bookRepository = new BookRepository(application);

    }

    @SuppressLint("LongLogTag")
    public LiveData<List<BookDetails>> getAllBook()
    {
        Log.d("BookViewModel getAllBook(): ","getBookMutableLivedata() from BookRepository and return");
        MyApplication myApplication =MyApplication.create(getApplication());
        ApiService userService =myApplication.getApiService();
        return bookRepository.getBookMutableLivedata(userService);
    }
}
