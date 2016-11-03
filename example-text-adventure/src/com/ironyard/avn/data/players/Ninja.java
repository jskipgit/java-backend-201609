package com.ironyard.avn.data.players;

/**
 * Created by jasonskipper on 9/12/16.
 */
public class Ninja extends Player {

    public Ninja(){
        setHealth(200);
    }

    @Override
    public String getType() {
        return "Ninja";
    }
}
