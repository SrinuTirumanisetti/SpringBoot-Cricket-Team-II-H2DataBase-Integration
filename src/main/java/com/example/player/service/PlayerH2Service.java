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

import com.example.player.repository.PlayerReposistory;
import com.example.player.model.Player;


class PlayerH2Service extends PlayerReposistory{

    public ArrayList<Player> getPlayer(){

    }
}