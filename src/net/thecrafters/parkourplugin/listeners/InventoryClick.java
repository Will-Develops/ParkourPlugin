package net.thecrafters.parkourplugin.listeners;

import net.thecrafters.parkourplugin.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryClick implements Listener{
	
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack clicked = event.getCurrentItem();
        Inventory inventory = event.getInventory();
        if (inventory.getName().equals(Main.myInventory.getName())) {
                if (clicked.getType() == Material.TNT) {
                        event.setCancelled(true);
                        player.closeInventory();
                } else if (clicked.getType() == Material.SAPLING) {
                        event.setCancelled(true);
                        player.performCommand("spawn");
                        player.closeInventory();
                } else if (clicked.getType() == Material.ANVIL) {
                    	int x = Main.getInstance().getConfig().getInt("Players" + "." + player.getName() + ".checkpoint.x");
                    	int y = Main.getInstance().getConfig().getInt("Players" + "." +player.getName() + ".checkpoint.y");
                    	int z = Main.getInstance().getConfig().getInt("Players" + "." +player.getName() + ".checkpoint.z");
                    	World world = Bukkit.getWorld(Main.getInstance().getConfig().getString("Players" + "." + player.getName() + ".checkpoint.world"));
                    	
                    	player.teleport(new Location(world, x, y, z));
                    	player.sendMessage(Main.Prefix + ChatColor.AQUA + "Teleporting To Checkpoint!");
                    	
                        event.setCancelled(true);
                        player.closeInventory();
                } else if (clicked.getType() == Material.OBSIDIAN) {
                        event.setCancelled(true);
                        player.closeInventory();
            }
                event.setCancelled(true);
        }
        
        if(event.getWhoClicked().getGameMode() == GameMode.SURVIVAL || event.getWhoClicked().getGameMode() == GameMode.ADVENTURE){
        	event.setCancelled(true);
        } else {
        	event.setCancelled(false);
        }
    }
	
}
