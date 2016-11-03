package com.ironyard.avn.data.abilities;

import java.util.Random;

/**
 * Created by jasonskipper on 9/13/16.
 */
public class RandomSmashAbility extends OffensiveAbility{
    @Override
    public int getDamageAmount(int rolledAmount) {
        int max = rolledAmount;
        int min = -10;
        Random r = new Random();
        int randomDamageAmount =  r.nextInt((max - min) + 1) + min;
        return rolledAmount + randomDamageAmount;
    }

    @Override
    public String getName() {
        return "RandomSmash";
    }
}
