package com.ironyard.data;

import java.util.List;

/**
 * Created by jasonskipper on 9/26/16.
 */
public class Student {
    private long id;
    private String name;
    private int age;
    private List<Assignment> assignments;


    public Student(){

    }


    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
