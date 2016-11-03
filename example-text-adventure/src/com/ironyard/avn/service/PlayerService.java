package com.ironyard.avn.service;

import com.ironyard.avn.data.players.Alien;
import com.ironyard.avn.data.players.Ninja;
import com.ironyard.avn.data.players.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jasonskipper on 9/12/16.
 */
public class PlayerService {

    public List<Player> getAllPlayers(){
        List<Player> allOfThem = new ArrayList<>();
        allOfThem.add(new Ninja());
        allOfThem.add(new Alien());
        return allOfThem;
    }
}
