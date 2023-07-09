package com.rosed.betterchat.Item;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {

    private static ItemStack megaphoneStack;

    public ItemManager()   {

        setUpMegaphoneStack();

    }

    public static ItemStack getMegaphoneStack()   { return megaphoneStack; }

    private void setUpMegaphoneStack()   {

        megaphoneStack = new ItemStack(Material.GOAT_HORN);
        ItemMeta megaphoneMeta = megaphoneStack.getItemMeta();
        megaphoneMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&dMegaphone"));
        megaphoneMeta.setLocalizedName("better-chat.megaphoneitem");
        List<String> megaphoneLore = new ArrayList<>();
        megaphoneLore.add(ChatColor.translateAlternateColorCodes('&', "&5Hold to increase your range"));
        megaphoneMeta.setLore(megaphoneLore);
        megaphoneMeta.addEnchant(Enchantment.MENDING, 1, true);
        megaphoneMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        megaphoneStack.setItemMeta(megaphoneMeta);

    }

}
