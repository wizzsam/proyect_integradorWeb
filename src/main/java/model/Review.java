
package model;

public class Review {
    private int id;
    private String comment;
    private int rating;

    public Review() {}

    public Review(String comment, int rating) {
        this.comment = comment;
        this.rating = rating;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}