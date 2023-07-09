package com.rosed.betterchat.Command;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

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
            player.sendMessage(ChatColor.GREEN + "You have been given the " + ChatColor.GOLD + "Megaphone");

            // give the player the megaphone
            ItemStack megaphoneStack = new ItemStack(Material.GOAT_HORN);
            ItemMeta megaphoneMeta = megaphoneStack.getItemMeta();
            megaphoneMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&dMegaphone"));
            megaphoneMeta.setLocalizedName("better-chat.megaphoneitem");
            List<String> megaphoneLore = new ArrayList<>();
            megaphoneLore.add(ChatColor.translateAlternateColorCodes('&', "&5Hold to increase your range"));
            megaphoneMeta.setLore(megaphoneLore);
            megaphoneMeta.addEnchant(Enchantment.MENDING, 1, true);
            megaphoneMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            megaphoneStack.setItemMeta(megaphoneMeta);

            player.getInventory().addItem(megaphoneStack);
        } else  {
            player.sendMessage(ChatColor.RED + "You don't have permission to use " + ChatColor.GOLD + "/megaphone");
        }

        return false;
    }
}
