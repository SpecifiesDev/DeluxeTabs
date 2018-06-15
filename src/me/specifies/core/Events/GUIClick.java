package me.specifies.core.Events;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import me.specifies.core.DeluxeTabs;
/*  
Copyright (C) 2018  Specifies

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
public class GUIClick implements Listener{
	DeluxeTabs plugin;
	public GUIClick(DeluxeTabs instance) {
		this.plugin = instance;
	}
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		File prefix = new File(plugin.getDataFolder() + File.separator + "prefixes" + File.separator + "prefixes.yml");
		FileConfiguration preconf = YamlConfiguration.loadConfiguration(prefix);
		
		String guipref = plugin.getConfig().getString("gui-prefix");
		String guipreff = plugin.color(guipref);
		
		Player p = (Player) e.getWhoClicked();
		UUID u = p.getUniqueId();
		File pf = new File(plugin.getDataFolder() + File.separator + "players" + File.separator + u + ".yml");
		FileConfiguration conf = YamlConfiguration.loadConfiguration(pf);
		

		String ctitle = plugin.getConfig().getString("command-prefix");
		
		if(e.getInventory().getName().equals(guipreff)) {
			ItemStack item = e.getCurrentItem();
			if(item == null || item.getType() == Material.AIR) {
				return;
				
			} 
			String name = item.getItemMeta().getDisplayName();
			if(item.getType() == Material.STAINED_GLASS_PANE) {
				e.setCancelled(true);
			}
			if(item.getType() == Material.NAME_TAG) {
				e.setCancelled(true);
				String pre1 = getPrefix(1);
				String pre2 = getPrefix(2);
				String pre3 = getPrefix(3);
				String pre4 = getPrefix(4);
				String pre5 = getPrefix(5);
				String pre6 = getPrefix(6);
				String pre7 = getPrefix(7);
				String pre8 = getPrefix(8);
				String pre9 = getPrefix(9);
				String pre10 = getPrefix(10);
				String pre11 = getPrefix(11);
				String pre12 = getPrefix(12);
				String pre13 = getPrefix(13);
				String pre14 = getPrefix(14);
				String pre15 = getPrefix(15);
				String pre16 = getPrefix(16);
				String pre17 = getPrefix(17);
				String pre18 = getPrefix(18);
				String pre19 = getPrefix(19);
				String pre20 = getPrefix(20);
				String pre21 = getPrefix(21);
				String pre22 = getPrefix(22);
				if(name.equals(plugin.color(pre1))) {
					if(p.hasPermission("deluxetabs.prefix.1")) {
						manageData(conf, pf, ctitle, p, pre1);
					} else {
						p.sendMessage(plugin.color(ctitle + " &cIt appears you do not have access to this tag."));
						p.closeInventory();
					}
				}
				if(name.equals(plugin.color(pre2))) {
					if(p.hasPermission("deluxetabs.prefix.2")) {
						manageData(conf, pf, ctitle, p, pre2);
					} else {
						p.sendMessage(plugin.color(ctitle + " &cIt appears you do not have access to this tag."));
						p.closeInventory();
					}
				}
				if(name.equals(plugin.color(pre3))) {
					if(p.hasPermission("deluxetabs.prefix.3")) {
						manageData(conf, pf, ctitle, p, pre3);
					} else {
						p.sendMessage(plugin.color(ctitle + " &cIt appears you do not have access to this tag."));
						p.closeInventory();
					}
				}
				if(name.equals(plugin.color(pre4))) {
					if(p.hasPermission("deluxetabs.prefix.4")) {
						manageData(conf, pf, ctitle, p, pre4);
					} else {
						p.sendMessage(plugin.color(ctitle + " &cIt appears you do not have access to this tag."));
						p.closeInventory();
					}
				}
				if(name.equals(plugin.color(pre5))) {
					if(p.hasPermission("deluxetabs.prefix.5")) {
						manageData(conf, pf, ctitle, p, pre5);
					} else {
						p.sendMessage(plugin.color(ctitle + " &cIt appears you do not have access to this tag."));
						p.closeInventory();
					}
				}
				if(name.equals(plugin.color(pre6))) {
					if(p.hasPermission("deluxetabs.prefix.6")) {
						manageData(conf, pf, ctitle, p, pre6);
					} else {
						p.sendMessage(plugin.color(ctitle + " &cIt appears you do not have access to this tag."));
						p.closeInventory();
					}
				}
				if(name.equals(plugin.color(pre7))) {
					if(p.hasPermission("deluxetabs.prefix.7")) {
						manageData(conf, pf, ctitle, p, pre7);
					} else {
						p.sendMessage(plugin.color(ctitle + " &cIt appears you do not have access to this tag."));
						p.closeInventory();
					}
				}
				if(name.equals(plugin.color(pre8))) {
					if(p.hasPermission("deluxetabs.prefix.8")) {
						manageData(conf, pf, ctitle, p, pre8);
					} else {
						p.sendMessage(plugin.color(ctitle + " &cIt appears you do not have access to this tag."));
						p.closeInventory();
					}
				}
				if(name.equals(plugin.color(pre9))) {
					if(p.hasPermission("deluxetabs.prefix.9")) {
						manageData(conf, pf, ctitle, p, pre9);
					} else {
						p.sendMessage(plugin.color(ctitle + " &cIt appears you do not have access to this tag."));
						p.closeInventory();
					}
				}
				if(name.equals(plugin.color(pre10))) {
					if(p.hasPermission("deluxetabs.prefix.10")) {
						manageData(conf, pf, ctitle, p, pre10);
					} else {
						p.sendMessage(plugin.color(ctitle + " &cIt appears you do not have access to this tag."));
						p.closeInventory();
					}
				}
				if(name.equals(plugin.color(pre11))) {
					if(p.hasPermission("deluxetabs.prefix.11")) {
						manageData(conf, pf, ctitle, p, pre11);
					} else {
						p.sendMessage(plugin.color(ctitle + " &cIt appears you do not have access to this tag."));
						p.closeInventory();
					}
				}
				if(name.equals(plugin.color(pre12))) {
					if(p.hasPermission("deluxetabs.prefix.12")) {
						manageData(conf, pf, ctitle, p, pre12);
					} else {
						p.sendMessage(plugin.color(ctitle + " &cIt appears you do not have access to this tag."));
						p.closeInventory();
					}
				}
				if(name.equals(plugin.color(pre13))) {
					if(p.hasPermission("deluxetabs.prefix.13")) {
						manageData(conf, pf, ctitle, p, pre13);
					} else {
						p.sendMessage(plugin.color(ctitle + " &cIt appears you do not have access to this tag."));
						p.closeInventory();
					}
				}
				if(name.equals(plugin.color(pre14))) {
					if(p.hasPermission("deluxetabs.prefix.14")) {
						manageData(conf, pf, ctitle, p, pre14);
					} else {
						p.sendMessage(plugin.color(ctitle + " &cIt appears you do not have access to this tag."));
						p.closeInventory();
					}
				}
				if(name.equals(plugin.color(pre15))) {
					if(p.hasPermission("deluxetabs.prefix.15")) {
						manageData(conf, pf, ctitle, p, pre15);
					} else {
						p.sendMessage(plugin.color(ctitle + " &cIt appears you do not have access to this tag."));
						p.closeInventory();
					}
				}
				if(name.equals(plugin.color(pre16))) {
					if(p.hasPermission("deluxetabs.prefix.16")) {
						manageData(conf, pf, ctitle, p, pre16);
					} else {
						p.sendMessage(plugin.color(ctitle + " &cIt appears you do not have access to this tag."));
						p.closeInventory();
					}
				}
				if(name.equals(plugin.color(pre17))) {
					if(p.hasPermission("deluxetabs.prefix.17")) {
						manageData(conf, pf, ctitle, p, pre17);
					} else {
						p.sendMessage(plugin.color(ctitle + " &cIt appears you do not have access to this tag."));
						p.closeInventory();
					}
				}
				if(name.equals(plugin.color(pre18))) {
					if(p.hasPermission("deluxetabs.prefix.18")) {
						manageData(conf, pf, ctitle, p, pre18);
					} else {
						p.sendMessage(plugin.color(ctitle + " &cIt appears you do not have access to this tag."));
						p.closeInventory();
					}
				}
				if(name.equals(plugin.color(pre19))) {
					if(p.hasPermission("deluxetabs.prefix.19")) {
						manageData(conf, pf, ctitle, p, pre19);
					} else {
						p.sendMessage(plugin.color(ctitle + " &cIt appears you do not have access to this tag."));
						p.closeInventory();
					}
				}
				if(name.equals(plugin.color(pre20))) {
					if(p.hasPermission("deluxetabs.prefix.20")) {
						manageData(conf, pf, ctitle, p, pre20);
					} else {
						p.sendMessage(plugin.color(ctitle + " &cIt appears you do not have access to this tag."));
						p.closeInventory();
					}
				}
				if(name.equals(plugin.color(pre21))) {
					if(p.hasPermission("deluxetabs.prefix.21")) {
						manageData(conf, pf, ctitle, p, pre21);
					} else {
						p.sendMessage(plugin.color(ctitle + " &cIt appears you do not have access to this tag."));
						p.closeInventory();
					}
				}
				if(name.equals(plugin.color(pre22))) {
					if(p.hasPermission("deluxetabs.prefix.22")) {
						manageData(conf, pf, ctitle, p, pre22);
					} else {
						p.sendMessage(plugin.color(ctitle + " &cIt appears you do not have access to this tag."));
						p.closeInventory();
					}
				}
			}
			if(item.getType() == Material.STAINED_CLAY) {
				e.setCancelled(true);
				p.closeInventory();
			}
			if(item.getType() == Material.PAPER) {
				e.setCancelled(true);
				boolean isEnabled = conf.getBoolean("custom-prefix");
				if(isEnabled == true) {
					plugin.message("true");
					conf.set("custom-prefix", false);
					conf.set("current-prefix", "");
					try {
						conf.save(pf);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					String final1 = DeluxeTabs.getChat().getPlayerPrefix(p);
					p.setPlayerListName(plugin.color(final1 + " &7" + p.getName()));
					p.sendMessage(plugin.color(ctitle + " &7You have disabled your prefixes."));
					p.closeInventory();
					
				}
				if(isEnabled == false) {
					conf.set("custom-prefix", true);
					conf.set("current-prefix", "");
					try {
						conf.save(pf);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					p.sendMessage(plugin.color(ctitle + " &7You have enabled your prefixes."));
					p.closeInventory();
					
				}
			}
		}
	}
	public String getPrefix(int prefixnumber) {
		File prefix = new File(plugin.getDataFolder() + File.separator + "prefixes" + File.separator + "prefixes.yml");
		FileConfiguration preconf = YamlConfiguration.loadConfiguration(prefix);
		String prefnumb = Integer.toString(prefixnumber);
		String final1 = preconf.getString("Prefix" + prefnumb);
		return final1;
	}
	public void manageData(FileConfiguration conf, File f, String prefix, Player p, String pref2) {
		p.sendMessage(plugin.color(prefix + " &7Your prefix has been changed to: " + pref2));
		p.setPlayerListName(plugin.color(pref2 + " &7" + p.getName()));
		conf.set("custom-prefix", true);
		conf.set("current-prefix", pref2);
		try {
			conf.save(f);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		p.closeInventory();
	}
}
