package com.palmtreefever.Casino;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import com.palmtreefever.Casino.commands.CommandHandler;
import com.palmtreefever.Casino.commands.Casino;
import com.palmtreefever.Casino.commands.Wool;
import com.palmtreefever.Casino.events.InventoryInteraction;

public class Main extends JavaPlugin implements Listener {

	public static Plugin plugin; // TODO: Developed by palmtreefever#2614

	public static Economy econ;

	public void onEnable() {
		plugin = this;
		loadVault();// If it is null, listen for PluginLoadEvent and detect vault
		this.registerCommands();
		 Bukkit.getPluginManager().registerEvents(new InventoryInteraction(), this);
		if (!getDataFolder().exists()) {
			getDataFolder().mkdirs();
			saveResource("casino.yml", false);
		}
		loadConfig();// config.yml
	}

	public void onDisable() {
		saveDefaultConfig(); // config that owners can edit
	}

	private boolean loadVault() {
		if (!this.setupEconomy()) {
			Bukkit.getConsoleSender().sendMessage("\u00a7b\u00a7l[Gamble] No Economy found, using command");
			return false;
		}
		Bukkit.getConsoleSender().sendMessage("\u00a7b\u00a7l[Gamble] Economy found, hooking.");
		return true;
	}

	private void loadConfig() { // config.yml
		getConfig().options().copyDefaults(true);
		saveDefaultConfig();
	}
	
	public void registerCommands() {
        CommandHandler handler = new CommandHandler();
        handler.register("casino", new Casino());
        handler.register("wool", new Wool());
		getCommand("casino").setExecutor(handler);
	}

	private boolean setupEconomy() {
		if (this.getServer().getPluginManager().getPlugin("Vault") == null) {
			return false;
		}
		final RegisteredServiceProvider<Economy> rsp = this.getServer().getServicesManager().getRegistration(Economy.class);
		if (rsp == null) {
			return false;
		}
		econ = rsp.getProvider();
		return econ != null;
	}

	public static void addMoney(OfflinePlayer p, double amount) {
		if (econ != null) {
			econ.depositPlayer(p, amount);
		}
	}

	public static void withdrawMoney(OfflinePlayer p, double amount) {
		if (econ != null) {
			econ.withdrawPlayer(p, amount);
		}
	}

	public static double getMoney(OfflinePlayer p) {
		if (econ != null) {
			return econ.getBalance(p);
		}
		return 0;
	}

	public static boolean hasEnough(OfflinePlayer p, double amount) {
		if (econ != null) {
			return econ.has(p, amount);
		}
		return false;
	}

}