package com.palmtreefever.Casino.commands;

import java.util.Arrays;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.palmtreefever.Casino.Main;

public class Wool implements CommandInterface {
	
	String sName = Main.plugin.getConfig().getString("ServerPrefix");
	int woolCost = Main.plugin.getConfig().getInt("WoolCost");
	String insuffFunds = Main.plugin.getConfig().getString("CantGamble");

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if (sender.hasPermission("Gamble.wool")) {
			Player player = (Player) sender;
			Player senderO = (Player) sender;
			if(Main.hasEnough(senderO, woolCost)) {
				sender.sendMessage((ChatColor.translateAlternateColorCodes('&',sName + ChatColor.YELLOW + " You have spent " + ChatColor.AQUA + 
						woolCost + ChatColor.YELLOW + " to gamble on wool colors!")));
				Main.withdrawMoney(senderO, woolCost);
				player.openInventory(createInventory_2());
				return true;
			} else {
			sender.sendMessage((ChatColor.translateAlternateColorCodes('&',sName + " " + insuffFunds)));
				return true;
			}
		}
		return false;
	}
	
	@SuppressWarnings("deprecation")
	public Inventory createInventory_2() {
		  Inventory inv = Bukkit.createInventory(null, 27, "§dWool Flip");
		  ItemStack item0 = new ItemStack(Material.RED_STAINED_GLASS_PANE, 1, (short)14);
		    ItemMeta im0 = item0.getItemMeta();
		      im0.setDisplayName(ChatColor.translateAlternateColorCodes('&', sName));
		    item0.setItemMeta(im0);;
		  ItemStack item1 = new ItemStack(Material.BLUE_STAINED_GLASS_PANE, 1, (short)11);
		    ItemMeta im1 = item1.getItemMeta();
		      im1.setDisplayName("§9Gamble");
		    item1.setItemMeta(im1);;
		  ItemStack item2 = new ItemStack(Material.LIME_WOOL, 1, (short)5);
		    ItemMeta im2 = item2.getItemMeta();
		      im2.setDisplayName("§aGreen");
		      im2.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', "§cClick to bet §b" + woolCost + " §con §aGreen!")));
		    item2.setItemMeta(im2);;
		  ItemStack item3 = new ItemStack(Material.ORANGE_WOOL, 1, (short)1);
		    ItemMeta im3 = item3.getItemMeta();
		      im3.setDisplayName("§6Orange");
		      im3.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', "§cClick to bet §b" + woolCost + " §con §6Orange!")));
		    item3.setItemMeta(im3);;
		  ItemStack item4 = new ItemStack(Material.MAGENTA_WOOL, 1, (short)2);
		    ItemMeta im4 = item4.getItemMeta();
		      im4.setDisplayName("§5Magenta");
		      im4.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', "§cClick to bet §b" + woolCost + " §con §5Magenta!")));
		    item4.setItemMeta(im4);;
		  for(int i : Arrays.asList(0,2,4,6,8,10,16,18,20,22,24,26)) {
		    inv.setItem(i, item0);
		  }
		  for(int i : Arrays.asList(1,3,5,7,9,11,15,17,19,21,23,25)) {
		    inv.setItem(i, item1);
		  }
		inv.setItem(14, item4);
		inv.setItem(13, item3);
		inv.setItem(12, item2);
		return inv;
	}
}