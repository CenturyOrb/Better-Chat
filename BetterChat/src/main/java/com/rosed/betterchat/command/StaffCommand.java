package com.rosed.betterchat.command;

import com.rosed.betterchat.manager.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class StaffCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player))   { return false; }
        Player player = (Player) sender;

        if (!player.hasPermission("better-chat.better-chat.staffchat"))   {
            player.sendMessage(ChatColor.RED + "You don't have permission to use " + ChatColor.GOLD + "/schat");
            return false;
        }

        if (args.length == 1)   {
            String formattedMessage = ConfigManager.getStaffFormat();
            String message = args[0];
            String userName = player.getName();
            formattedMessage = formattedMessage.replace("{USERNAME}", userName);
            formattedMessage = formattedMessage.replace("{MESSAGE}", message);

            player.sendMessage("message: " + message + " userName: " + userName);
            player.sendMessage("final message: " + formattedMessage);
            Bukkit.broadcast(formattedMessage, "better-chat.staffchat");

        } else {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c(&6&l!&c) Invalid message"));
        }

        return false;
    }
}
