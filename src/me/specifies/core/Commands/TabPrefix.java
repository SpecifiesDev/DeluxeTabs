package me.specifies.core.Commands;

import java.util.ArrayList;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.specifies.core.DeluxeTabs;
import me.specifies.core.Helpers.HelpHelper;
import me.specifies.core.Inventories.ScrollingInventory;

public class TabPrefix implements CommandExecutor {
	
	private DeluxeTabs plugin;
	
	public TabPrefix() {
		this.plugin = DeluxeTabs.getInstance();
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			
			Player p = (Player) sender;
			
			if(args.length == 1) {
				
				if(args[0].equalsIgnoreCase("help")) new HelpHelper(p).send();
				
			} else {
				
				if(p.hasPermission("deluxetabs.tabprefix")) {
					
					
					ArrayList<ItemStack> tags = new ArrayList<ItemStack>();
					
					for(Map.Entry<String, String> entry : this.plugin.getTags().entrySet()) {
						
						String name = entry.getKey();
						
						ItemStack item = new ItemStack(Material.NAME_TAG, 1);
						ItemMeta im = item.getItemMeta();
						im.setDisplayName(plugin.color(name));
						item.setItemMeta(im);
						
						tags.add(item);
						
						
					}
					
					new ScrollingInventory(tags, this.plugin.getConfig().getString("gui-prefix"), p);
					
					
				} else p.sendMessage(plugin.color("&cYou do not have permission to use this command."));
				
			}
			
			
		} else sender.sendMessage(plugin.color("&cYou must be a player to use this command."));
		return true;
	}

}
