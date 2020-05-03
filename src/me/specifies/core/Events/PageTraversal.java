package me.specifies.core.Events;

import java.util.Map.Entry;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import me.specifies.core.DeluxeTabs;
import me.specifies.core.Inventories.ScrollingInventory;
import me.specifies.core.PlayerData.GamePlayer;

public class PageTraversal implements Listener {
	
	DeluxeTabs plugin;
	public PageTraversal() { this.plugin = DeluxeTabs.getInstance(); }
	
	@EventHandler(ignoreCancelled = true)
	public void click(InventoryClickEvent e) {
		if(!(e.getWhoClicked() instanceof Player)) return;
		
		Player p = (Player) e.getWhoClicked();
		
		if(!ScrollingInventory.users.containsKey(p.getUniqueId())) return;
		
		ScrollingInventory state = ScrollingInventory.users.get(p.getUniqueId());
		
		
		if(e.getCurrentItem() == null) return;
		
		ItemStack item = e.getCurrentItem();
		
		if(ChatColor.stripColor(item.getItemMeta().getDisplayName()).equalsIgnoreCase("next page")) {
			
			e.setCancelled(true);
			if(state.currentPage >= state.pages.size() - 1) return;
			
			state.currentPage++;
			
			p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, 10, 29);
			
			p.openInventory(state.pages.get(state.currentPage));
			
		} else if(ChatColor.stripColor(item.getItemMeta().getDisplayName()).equalsIgnoreCase("previous page")) {
			
			e.setCancelled(true);
			
			if(state.currentPage > 0) {
				state.currentPage--;
				p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, 10, 29);
				p.openInventory(state.pages.get(state.currentPage));
			}
		} else if(item.getType() == Material.NAME_TAG) {
			e.setCancelled(true);
			
			String name = ChatColor.stripColor(item.getItemMeta().getDisplayName());
			
			for(Entry<String, String> entry : plugin.getTags().entrySet()) {
				
				// A rather hacky way of converting it lol
				String key = ChatColor.stripColor(plugin.color(entry.getKey()));
				String value = entry.getValue();
				
				if(key.equals(name)) {
					
					if(p.hasPermission(value)) {
						
						GamePlayer player = new GamePlayer(p.getName());
						
						try {
							player.setPrefix(entry.getKey());
							player.setPrefixState(true);
							
							player.update();
							
							p.sendMessage(plugin.color("&aYour prefix has been changed to&7: \"" + entry.getKey() + "\""));
							
							break;
							
						} catch(Exception err) {
							err.printStackTrace();
						}
						
					} else p.sendMessage(plugin.color("&cYou do not have permission to use the prefix &7: \"" + entry.getKey() + "\""));
					break;
					
				}
				
			}
			
		} else if(item.getType() == Material.GREEN_STAINED_GLASS_PANE) e.setCancelled(true);
		
	}

}
