package Command;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.ArrayList;
import java.util.List;

public class PlayCommand implements Command {

    List<String> args;
    GuildMessageReceivedEvent event;
    String helpMessage = "Welcome to TeamBot (tb) help!\nPrefix = \"~\"\nCommands:\n->    help\n->    other commands ...";

    public PlayCommand(List<String> args, GuildMessageReceivedEvent event){
        this.args = args;
        this.event = event;
    }

    @Override
    public void execute() throws Throwable {

        Runtime.getRuntime().exec("/bin/bash -c your_command");

        this.finalize();
    }
}