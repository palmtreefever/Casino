package com.palmtreefever.Casino.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.palmtreefever.Casino.utils.Commands;
import com.palmtreefever.Casino.utils.Messages;

public class Casino implements CommandInterface {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if (cmd.getName().equalsIgnoreCase("casino")) {
			if (sender.hasPermission("Casino.casino")) {
				Commands.CommandList(sender);
				return true;
			}
			sender.sendMessage(Messages.PREFIX.toString() + Messages.NO_PERMISSION.toString());
		}
		return false;
	}
}