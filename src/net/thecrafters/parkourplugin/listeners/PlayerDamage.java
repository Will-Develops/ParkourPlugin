package net.thecrafters.parkourplugin.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class PlayerDamage implements Listener{
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent event){
        if (event.getEntity() instanceof Player) {
            Player player = (Player)event.getEntity();
            if(player.getInventory().getItemInHand().getType() == Material.FISHING_ROD){
            	player.setFallDistance(0.0F);
        	}
        }
	}
	
}

