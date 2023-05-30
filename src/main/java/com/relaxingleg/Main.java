package com.relaxingleg;
import com.relaxingleg.commands.commands;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.exceptions.InvalidTokenException;
import net.dv8tion.jda.api.requests.GatewayIntent;
import javax.security.auth.login.LoginException;
import static net.dv8tion.jda.api.requests.GatewayIntent.MESSAGE_CONTENT;
public class Main {
    public static void main(String[] args) throws InvalidTokenException {
        JDABuilder builder = JDABuilder.createDefault("MTExMjgyNDY5NDI1Nzc1MDA4Nw.GZVfxl.IQ5Ia16KJ_C-j7VyUKK_-V8mSxSDF4cBtlM0GI");
        builder.enableIntents(GatewayIntent.GUILD_MESSAGES, GatewayIntent.DIRECT_MESSAGES, GatewayIntent.MESSAGE_CONTENT);
        JDA jda = builder.build();
        jda.addEventListener(new commands());
        jda.addEventListener(new Listeners());
    }
}
