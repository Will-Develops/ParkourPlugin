package net.thecrafters.parkourplugin.listeners;

import net.thecrafters.parkourplugin.Main;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class Respawn implements Listener{
	
	@EventHandler
	public void PlayerRespawn(PlayerRespawnEvent event){
		Player player = event.getPlayer();
		if(player.getInventory().getItem(0) != Main.Hooking){
    		player.getInventory().setItem(0, Main.EmptySlot);
    	}
	}
	

}
