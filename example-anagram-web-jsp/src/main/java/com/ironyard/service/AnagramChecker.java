package com.ironyard.service;

import java.util.Arrays;

/**
 * Created by jasonskipper on 10/13/16.
 */
public class AnagramChecker {
    public static void main(String[] args){
        AnagramChecker checker = new AnagramChecker();
        checker.isAnagram("Hello", "Hwllo");
    }

    public boolean isAnagram(String oneWord, String anotherWord){
        boolean isAnagram = true;
        if(oneWord.length() != anotherWord.length()){
            // not same length
            isAnagram = false;
        } else if(oneWord.equalsIgnoreCase(anotherWord)){
            // cheater
            isAnagram = false;
        }else{

            // get rid of case sensitivity
            oneWord = oneWord.toLowerCase();
            anotherWord = anotherWord.toLowerCase();

            char[] oneWordChars = oneWord.toCharArray();
            Arrays.sort(oneWordChars);
            char[] anotherWordChars = anotherWord.toCharArray();
            Arrays.sort(anotherWordChars);

            for(int i=0; i<oneWordChars.length; i++){
                if(oneWordChars[i] != anotherWordChars[i]){
                    isAnagram = false;
                    break;
                }
            }
        }

        return isAnagram;
    }
}
