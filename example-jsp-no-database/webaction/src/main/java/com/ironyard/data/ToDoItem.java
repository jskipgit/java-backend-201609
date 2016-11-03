package com.ironyard.data;

/**
 * Created by jasonskipper on 9/15/16.
 */
public class ToDoItem {
    private String name;
    private String detail;
    private long id;

    public ToDoItem(String aName, String aDetail, long anId){
        name = aName;
        detail = aDetail;
        id = anId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return getName();
    }
}
