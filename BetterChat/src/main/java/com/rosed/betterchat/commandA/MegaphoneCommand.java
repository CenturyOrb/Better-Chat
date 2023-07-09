package com.rosed.betterchat.commandA;

import com.rosed.betterchat.managerA.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MegaphoneCommand implements CommandExecutor {

    /**
     * command that gives megaphone to players with better-chat.megaphone permission
     * @param sender Source of the command
     * @param command Command which was executed
     * @param label Alias of the command which was used
     * @param args Passed command arguments
     * @return
     */
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player))   { return false; }
        Player player = (Player) sender;

        // check for perms
        if (player.hasPermission("better-chat.megaphone"))   {

            // give the player the megaphone
            player.getInventory().addItem(ItemManager.getMegaphoneStack());
            player.sendMessage(ChatColor.GREEN + "You have been given the " + ChatColor.GOLD + "Megaphone");

        } else  {
            player.sendMessage(ChatColor.RED + "You don't have permission to use " + ChatColor.GOLD + "/megaphone");
        }

        return false;
    }
}
