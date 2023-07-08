package com.rosed.betterchat.Manager;

import com.rosed.betterchat.BetterChat;

public class ConfigManager {

    private BetterChat betterChat;
    private static int configRadius;

    public ConfigManager(BetterChat betterChat)   {

        this.betterChat = betterChat;
        betterChat.getConfig().options().copyDefaults();
        betterChat.saveDefaultConfig();

        configRadius = betterChat.getConfig().getInt("Proximity-radius");

    }

    public static int getConfigRadius()   { return configRadius; }

}
