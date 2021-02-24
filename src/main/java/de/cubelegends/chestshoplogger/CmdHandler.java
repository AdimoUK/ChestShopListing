package de.cubelegends.chestshoplogger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.cubelegends.chestshoplogger.managers.ShopManager;
import java.util.Arrays;
import java.util.logging.Logger;
import org.apache.commons.lang.ArrayUtils;
import org.bukkit.Bukkit;

public class CmdHandler implements CommandExecutor {
    
        private Logger log = Bukkit.getLogger();
	private ChestShopLogger plugin;
	
	public CmdHandler(ChestShopLogger plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		ShopManager sm = new ShopManager(plugin);
		
		if(sender instanceof Player) {
			
			Player player = (Player) sender;
			
			if(args.length == 2 && args[0].equalsIgnoreCase("tp")) {
				sm.tp(player, args[1]);
				return true;			
			}
			
		}
		
		if(args.length == 2 && args[0].equalsIgnoreCase("coords")) {
			sm.coords(sender, args[1]);
			return true;			
		}
		               
                if(args.length >= 3 && args[0].equalsIgnoreCase("find")) {
                    String[] matIn = args;
                    matIn = (String[]) ArrayUtils.remove(matIn, 0);
                    matIn = (String[]) ArrayUtils.remove(matIn, 0);
                    String matOut = Arrays.toString(matIn).replaceAll("[,\\[\\]]", "");
                                       
                    sm.find(sender, args[1], matOut);
                    return true;
                }

        help(sender);
		return true;
	}

    private void help(CommandSender sender) {

        if(sender.hasPermission("chestshoplogger.find")) {
            sender.sendMessage(ChatColor.GREEN + "/shop find buy <item> " + ChatColor.GRAY + "- Search for buyable items");
            sender.sendMessage(ChatColor.GREEN + "/shop find sell <item> " + ChatColor.GRAY + "- Search for sellable items");
            sender.sendMessage(ChatColor.GREEN + "/shop find player <player> " + ChatColor.GRAY + "- Search for player shops");
        }

        if(sender.hasPermission("chestshoplogger.tp")) {
            sender.sendMessage(ChatColor.GREEN + "/shop tp <id> " + ChatColor.GRAY + "- Teleport to a shop");
        }

        if(sender.hasPermission("chestshoplogger.coords")) {
            sender.sendMessage(ChatColor.GREEN + "/shop coords <id> " + ChatColor.GRAY + "- Display coordinates of a shop");
        }

    }

}
