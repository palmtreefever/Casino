package com.palmtreefever.Casino.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.palmtreefever.Casino.utils.Commands;
import com.palmtreefever.Casino.utils.Messages;

public class Help implements CommandInterface {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if (sender.hasPermission("Casino.help")) {
			if (args.length == 1) { // /casino help
				Commands.CommandList(sender);
				return true;
			}/* else if(args.length == 2 && args[1].matches("2")) { // /casino help 2
				Commands.CommandList2(sender);
				return true;
			}else if(args.length == 2 && args[1].matches("3")) { // /casino help 3
				Commands.CommandList3(sender);
				return true;
			}*/
			else {
				sender.sendMessage(Messages.PREFIX.getRaw()+ Messages.HELP_FORMAT.getRaw());
				return true;
			}
		}
		sender.sendMessage(Messages.PREFIX.getRaw()+ Messages.NO_PERMISSION.getRaw());
		return false;
	}
}