package com.rosed.betterchat.Manager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerManager {

    private List<Player> players;

    public PlayerManager()   {

        players = new ArrayList<>();
        players.addAll(Bukkit.getOnlinePlayers());

    }

    /**
     * returns online players
     * @return
     */
    public List<Player> getPlayers()   { return players; }

}
