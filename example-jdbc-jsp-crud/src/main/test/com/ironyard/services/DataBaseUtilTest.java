package com.ironyard.services;

import static org.junit.Assert.*;

/**
 * Created by jasonskipper on 10/3/16.
 */
public class DataBaseUtilTest {
    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void getConnection() throws Exception {
        DataBaseUtil myUtil = new DataBaseUtil();
        assertNotNull(myUtil.getConnection());
    }

}