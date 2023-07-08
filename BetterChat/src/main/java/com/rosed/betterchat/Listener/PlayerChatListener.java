package com.rosed.betterchat.Listener;

import com.rosed.betterchat.Manager.ConfigManager;
import com.rosed.betterchat.Manager.PlayerManager;
import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.audience.Audience;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.List;

public class PlayerChatListener implements Listener {

    private PlayerManager playerManager;

    public PlayerChatListener(PlayerManager playerManager)   {

        this.playerManager = playerManager;

    }

    /**
     * sends a players message to players in proximity
     * @param e AsyncChatEvent
     */
    @EventHandler
    public void onPlayerChatEvent(AsyncChatEvent e)   {

        Player chatSender = e.getPlayer();

        // cancel if sender is near no one
        for (Player player : playerManager.getPlayers())   {
            if (chatSender.getLocation().distance(player.getLocation()) > ConfigManager.getConfigRadius())   {
                e.viewers().remove(player);
            }
        }

        if (0 >= e.viewers().size() - 2) {
            chatSender.sendMessage(ChatColor.RED + "No one heard your message");
            e.setCancelled(true);
        }

    }

    public List<Player> getPlayers()   { return playerManager.getPlayers(); }

}
