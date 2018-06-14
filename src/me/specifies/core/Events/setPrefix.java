package me.specifies.core.Events;

import java.io.File;
import java.util.UUID;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

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
public class setPrefix implements Listener{
	DeluxeTabs plugin;
	public setPrefix(DeluxeTabs instance) {
		this.plugin = instance;
	}
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		UUID u = p.getUniqueId();
		File pf = new File(plugin.getDataFolder() + File.separator + "players" + File.separator + u + ".yml");
		FileConfiguration conf = YamlConfiguration.loadConfiguration(pf);
		
		boolean isEnabled = conf.getBoolean("custom-prefix");
		if(isEnabled == true) {
			if(p.hasPermission("deluxetabs.customprefix")) {
				String final1 = conf.getString("current-prefix");
				if(final1.equals("")) {
					String final2 = DeluxeTabs.getChat().getPlayerPrefix(p);
					p.setPlayerListName(plugin.color(final2 + " &7" + p.getName()));
				}
				else {
				p.setPlayerListName(plugin.color(final1 + " &7" + p.getName()));
				}
			}
		}
		if(isEnabled == false) {
			if(p.hasPermission("deluxetabs.onjoin")) {
				String final1 = DeluxeTabs.getChat().getPlayerPrefix(p);
				p.setPlayerListName(plugin.color(final1 + " &7" + p.getName()));
			}
		}
	}
}
