package com.ironyard.avn.data.players;

import com.ironyard.avn.data.abilities.Ability;
import com.ironyard.avn.data.abilities.DeffensiveAbility;
import com.ironyard.avn.data.abilities.OffensiveAbility;
import com.ironyard.avn.data.selection.Thing;

/**
 * Created by jasonskipper on 9/12/16.
 */
public abstract class Player implements Thing {
    private int health;
    private String userName;
    private OffensiveAbility offensiveAbility;
    private DeffensiveAbility deffensiveAbility;

    public int battle(Player yourEnemy, int rolledAmount){
        int totalDamage = this.getOffensiveAbility().getDamageAmount(rolledAmount);
        totalDamage = yourEnemy.getDeffensiveAbility().getDamageAmount(totalDamage);
        yourEnemy.setHealth(yourEnemy.getHealth() - totalDamage);
        return totalDamage;
    }

    public boolean isAlive(){
        return getHealth()  > 0;
    }

    public String toString(){
        return getType();
    }

    public OffensiveAbility getOffensiveAbility() {
        return offensiveAbility;
    }

    public void setOffensiveAbility(OffensiveAbility offensiveAbility) {
        this.offensiveAbility = offensiveAbility;
    }

    public DeffensiveAbility getDeffensiveAbility() {
        return deffensiveAbility;
    }

    public void setDeffensiveAbility(DeffensiveAbility deffensiveAbility) {
        this.deffensiveAbility = deffensiveAbility;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public abstract String getType();

    public String getThingName(){
        return getType();
    }

    public String getThingType(){
        return "Player";
    }


}
