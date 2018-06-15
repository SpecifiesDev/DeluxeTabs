package me.specifies.core.Commands;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.specifies.core.DeluxeTabs;

/*  
*	Copyright (C) 2018  Specifies
*
*   This program is free software: you can redistribute it and/or modify
*   it under the terms of the GNU General Public License as published by
*   the Free Software Foundation, either version 3 of the License, or
*   (at your option) any later version.
*
*   You should have received a copy of the GNU General Public License
*   along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */


public class TabPrefix implements CommandExecutor{
	DeluxeTabs plugin;
	public TabPrefix(DeluxeTabs instance) {
		this.plugin = instance;
	}
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	String pmsg = plugin.getConfig().getString("command-prefix");
    	String ctitle = plugin.getConfig().getString("gui-prefix");
    	if(cmd.getName().equalsIgnoreCase("tabprefix")) {
    	if(args.length == 1) {	
    		if(args[0].equalsIgnoreCase("help")) {
    			if(!(sender instanceof Player)) {
    				sender.sendMessage(plugin.color(ctitle + " &cYou must be a player to use this command."));
    			} else {
    			Player help = (Player) sender;
    			help.sendMessage(plugin.color("&8&m-----------------------&7[" + ctitle + "&7]&8&m-----------------------"));
    			help.sendMessage(plugin.color("&c&l/tabprefix&7&l:"));
    			help.sendMessage(plugin.color("&bOpen up a GUI where players can toggle prefixes they have access to."));
    			help.sendMessage(plugin.color("&c&l/setprefix&7&l:"));
    			help.sendMessage(plugin.color("&bManually set the prefix of a target player."));
    			help.sendMessage(plugin.color("&c&l/clearprefix&7&l:"));
    			help.sendMessage(plugin.color("&bManually clear the prefix of a target player."));
    			}
    		}
    	} else {	
    		
    		
        	if(!(sender instanceof Player)) {
        		plugin.message(plugin.color(pmsg + "&cYou must be a player to use this command."));
        	} else {
        	Player p = (Player) sender;
        	String gtitle = plugin.getConfig().getString("gui-prefix");
        	String fgtitle = plugin.color(gtitle);
    		if(p.hasPermission("deluxtabs.tabprefix")) {
    			p.sendMessage(plugin.color(pmsg + " &7Opening prefix GUI."));;
    			createGui(p, 45, fgtitle);
    		} 
    		else {
    			p.sendMessage(plugin.color(pmsg + " &7It appears you do not have access to this command."));
    		}
    	}
    	}
    }
        return true;
    }
    public void createGui(Player p, int slots, String prefix) {
    	UUID u = p.getUniqueId();
		File pf = new File(plugin.getDataFolder() + File.separator + "players" + File.separator + u + ".yml");
		FileConfiguration conf = YamlConfiguration.loadConfiguration(pf);
    	
    	Inventory inv = Bukkit.createInventory(null, slots, prefix);
    	ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 15);
    	ItemMeta gm = glass.getItemMeta();
    	gm.setDisplayName(plugin.color("&9"));
    	glass.setItemMeta(gm);
    	
    	ItemStack quit = new ItemStack(Material.STAINED_CLAY, 1, (byte) 14);
    	ItemMeta qm = quit.getItemMeta();
    	qm.setDisplayName(plugin.color("&c&lEXIT"));
    	ArrayList<String> lore = new ArrayList<String>();
    	lore.add(plugin.color("&cClick me to exit the GUI."));
    	qm.setLore(lore);
    	quit.setItemMeta(qm);
    	
    	ItemStack enabled = new ItemStack(Material.PAPER, 1);
    	ItemMeta em = enabled.getItemMeta();
    	em.setDisplayName(plugin.color("&a&lToggle Prefix"));
    	boolean bc = conf.getBoolean("custom-prefix");
    	ArrayList<String> loreb = new ArrayList<String>();
    	if(bc == true) {
    		loreb.add(plugin.color("&7Prefix Enabled&8: &aTrue"));
    	}
    	if(bc == false) {
    		loreb.add(plugin.color("&7Prefix Enabled&8: &cFalse"));
    	}
    	em.setLore(loreb);
    	enabled.setItemMeta(em);
    	
		File pre = new File(plugin.getDataFolder() + File.separator + "prefixes" + File.separator + "prefixes.yml");
		FileConfiguration preconf = YamlConfiguration.loadConfiguration(pre);
		
		ItemStack item1 = newItem(plugin.color(preconf.getString("Prefix1")), Material.NAME_TAG, 1);
    	ItemStack item2 = newItem(plugin.color(preconf.getString("Prefix2")), Material.NAME_TAG, 1);
    	ItemStack item3 = newItem(plugin.color(preconf.getString("Prefix3")), Material.NAME_TAG, 1);
    	ItemStack item4 = newItem(plugin.color(preconf.getString("Prefix4")), Material.NAME_TAG, 1);
    	ItemStack item5 = newItem(plugin.color(preconf.getString("Prefix5")), Material.NAME_TAG, 1);
    	ItemStack item6 = newItem(plugin.color(preconf.getString("Prefix6")), Material.NAME_TAG, 1);
    	ItemStack item7 = newItem(plugin.color(preconf.getString("Prefix7")), Material.NAME_TAG, 1);
    	//row 1
    	ItemStack item8 = newItem(plugin.color(preconf.getString("Prefix8")), Material.NAME_TAG, 1);
    	ItemStack item9 = newItem(plugin.color(preconf.getString("Prefix9")), Material.NAME_TAG, 1);
    	ItemStack item10 = newItem(plugin.color(preconf.getString("Prefix10")), Material.NAME_TAG, 1);
    	ItemStack item11 = newItem(plugin.color(preconf.getString("Prefix11")), Material.NAME_TAG, 1);
    	ItemStack item12 = newItem(plugin.color(preconf.getString("Prefix12")), Material.NAME_TAG, 1);
    	ItemStack item13 = newItem(plugin.color(preconf.getString("Prefix13")), Material.NAME_TAG, 1);
    	ItemStack item14 = newItem(plugin.color(preconf.getString("Prefix14")), Material.NAME_TAG, 1);
    	//row2
    	ItemStack item15 = newItem(plugin.color(preconf.getString("Prefix15")), Material.NAME_TAG, 1);
    	ItemStack item16 = newItem(plugin.color(preconf.getString("Prefix16")), Material.NAME_TAG, 1);
    	ItemStack item17 = newItem(plugin.color(preconf.getString("Prefix17")), Material.NAME_TAG, 1);
    	ItemStack item18 = newItem(plugin.color(preconf.getString("Prefix18")), Material.NAME_TAG, 1);
    	ItemStack item19 = newItem(plugin.color(preconf.getString("Prefix19")), Material.NAME_TAG, 1);
    	ItemStack item20 = newItem(plugin.color(preconf.getString("Prefix21")), Material.NAME_TAG, 1);
    	ItemStack item21 = newItem(plugin.color(preconf.getString("Prefix22")), Material.NAME_TAG, 1);
    	int i;
    	for(i = 0; i < 9; i++) {
    		inv.setItem(i, glass);
    	}
    	inv.setItem(9, glass);
    	inv.setItem(10, item1);
    	inv.setItem(11, item2);
    	inv.setItem(12, item3);
    	inv.setItem(13, item4);
    	inv.setItem(14, item5);
    	inv.setItem(15, item6);
    	inv.setItem(16, item7);
    	inv.setItem(17, glass);
    	inv.setItem(18, glass);
    	inv.setItem(19, item8);
    	inv.setItem(20, item9);
    	inv.setItem(21, item10);
    	inv.setItem(22, item11);
    	inv.setItem(23, item12);
    	inv.setItem(24, item13);
    	inv.setItem(25, item14);
    	inv.setItem(26, glass);
    	inv.setItem(27, glass);
    	inv.setItem(28, item15);
    	inv.setItem(29, item16);
    	inv.setItem(30, item17);
    	inv.setItem(31, item18);
    	inv.setItem(32, item19);
    	inv.setItem(33, item20);
    	inv.setItem(34, item21);
    	inv.setItem(35, glass);
    	inv.setItem(36, glass);
    	inv.setItem(37, glass);
    	inv.setItem(38, glass);
    	inv.setItem(39, quit);
    	inv.setItem(40, glass);
    	inv.setItem(41, enabled);
    	inv.setItem(42, glass);
    	inv.setItem(43, glass);
    	inv.setItem(44, glass);
    	p.openInventory(inv);
    }
    
    public ItemStack newItem(String name, Material m, int amount) {
    	ItemStack ne = new ItemStack(m, amount);
    	ItemMeta nem = ne.getItemMeta();
    	nem.setDisplayName(plugin.color(name));
    	ne.setItemMeta(nem);
    	return ne;
    }

}
