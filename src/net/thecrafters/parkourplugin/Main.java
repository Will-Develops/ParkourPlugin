package net.thecrafters.parkourplugin;
 
import java.util.HashMap;

import net.thecrafters.parkourplugin.commands.ReloadConfig;
import net.thecrafters.parkourplugin.commands.openMenu;
import net.thecrafters.parkourplugin.commands.setSpawn;
import net.thecrafters.parkourplugin.listeners.BlockBreak;
import net.thecrafters.parkourplugin.listeners.BlockPlace;
import net.thecrafters.parkourplugin.listeners.Death;
import net.thecrafters.parkourplugin.listeners.DisableDrops;
import net.thecrafters.parkourplugin.listeners.ProjectileHit;
import net.thecrafters.parkourplugin.listeners.Interact;
import net.thecrafters.parkourplugin.listeners.InventoryClick;
import net.thecrafters.parkourplugin.listeners.Join;
import net.thecrafters.parkourplugin.listeners.PlayerDamage;
import net.thecrafters.parkourplugin.listeners.PlayerMovement;
import net.thecrafters.parkourplugin.listeners.Quit;
import net.thecrafters.parkourplugin.listeners.Respawn;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
 
 
public class Main extends JavaPlugin implements CommandExecutor, Listener{
	
        Main plugin;
        private static Main instance;
        FileConfiguration config;
        public static HashMap<String, Long> cooldowns = new HashMap<String, Long>();
       
        public static Material SelectorItem = Material.WATCH;
        public static String SelectorName = ChatColor.GOLD + "Parkour Options";
        public static Inventory myInventory = Bukkit.createInventory(null, 18, SelectorName);
        
        public static String Prefix = ChatColor.LIGHT_PURPLE + "[" + ChatColor.YELLOW + "TCN Parkour" + ChatColor.LIGHT_PURPLE + "]" + ChatColor.RESET + " ";
        
        public static ItemStack selector = new ItemHelper(new ItemStack(SelectorItem)).setName(SelectorName).build();
        
       
        static ItemStack BackToSpawn = new ItemHelper(new ItemStack(Material.SAPLING)).setName(ChatColor.BLUE + "Back To Spawn").build();
        static ItemStack WipeCheckPoint = new ItemHelper(new ItemStack(Material.OBSIDIAN)).setName(ChatColor.RED + "Clear CheckPoint").build();
        static ItemStack LastCheckPoint = new ItemHelper(new ItemStack(Material.ANVIL)).setName(ChatColor.YELLOW + "Back To CheckPoint").build();
        static ItemStack CloseMenu = new ItemHelper(new ItemStack(Material.TNT)).setName(ChatColor.RED + "Close Menu").build();
        
        public static ItemStack Hooking = new ItemHelper(new ItemStack(Material.FISHING_ROD)).setName(ChatColor.AQUA + "Grapping Hook").addLoreLine("").addLoreLine(ChatColor.RED + "Warning: You will take fall damage!").build();
        public static ItemStack EmptySlot = new ItemStack(Material.AIR);
        
        public static ItemStack Helmet = new ItemHelper(new ItemStack(Material.LEATHER_HELMET)).setName(ChatColor.RED + "Parkour Kit").build();
        public static ItemStack Chestplate = new ItemHelper(new ItemStack(Material.LEATHER_CHESTPLATE)).setName(ChatColor.RED + "Parkour Kit").build();
        public static ItemStack Leggins = new ItemHelper(new ItemStack(Material.LEATHER_LEGGINGS)).setName(ChatColor.RED + "Parkour Kit").build();
        public static ItemStack Boots = new ItemHelper(new ItemStack(Material.LEATHER_BOOTS)).setName(ChatColor.RED + "Parkour Kit").build();
        
        public static ItemStack AHelmet = new ItemHelper(new ItemStack(Material.DIAMOND_HELMET)).setName(ChatColor.RED + "Parkour Kit").build();
        public static ItemStack AChestplate = new ItemHelper(new ItemStack(Material.DIAMOND_CHESTPLATE)).setName(ChatColor.RED + "Parkour Kit").build();
        public static ItemStack ALeggins = new ItemHelper(new ItemStack(Material.DIAMOND_LEGGINGS)).setName(ChatColor.RED + "Parkour Kit").build();
        public static ItemStack ABoots = new ItemHelper(new ItemStack(Material.DIAMOND_BOOTS)).setName(ChatColor.RED + "Parkour Kit").build();
       
        public void onEnable(){
        	instance = this;
        	getCommand("popenmenu").setExecutor(new openMenu());
        	getCommand("psetspawn").setExecutor(new setSpawn());
        	getCommand("preloadconfig").setExecutor(new ReloadConfig());
        	registerEvents(this, new PlayerDamage(), new Respawn(), new DisableDrops(), new Join(), new Death(), new ProjectileHit(), new Interact(), new InventoryClick(), new PlayerMovement(), new Quit(), new BlockPlace(), new BlockBreak());
        	config = getConfig();
        	getConfig().options().copyDefaults(true);
        	saveConfig();
        }
        
        public static void registerEvents(Plugin plugin, Listener... listeners) {
            for (Listener listener : listeners) {
                Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
            }
        }
       
        public void onDisable(){
        	
        }
       
        static {
        	myInventory.setItem(1, BackToSpawn);
        	myInventory.setItem(3, LastCheckPoint);
        	myInventory.setItem(5, WipeCheckPoint);
        	myInventory.setItem(17, CloseMenu);
        }
        
        public static Main getInstance(){
    		return instance;
    	}
}