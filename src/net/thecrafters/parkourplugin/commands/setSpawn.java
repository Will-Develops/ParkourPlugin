package net.thecrafters.parkourplugin.commands;

import net.thecrafters.parkourplugin.Main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class setSpawn implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
        if(!(sender instanceof Player)) {
            return true;
        }
        
        Player player = (Player) sender;
        
    	if(player.hasPermission("parkourplugin.setspawn")){
    		Main.getInstance().getConfig().set("Settings" + ".WorldSpawn" + ".x", player.getLocation().getBlockX());
    		Main.getInstance().getConfig().set("Settings" + ".WorldSpawn" + ".y", player.getLocation().getBlockY());
    		Main.getInstance().getConfig().set("Settings" + ".WorldSpawn" + ".z", player.getLocation().getBlockZ());
    		Main.getInstance().getConfig().set("Settings" + ".WorldSpawn" + ".world", player.getLocation().getWorld().getName());
    		Main.getInstance().saveConfig();
            player.sendMessage(Main.Prefix + ChatColor.AQUA + "Spawn Set!");
    	} else {
    		player.sendMessage(Main.Prefix + ChatColor.RED + "You do not have permission to use this command!");
    	}
			
        return true;
    }

}
