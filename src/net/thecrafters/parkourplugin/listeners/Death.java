package net.thecrafters.parkourplugin.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Death implements Listener{
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event) {
		
		//for(ItemStack is : event.getDrops()) {
			//if(is.getType() == Material.FISHING_ROD) {
				//if(is.getItemMeta().getDisplayName() != null){
					//event.getDrops().remove(is);
				//}
			//}
		//}
		
		event.setKeepInventory(true);
	}	
	
}
