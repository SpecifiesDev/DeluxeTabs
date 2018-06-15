package me.specifies.core.Commands;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

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
public class ClearPrefix implements CommandExecutor{
	DeluxeTabs plugin;
	public ClearPrefix(DeluxeTabs instance) {
		this.plugin = instance;
	}
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	String prefix = plugin.getConfig().getString("command-prefix");
    	if(cmd.getName().equalsIgnoreCase("clearprefix")) {
        	if(!(sender instanceof Player)) {
        		if(args.length == 1) {
        			Player np = Bukkit.getPlayer(args[0]);
        			if(np == null) {
        				sender.sendMessage(plugin.color(prefix + " &cIt appears that the target player is not online."));
        			} else {
        				UUID u = np.getUniqueId();
        				File pf = new File(plugin.getDataFolder() + File.separator + "players" + File.separator + u + ".yml");
        				FileConfiguration conf = YamlConfiguration.loadConfiguration(pf);
        				conf.set("custom-prefix", false);
        				conf.set("current-prefix", "");
        				try {
							conf.save(pf);
						} catch (IOException e) {
							e.printStackTrace();
						}
        				String final1 = DeluxeTabs.getChat().getPlayerPrefix(np);
        				np.setPlayerListName(plugin.color(final1 + " &7" + np.getName()));
        				sender.sendMessage(plugin.color(prefix + " &aYou have sucessfully cleared the prefix of &6" + np.getName() + "&a."));
        			}
        		} else {
        			sender.sendMessage(plugin.color(prefix + " &cUsage&7: /clearprefix <player>"));
        		}
        	} else {
        	Player p = (Player) sender;
        	if(p.hasPermission("deluxetabs.clearprefix")) {
        		if(args.length == 1) {
        			Player np = Bukkit.getPlayer(args[0]);
        			if(np == null) {
        				p.sendMessage(plugin.color(prefix + " &cIt appears that the target player is not online."));
        			} else {
        				UUID u = np.getUniqueId();
        				File pf = new File(plugin.getDataFolder() + File.separator + "players" + File.separator + u + ".yml");
        				FileConfiguration conf = YamlConfiguration.loadConfiguration(pf);
        				conf.set("custom-prefix", false);
        				conf.set("current-prefix", "");
        				try {
							conf.save(pf);
						} catch (IOException e) {
							e.printStackTrace();
						}
        				String final1 = DeluxeTabs.getChat().getPlayerPrefix(np);
        				np.setPlayerListName(plugin.color(final1 + " &7" + np.getName()));
        				p.sendMessage(plugin.color(prefix + " &aYou have sucessfully cleared the prefix of &6" + np.getName() + "&a."));
        			}
        		} else {
        			p.sendMessage(plugin.color(prefix + " &cUsage&7: /clearprefix <player>"));
        		}
        	} else {
        		p.sendMessage(plugin.color(prefix + " &cYou do not have permission to use this command."));
        	}
        	}
    }
    return true;
}
}
