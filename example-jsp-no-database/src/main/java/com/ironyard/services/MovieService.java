package com.ironyard.services;

import com.ironyard.data.Movie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jasonskipper on 9/19/16.
 */
public class MovieService {

    public List<Movie> generateFakeMovies(){
        List<Movie> mylist = new ArrayList<>();
        mylist.add(new Movie("Space Balls", "Comedy", "https://en.wikipedia.org/wiki/File:Spaceballs.jpg",1));
        mylist.add(new Movie("The Matrix", "Sci Fi", "https://en.wikipedia.org/wiki/File:The_Matrix_Poster.jpg",2));
        return mylist;
    }
}
