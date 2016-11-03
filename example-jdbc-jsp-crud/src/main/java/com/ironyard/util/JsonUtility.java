package com.ironyard.util;

import com.google.gson.Gson;

/**
 * Utility to convert To/From JSON, currently uses GSON lib
 */
public class JsonUtility {

    /**
     * This methods converts any Ojbect to a String
     * that is in the JSON format.
     * @param convertMe
     * @return
     */
    public String convertToJson(Object convertMe){
        Gson myParser = new Gson();
        String data = null;
        data = myParser.toJson(convertMe);
        return data;
    }

    /**
     * Converts the given string into and object, the type of which is specified
     * in the arguements
     * @param data string to convert
     * @param className type of object to convert to
     * @return
     */
    public Object convertJsonToObject(String data, Class className){
        Object created = null;
        Gson myParser = new Gson();
        created = myParser.fromJson(data, className);
        return created;
    }
}
