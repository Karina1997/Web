package com.facemash;

public class PictureForm {
    private int id;
    private float rating;
    private String way;

    PictureForm() {
        this.way = new String();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public void set(int id, String way, float rating) {
        this.id = id;
        this.way = way;
        this.rating = rating;
    }

    public String toString() {
        return "id:" + id + " way:" + way + " rating:" + rating;
    }
}
