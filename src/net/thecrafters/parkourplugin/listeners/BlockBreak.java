package net.thecrafters.parkourplugin.listeners;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreak implements Listener{
	
    @EventHandler
    public boolean onPlayerBreak(BlockBreakEvent event) {
    	if(event.getPlayer().getGameMode() == GameMode.SURVIVAL || event.getPlayer().getGameMode() == GameMode.ADVENTURE){
    		event.setCancelled(true);
    	} else {
    		event.setCancelled(false);
    	}
		return false;
    }
	
}
