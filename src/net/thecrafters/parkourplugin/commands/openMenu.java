package net.thecrafters.parkourplugin.commands;

import net.thecrafters.parkourplugin.Main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class openMenu implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
        if(!(sender instanceof Player)) {
            return true;
        }
        
        Player player = (Player) sender;
        
		player.openInventory(Main.myInventory);
			
        return true;
    }

}
