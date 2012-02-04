package com.feildmaster.privatechat;

import com.feildmaster.lib.configuration.PluginWrapper;
import java.util.*;

public class Plugin extends PluginWrapper {
    protected boolean isChannelChatEnabled;
    protected Map<String, String> messaging = new HashMap<String, String>(); // Player "telling" to player
    protected Map<String, String> received = new HashMap<String, String>(); // Player received "tell" from Player
    private EventListener l = new EventListener(this);
    private TellCommand t = new TellCommand(this);
    //private ReplyCommand r = new ReplyCommand(this);

    public void onEnable() {
        isChannelChatEnabled = getServer().getPluginManager().getPlugin("ChannelChat") != null;

        getServer().getPluginCommand("tell").setExecutor(t);


        getServer().getPluginManager().registerEvents(l, this);
    }

    public void onDisable() {}
}
