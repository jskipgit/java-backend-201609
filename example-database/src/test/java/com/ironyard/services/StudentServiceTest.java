package com.ironyard.services;

import com.ironyard.data.Assignment;
import com.ironyard.data.Student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jasonskipper on 9/26/16.
 */
public class StudentServiceTest {

    @org.junit.BeforeClass
    public static void setUp() throws SQLException {
        Database myDb = new Database();
        myDb.init();
        myDb.clearAllData();
    }

    @org.junit.After
    public void breakDown() throws SQLException {
        Database myDb = new Database();
//        myDb.destory();
    }
    @org.junit.Test
    public void createStudentEmptyStudentShouldFail() throws SQLException {

        StudentService myServ = new StudentService();
        // create the student
        Student createIt = new Student();
        try {
            myServ.createStudent(createIt);
        }catch(Throwable e){
            // ignore
        }
        assertEquals(0, createIt.getId());

    }

    @org.junit.Test
    public void createStudentShouldIgnoreInputId() throws SQLException {

        StudentService myServ = new StudentService();
        // create the student
        Student createIt = new Student("skipper", 40);
        createIt.setId(104);
        try {
            myServ.createStudent(createIt);
        }catch(Throwable e){
            // ignore
        }
        // should have ignored input ID and generated it's own id
        assertNotEquals(104, createIt.getId());
        // should be no object with 104 in DB
        Student found = myServ.getStudentById(104);
        assertNull(found);

    }
    @org.junit.Test
    public void createStudentNoAssignments() throws SQLException {

        StudentService myServ = new StudentService();
        // create the student
        Student createIt = new Student("jason", 40);
        myServ.createStudent(createIt);
        assertNotNull(createIt.getId());

        // lets see if its really there
        Student found = myServ.getStudentById(createIt.getId());
        assertEquals(found.getName(),"jason");
        assertEquals(found.getAge(),40);
        assertEquals(createIt.getId(), found.getId());

    }
    @org.junit.Test
    public void createStudentWithAssignments() throws SQLException {

        StudentService myServ = new StudentService();
        // create the student
        Student createIt = new Student("jason", 40);

        List<Assignment> someAssignments = new ArrayList<Assignment>();
        someAssignments.add(new Assignment("Object References", 100));
        someAssignments.add(new Assignment("ABCs", 80));
        someAssignments.add(new Assignment("Math", 95));

        createIt.setAssignments(someAssignments);

        myServ.createStudent(createIt);
        assertNotEquals(0, createIt.getId());
        assertNotNull(createIt.getId());
        //every assignment as an id
        for(Assignment tmpA: createIt.getAssignments()){
            assertNotEquals(0, tmpA.getId());
            assertNotNull(tmpA.getId());
        }

        // lets see if its really there
        Student found = myServ.getStudentById(createIt.getId());
        assertEquals(found.getName(),"jason");
        assertEquals(found.getAge(),40);
        assertEquals(createIt.getId(), found.getId());



    }

    @org.junit.Test
    public void updateStudent() throws SQLException {
        StudentService myServ = new StudentService();
        Student createIt = new Student("jason", 40);
        myServ.createStudent(createIt);
        assertNotNull(createIt.getId());
        // fetch and change it
        Student found = myServ.getStudentById(createIt.getId());
        found.setAge(100);
        found.setName("Skipper");
        myServ.updateStudent(found);

        // fetch it
        Student updatedStudent = myServ.getStudentById(found.getId());
        assertEquals(updatedStudent.getAge(),100);
        assertEquals(updatedStudent.getName(),"Skipper");

    }

    @org.junit.Test
    public void deleteStudent() throws SQLException {

        StudentService myServ = new StudentService();
        // creating a student
        Student createIt = new Student("jason", 40);
        myServ.createStudent(createIt);
        assertNotNull(createIt.getId());

        // fetch
        Student found = myServ.getStudentById(createIt.getId());

        // delete it NOW
        myServ.deleteStudent(found);

        // should not exist
        assertNull(myServ.getStudentById(found.getId()));

    }
}