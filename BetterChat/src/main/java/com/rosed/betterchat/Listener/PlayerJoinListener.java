package com.rosed.betterchat.Listener;

import com.rosed.betterchat.Manager.PlayerManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    private PlayerManager playerManager;

    public PlayerJoinListener(PlayerManager playerManager)   {

        this.playerManager = playerManager;

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e)   {

        Player joiningPlayer = e.getPlayer();
        playerManager.getPlayers().add(joiningPlayer);

    }

}
