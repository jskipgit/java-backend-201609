package com.ironyard.avn.service;

import com.ironyard.avn.data.abilities.OffensiveAbility;
import com.ironyard.avn.data.players.Player;
import com.ironyard.avn.data.selection.Thing;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by jasonskipper on 9/12/16.
 */
public class UserInputService {

    public Thing chooseThing(List<Thing> allThings){
        Thing one = null;
        System.out.println("Please select your "+allThings.get(0).getThingType()+":");
        System.out.println(allThings);

        // special cases
        if(allThings == null || allThings.size()==0){
            return null;
        }


        Scanner input = new Scanner(System.in);
        while(one == null) {
            String userChoseThis = input.nextLine();
            for (Thing tmp : allThings) {
                if (userChoseThis.equalsIgnoreCase(tmp.getThingName())) {
                    one = tmp;
                }
            }
            if (one == null) {
                System.out.println("Choose a proper "+allThings.get(0)+", Example [bear,lion] you type: lion");
            }
        }
        return one;
    }

    public int generateDiceRollAmount(int max){
        int min = 0;
        Random r = new Random();
        return  r.nextInt((max - min) + 1) + min;
    }
}
