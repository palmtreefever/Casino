package com.palmtreefever.Casino.commands;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.palmtreefever.Casino.utils.Messages;


public class CommandHandler  implements CommandExecutor {
 
    private static HashMap<String, CommandInterface> commands = new HashMap<String, CommandInterface>();

    public void register(String name, CommandInterface cmd) {
		commands.put(name, cmd);
	}

    public boolean exists(String name) {
		return commands.containsKey(name);
	}

    public CommandInterface getExecutor(String name) {
		return commands.get(name);
	}
 
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
 
        if(sender instanceof Player) {
            if(args.length == 0) {
                getExecutor("casino").onCommand(sender, cmd, msg, args);
				return true;
			}

            if(args.length > 0) {
                if(exists(args[0])){
                    getExecutor(args[0]).onCommand(sender, cmd, msg, args);
					return true;
				} else {
                    sender.sendMessage(Messages.UNKNOWN_CMD_ERROR.getRaw());
					return true;
				}
			}
		} else {
			sender.sendMessage(Messages.NOT_PLAYER_CMD_ERROR.getRaw());
			return true;
		}
		return false;
	}
}