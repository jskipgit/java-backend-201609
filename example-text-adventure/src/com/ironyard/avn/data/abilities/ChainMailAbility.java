package com.ironyard.avn.data.abilities;

/**
 * Created by jasonskipper on 9/13/16.
 */
public class ChainMailAbility extends DeffensiveAbility {

    @Override
    public int getDamageAmount(int rolledAmount) {
        return (int) (rolledAmount - (rolledAmount * .10) );
    }

    @Override
    public String getName() {
        return "ChainMailAbility";
    }
}
