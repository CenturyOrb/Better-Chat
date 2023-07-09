package com.rosed.betterchat.managerA;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

public class PlayerManager {

    private Set<Player> players;

    public PlayerManager()   {

        players = new HashSet<>();
        players.addAll(Bukkit.getOnlinePlayers());

    }

    /**
     * returns online players
     * @return
     */
    public Set<Player> getPlayers()   { return players; }

}
