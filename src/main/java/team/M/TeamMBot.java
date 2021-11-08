package team.M;

import listeners.HelloListener;
import listeners.TeamMaker;
import net.dv8tion.jda.api.*;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.requests.*;
import net.dv8tion.jda.api.utils.*;
import net.dv8tion.jda.api.utils.cache.*;

import javax.security.auth.login.*;
import java.io.*;


public class TeamMBot {

    public static JDABuilder builder;

    public static String prefix;


    public static void main(String[] args) throws LoginException, IOException {

        //place where file is located. double backward slash should be used.
        File file = new File("/home/luc/Documents/computing/DiscordBot/token");

        BufferedReader fileReader = new BufferedReader(new FileReader(file));

        String token = fileReader.readLine();

        prefix = "~";

        builder = JDABuilder.createDefault(token);

        builder.disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE);

        builder.setBulkDeleteSplittingEnabled(false);

        builder.setCompression(Compression.NONE);

        builder.setActivity(Activity.playing("Discord"));

        builder.enableIntents(GatewayIntent.GUILD_MEMBERS);

        registerListeners();

        builder.build();

    }

    public static void registerListeners() {
        builder.addEventListeners(new HelloListener());
        builder.addEventListeners(new TeamMaker());
    }

}