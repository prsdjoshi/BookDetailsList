package com.assessment.bookdetailsprogram2.model.bookmodel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Book
{

    @SerializedName("results")
    private List<BookDetails> data;

    public void setData(List<BookDetails> data){
        this.data = data;
    }
    public List<BookDetails> getData(){
        return this.data;
    }
}