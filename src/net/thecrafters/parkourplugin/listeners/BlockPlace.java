package net.thecrafters.parkourplugin.listeners;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlace implements Listener{
	
    @EventHandler
    public boolean onPlayerPlace(BlockPlaceEvent event) {
    	if(event.getPlayer().getGameMode() == GameMode.SURVIVAL || event.getPlayer().getGameMode() == GameMode.ADVENTURE){
    		event.setCancelled(true);
    	} else {
    		event.setCancelled(false);
    	}
		return false;
    }
	
}
