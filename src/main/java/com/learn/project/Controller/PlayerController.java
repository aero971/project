package com.learn.project.Controller;

import com.learn.project.entity.Player;
import com.learn.project.repository.PlayerRepo;
import com.learn.project.service.PlayerService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/supes")
public class PlayerController {

//    @Autowired
//    PlayerRepo playerRepo;

    @Autowired
    PlayerService playerService;

    @PostMapping
    public boolean SavePlayer(@RequestBody Player player)
    {
        player.setDateTime(LocalDateTime.now());
        playerService.SavePlayer(player);
        return true;
    }

    @GetMapping
    public List<Player> GetPlayers()
    {
        return playerService.findAll();
    }
    // ---------------specific single entry
    @GetMapping("/id/{supId}")
    public Optional<Player> getPlayerById(@PathVariable ObjectId supId )
    {

        return playerService.findPlayerById(supId);
    }

    @DeleteMapping("/id/{supId}")
    public void deletePlayerById(@PathVariable ObjectId supId )
    {
        playerService.DeletePlayer(supId);
    }

    @PutMapping("/id/{supId}")
    public boolean EditPlayerByID(@RequestBody Player player,@PathVariable ObjectId supId  )
    {
        playerService.UpdatePlayer(player,supId);
        return true;
    }

}
