package me.specifies.core;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import me.specifies.core.Commands.ClearPrefix;
import me.specifies.core.Commands.CreatePrefix;
import me.specifies.core.Commands.TabPrefix;
import me.specifies.core.Events.GUIClick;
import me.specifies.core.Events.setDefaultFile;
import me.specifies.core.Events.setPrefix;
import net.milkbowl.vault.chat.Chat;

/*  
Copyright (C) 2018  Specifies

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
public class DeluxeTabs extends JavaPlugin{
	private static Chat chat;
	public void onEnable() {
		createDef();
		this.saveDefaultConfig();
		registerEvents();
		registerCommands();
		setUpChat();
	}
	public void registerEvents() {
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new setPrefix(this), this);
		pm.registerEvents(new setDefaultFile(this), this);
		pm.registerEvents(new GUIClick(this), this);
	}
	public void registerCommands() {
		getCommand("tabprefix").setExecutor(new TabPrefix(this));
		getCommand("setprefix").setExecutor(new CreatePrefix(this));
		getCommand("clearprefix").setExecutor(new ClearPrefix(this));
	}
	
	
	//utils
	public String color(String m) {
		return ChatColor.translateAlternateColorCodes('&', m);
	}
	public void message(String m) {
		getServer().getConsoleSender().sendMessage(m);
	}
	
	public void createDef() {
		File folder = new File(getDataFolder() + File.separator + "prefixes");
		File prefix = new File(getDataFolder() + File.separator + "prefixes" + File.separator + "prefixes.yml");
		FileConfiguration preconf = YamlConfiguration.loadConfiguration(prefix);
		if(!folder.exists()) {
			folder.mkdirs();
		preconf.set("Prefix1", "&7[&eGod&7]");
		preconf.set("Prefix2", "&7[&4L33T&7]");
		preconf.set("Prefix3", "&7[&cPvP&bGod&7]");
		preconf.set("Prefix4", "&7[&eeGirl&7]");
		preconf.set("Prefix5", "&7[&deBoy&7");
		preconf.set("Prefix6", "&7[&dn00b&7]");
		preconf.set("Prefix7", "&7[&aWizard&7]");
		preconf.set("Prefix8", "&7[&1K&2a&3p&4p&5a&7]");
		preconf.set("Prefix9", "&7[&4Cannoner&7]");
		preconf.set("Prefix10", "&7[&eHerbist&7]");
		preconf.set("Prefix11", "&7[&8H4X0R&7]");
		preconf.set("Prefix12", "&7[&cOverlord&7]");
		preconf.set("Prefix13", "&7[&3Archer&7-&3God]");
		preconf.set("Prefix14", "&7[&bTitan&7]");
		preconf.set("Prefix15", "&7[&4Kronos&7]");
		preconf.set("Prefix16", "&7[&5Strategist&7]");
		preconf.set("Prefix17", "&7[&5S&dw&ea&cg&7]");
		preconf.set("Prefix18", "&7[&bMinecrafter&7]");
		preconf.set("Prefix19", "&7[&dSus&7]");
		preconf.set("Prefix20", "&7[&4Invincible&7]");
		preconf.set("Prefix21", "&7[&bSpeedHax&7]");
		preconf.set("Prefix22", "&7[&2Millionare&7]");
		try {
			preconf.save(prefix);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	}
	private boolean setUpChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
	}
	public static Chat getChat() {
		return chat;
	}
}
