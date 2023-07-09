package com.rosed.betterchat;

import com.rosed.betterchat.Command.MegaphoneCommand;
import com.rosed.betterchat.Listener.PlayerChatListener;
import com.rosed.betterchat.Listener.PlayerJoinListener;
import com.rosed.betterchat.Listener.PlayerQuitListener;
import com.rosed.betterchat.Manager.ConfigManager;
import com.rosed.betterchat.Manager.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class BetterChat extends JavaPlugin {

    private ConfigManager configManager;
    private PlayerManager playerManager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        register();
        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&aBetterChat has started!"));
    }

    /**
     * register manager, event
     */
    private void register()   {

        // register managers
        configManager = new ConfigManager(this);
        playerManager = new PlayerManager();

        // register events
        Bukkit.getPluginManager().registerEvents(new PlayerQuitListener(playerManager), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(playerManager), this);
        Bukkit.getPluginManager().registerEvents(new PlayerChatListener(playerManager), this);

        // register commands
        getCommand("megaphone").setExecutor(new MegaphoneCommand());

    }

}
