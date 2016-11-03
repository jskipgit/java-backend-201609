package com.ironyard.avn.service;

import com.ironyard.avn.data.abilities.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jasonskipper on 9/13/16.
 */
public class AbilityService {

    public List<OffensiveAbility> getOffensiveAbilities(){
        List<OffensiveAbility> abilities = new ArrayList<>();
        abilities.add(new DoubleSmashAbility());
        abilities.add(new RandomSmashAbility());
        return abilities;
    }

    public List<DeffensiveAbility> getDeffensiveAbilities(){
        List<DeffensiveAbility> abilities = new ArrayList<>();
        abilities.add(new ChainMailAbility());
        abilities.add(new BlockerAbility());
        return abilities;
    }
}
