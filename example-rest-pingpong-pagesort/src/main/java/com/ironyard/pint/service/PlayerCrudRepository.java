package com.ironyard.pint.service;

import com.ironyard.ping.data.Player;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jasonskipper on 10/24/16.
 */
public interface PlayerCrudRepository extends CrudRepository<Player, Long> {
}
