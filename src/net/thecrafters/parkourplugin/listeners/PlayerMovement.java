package net.thecrafters.parkourplugin.listeners;

import net.thecrafters.parkourplugin.Main;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class PlayerMovement implements Listener{
	
	@SuppressWarnings("deprecation")
	@EventHandler
    public boolean onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Block block = player.getLocation().getBlock().getRelative(BlockFace.DOWN);
       
        int cooldownTime = 1;
        Block blockbelow = player.getLocation().getBlock().getRelative(BlockFace.DOWN);
        Block blockEast = player.getLocation().getBlock().getRelative(BlockFace.EAST);
        Block blockNorth = player.getLocation().getBlock().getRelative(BlockFace.NORTH);
        Block blockWest = player.getLocation().getBlock().getRelative(BlockFace.WEST);
        Block blockSouth = player.getLocation().getBlock().getRelative(BlockFace.SOUTH);
        //Location below = player.getLocation().subtract(0.0D, 0.0D, 0.0D);
        
        //if(below.getBlock().getType() != Material.AIR){
        	//player.removePotionEffect();
        //}
        
        if(player.getGameMode() == GameMode.SURVIVAL || player.getGameMode() == GameMode.ADVENTURE){
	        if(block.getType() == Material.REDSTONE_BLOCK){
	            if(Main.cooldowns.containsKey(player.getName())) {
	                long secondsLeft = ((Main.cooldowns.get(player.getName())/1000)+cooldownTime) - (System.currentTimeMillis()/1000);
	                if(secondsLeft>0) {
	                    return true;
	                }
	            }
	            Main.getInstance().getConfig().set("Players" + "." + player.getName() + ".checkpoint.x", player.getLocation().getBlockX());
	            Main.getInstance().getConfig().set("Players" + "." + player.getName() + ".checkpoint.y", player.getLocation().getBlockY());
	            Main.getInstance().getConfig().set("Players" + "." + player.getName() + ".checkpoint.z", player.getLocation().getBlockZ());
	            Main.getInstance().getConfig().set("Players" + "." + player.getName() + ".checkpoint.world", player.getLocation().getWorld().getName());
	            Main.getInstance().saveConfig();
	            player.sendMessage(Main.Prefix + ChatColor.AQUA + "Checkpoint Updated!");
	            Main.cooldowns.put(player.getName(), System.currentTimeMillis());
	            return true;
	        }
	       
	        if(block.getType() == Material.CLAY){
	            if(Main.cooldowns.containsKey(player.getName())) {
	                long secondsLeft = ((Main.cooldowns.get(player.getName())/1000)+cooldownTime) - (System.currentTimeMillis()/1000);
	                if(secondsLeft>0) {
	                    return true;
	                }
	            }
	            
	            if(Main.getInstance().getConfig().getString("Players" + "." + player.getName() + ".warp.id") != null){
	            	player.sendMessage("found");
	            } else {
	            	player.sendMessage("not found");
	            }
	           
	            //int x = Main.getInstance().getConfig().getInt("Players" + "." + player.getName() + ".warp.x");
	        	//int y = Main.getInstance().getConfig().getInt("Players" + "." +player.getName() + ".warp.y");
	        	//int z = Main.getInstance().getConfig().getInt("Players" + "." +player.getName() + ".warp.z");
	        	//World world = Bukkit.getWorld(Main.getInstance().getConfig().getString("Players" + "." + player.getName() + ".world"));
	        	
	        	//player.teleport(new Location(world, x, y, z));
	        	
	            Main.cooldowns.put(player.getName(), System.currentTimeMillis());
	            return true;
	        }
	        
	        if(block.getType() == Material.SPONGE){
	            if(Main.cooldowns.containsKey(player.getName())) {
	                long secondsLeft = ((Main.cooldowns.get(player.getName())/1000)+cooldownTime) - (System.currentTimeMillis()/1000);
	                if(secondsLeft>0) {
	                    return true;
	                }
	            }
	            
	            int lastWarp = Main.getInstance().getConfig().getInt("Players" + "." + player.getName() + ".warp.id");
	            
	            Main.getInstance().getConfig().set("Players" + "." + player.getName() + ".warp.id", lastWarp + 1);
	            Main.getInstance().getConfig().set("Players" + "." + player.getName() + ".warp.x", player.getLocation().getBlockX());
	            Main.getInstance().getConfig().set("Players" + "." + player.getName() + ".warp.y", player.getLocation().getBlockY());
	            Main.getInstance().getConfig().set("Players" + "." + player.getName() + ".warp.z", player.getLocation().getBlockZ());
	            Main.getInstance().getConfig().set("Players" + "." + player.getName() + ".warp.world", player.getLocation().getWorld().getName());
	            Main.getInstance().saveConfig();
	            
	            player.sendMessage(lastWarp + 1 + "");
	            
	            Main.cooldowns.put(player.getName(), System.currentTimeMillis());
	            return true;
	        }
	        
	        if(blockbelow.getType() == Material.COAL_ORE){
	        	player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 23, 1));
	        }
	        
	        if(blockbelow.getType() == Material.IRON_ORE){
	        	player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 23, 1));
	        }
	        
	        if(blockbelow.getType() == Material.WOOL){
	        	double jumpheight = 1;
	            player.setVelocity(new Vector(0.0D, jumpheight, 0.0D));
	        }
	        
	        if(blockbelow.getType() == Material.OBSIDIAN){
	        	player.setFallDistance(0.0F);
	        }
	        
	        if(blockbelow.getType() == Material.GLOWSTONE){
	        	player.setFireTicks(0);
	        }
	        
	        if(blockbelow.getType() == Material.MELON_BLOCK){
	        	player.setHealth(20);
	        	player.setFoodLevel(20);
	        }
	        
	        if(blockbelow.getType() == Material.HAY_BLOCK){
	        	if(player.getInventory().getItem(0) != Main.EmptySlot){
	        		Main.Hooking.addUnsafeEnchantment(Enchantment.DURABILITY, 1000);
	        		player.getInventory().setItem(0, Main.Hooking);
	        	}
	        }
	        
	        if(blockbelow.getType() == Material.LAPIS_BLOCK){
	        	if(player.getInventory().getItem(0) != Main.Hooking){
	        		player.getInventory().setItem(0, Main.EmptySlot);
	        	}
	        }
	        
	        if(blockEast.getType() == Material.QUARTZ_BLOCK || blockNorth.getType() == Material.QUARTZ_BLOCK || blockWest.getType() == Material.QUARTZ_BLOCK || blockSouth.getType() == Material.QUARTZ_BLOCK){
	            double climbs = Double.valueOf(0.4D);
	            if ((!player.isSneaking())) {
	                player.setVelocity(new Vector(0.0D, climbs, 0.0D));
	            }
	        }
        }
        return false;
    }
	
}
