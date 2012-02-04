package com.feildmaster.privatechat;

import org.bukkit.command.CommandSender;
import org.bukkit.event.*;

public class PersonalMessageEvent extends Event {
    private final CommandSender s, r;
    private final String m;

    public PersonalMessageEvent(CommandSender sender, CommandSender receiver, String message) {
        s = sender;
        r = receiver;
        m = message;
    }

    public CommandSender getSender() {
        return s;
    }

    public CommandSender getReceiver() {
        return r;
    }

    public String getMessage() {
        return m;
    }

    private static final HandlerList handlers = new HandlerList();
    public HandlerList getHandlers() {
        return handlers;
    }
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
