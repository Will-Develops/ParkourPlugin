package net.thecrafters.parkourplugin.listeners;

import net.thecrafters.parkourplugin.Main;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class Join implements Listener{
	
    @EventHandler
    public boolean onJoin(PlayerJoinEvent event){
    	
        final Player player = event.getPlayer();
        GameMode PGameMode = player.getGameMode();
       
        if(!(PGameMode.equals(GameMode.SURVIVAL))){
                player.setGameMode(GameMode.SURVIVAL);
        }
        
        if(player.hasPermission("parkourplugin.admin") || player.isOp()){
        	player.getInventory().clear();
	        player.getInventory().setBoots(Main.ABoots);
	        player.getInventory().setLeggings(Main.ALeggins);
	        player.getInventory().setChestplate(Main.AChestplate);
	        player.getInventory().setHelmet(Main.AHelmet);
	       
	        player.getInventory().setItem(2, Main.selector);
	        
	        if(Main.getInstance().getConfig().getBoolean("Settings.Book.Enabled") == true){
		        ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
		        
		        BookMeta meta = (BookMeta)book.getItemMeta();
		        meta.setTitle(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Settings.Book.Title")));
		        meta.setAuthor(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Settings.Book.Author")));
		        
		        if(Main.getInstance().getConfig().getString("Settings.Book.Page1") != "disable"){
		        	meta.setPages(new String[] {ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Settings.Book.Page1")) });
		        }
		        
		        if(Main.getInstance().getConfig().getString("Settings.Book.Page2") != "disable"){
		        	meta.addPage(new String[] {ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Settings.Book.Page2")) });
		        }
		        
		        if(Main.getInstance().getConfig().getString("Settings.Book.Page3") != "disable"){
		        	meta.addPage(new String[] {ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Settings.Book.Page3")) });
		        }
		        
		        if(Main.getInstance().getConfig().getString("Settings.Book.Page4") != "disable"){
		        	meta.addPage(new String[] {ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Settings.Book.Page4")) });
		        }
		        
		        book.setItemMeta(meta);
		        ItemStack finalBook = new ItemStack(book);
		        player.getInventory().setItem(4, finalBook);
	        }
	        
        } else {
        	player.getInventory().clear();
	        player.getInventory().setBoots(Main.Boots);
	        player.getInventory().setLeggings(Main.Leggins);
	        player.getInventory().setChestplate(Main.Chestplate);
	        player.getInventory().setHelmet(Main.Helmet);
	       
	        player.getInventory().setItem(2, Main.selector);
	        
	        if(Main.getInstance().getConfig().getBoolean("Settings.Book.Enabled") == true){
		        ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
		        
		        BookMeta meta = (BookMeta)book.getItemMeta();
		        meta.setTitle(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Settings.Book.Title")));
		        meta.setAuthor(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Settings.Book.Author")));
		        
		        if(Main.getInstance().getConfig().getString("Settings.Book.Page1") != "disable"){
		        	meta.setPages(new String[] {ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Settings.Book.Page1")) });
		        }
		        
		        if(Main.getInstance().getConfig().getString("Settings.Book.Page2") != "disable"){
		        	meta.addPage(new String[] {ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Settings.Book.Page2")) });
		        }
		        
		        if(Main.getInstance().getConfig().getString("Settings.Book.Page3") != "disable"){
		        	meta.addPage(new String[] {ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Settings.Book.Page3")) });
		        }
		        
		        if(Main.getInstance().getConfig().getString("Settings.Book.Page4") != "disable"){
		        	meta.addPage(new String[] {ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Settings.Book.Page4")) });
		        }
		        
		        book.setItemMeta(meta);
		        ItemStack finalBook = new ItemStack(book);
		        player.getInventory().setItem(4, finalBook);
	        }
	        
	        
        }
       
        Main.getInstance().getServer().getScheduler().scheduleSyncRepeatingTask( Main.getInstance(), new Runnable(){
            public void run(){
              if (player.getFoodLevel() != 20) {
                player.setFoodLevel(20);
              }
            }
          }, 0L, 1L);
       
        return false;
    }

}
