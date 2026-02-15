package com.learn.project.service;

import com.learn.project.entity.Player;
import com.learn.project.repository.PlayerRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.time.*;

@Component
public class PlayerService {

    @Autowired
    private PlayerRepo playerRepo;
    public void SavePlayer(Player player)
    {

        playerRepo.save(player);
    }

    public List<Player> findAll()
    {
        return playerRepo.findAll();
    }

//    public Optional<Player> findPlayerById(String id)
//    {
//        return  playerRepo.findById(id);
//    }

    public Optional<Player> findPlayerById(ObjectId id)
    {
        return  playerRepo.findById(id);
    }

    public void DeletePlayer(ObjectId id)
    {
        playerRepo.deleteById(id);
    }

    public void UpdatePlayer(Player newPlayer,ObjectId id)
    {

        Player existingPlayer = findPlayerById(id).orElse(null);

        if (existingPlayer != null)
        {
            // Update only if new value is NOT null

            if (newPlayer.getName() != null) {
                existingPlayer.setName(newPlayer.getName());
            }

            if (newPlayer.getSuperpower() != null) {
                existingPlayer.setSuperpower(newPlayer.getSuperpower());
            }

            if (newPlayer.getLevel() != null) {
                existingPlayer.setLevel(newPlayer.getLevel());
            }

            playerRepo.save(existingPlayer);
        }
    }

}
