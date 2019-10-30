package net.thecrafters.parkourplugin.listeners;

import net.thecrafters.parkourplugin.Main;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class Interact implements Listener{
    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();
        try{
            if(event.getItem().getType().equals(Main.SelectorItem) && event.getItem().getItemMeta().getDisplayName().equals(Main.SelectorName)){
                if (event.getAction().equals(Action.LEFT_CLICK_BLOCK) || event.getAction().equals(Action.LEFT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK) || event.getAction().equals(Action.RIGHT_CLICK_AIR)){
                	player.performCommand("popenmenu");
                }
            }
        } catch (Exception e){}
    }
}
