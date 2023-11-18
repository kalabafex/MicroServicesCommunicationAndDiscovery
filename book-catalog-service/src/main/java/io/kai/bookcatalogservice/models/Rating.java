package io.kai.bookcatalogservice.models;

public class Rating {
    private String bookID;
    private int rating;

    public Rating(String bookID, int rating) {
        this.bookID = bookID;
        this.rating = rating;
    }
    public Rating() {
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
