package me.specifies.core.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.specifies.core.PlayerData.GamePlayer;

public class SetPlayerPrefix implements Listener {
	
	@EventHandler
	public void join(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		new GamePlayer(p.getName()).update();
	}

}
