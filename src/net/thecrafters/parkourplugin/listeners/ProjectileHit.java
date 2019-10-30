package net.thecrafters.parkourplugin.listeners;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fish;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.util.Vector;

@SuppressWarnings("deprecation")
public class ProjectileHit implements Listener{
	
	@EventHandler
	public void grapple(ProjectileHitEvent event){
		Entity e = event.getEntity();
		Arrow arrow = (Arrow)event.getEntity();
		
		if ((e instanceof Fish)){
			Player p = (Player)event.getEntity().getShooter();
			Location Location = p.getLocation();
			Location landLocation = e.getLocation();
			Vector direction = landLocation.toVector().subtract(Location.toVector()).normalize();
			p.setVelocity(direction.multiply(3));
			e.remove();
		}
		
	    if ((e instanceof Arrow)){
	      if ((arrow.getShooter() instanceof Player)){
	        Player player = (Player)arrow.getShooter();
            Location destination = arrow.getLocation();
            player.teleport(destination);
            player.playSound(player.getLocation(), Sound.ENDERDRAGON_WINGS, 1.0F, 1.0F);
            arrow.remove();
            return;
	      }
	    }
	}

}
