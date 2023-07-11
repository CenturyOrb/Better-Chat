package com.rosed.betterchat.manager;

import com.rosed.betterchat.BetterChat;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

import java.util.HashMap;
import java.util.UUID;

public class PermissionManager {

    private HashMap<UUID, PermissionAttachment> perms = new HashMap<>();

    private BetterChat betterChat;
    private PlayerManager playerManager;

    public PermissionManager(BetterChat betterChat, PlayerManager playerManager)   {

        this.betterChat = betterChat;
        this.playerManager = playerManager;

        addAllPlayersAttachment();

    }

    private void addAllPlayersAttachment()   {

        for (Player player : playerManager.getPlayers())   {

            PermissionAttachment attachment;
            if (!perms.containsKey(player.getUniqueId()))   {
                attachment = player.addAttachment(betterChat);
                perms.put(player.getUniqueId(), attachment);
            }

        }

    }

    public void setPlayerPermission(Player player, String permission, boolean set)   {

        PermissionAttachment attachment;
        if (!perms.containsKey(player.getUniqueId()))   {
            attachment = player.addAttachment(betterChat);
            perms.put(player.getUniqueId(), attachment);
            System.out.println("a");
        } else {
            attachment = perms.get(player.getUniqueId());
            System.out.println("b");
        }

        if (set)   {
            attachment.setPermission(permission, set);
            System.out.println(1);
        } else {
            attachment.setPermission(permission, set);
            System.out.println(2);
        }


    }

    /**
     * get permissionAttachment of all players
     * @return PermissionAttachment of
     */
    public HashMap<UUID, PermissionAttachment> getPerms()   { return perms; }

}
