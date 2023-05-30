package com.relaxingleg.commands;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;

public class commands extends ListenerAdapter
{
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
         String command=event.getName();
         if(command.equals("welcome")) {
             String userTag = event.getUser().getAsTag();
             event.reply("WELCOME TO THE SERVER ,** "+ userTag +"**!").queue();
         }
         else if(command.equals("roles"))
        {
            event.deferReply().queue(); //this is to delay the replay since u only have 3 seconds to send the replay
            //so if you're sending a reply that will take mover then 3 seconds because of accessing the database or something,
            //we can use this deferReply()
            String respone="";
            for(Role role:event.getGuild().getRoles())
            {
                respone+=role.getAsMention() +"\n";
            }
            //we can only send one reply so we cant use the reply function again we can gethook() for sending the message
            event.getHook().sendMessage(respone).queue();
        }
         else if (command.equals("say"))
        {
            OptionMapping messageOption=event.getOption("message");
            String message=messageOption.getAsString();
            MessageChannel channel;
            OptionMapping channelOption=event.getOption("channel");
            if(channelOption!=null)
            {
                channel=channelOption.getAsChannel().asTextChannel();
            }
            else
            {
                channel=event.getChannel();
            }
            channel.sendMessage(message).queue();
            event.reply("your message was sent!").setEphemeral(true).queue();
        }
         else if(command.equals("emote"))
         {
             OptionMapping emoteOption=event.getOption("emote");
             String message1=emoteOption.getAsString();
             String replymessage="";
             switch (message1.toLowerCase())
             {
                 case "hug" ->
                 {
                     replymessage="YOU AINT HUGING ANYWAY,U ARE DIEING ALONE";
                 }
                 case "laugh" ->
                 {
                     replymessage="THE LAST TIME U LAUGHED WAS 10 YEARS AGO";
                 }
                 case "cry" ->
                 {
                     replymessage="YOU GONNA CRY EVERYDAY";
                 }
             }
             event.reply(replymessage).queue();
         }
         else if(command.equals("giverole"))
         {
             Member member=event.getOption("user").getAsMember();
             Role role=event.getOption("role").getAsRole();
             event.getGuild().addRoleToMember(member,role).queue();
             event.reply(member.getAsMention()+"has been given the role of"+ role.getAsMention()+"role!").queue();
         }
    }
    //THIS IS GUILD COMMAND, ITS INSTANT BUT 100 MAX
    //THESE COMMANDS GET UPDATED INSTANTLY AND GREAT FOR TESTING
    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event)
    {
        List<CommandData> commandData=new ArrayList<>();

       //welcome you to the server
        commandData.add(Commands.slash("welcome","Get welcome by the bot"));

        //displays all the roles in the server
        commandData.add(Commands.slash("roles","Displays all the roles in the server"));

        //displaying the message give by by you
        OptionData option1=new OptionData(OptionType.STRING,"message","The message u want bot will say",true);
        OptionData option2=new OptionData(OptionType.CHANNEL,"channel","The Channel u want to send the message",true)
                .setChannelTypes(ChannelType.TEXT,ChannelType.NEWS,ChannelType.GUILD_PUBLIC_THREAD);
        commandData.add(Commands.slash("say","Make the bot say a message").addOptions(option1,option2));

        //give an emoted type
        OptionData option3=new OptionData(OptionType.STRING,"emote","The emote u want to choose",true)
                .addChoice("hug","hug").addChoice("laugh","hug").addChoice("cry","cry");
        commandData.add(Commands.slash("emote","The emote").addOptions(option3));

        //give user a role <user><role>
        OptionData option4=new OptionData(OptionType.USER,"user","The user to give role to",true);
        OptionData option5=new OptionData(OptionType.ROLE,"role","The role to give to user",true);
        commandData.add(Commands.slash("giverole","Give a user a role").addOptions(option4,option5));

        event.getGuild().updateCommands().addCommands(commandData).queue();
    }
    //THIS IS THE GLOBAL COMMAND, WILL TAKE An HOUR TO GET UPDATED BUT UNLIMITED
    //@Override
   // public void onReady(@NotNull ReadyEvent event)
    //{
    //    List<CommandData> commandData=new ArrayList<>();
    //    commandData.add(Commands.slash("welcome","get welcome by the bot"));
      //  event.getJDA().updateCommands().addCommands(commandData).queue();
    //}
}
