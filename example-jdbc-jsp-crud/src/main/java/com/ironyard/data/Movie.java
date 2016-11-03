package com.ironyard.data;

/**
 * Created by jasonskipper on 10/3/16.
 */
public class Movie {
    private String name;
    private String cat;
    private int salesAmountMillions;
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public int getSalesAmountMillions() {
        return salesAmountMillions;
    }

    public void setSalesAmountMillions(int salesAmountMillions) {
        this.salesAmountMillions = salesAmountMillions;
    }
}
