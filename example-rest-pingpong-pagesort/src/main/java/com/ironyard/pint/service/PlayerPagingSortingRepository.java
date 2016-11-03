package com.ironyard.pint.service;

import com.ironyard.ping.data.Player;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by jasonskipper on 10/25/16.
 */
public interface PlayerPagingSortingRepository extends PagingAndSortingRepository<Player, Long> {
}
