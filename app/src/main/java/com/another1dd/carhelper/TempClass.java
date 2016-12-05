package com.another1dd.carhelper;

/**
 * Created by another1dd on 29.11.16.
 */

public class TempClass {
    public String title;
    public String text;
    public int rating;

    public TempClass(){}

    public TempClass(String title, String text, int rating)
    {
        this.title = title;
        this.text = text;
        this.rating = rating;
    }

    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }

    public int getRating() {
        return rating;
    }
}
