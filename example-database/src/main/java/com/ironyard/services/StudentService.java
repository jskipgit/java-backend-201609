package com.ironyard.services;

import com.ironyard.data.Assignment;
import com.ironyard.data.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jasonskipper on 9/26/16.
 */
public class StudentService {

    public void createStudent(Student myStudent) throws SQLException {

        Database myDba = new Database();
        AssignmentService assServ = new AssignmentService();
        Connection conn = myDba.getConnection();
        PreparedStatement stmt = conn.prepareStatement("INSERT into students VALUES " +
                "(null, ?, ?)", Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, myStudent.getName());
        stmt.setInt(2, myStudent.getAge());
        stmt.execute();

        // now lets get the id
        ResultSet generatedKeys = stmt.getGeneratedKeys();
        if (generatedKeys.next()) {
            myStudent.setId(generatedKeys.getLong(1));
        } else {
            throw new SQLException("Creating student failed, no ID obtained.");
        }
        // lets create the assignments
        if(myStudent.getAssignments() != null) {
            for (Assignment ass : myStudent.getAssignments()) {
                assServ.createAssignment(myStudent, ass);
            }
        }
    }

    public Student getStudentByName(String studentName) throws SQLException {
        Student found = null;
        Database myDba = new Database();
        Connection conn = myDba.getConnection();
        PreparedStatement stmt = conn.prepareCall("SELECT * FROM students WHERE stu_name = ?");
        stmt.setString(1, studentName);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            found = new Student();
            found.setName(rs.getString("stu_name"));
            found.setAge(rs.getInt("stu_age"));
            found.setId(rs.getLong("stu_id"));
        }
        return found;
    }

    public Student getStudentById(long id) throws SQLException {
        Student found = null;
        Database myDba = new Database();
        Connection conn = myDba.getConnection();
        PreparedStatement stmt = conn.prepareCall("SELECT * FROM students WHERE stu_id = ?");
        stmt.setLong(1, id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            found = new Student();
            found.setName(rs.getString("stu_name"));
            found.setAge(rs.getInt("stu_age"));
            found.setId(rs.getLong("stu_id"));
        }
        return found;
    }

    public void updateStudent(Student aStudent) throws SQLException{
        Database myDba = new Database();
        Connection conn = myDba.getConnection();
            PreparedStatement stmt = conn.prepareStatement("Update students set stu_age = ?, stu_name =? where stu_id=?");
        stmt.setInt(1, aStudent.getAge());
        stmt.setString(2, aStudent.getName());
        stmt.setLong(3, aStudent.getId());
        stmt.executeUpdate();
    }

    public void deleteStudent(Student aStudent) throws SQLException{
        Database myDba = new Database();
        Connection conn = myDba.getConnection();
        PreparedStatement stmt = conn.prepareStatement("Delete from students where stu_id=?");
        stmt.setLong(1, aStudent.getId());
        stmt.executeUpdate();
    }

    public List<Student> getAllStudents() throws SQLException{
        List<Student> allStudents = new ArrayList<Student>();
        Student found = null;
        Database myDba = new Database();
        Connection conn = myDba.getConnection();
        PreparedStatement stmt = conn.prepareCall("SELECT * FROM students");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            found = new Student();
            found.setName(rs.getString("stu_name"));
            found.setAge(rs.getInt("stu_age"));
            found.setId(rs.getLong("stu_id"));
            allStudents.add(found);
        }
        return allStudents;
    }

}
