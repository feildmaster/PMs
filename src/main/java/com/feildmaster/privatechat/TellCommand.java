package com.feildmaster.privatechat;

import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class TellCommand implements CommandExecutor {
    private final Plugin plugin;

    public TellCommand(Plugin p) {
        plugin = p;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(args.length == 0) { // Ending conversation
            if(plugin.messaging.containsKey(sender.getName())) {
                
            }
            return true;
        }

        if(args[0].startsWith("?")) { // These are custom settings!
            changeSettings(sender, args);
        } else {
            Player p = plugin.getServer().getPlayer(args[0]); // first word is always player?
            // Store conversation *if* their settings allow it
            
            if(args.length > 1) { // Send a message
            }
        }

        return true;
    }

    public void changeSettings(CommandSender sender, String[] args) {
        if(!(sender instanceof Player)) {
            // Needs to be a player to set settings
            return;
        }
    }
}
