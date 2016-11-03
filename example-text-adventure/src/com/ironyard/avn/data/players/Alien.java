package com.ironyard.avn.data.players;

/**
 * Created by jasonskipper on 9/12/16.
 */
public class Alien extends Player {

    public Alien(){
        setHealth(250);
    }

    @Override
    public String getType() {
        return "Alien";
    }
}
