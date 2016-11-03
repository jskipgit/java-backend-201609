package com.ironyard.services;

import com.ironyard.data.Assignment;
import com.ironyard.data.Student;

import java.sql.*;

/**
 * Created by jasonskipper on 9/27/16.
 */
public class AssignmentService {

    public void createAssignment(Student y, Assignment x) throws SQLException {

        Database myDba = new Database();
        Connection conn = myDba.getConnection();
        PreparedStatement stmt = conn.prepareStatement("INSERT into assignments" +
                " (ass_id, ass_name, ass_grade, ass_stu_id) VALUES" +
                "(null, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, x.getName());
        stmt.setInt(2, x.getGrade());
        stmt.setLong(3, y.getId());
        stmt.execute();

        // now lets get the id
        ResultSet generatedKeys = stmt.getGeneratedKeys();
        if (generatedKeys.next()) {
            x.setId(generatedKeys.getLong(1));
        } else {
            throw new SQLException("Creating student failed, no ID obtained.");
        }
        // lets create the assignments

    }
}
