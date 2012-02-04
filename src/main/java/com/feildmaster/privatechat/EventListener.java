package com.feildmaster.privatechat;

import org.bukkit.event.*;
import org.bukkit.event.player.*;

public class EventListener implements Listener {
    private final Plugin plugin;

    public EventListener(Plugin p) {
        plugin = p;
    }

    @EventHandler(priority = EventPriority.LOWEST)
    // Hook to modify recipients
    public void onChat(PlayerChatEvent event) {
        if(event.isCancelled()) return; // Canceled Event?

        String name = plugin.messaging.get(event.getPlayer().getName()); // Recipients name
        String message = event.getMessage();

        // Check for @[player]
        if(message.startsWith("@")) {
            String[] parts = message.split(" ", 2);
            if(parts.length != 2) { // Please include a message!
                return;
            }

            message = parts[1]; // Use provided message

            if(parts[0].length() > 1) { // Use provided name
                name = parts[0].substring(1);
            }
        }

        if(name == null) { // This "shouldn't" happen... Needs testing
            return;
        }

        if (event.getPlayer().performCommand("tell "+name+" "+message)) { // Send this chat as a command!
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        String name = event.getPlayer().getName();
        plugin.messaging.remove(name);
        plugin.received.remove(name);
    }
}
