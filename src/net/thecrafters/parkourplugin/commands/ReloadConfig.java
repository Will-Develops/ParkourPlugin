package net.thecrafters.parkourplugin.commands;

import net.thecrafters.parkourplugin.Main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadConfig implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
        if(!(sender instanceof Player)) {
            return true;
        }
        
        Player player = (Player) sender;
        
    	if(player.hasPermission("parkourplugin.reloadconfig")){
    		Main.getInstance().reloadConfig();
    		player.sendMessage(Main.Prefix + ChatColor.AQUA + "Config Reloaded!");
    	} else {
    		player.sendMessage(Main.Prefix + ChatColor.RED + "You do not have permission to use this command!");
    	}
			
        return true;
    }

}
