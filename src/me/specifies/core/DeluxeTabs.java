package me.specifies.core;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.specifies.core.Commands.ClearPrefix;
import me.specifies.core.Commands.SetPrefix;
import me.specifies.core.Commands.TabPrefix;
import me.specifies.core.Events.PageTraversal;
import me.specifies.core.Events.RemovePlayerInstance;
import me.specifies.core.Events.SetPlayerPrefix;
import me.specifies.core.Inventories.ScrollingInventory;

public class DeluxeTabs extends JavaPlugin {
	
	private static DeluxeTabs instance;
	
	private HashMap<String, String> tags = new HashMap<>();
	
	private File defaultPath = new File(this.getDataFolder(), "\\data");
	
	
	public void onEnable() {
		
		instance = this;
		
		this.saveDefaultConfig();
		
		registerCommands(); 
		registerEvents();
		
		pullTagConfiguration();
		
		if(!defaultPath.exists()) defaultPath.mkdirs();
		
	}
	
	public void onDisable() {
		for(Map.Entry<UUID, ScrollingInventory> entry : ScrollingInventory.users.entrySet()) {
			
			UUID u = entry.getKey();
			
			Player p = Bukkit.getPlayer(u);
			
			ScrollingInventory.users.remove(u);
			try { p.closeInventory(); } catch(Exception err) {/* No reason to log anything */} 
			
			
		}
		
		instance = null;
	}
	
	public static DeluxeTabs getInstance() {
		return instance;
	}
	
	public HashMap<String, String> getTags() {
		return tags;
	}
	
	public String color(String m) {
		return ChatColor.translateAlternateColorCodes('&', m);
	}
	
	private void registerCommands() {
		getCommand("tabprefix").setExecutor(new TabPrefix());
		getCommand("clearprefix").setExecutor(new ClearPrefix());
		getCommand("setprefix").setExecutor(new SetPrefix());
	}
	
	private void registerEvents() {
		PluginManager pm = Bukkit.getPluginManager();
		
		pm.registerEvents(new PageTraversal(), this);
		pm.registerEvents(new SetPlayerPrefix(), this);
		pm.registerEvents(new RemovePlayerInstance(), this);
		
	}
	
	private void pullTagConfiguration() {
		for(String key : this.getConfig().getConfigurationSection("tags").getKeys(false)) {
			
			String tag = this.getConfig().getString("tags." + key + ".tag");
			String permNode = this.getConfig().getString("tags." + key + ".permission");
			
			
			if(tag.length() > this.getConfig().getInt("character-limit")) System.out.println("[DeluxeTabs] The tag \"" + tag + "\" will not be loaded as it exceeds the character limit set in configuration.");
			else if(permNode == null || tag == null) System.out.println("[DeluxeTabs] The tag \"" + tag + "\" has invalid configuration."); 
			else tags.put(tag, permNode);
			
			
		}
	}
	
}
