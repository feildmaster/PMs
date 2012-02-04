package com.feildmaster.privatechat;

/**
 * Hooks into ChannelChat for /cc tell, #tell commands
 */
public class TellChannel extends com.feildmaster.channelchat.channel.CustomChannel {
    public TellChannel() {
        super("tell");
    }
}
