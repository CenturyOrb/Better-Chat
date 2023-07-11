package com.rosed.betterchat.listener;

import com.rosed.betterchat.manager.ConfigManager;
import com.rosed.betterchat.manager.PlayerManager;
import io.papermc.paper.event.player.AsyncChatEvent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.meta.ItemMeta;

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

        chatSender.sendMessage(chatSender.hasPermission("better-chat.chat") + "");

        int radius = ConfigManager.getConfigRadius();

        // check if the player is holding the megaphone
        ItemMeta mainHandMeta = chatSender.getInventory().getItemInMainHand().getItemMeta();
        ItemMeta offHandMeta = chatSender.getInventory().getItemInOffHand().getItemMeta();

        // check mainhand for megaphone
        if (mainHandMeta != null && mainHandMeta.getLocalizedName().equals("better-chat.megaphoneitem"))   { // checks if the item isn't the megaphone
            radius = ConfigManager.getConfigMegaphoneRadius();
        }

        // check offhand for megaphone
        if (offHandMeta != null && offHandMeta.getLocalizedName().equals("better-chat.megaphoneitem"))   { // checks if the item isn't the megaphone
            radius = ConfigManager.getConfigMegaphoneRadius();
        }

        // remove viewers if the viewer isn't in the same world
        // remove viewers if the viewer isn't close enough
        for (Player player : playerManager.getPlayers())   {

            if (chatSender.getWorld() != player.getWorld())   {
                e.viewers().remove(player);
            } else if (chatSender.getLocation().distance(player.getLocation()) > radius)   {
                e.viewers().remove(player);
            }
        }

        // send message if there are no viewers nearby
        if (0 >= e.viewers().size() - 2) {
            chatSender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigManager.getUnheardMessage()));
            e.setCancelled(true);
        }

    }

}
