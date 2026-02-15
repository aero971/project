package com.learn.project.Controller;

import com.learn.project.entity.Player;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/sups")
public class controller {

    HashMap<Long, Player> supes = new HashMap<>();

    @GetMapping
    public ArrayList<Player> GetPlayers()
    {
        return new ArrayList<>(supes.values());
    }

//    @PostMapping
//    public boolean SetPlayer(@RequestBody Player player)
//    {
//        supes.put(player.getId(),player);
//        return true;
//    }

    @GetMapping("/id/{supId}")
    public Player getPlayerById(@PathVariable Long supId )
    {
        return supes.get(supId);
    }

    @DeleteMapping("/id/{supId}")
    public Player deletePlayerById(@PathVariable Long supId )
    {
        return supes.remove(supId);
    }

    @PutMapping("/id/{supId}")
    public boolean EditPlayerByID(@PathVariable Long supId,@RequestBody Player player)
    {
        supes.put(supId,player);
        return true;
    }
}
