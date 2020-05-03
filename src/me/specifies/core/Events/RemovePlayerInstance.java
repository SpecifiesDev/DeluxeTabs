package me.specifies.core.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import me.specifies.core.Inventories.ScrollingInventory;

public class RemovePlayerInstance implements Listener {
	
	@EventHandler
	public void leave(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		
		if(ScrollingInventory.users.containsKey(p.getUniqueId())) ScrollingInventory.users.remove(p.getUniqueId());
	}

}
