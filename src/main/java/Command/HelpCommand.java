package Command;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.ArrayList;

public class HelpCommand implements Command {

    ArrayList<String> args;
    GuildMessageReceivedEvent event;
    String helpMessage = "Welcome to TeamBot (tb) help!\nPrefix = \"~\"\nCommands:\n->    help\n->    other commands ...";

    public HelpCommand(ArrayList<String> args, GuildMessageReceivedEvent event){
        this.args = args;
        this.event = event;
    }

    @Override
    public void execute() throws Throwable {
        event.getChannel().sendMessage(helpMessage).queue();
        this.finalize();
    }
}
