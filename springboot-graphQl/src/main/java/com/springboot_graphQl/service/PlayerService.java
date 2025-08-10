package com.springboot_graphQl.service;

import com.springboot_graphQl.model.Player;
import com.springboot_graphQl.model.Team;

import java.util.List;
import java.util.Optional;

public interface PlayerService {

    List<Player> findAllPlayers();

    Optional<Player> findPlayerById(Integer id);

    Player createPlayer(String name, Team team);

    Player deletePlayer(Integer id);

    Player updatePlayer(Integer id, String name, Team team);
}
