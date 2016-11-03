package com.ironyard.service;

import com.ironyard.data.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jasonskipper on 9/19/16.
 */
public class StudentService {

    /**
     * Dummy data method, always creates a new list
     * containing the same student data
     * @return a list of students
     */
    public List<Student> createDummyStudentData(){
        List<Student> allStudents = new ArrayList<>();
        allStudents.add(new Student("Jason", "Skipper","skipper.jason@gmail.com", "555-55-5555", 3.0, 40, 1));
        allStudents.add(new Student("Jane", "Smith","smith.jane@gmail.com", "555-55-7777", 4.0, 30, 2));
        return allStudents;
    }
}
