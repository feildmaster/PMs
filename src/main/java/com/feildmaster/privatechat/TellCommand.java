package com.feildmaster.privatechat;

import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class TellCommand implements CommandExecutor {
    private Plugin plugin;

    public TellCommand(Plugin p) {
        plugin = p;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(args.length == 0) { // Ending conversation
            if(plugin.messaging.containsKey(sender.getName())) {
                plugin.messaging.remove(sender.getName());
            }
            return true;
        }

        int index = changeSettings(sender, args);

        if(index == -1) { // No extra arguments after settings...!
            return true;
        }

        Player p = plugin.getServer().getPlayer(args[index]); // first word is always player?
        // Store conversation *if* their settings allow it

        if(args.length == index) { // Set conversation partner
             return true;
        }

        // Send a message
        StringBuilder msg = new StringBuilder();
        for(int i = index; i < args.length; i++) {

        }

        return true;
    }

    public int changeSettings(CommandSender sender, String[] args) {
        int i;
        for(i = 0; i < args.length; i++) {
            String arg = args[i];
            if(!arg.startsWith("--")) break; // End of arguments
            if(!(sender instanceof Player)) continue; // Needs to be a player to set a setting
            // Not a valid setting? break
        }
        return i == args.length ? -1 : i;
    }
}
