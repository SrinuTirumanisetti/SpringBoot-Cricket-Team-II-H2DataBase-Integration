/*
 * You can use the following import statements
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.jdbc.core.JdbcTemplate;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.ArrayList;
 * 
 */

// Write your code here

package com.example.player.service;

import com.example.player.repository.PlayerRepository;
import com.example.player.model.Player;
import com.example.player.model.PlayerRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class PlayerH2Service implements PlayerRepository {

    @Autowired
    private JdbcTemplate db;

    @Override
    public ArrayList<Player> getPlayers() {
        Collection<Player> playerList = db.query("SELECT * FROM TEAM", new PlayerRowMapper());
        return new ArrayList<>(playerList);
    }

    @Override
    public Player addPlayer(Player player) {
        db.update(
            "INSERT INTO TEAM(playerName, jerseyNumber, role) VALUES (?, ?, ?)",
            player.getPlayerName(),
            player.getJerseyNumber(),
            player.getRole()
        );

        Player savedPlayer = db.queryForObject(
            "SELECT * FROM TEAM WHERE playerName = ? AND jerseyNumber = ? AND role = ?",
            new PlayerRowMapper(),
            player.getPlayerName(),
            player.getJerseyNumber(),
            player.getRole()
        );

        return savedPlayer;
    }
}
