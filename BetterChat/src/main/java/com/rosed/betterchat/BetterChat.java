package com.rosed.betterchat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class BetterChat extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&aBetterChat has started!"));
    }

    private void register()   {
        
    }

}
