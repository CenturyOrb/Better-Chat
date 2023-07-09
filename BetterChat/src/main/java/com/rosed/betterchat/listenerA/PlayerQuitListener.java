package com.rosed.betterchat.listenerA;

import com.rosed.betterchat.managerA.PlayerManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    private PlayerManager playerManager;

    public PlayerQuitListener(PlayerManager playerManager)   {

        this.playerManager = playerManager;

    }

    /**
     * removes player from players list on leave
     * @param e PlayerQuitEvent
     */
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e)   {

        Player quittingPlayer = e.getPlayer();
        playerManager.getPlayers().remove(quittingPlayer);

    }

}
