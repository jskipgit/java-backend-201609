package com.ironyard.controller;

import com.ironyard.ping.data.Player;
import com.ironyard.pint.service.PlayerCrudRepository;
import com.ironyard.pint.service.PlayerPagingSortingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jasonskipper on 10/24/16.
 */
@RestController
public class PlayerController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private PlayerCrudRepository playerCrudRepo;
    private PlayerPagingSortingRepository playerPgStRepo;

    @Autowired
    public void setPlayerPgStRepo(PlayerPagingSortingRepository playerPgStRepo) {
        this.playerPgStRepo = playerPgStRepo;
    }

    @Autowired
    public void setPlayerCrudRepo(PlayerCrudRepository playerCrudRepo) {
        this.playerCrudRepo = playerCrudRepo;
    }

    @RequestMapping(value = "/player", method = RequestMethod.POST, produces = "application/json")
    public Player save(@RequestBody Player aMovie) {
        playerCrudRepo.save(aMovie);
        return playerCrudRepo.findOne(aMovie.getId());
    }

    @RequestMapping(value = "/players", method = RequestMethod.GET)
    public Iterable<Player> listAll(@RequestParam(value = "page") Integer page,
                                    @RequestParam("size") Integer size,
                                    @RequestParam(value = "sortby", required = false) String sortby,
                                    @RequestParam(value = "dir", required = false) Sort.Direction direction) {

        Iterable<Player> found = null;

        if(sortby == null){
            sortby = "lastName";
        }

        if(direction == null){
            direction = Sort.Direction.ASC;
        }
        // long way
        Sort s =  new Sort(direction, sortby);
        PageRequest pr = new PageRequest(page, size, s);
        found = playerPgStRepo.findAll(pr);

        // short cut
        //found = playerPgStRepo.findAll(new PageRequest(page, size,  new Sort(direction, sortby)));

        return found;
    }
}
