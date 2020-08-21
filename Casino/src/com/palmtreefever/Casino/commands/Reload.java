package com.palmtreefever.Casino.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.palmtreefever.Casino.Main;
import com.palmtreefever.Casino.utils.Messages;

public class Reload implements CommandInterface {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if (sender.hasPermission("Casino.reload")) {
			Main.plugin.reloadConfig();
			sender.sendMessage(Messages.PREFIX.getRaw() + Messages.CONFIG_RELOAD.getRaw());
			return true;
		} else {
			return false;
		}
	}
}