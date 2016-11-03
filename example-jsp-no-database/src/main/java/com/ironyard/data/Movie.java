package com.ironyard.data;

/**
 * Created by jasonskipper on 9/19/16.
 */
public class Movie {

    private String title;
    private String category;
    private String imgUrl;
    private long id;

    public Movie(String title, String category, String imgUrl, long id) {
        this.title = title;
        this.category = category;
        this.imgUrl = imgUrl;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
