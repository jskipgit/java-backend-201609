package com.ironyard.avn.data.abilities;

import com.ironyard.avn.data.selection.Thing;

/**
 * Created by jasonskipper on 9/13/16.
 */
public abstract class Ability implements Thing {

    public abstract int getDamageAmount(int rolledAmount);
    public abstract String getName();

    public String getThingName(){
        return getName();
    }

    public String toString(){
        return getName();
    }
}
