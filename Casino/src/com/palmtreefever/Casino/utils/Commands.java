package com.palmtreefever.Casino.utils;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class Commands {
	static String playerWHITE = ChatColor.WHITE + "player" + ChatColor.YELLOW;
	static String gambleWHITE = ChatColor.WHITE + "casino" + ChatColor.YELLOW;
	
	public static void CommandList(CommandSender sender) {
		sender.sendMessage(Messages.PREFIX.getRaw() + ChatColor.BLUE + "--------" + ChatColor.GRAY + "{" + ChatColor.GOLD + "Casino" + ChatColor.GRAY + "}" + ChatColor.BLUE + "----------");
	    sender.sendMessage(Messages.PREFIX.getRaw() + ChatColor.YELLOW + " /casino wool");
	    sender.sendMessage(Messages.PREFIX.getRaw() + ChatColor.YELLOW + " /casino reload");
//	    sender.sendMessage(Messages.PREFIX.getRaw() + ChatColor.YELLOW + " /casino disband");
//	    sender.sendMessage(Messages.PREFIX.getRaw() + ChatColor.YELLOW + " /casino leave");
//	    sender.sendMessage(Messages.PREFIX.getRaw() + ChatColor.YELLOW + " /casino invite <" + playerWHITE + ">");
//	    sender.sendMessage(Messages.PREFIX.getRaw() + ChatColor.YELLOW + " /casino join <" + casinoWHITE + ">");
//	    sender.sendMessage(Messages.PREFIX.getRaw() + ChatColor.YELLOW + " /casino kick <" + playerWHITE + ">");
//	    sender.sendMessage(Messages.PREFIX.getRaw() + ChatColor.YELLOW + " /casino enemy <" + casinoWHITE + ">");
//	    sender.sendMessage(Messages.PREFIX.getRaw() + ChatColor.YELLOW + " /casino ally <" + casinoWHITE + ">");
//	    sender.sendMessage(Messages.PREFIX.getRaw() + ChatColor.YELLOW + " /casino neutral <" + casinoWHITE + ">");
//	    sender.sendMessage(Messages.PREFIX.getRaw() + ChatColor.YELLOW + " /casino info <" + casinoWHITE + ">");
//	    sender.sendMessage(Messages.PREFIX.getRaw() + ChatColor.YELLOW + " /casino help #1-3");
        sender.sendMessage(Messages.PREFIX.getRaw() + ChatColor.BLUE + "--------" + ChatColor.GRAY + "{" + ChatColor.GOLD + "Page 1" + ChatColor.GRAY + "}" + ChatColor.BLUE + "---------");
	}
}