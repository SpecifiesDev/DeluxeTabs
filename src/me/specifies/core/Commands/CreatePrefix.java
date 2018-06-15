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
public class CreatePrefix implements CommandExecutor{
	DeluxeTabs plugin;
	public CreatePrefix(DeluxeTabs instance) {
		this.plugin = instance;
	}
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	String gtitle = plugin.getConfig().getString("command-prefix");
    	int charlimit = plugin.getConfig().getInt("character-limit");
    	String charstring = Integer.toString(charlimit);
    	if(cmd.getName().equalsIgnoreCase("setprefix")) {
    		if(!(sender instanceof Player)) {
    			if(args.length == 2) {
    				String pn = args[0].toString();
    				Player player = Bukkit.getPlayer(pn);
    				if(player == null) {
    					sender.sendMessage(plugin.color(gtitle + " &cIt appears that the target player is not online."));
    				}
    				else {
        				UUID u = player.getUniqueId();
        				File pf = new File(plugin.getDataFolder() + File.separator + "players" + File.separator + u + ".yml");
        				FileConfiguration conf = YamlConfiguration.loadConfiguration(pf);
    					String arg1 = args[1].toString();
    					if(arg1.length() > charlimit) {
    					sender.sendMessage(plugin.color(gtitle + " &cIt appears that the prefix you have entered exceeds the maximum character limit of &6" + charstring + "&c."));	
    					} else {
    					sender.sendMessage(plugin.color(gtitle + " &7The prefix of the player &6" + pn + " &7has been set to " + arg1));
    					player.setPlayerListName(plugin.color(arg1 + " &7" + player.getName()));
    					conf.set("current-prefix", arg1);
    					conf.set("custom-prefix", true);
    					try {
							conf.save(pf);
						} catch (IOException e) {
							e.printStackTrace();
						}
    				}
    				}
    			} else {
    				sender.sendMessage(plugin.color(gtitle + " &cUsage: /setprefix <player> <prefix>"));
    			}
    		} else {
    	    	Player p = (Player) sender;
    		if(p.hasPermission("deluxetabs.setprefix")) {
    			if(args.length == 2) {
    				String pn = args[0].toString();
    				Player player = Bukkit.getPlayer(pn);
    				if(player == null) {
    					p.sendMessage(plugin.color(gtitle + " &cIt appears that the target player is not online."));
    				}
    				else {
        				UUID u = player.getUniqueId();
        				File pf = new File(plugin.getDataFolder() + File.separator + "players" + File.separator + u + ".yml");
        				FileConfiguration conf = YamlConfiguration.loadConfiguration(pf);
    					String arg1 = args[1].toString();
    					if(arg1.length() > charlimit) {
    						p.sendMessage(plugin.color(gtitle + " &cIt appears the prefix you have entered exceeds the maximum character limit of &6" + charstring + "&c."));
    					} else {
    					p.sendMessage(plugin.color(gtitle + " &7The prefix of the player &6" + pn + " &7has been set to " + arg1));
    					player.setPlayerListName(plugin.color(arg1 + " &7" + player.getName()));
    					conf.set("current-prefix", arg1);
    					conf.set("custom-prefix", true);
    					try {
							conf.save(pf);
						} catch (IOException e) {
							e.printStackTrace();
						}
    				}
    				}
    			}
    			else {
    				p.sendMessage(plugin.color(gtitle + " &cUsage: /setprefix <player> <prefix>"));
    			}
    		} else {
    			p.sendMessage(plugin.color(gtitle + " &cIt appears you do not have access to this command."));
    		}
    	}
    	}
        return true;
    }
}
