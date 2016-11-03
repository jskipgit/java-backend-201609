package com.ironyard.service;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jasonskipper on 10/13/16.
 */
public class AnagramCheckerTest {
    @Test
    public void testShoulbBeAnagramTrue() throws Exception {
        AnagramChecker myChecker = new AnagramChecker();
        boolean winner = myChecker.isAnagram("iceman", "cinema");
        Assert.assertTrue(winner);

        // capital letters should not matter
        winner = myChecker.isAnagram("iceman", "CINEMA");
        Assert.assertTrue(winner);
    }

    @Test
    public void testShoulbBeAnagramFalse() throws Exception {
        AnagramChecker myChecker = new AnagramChecker();

        // same length different letters
        boolean winner = myChecker.isAnagram("icxman", "cinema");
        Assert.assertFalse(winner);

        // different length different letters
        winner = myChecker.isAnagram("icxmans", "cinema");
        Assert.assertFalse(winner);

        // same letters different length
        winner = myChecker.isAnagram("same", "samee");
        Assert.assertFalse(winner);

        // look for cheaters
        winner = myChecker.isAnagram("same", "same");
        Assert.assertFalse(winner);

        // look for cheaters
        winner = myChecker.isAnagram("same", "same");
        Assert.assertFalse(winner);

        // another cheater
        winner = myChecker.isAnagram("", "");
        Assert.assertFalse(winner);

    }
}