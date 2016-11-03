package com.ironyard.avn;

import com.ironyard.avn.data.abilities.*;
import com.ironyard.avn.data.players.Alien;
import com.ironyard.avn.data.players.Player;
import com.ironyard.avn.service.AbilityService;
import com.ironyard.avn.service.PlayerService;
import com.ironyard.avn.service.UserInputService;

import java.util.List;
import java.util.Scanner;

/**
 * Created by jasonskipper on 9/12/16.
 */
public class Game
{
    /**
     * This is how you run my cool game!
     * @param args not used
     */
    public static void main(String[] args){
        // print out game intro
        System.out.println("Welcome to my game.");
        System.out.println("Rules go here haha.");

        // player selection
        Player playerOne = null;
        Player enemy = null;
        OffensiveAbility offensiveAbility = null;
        DeffensiveAbility defenseAbility = null;

        // create services
        PlayerService playerService = new PlayerService();
        UserInputService uiService = new UserInputService();
        AbilityService abilityService = new AbilityService();

        List allPlayers =  playerService.getAllPlayers();
        playerOne = (Player) uiService.chooseThing(allPlayers);
        System.out.println("Congrats! You are a "+playerOne);

        List allOffensive = abilityService.getOffensiveAbilities();
        offensiveAbility = (OffensiveAbility) uiService.chooseThing(allOffensive);
        System.out.println("Congrats! You choose "+offensiveAbility);

        List allDefensive = abilityService.getDeffensiveAbilities();
        defenseAbility = (DeffensiveAbility) uiService.chooseThing(allDefensive);
        System.out.println("Congrats! You choose "+defenseAbility);

        playerOne.setDeffensiveAbility(defenseAbility);
        playerOne.setOffensiveAbility(offensiveAbility);

        // set enemy
        enemy = new Alien();
        enemy.setDeffensiveAbility(new ChainMailAbility());
        enemy.setOffensiveAbility(new RandomSmashAbility());

        System.out.println("Congrats! You are fighting a "+enemy);

        // play game
        boolean isPlayerOneTurn = true;
        while(playerOne.isAlive() && enemy.isAlive()){
            if(isPlayerOneTurn){
                System.out.println("Press enter to roll your dice!");
                Scanner input = new Scanner(System.in);
                input.nextLine();
                // generate randome number
                int roll = uiService.generateDiceRollAmount(100);
                int totalDamage = playerOne.battle(enemy,roll);
                System.out.println("You did some damage, totaling:"+totalDamage);
            } else {
                System.out.println("Prepare for attack! Hit enter to start the enemies turn.!");
                Scanner input = new Scanner(System.in);
                input.nextLine();
                // generate randome number
                int roll = uiService.generateDiceRollAmount(100);
                int totalDamage =enemy.battle(playerOne,roll);
                System.out.println("Ouch!, your enemy did some damage to you, totaling:"+totalDamage);
            }
            // alternates turns
            isPlayerOneTurn = !isPlayerOneTurn;
            // print status
            System.out.println("Your health:"+playerOne.getHealth());
            System.out.println("Enemy health:"+enemy.getHealth());
        }

        if(playerOne.isAlive()){
            System.out.println("Congrats!! you won!");
        } else {
            System.out.println("Bummer, better luck next time :(");
        }

    }
}
