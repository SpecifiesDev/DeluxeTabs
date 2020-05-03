package me.specifies.core.Commands;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.specifies.core.DeluxeTabs;
import me.specifies.core.PlayerData.GamePlayer;

public class SetPrefix implements CommandExecutor {
	
	DeluxeTabs plugin;
	public SetPrefix() { this.plugin = DeluxeTabs.getInstance(); }
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		
		if(sender instanceof Player) {
			
			Player p = (Player) sender;
			
			if(args.length == 0) {
				p.sendMessage("&cInvalid arguments.");
			} else if(args.length == 1) {
				
				if(p.hasPermission("deluxetabs.setprefix.self")) {
					
					if(!(args[0].length() > this.plugin.getConfig().getInt("character-limit"))) {
						
						GamePlayer player = new GamePlayer(p.getName());
						
						try {
							
							player.setPrefix(args[0]);
							player.setPrefixState(true);
							
							player.update();
							
							p.sendMessage(plugin.color("&aYour prefix has been set to &7\"" + args[0] + "&7\""));
							
						} catch(IOException err) { err.printStackTrace(); }
						
					} else p.sendMessage(plugin.color("&cThe specified prefix exceeds the maximum character limit."));
					
				} else p.sendMessage(plugin.color("&cYou do not have permission to set the prefix of yourself."));
				
			} else if(args.length == 2) {
				
				if(p.hasPermission("deluxetabs.setprefix.others")) {
					
					Player target = Bukkit.getPlayer(args[0]);
					String prefix = args[1];
					
					if(!(target == null)) {
						
						if(!(prefix.length() > this.plugin.getConfig().getInt("character-limit"))) {
							
							GamePlayer player = new GamePlayer(target.getName());
							
							try {
								
								player.setPrefix(prefix);
								player.setPrefixState(true);
								
								player.update();
								
								
								p.sendMessage(plugin.color("&aThe player's prefix has been updated."));
								
							} catch(IOException err) { err.printStackTrace(); }
							
						} else p.sendMessage(plugin.color("&cThe specified prefix eceeds the maximum character limit."));
						
					} else p.sendMessage(plugin.color("&cYou may only set the prefix of an online player."));
					
				} else p.sendMessage(plugin.color("&cYou do not have permission to set the prefix of others."));
				
			}
			
		} else {
			
			if(args.length == 0) {
				sender.sendMessage(plugin.color("&cInvalid Arguments. Usage&7: &c/setprefix <ign>"));
			} else {
				
				Player target = Bukkit.getPlayer(args[0]);
				String prefix = args[1];
				
				if(!(target == null)) {
					
					if(!(prefix.length() > this.plugin.getConfig().getInt("character-limit"))) {
						
						GamePlayer p = new GamePlayer(target.getName());
						
						try {
							p.setPrefix(prefix);
							p.setPrefixState(true);
							
							p.update();
							
							sender.sendMessage(plugin.color("&aPlayer's prefix has been updated."));
						} catch(IOException err) { err.printStackTrace(); }
						
						
					} else sender.sendMessage(plugin.color("&cThe inputted prefix exceeds the character limit specified in the configuration."));
					
				} else sender.sendMessage(plugin.color("&cYou may only set the prefix of an online player."));
				
				
			}
			
		}
		
		return true;
	}

}
