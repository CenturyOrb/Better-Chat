package com.rosed.betterchat.Manager;

import com.rosed.betterchat.BetterChat;

public class ConfigManager {

    private BetterChat betterChat;
    private static int configRadius;
    private static int configMegaphoneRadius;

    public ConfigManager(BetterChat betterChat)   {

        this.betterChat = betterChat;
        betterChat.getConfig().options().copyDefaults();
        betterChat.saveDefaultConfig();

        configRadius = betterChat.getConfig().getInt("proximity-radius");
        configMegaphoneRadius = betterChat.getConfig().getInt("megaphone-proximity-radius");

    }

    /**
     * gets the default radius of proximity chat in config
     * @return default radius
     */
    public static int getConfigRadius()   { return configRadius; }

    /**
     * gets the megaphone radius of proximity chat in config
     * @return megaphone radius
     */
    public static int getConfigMegaphoneRadius()   { return configMegaphoneRadius; }

}
