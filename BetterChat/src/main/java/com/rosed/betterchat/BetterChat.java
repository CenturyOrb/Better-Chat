package com.rosed.betterchat;

import com.rosed.betterchat.command.MegaphoneCommand;
import com.rosed.betterchat.command.MuteCommand;
import com.rosed.betterchat.command.StaffCommand;
import com.rosed.betterchat.manager.ItemManager;
import com.rosed.betterchat.listener.PlayerChatListener;
import com.rosed.betterchat.listener.PlayerJoinListener;
import com.rosed.betterchat.listener.PlayerQuitListener;
import com.rosed.betterchat.manager.ConfigManager;
import com.rosed.betterchat.manager.PermissionManager;
import com.rosed.betterchat.manager.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class BetterChat extends JavaPlugin {

    private ConfigManager configManager;
    private PlayerManager playerManager;
    private ItemManager itemManager;
    private PermissionManager permissionmanager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        register();
    }

    /**
     * register manager, event
     */
    private void register()   {

        // register managers
        configManager = new ConfigManager(this);
        playerManager = new PlayerManager();
        itemManager = new ItemManager(this);
        permissionmanager = new PermissionManager(this, playerManager);

        // register events
        Bukkit.getPluginManager().registerEvents(new PlayerQuitListener(playerManager), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(playerManager), this);
        Bukkit.getPluginManager().registerEvents(new PlayerChatListener(playerManager), this);

        // register commands
        getCommand("megaphone").setExecutor(new MegaphoneCommand());
        getCommand("mute").setExecutor(new MuteCommand(playerManager, permissionmanager));
        getCommand("schat").setExecutor(new StaffCommand());
    }

}
