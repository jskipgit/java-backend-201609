package com.ironyard.avn.data.abilities;

/**
 * Created by jasonskipper on 9/13/16.
 */
public class DoubleSmashAbility extends OffensiveAbility {

    @Override
    public int getDamageAmount(int rolledAmount) {

        return rolledAmount * 2;
    }

    @Override
    public String getName() {
        return "DoubleSmash";
    }
}
