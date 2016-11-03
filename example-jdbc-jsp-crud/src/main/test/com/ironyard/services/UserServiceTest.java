package com.ironyard.services;

import com.ironyard.data.User;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jasonskipper on 10/17/16.
 */
public class UserServiceTest {
    @Test
    public void getUserByNameAndPass() throws Exception {

        UserService userService = new UserService();
        User found = userService.getUserByNameAndPass("jason", "skipper");
        Assert.assertNotNull(found);
    }

}