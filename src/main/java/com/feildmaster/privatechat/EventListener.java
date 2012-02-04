package com.feildmaster.privatechat;

import org.bukkit.entity.Player;
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
        if(!plugin.messaging.containsKey(event.getPlayer().getName())) return; // Hasn't set Recipient yet?

        event.getRecipients().clear(); // Empty List, Allows for other plugins to add in.

        String name = plugin.messaging.get(event.getPlayer().getName()); // Recipients name
        if(name == null) {
            // This shouldn't happen
            return;
        }
    }

    @EventHandler()
    public void format(PlayerChatEvent event) {
        if(event.isCancelled()) return;
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        String name = event.getPlayer().getName();
        plugin.messaging.remove(name);
        plugin.received.remove(name);
    }
}
