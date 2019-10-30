package net.thecrafters.parkourplugin.listeners;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DisableDrops implements Listener{
	
	@EventHandler
	public void OnItemDrop(PlayerDropItemEvent event){
		if(event.getPlayer().getGameMode() == GameMode.SURVIVAL || event.getPlayer().getGameMode() == GameMode.ADVENTURE){
    		event.setCancelled(true);
    	} else {
    		event.setCancelled(false);
    	}
	}
}
