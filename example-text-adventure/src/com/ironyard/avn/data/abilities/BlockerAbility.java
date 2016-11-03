package com.ironyard.avn.data.abilities;

/**
 * Created by jasonskipper on 9/13/16.
 */
public class BlockerAbility extends DeffensiveAbility {
    @Override
    public int getDamageAmount(int rolledAmount) {

        return (int) (rolledAmount * .5);
    }

    @Override
    public String getName() {
        return "Blocker";
    }
}
