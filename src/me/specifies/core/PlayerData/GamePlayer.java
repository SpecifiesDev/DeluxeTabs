package me.specifies.core.PlayerData;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.specifies.core.DeluxeTabs;
import me.specifies.core.Inventories.ScrollingInventory;

public class GamePlayer {
	
	private String player;
	private DeluxeTabs plugin;
	
	private File path;
	private YamlConfiguration config;
	
	public GamePlayer(String player) {
		
		this.player = player;
		this.plugin = DeluxeTabs.getInstance();
		this.path = new File(plugin.getDataFolder(), "\\data\\" + this.getPlayer().getUniqueId() + ".yml");
		this.config = YamlConfiguration.loadConfiguration(this.path);
		
		if(!this.path.exists()) {
			
			this.config.set("prefix-toggled", false);
			this.config.set("prefix", "");
			
			try { this.config.save(this.path); } catch(Exception err) { err.printStackTrace(); }
			
		}
		
	}
	
	public void update() {
		
		if(this.getPrefixState()) {
			this.getPlayer().setPlayerListName(plugin.color(this.getPrefix() + " &7" + this.getPlayer().getName()));
			
			ScrollingInventory.users.remove(this.getPlayer().getUniqueId());
			
			this.getPlayer().closeInventory();
		} 
		
	}
	
	public void clear() {
		
		try { this.setPrefixState(false); this.setPrefix(""); this.getPlayer().setPlayerListName(this.getPlayer().getName());} catch(IOException err) { err.printStackTrace(); }
		
	}
	
	public String getPrefix() {
		return this.config.getString("prefix");
	}
	
	public void setPrefix(String prefix) throws IOException {
		this.config.set("prefix", prefix);
		this.config.save(this.path);
	}
	
	public boolean getPrefixState() {
		return this.config.getBoolean("prefix-toggled");
	}
	
	public void setPrefixState(boolean state) throws IOException {
		this.config.set("prefix-toggled", state);
		this.config.save(this.path);
	}
	
	public Player getPlayer() {
		return Bukkit.getPlayer(this.player);
	}

}
