
package com.example.consocio.bibliospaz.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("can")
    @Expose
    private Can can;
    @SerializedName("books")
    @Expose
    private Paging books;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Can getCan() {
        return can;
    }

    public void setCan(Can can) {
        this.can = can;
    }

    public Paging getBooks() {
        return books;
    }

    public void setBooks(Paging books) {
        this.books = books;
    }

}
