package com.assessment.bookdetailsprogram2.model.bookmodel;

import com.google.gson.annotations.SerializedName;

public class BookDetails
{
    @SerializedName("book_id")
    private String book_id;

    @SerializedName("book_name")
    private String book_name;

    @SerializedName("book_desc")
    private String book_desc;

    @SerializedName("book_price")
    private String book_price;

    @SerializedName("book_author")
    private String book_author;

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_desc() {
        return book_desc;
    }

    public void setBook_desc(String book_desc) {
        this.book_desc = book_desc;
    }

    public String getBook_price() {
        return book_price;
    }

    public void setBook_price(String book_price) {
        this.book_price = book_price;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public String getBook_img_url() {
        return book_img_url;
    }

    public void setBook_img_url(String book_img_url) {
        this.book_img_url = book_img_url;
    }

    @SerializedName("book_img_url")
    private String book_img_url;
}