package com.feildmaster.privatechat;

import org.bukkit.command.*;

public class ReplyCommand implements CommandExecutor {
    private final Plugin plugin;

    public ReplyCommand(Plugin p) {
        plugin = p;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        return true;
    }
}
