package com.rosed.betterchat.Manager;

import com.rosed.betterchat.BetterChat;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {

    private BetterChat betterChat;

    private static ItemStack megaphoneStack;

    public ItemManager(BetterChat betterChat)   {

        this.betterChat = betterChat;

        setUpMegaphoneStack();

        setUpCraftingRecipes();

    }

    private void setUpCraftingRecipes()   {

        ShapedRecipe megaphoneRecipe = new ShapedRecipe(new NamespacedKey(betterChat, "megaphone"), megaphoneStack);
        megaphoneRecipe.shape(
                "IRI",
                "IGI",
                "III");

        megaphoneRecipe.setIngredient('G', Material.GOAT_HORN);
        megaphoneRecipe.setIngredient('I', Material.IRON_INGOT);
        megaphoneRecipe.setIngredient('R', Material.REDSTONE);

        Bukkit.addRecipe(megaphoneRecipe);
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
