package com.relaxingleg;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.events.user.update.UserUpdateOnlineStatusEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
//all methods cant be overridden directly, some require gateway intent while accessing personal and sensitive info
public class Listeners extends ListenerAdapter {
    // Sending a message whenever ready
    @Override
    public void onMessageReactionAdd(@NotNull MessageReactionAddEvent event) {
        JDA jda = event.getJDA();
        TextChannel channel = jda.getTextChannelById("1112806385906888768");
        User user = event.getUser();
        String jumpLink = event.getJumpUrl();
        String emoji = event.getReaction().getEmoji().getAsReactionCode();
        String channel1 = event.getChannel().getAsMention();

        String message = user.getAsTag() + " reacted to a [message]("+jumpLink+") with " + emoji + " in the " + channel + " channel!";
        channel.sendMessage(message).queue();
    }
    @Override
    public void onReady(@NotNull ReadyEvent event)
    {
        JDA jda = event.getJDA();
        TextChannel channel = jda.getTextChannelById("1112806385906888768");
        if (channel != null) {
            channel.sendMessage("Bot is ready!").queue();
        }
    }
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        JDA jda = event.getJDA();
        String message = event.getMessage().getContentRaw();
        TextChannel channel = jda.getTextChannelById("1112806385906888768");
        if (!event.getAuthor().isBot() && channel != null && !message.isEmpty()) {
            channel.sendMessage("the message u wrote is "+message).queue();
        }
    }
    @Override
    public void onUserUpdateOnlineStatus(@NotNull UserUpdateOnlineStatusEvent event) {
        JDA jda = event.getJDA();
        int onlineMembers = 0;
        for (Member member : event.getGuild().getMembers()) {
            if (member.getOnlineStatus() == OnlineStatus.ONLINE) {
                onlineMembers++;
            }
        }
        String message = event.getUser().getAsTag()+"updated their online status! There are "+onlineMembers+" members online now!";
        TextChannel channel = jda.getTextChannelById("1112806385906888768");
        channel.sendMessage("no of members online is"+onlineMembers).queue();
    }
}
// Text Channels: Text channels are the standard channels for text-based communication. They are used for general discussions, specific topics, announcements, and more.
// Voice Channels: Voice channels are used for real-time voice communication. They allow users to join and participate in voice conversations with other members of the server.
// Announcement Channels: Announcement channels are specialized text channels designed for important announcements within a server. Only server administrators and users with specific permissions can send messages in these channels.
// Category Channels: Category channels are used to group related channels together. They provide a way to organize and structure a server's channels into different categories.
// Store Channels: Store channels are channels where server owners can promote and sell game-related merchandise, such as game keys, DLCs, or merchandise.
// News Channels: News channels are channels that can be connected to external sources, such as RSS feeds or Twitter accounts, to automatically display news or updates within the channel.
// Stage Channels: Stage channels are designed for structured discussions or presentations. They have a designated speaker area and audience members who can listen and participate.
// Thread Channels: Thread channels allow for separate discussion threads within a text channel. They help organize conversations and reduce clutter in busy channe


