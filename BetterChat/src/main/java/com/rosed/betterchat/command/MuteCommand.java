package com.rosed.betterchat.command;

import com.rosed.betterchat.manager.PermissionManager;
import com.rosed.betterchat.manager.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MuteCommand implements CommandExecutor {

    private PlayerManager playerManager;
    private PermissionManager permissionManager;

    public MuteCommand(PlayerManager playerManager, PermissionManager permissionManager)   {

        this.playerManager = playerManager;
        this.permissionManager = permissionManager;

    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player))   { return false; }
        Player player = (Player) sender;

        if (!player.hasPermission("better-chat.mute"))   {
            player.sendMessage(ChatColor.RED + "You don't have permission to use " + ChatColor.GOLD + "/mute");
            return false;
        }


        if (args.length == 1)   {
            String playerName = args[0];
            if (playerManager.getPlayers().contains(Bukkit.getPlayer(playerName)))   {

                // if the player is muted then unmute them
                // if the player isn't muted then mute them
                if (Bukkit.getPlayer(playerName).hasPermission("better-chat.muted"))   {
                    permissionManager.setPlayerPermission(Bukkit.getPlayer(playerName), "better-chat.muted", false);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6You have muted &c" + playerName));
                } else {
                    permissionManager.setPlayerPermission(Bukkit.getPlayer(playerName), "better-chat.muted", true);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6You have unmuted &c" + playerName));
                }
            } else {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c" + playerName + " &6is not online"));
            }

        } else {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c(&6&l!&c) Invalid Player"));
        }

        return false;
    }
}
