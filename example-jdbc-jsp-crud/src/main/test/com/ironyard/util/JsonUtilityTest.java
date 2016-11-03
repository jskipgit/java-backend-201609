package com.ironyard.util;

import com.ironyard.data.Car;
import com.ironyard.data.Movie;
import com.ironyard.data.MovieStat;
import com.ironyard.data.Person;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jasonskipper on 10/10/16.
 */
public class JsonUtilityTest {
    @Test
    public void convertToJson() throws Exception {
        // Movie
        Movie testMovie = new Movie();
        testMovie.setCat("Comedy");
        testMovie.setName("Home Alone");
        testMovie.setSalesAmountMillions(108);
        testMovie.setId(1);

        JsonUtility jsUtil = new JsonUtility();
        String data = jsUtil.convertToJson(testMovie);
        Assert.assertNotNull(data);
        Assert.assertTrue(data.length()>0);
        System.out.println(data);

        // Movie Stat
        MovieStat mStat = new MovieStat();
        mStat.setSalesAmountMill(33);
        mStat.setCat("Comedy");

        data = jsUtil.convertToJson(mStat);
        Assert.assertNotNull(data);
        Assert.assertTrue(data.length()>0);
        System.out.println(data);

        //complex object
        Person p = new Person();
        p.setAge(40);
        p.setfName("ja : \"son");
        p.setlName("Skipper");

        Car fav = new Car();
        fav.setName("Jeep");
        fav.setColor("Black");
        p.setMyFavoriteCar(fav);

        Car one = new Car();
        one.setName("Jeep1");
        one.setColor("Black1");
        Car two = new Car();
        two.setName("Jeep2");
        two.setColor("Black2");

        List<Car> cars  = new ArrayList<>();
        cars.add(fav);
        cars.add(one);
        cars.add(two);

        p.setCars(cars);

        List<String> alisessss = new ArrayList<>();
        alisessss.add("skip");
        alisessss.add("jDog");
        alisessss.add("skipp-a-rinno");
        alisessss.add("dad");
        p.setAliases(alisessss);

        String wow = jsUtil.convertToJson(p);
        System.out.println(wow);

    }

    @Test
    public void convertFromJsonToObject() throws Exception {
        String data = "{\"name\":\"Home Alone\",\"cat\":\"Comedy\",\"salesAmountMillions\":108,\"id\":1}";
        JsonUtility jsUtil = new JsonUtility();
        Movie myMovie = (Movie) jsUtil.convertJsonToObject(data, Movie.class);

        Assert.assertNotNull(myMovie);
        Assert.assertEquals(1,myMovie.getId());
        Assert.assertEquals("Comedy",myMovie.getCat());
        Assert.assertEquals("Home Alone",myMovie.getName());
        Assert.assertEquals(108,myMovie.getSalesAmountMillions());
        System.out.println(myMovie);
    }

}