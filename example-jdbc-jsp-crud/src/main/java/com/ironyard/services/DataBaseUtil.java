package com.ironyard.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by jasonskipper on 10/3/16.
 */
public class DataBaseUtil {
    /**
     * Create a connection to the database
     * @return
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
       return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "admin");
    }

}
