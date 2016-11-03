package com.ironyard.services;

import org.h2.tools.Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by jasonskipper on 9/26/16.
 */
public class Database {

    public void init() throws SQLException {
        Server.createWebServer().start();
    }

    public void destory() throws SQLException {
        Statement stmt = getConnection().createStatement();
        stmt.execute("DROP TABLE  students");
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:./main", "sa", null);
    }

    public void clearAllData() throws SQLException{
        Statement stmt = getConnection().createStatement();
        stmt.execute("CREATE TABLE IF NOT EXISTS students (stu_id IDENTITY, stu_name VARCHAR NOT NULL, stu_age INT)");
        stmt.execute("CREATE TABLE IF NOT EXISTS assignments (" +
                "ass_id IDENTITY, " +
                "ass_name VARCHAR, " +
                "ass_grade INT, " +
                "ass_stu_id INT, " +
                " FOREIGN KEY ( ass_stu_id) " +
                "    REFERENCES students(stu_id)) ");
        stmt.execute("Delete from assignments;");
        stmt.execute("Delete from students;");
    }
}
