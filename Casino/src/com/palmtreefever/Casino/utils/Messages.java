package com.palmtreefever.Casino.utils;

import org.bukkit.ChatColor;

public enum Messages {
	PREFIX(ChatColor.GRAY + "["+ ChatColor.GREEN + "Gamble" + ChatColor.GRAY + "] " + ChatColor.RESET),
	NO_PERMISSION(ChatColor.RED + "You do not have permission to use this command!"), //maybe change this to NO_AUTHORITY or make it seperate. probably seperate
	UNKNOWN_CMD_ERROR(ChatColor.RED + "Unknown Command!"),
	NOT_PLAYER_CMD_ERROR(ChatColor.RED + "Must be a player to use this command!"),
	HELP_FORMAT(ChatColor.RED + "/casino help"),
	RELOAD_FORMAT(ChatColor.RED + "/casino reload");
	
	private String string;

	Messages(String string) {
		this.string = string;
	}

	public String getRaw() {
		return string;
	}
}