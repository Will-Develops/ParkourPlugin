package net.thecrafters.parkourplugin.listeners;

import java.util.logging.Level;

import net.thecrafters.parkourplugin.Main;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class Quit implements Listener{
	
    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        if(Main.cooldowns.containsKey(event.getPlayer().getName())){
        	Main.cooldowns.remove(event.getPlayer().getName());
            Bukkit.getLogger().log(Level.SEVERE, "Removed " + event.getPlayer().getName() + " from cooldowns");
        }
    }
	
}
