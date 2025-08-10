package com.springboot_graphQl.service;

import com.springboot_graphQl.model.Player;
import com.springboot_graphQl.model.Team;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final List<Player> players = new ArrayList<>();

    AtomicInteger id = new AtomicInteger(0);


    @Override
    public List<Player> findAllPlayers() {
        return players;
    }

    @Override
    public Optional<Player> findPlayerById(Integer id) {
        return players.stream().filter(player -> Objects.equals(player.id(), id)).findFirst();
    }

    @Override
    public Player createPlayer(String name, Team team) {
        Player player = new Player(id.incrementAndGet(), name, team);
        players.add(player);
        return player;
    }

    @Override
    public Player deletePlayer(Integer id) {
        Player playerInfo = players.stream().filter(player -> Objects.equals(player.id(), id))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Id not found"));
        players.remove(playerInfo);
        return playerInfo;
    }

    @Override
    public Player updatePlayer(Integer id, String name, Team team) {
        Player playerInfo = new Player(id, name, team);
        Optional<Player> optionalPlayer = players.stream().filter(player -> Objects.equals(player.id(), id))
                .findFirst();
        if (optionalPlayer.isPresent()) {
            Player player = optionalPlayer.get();
            int index = players.indexOf(player);
            players.set(index, playerInfo);
        } else {
            throw new IllegalArgumentException("Invalid Player");
        }
        return playerInfo;
    }

    @PostConstruct
    private void init() {
        players.add(new Player(id.incrementAndGet(), "Ram", Team.CSK));
        players.add(new Player(id.incrementAndGet(), "Ram", Team.CSK));
        players.add(new Player(id.incrementAndGet(), "Shyam", Team.CSK));
        players.add(new Player(id.incrementAndGet(), "Amit", Team.CSK));
        players.add(new Player(id.incrementAndGet(), "Vikram", Team.CSK));
        players.add(new Player(id.incrementAndGet(), "Suresh", Team.CSK));

        players.add(new Player(id.incrementAndGet(), "Rohit", Team.MI));
        players.add(new Player(id.incrementAndGet(), "Virat", Team.MI));
        players.add(new Player(id.incrementAndGet(), "Anil", Team.MI));
        players.add(new Player(id.incrementAndGet(), "Ramesh", Team.MI));
        players.add(new Player(id.incrementAndGet(), "Karan", Team.MI));

        players.add(new Player(id.incrementAndGet(), "Arjun", Team.DC));
        players.add(new Player(id.incrementAndGet(), "Manish", Team.DC));
        players.add(new Player(id.incrementAndGet(), "Deepak", Team.DC));
        players.add(new Player(id.incrementAndGet(), "Pradeep", Team.DC));
        players.add(new Player(id.incrementAndGet(), "Sanjay", Team.DC));

        players.add(new Player(id.incrementAndGet(), "Hardik", Team.GT));
        players.add(new Player(id.incrementAndGet(), "Rahul", Team.GT));
        players.add(new Player(id.incrementAndGet(), "Mukesh", Team.GT));
        players.add(new Player(id.incrementAndGet(), "Ajay", Team.GT));
        players.add(new Player(id.incrementAndGet(), "Nitin", Team.GT));

    }
}