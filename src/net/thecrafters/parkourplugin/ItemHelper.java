package net.thecrafters.parkourplugin;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
 
/*
 * ItemHelper class
 *
 * Builder class for making setting lores, names, enchants of items a hell of a lot easier
 *
 * Made by Jack Chappell
 *
 * Copyright 2014
 */
public class ItemHelper {
       
        private ItemMeta itemMeta;
        private ItemStack itemStack;
        private List<String> lore;
       
        /*
         * Class constructor
         *
         * To use I'd recommend doing:
         *              ItemStack i = (new ItemHelper(Material.ANVIL)
         *                                        .setName(ChatColor.RED + "This is an example")
         *                                        .addLoreLine("First line")
         *                                        .addLoreLine("Second line")
         *                                        .buildLore()
         *                                        .build();
         */
        public ItemHelper(ItemStack i) {
                itemStack = i;
                itemMeta = i.getItemMeta();
                lore = new ArrayList<String>();
        }
       
        /*
         * Sets the name of the current Item(s) in the ItemStack
         */
        public ItemHelper setName(String name) {
                itemMeta.setDisplayName(name);
                return this;
        }
       
        /*
         * Adds a line to the lore of the current Item(s) in the ItemStack
         */
        public ItemHelper addLoreLine(String lineText) {
                lore.add(lineText);
                return this;
        }
       
        /*
         * Adds an enchantment to the current Item(s) in the ItemStack
         */
        public ItemHelper addEnchant(Enchantment enchant, int level) {
                itemStack.addEnchantment(enchant, level);
                return this;
        }
       
        /*
         * Adds an unsafe enchantment to the current Item(s) in the ItemStack
         */
        public ItemHelper addUnsafeEnchant(Enchantment enchant, int level) {
                itemStack.addUnsafeEnchantment(enchant, level);
                return this;          
        }
       
        /*
         * Sets the durability of the current Item(s) in the ItemStack
         */
        public ItemHelper setDurability(short durability) {
                itemStack.setDurability(durability);
                return this;          
        }
       
        /*
         * Sets the amount of Item(s) in the ItemStack
         */
        public ItemHelper setAmount(int amount) {
                itemStack.setAmount(amount);
                return this;          
        }
 
        /*
         * Sets the type of the current Item(s) in the ItemStack
         */
        public ItemHelper setType(Material type) {
                itemStack.setType(type);
                return this;          
        }
       
        /*
         * Builds the ItemStack returning it
         */
        public ItemStack build() {
                itemMeta.setLore(lore);
                itemStack.setItemMeta(itemMeta);
                return itemStack;
        }
}