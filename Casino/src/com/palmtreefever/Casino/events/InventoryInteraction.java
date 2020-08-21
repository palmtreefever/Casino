package com.palmtreefever.Casino.events;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import com.palmtreefever.Casino.Main;

public class InventoryInteraction implements Listener {
	
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
    	String sName = Main.plugin.getConfig().getString("ServerPrefix");
    	String lose = Main.plugin.getConfig().getString("LostWool");
    	String win = Main.plugin.getConfig().getString("WinWool");
    	int woolPayout = Main.plugin.getConfig().getInt("WoolPayout");
        final Player p = (Player)e.getWhoClicked();
        final ItemStack clicked = e.getCurrentItem();
        if (e.getView().getTitle().equals(ChatColor.LIGHT_PURPLE + "Wool Flip")) {
        	
        	if(clicked != null && clicked.getType() != Material.AIR) {
        	
        	if(!e.getClickedInventory().equals(e.getView().getTopInventory())) {
        		e.setCancelled(true);
        		return;
        	}
        	if(clicked.getType() == Material.RED_STAINED_GLASS_PANE || clicked.getType() == Material.BLUE_STAINED_GLASS_PANE
        			|| !clicked.getType().isItem()) {
					e.setCancelled(true);
					return;
				}
                final Random r = new Random();
                final int choice = r.nextInt(5);
				// 0=C,1=L,2=O, 3=M,4=Y
                System.out.println(choice);
                if (choice == 0 && clicked.getType() == Material.CYAN_WOOL) {
					p.sendMessage((ChatColor.translateAlternateColorCodes('&',sName + ChatColor.GREEN + win+ ChatColor.AQUA + 
							woolPayout)));
					Main.addMoney(p, woolPayout);
				}
                else if (choice == 1 && clicked.getType() == Material.LIME_WOOL) {
					p.sendMessage((ChatColor.translateAlternateColorCodes('&',sName + ChatColor.GREEN + win+ ChatColor.AQUA + 
							woolPayout)));
					Main.addMoney(p, woolPayout);
				} else if (choice == 2 && clicked.getType() == Material.ORANGE_WOOL) {
					p.sendMessage((ChatColor.translateAlternateColorCodes('&',sName + ChatColor.GREEN + win + ChatColor.AQUA + 
							woolPayout)));
					Main.addMoney(p, woolPayout);
				} else if (choice == 3 && clicked.getType() == Material.MAGENTA_WOOL) {
					p.sendMessage((ChatColor.translateAlternateColorCodes('&',sName + ChatColor.GREEN + win + ChatColor.AQUA + 
							woolPayout)));
					Main.addMoney(p, woolPayout);
				}else if (choice == 4 && clicked.getType() == Material.YELLOW_WOOL) {
					p.sendMessage((ChatColor.translateAlternateColorCodes('&',sName + ChatColor.GREEN + win + ChatColor.AQUA + 
							woolPayout)));
					Main.addMoney(p, woolPayout);
				}
				else {
					p.sendMessage((ChatColor.translateAlternateColorCodes('&',sName + ChatColor.RED + lose)));
					//System.out.println(clicked.getType());
				}
				p.closeInventory();
				e.setCancelled(true);
			} else {
				return;
			}
        }
	}
}