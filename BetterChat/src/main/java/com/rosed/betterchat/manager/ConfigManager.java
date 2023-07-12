package com.rosed.betterchat.manager;

import com.rosed.betterchat.BetterChat;

public class ConfigManager {

    private BetterChat betterChat;
    private static int configRadius;
    private static int configMegaphoneRadius;
    private static String unheardMessage;
    private static String staffFormat;

    public ConfigManager(BetterChat betterChat)   {

        this.betterChat = betterChat;
        betterChat.getConfig().options().copyDefaults();
        betterChat.saveDefaultConfig();

        configRadius = betterChat.getConfig().getInt("proximity-radius");
        configMegaphoneRadius = betterChat.getConfig().getInt("megaphone-proximity-radius");
        unheardMessage = betterChat.getConfig().getString("unheard-message");
        staffFormat = betterChat.getConfig().getString("staff-format");

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

    /**
     * gets the unheard message that will send to the chat sender
     * if no one close enough
     * @return unheard message
     */
    public static String getUnheardMessage()   { return unheardMessage; }

    /**
     * gets staff chat format from config
     * @return staff chat format
     */
    public static String getStaffFormat()   { return staffFormat; }
}
