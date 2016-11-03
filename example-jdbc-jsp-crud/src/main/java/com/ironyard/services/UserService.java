package com.ironyard.services;

import com.ironyard.data.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by jasonskipper on 10/17/16.
 */
public class UserService {

    public User getUserByNameAndPass(String usr, String pass) throws SQLException {
        DataBaseUtil dbUtil = new DataBaseUtil();
        Connection c = null;
        User found = null;

        try {
            c = dbUtil.getConnection();
            // do a starts with search
            PreparedStatement ps = c.prepareStatement("select * from movieinfo.users WHERE usr_name = ? and usr_pass = ?;");
            ps.setString(1, usr);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                found = new User();
                found.setId(rs.getLong("usr_id"));
                found.setUsrName(rs.getString("usr_name"));
                found.setPass(rs.getString("usr_pass"));
            }
        }catch(SQLException t){
            t.printStackTrace();
            c.rollback();
            throw t;
        }finally {
            c.close();

        }
        return found;
    }
}
