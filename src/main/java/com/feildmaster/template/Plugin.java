package com.feildmaster.template;

import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin {
    private EventListener l = new EventListener(this);

    public void onEnable() {
        getServer().getPluginManager().registerEvents(l, this);
    }

    public void onDisable() {}
}
