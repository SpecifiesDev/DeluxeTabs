package me.specifies.core.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.specifies.core.DeluxeTabs;
import me.specifies.core.PlayerData.GamePlayer;

public class ClearPrefix implements CommandExecutor {
	
	DeluxeTabs plugin;
	public ClearPrefix() {
		this.plugin = DeluxeTabs.getInstance();
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			
			Player p = (Player) sender;
			
			if(args.length == 0) {
				
				if(p.hasPermission("deluxetabs.clear.self")) {
					new GamePlayer(p.getName()).clear();
					p.sendMessage(plugin.color("&aYour prefix has been cleared"));
				} else p.sendMessage(plugin.color("&cYou do not have permission to clear the prefix of yourself."));
				
			} else {
				
				if(p.hasPermission("deluxetabs.clear.others")) {
					
					Player target = Bukkit.getPlayer(args[0]);
					if(!(target == null)) {
						
						new GamePlayer(args[0]).clear();
						p.sendMessage(plugin.color("&aThe prefix of &6" + args[0] + " &abeen cleared."));
						
					} else p.sendMessage(plugin.color("&cYou may only clear the prefix of a player that is currently online."));
					
				} else p.sendMessage(plugin.color("&cYou do not permission to clear the prefix of other players."));
				
				
				
			}
			
			
		} else {
			if(args.length == 0) sender.sendMessage(plugin.color("&cThe console can only clear the prefix of another player."));
			else {
				
				Player target = Bukkit.getPlayer(args[0]);
				
				if(!(target == null)) {
					
					GamePlayer player = new GamePlayer(args[0]);
					
					player.clear();
					
					sender.sendMessage(plugin.color("&aThe player's prefix has been cleared."));
					
				} else sender.sendMessage(plugin.color("&cYou may only clear the prefix of an online player."));
				
			}
		}
		
		return true;
	}

}
