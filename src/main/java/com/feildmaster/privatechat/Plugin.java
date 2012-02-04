package com.feildmaster.privatechat;

import com.feildmaster.channelchat.channel.ChannelManager;
import com.feildmaster.lib.configuration.PluginWrapper;
import java.util.*;

public class Plugin extends PluginWrapper {
    protected ChannelManager manager;
    private EventListener l = new EventListener(this);
    protected Map<String, String> messaging = new HashMap<String, String>(); // Player "telling" to player
    protected Map<String, String> received = new HashMap<String, String>(); // Player received "tell" from Player

    public void onEnable() {
        if(getServer().getPluginManager().getPlugin("ChannelChat") != null) {
            manager = ChannelManager.getManager();
        }

        getServer().getPluginManager().registerEvents(l, this);
    }

    public void onDisable() {}
}
