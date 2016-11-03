package com.ironyard.data;

/**
 * Created by jasonskipper on 9/27/16.
 */
public class Assignment {
    private String name;
    private int grade;
    private long id;

    public Assignment(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
