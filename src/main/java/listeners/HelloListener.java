package listeners;

import Command.Command;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.RestAction;
import team.M.TeamMBot;

import java.nio.channels.Channel;
import java.nio.channels.Channels;
import java.util.Locale;
import java.util.*;
import java.util.Objects;

import team.M.TeamMBot.*;
import Command.*;
import vote.Vote;

/*
Channels ids:

random: 756938977868644369
teachershatting: 780840656398319696
 */

public class HelloListener extends ListenerAdapter {

    ArrayList<Vote> activeVotes = new ArrayList<Vote>();


    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        String messageSent = event.getMessage().getContentRaw();

        if(messageSent.equalsIgnoreCase("hello")) {
            event.getMessage().delete().queue();
            event.getChannel().sendMessage("J'aimerais que Steak se la ramène et me fasse un logo ou kkchose pcq là juis pogné avec la face a Hamdache :'(").queue();
        }

        if(messageSent.substring(0, 3).equalsIgnoreCase(TeamMBot.prefix + "tb")){
            String message = event.getMessage().toString();

            if(message.charAt(3) != ' '){
                event.getChannel().sendMessage("There was an error in command. Please respect the syntax `~tb " +
                        "<command> <arg0> <arg1> ... <argN>` Char = " + message).queue();
            }
            else{
                ArrayList<String> commandAndArgs = new ArrayList<String>(Arrays.asList(message.substring(4,
                        message.length()).split(" ")));
                switch (commandAndArgs.get(0)){
                    case "help":
                        HelpCommand helpCommand = new HelpCommand(commandAndArgs, event);
                        try {
                            helpCommand.execute();
                        } catch (Throwable e) {
                            e.printStackTrace();
                        }
                        break;

                    case "vote":
                        Command command;
                        break;
                }
            }
        }

//        if(messageSent.equalsIgnoreCase(TeamMBot.prefix + "help")) {
//            event.getMessage().delete().queue();
//            event.getChannel().sendMessage("Commands:").queue();
//            event.getChannel().sendMessage("- help").queue();
//            event.getChannel().sendMessage("- announce").queue();
//        }

        if(messageSent.split(" ")[0].equalsIgnoreCase(TeamMBot.prefix + "vote")){
            String voteCommand = event.getMessage().getContentDisplay();
            ArrayList<String> decomposedCommand = new ArrayList<String>(Arrays.asList(voteCommand.split(" ")));

            // Display vote status
            if(Objects.equals(decomposedCommand.get(1), "status")){
                for(Vote singleVote:activeVotes){
                    String result = singleVote.getTitle() + "\n" + "\n" + singleVote.getResult();
                    event.getChannel().sendMessage(result).queue();
                }
            }

            else {
                ArrayList<String> voteChoices = new ArrayList<String>(decomposedCommand.subList(1, decomposedCommand.size()));

                // Collecting vote choices
                //            for(int i=1; i<voteChoices.size(); i++){
                //                event.getChannel().sendMessage(voteChoices.get(1)).queue();
                //            }

                // Create vote
                activeVotes.add(new Vote("My super vote2", voteChoices));
            }
        }

        if(messageSent.equalsIgnoreCase(TeamMBot.prefix + "announce")) {
            event.getMessage().delete().queue();
            event.getChannel().sendMessage("Sending announcement").queue();
            event.getGuild().getTextChannelById("780840656398319696").sendMessage("Annoucement Test").queue();
        }

        if(messageSent.equalsIgnoreCase(TeamMBot.prefix + "hate MF")) {
            event.getMessage().delete().queue();
            event.getGuild().getTextChannelById("780840656398319696").sendMessage("Non mais tsé MF pareil ... est tu poche quand-même comme prof?").queue();
        }

        if(messageSent.equalsIgnoreCase(TeamMBot.prefix + "hate Hamdache")) {
            event.getMessage().delete().queue();
            event.getGuild().getTextChannelById("780840656398319696").sendMessage("J'tai dis que ça donnait 14. T'es tu cave ou quoi? Devinez qui j'imite.").queue();
        }

        if(messageSent.toLowerCase(Locale.ROOT).contains("bière") || messageSent.toLowerCase(Locale.ROOT).contains("biere")) {
            event.getChannel().sendMessage("YEAHHHHHH j'espère pour toi qu'elle est bien froide.").queue();
        }

//        if(messageSent.toLowerCase(Locale.ROOT).contains("louis") || messageSent.toLowerCase(Locale.ROOT).contains("steak")) {
//            event.getChannel().sendMessage("J'attends toujours après une photo qui a de l'allure Louis >:(").queue();
//        }

        if(messageSent.toLowerCase(Locale.ROOT).contains("hunt")) {
            event.getChannel().sendMessage("Vous allez encore vous faire décalisser boys haha j'ai hâte de voir ça XD").queue();
        }

        if(messageSent.toLowerCase(Locale.ROOT).contains("étudier") || messageSent.toLowerCase(Locale.ROOT).contains("etudier") || messageSent.toLowerCase(Locale.ROOT).contains("etude") || messageSent.toLowerCase(Locale.ROOT).contains("étude")) {
            event.getChannel().sendMessage("LOL étudier").queue();
        }

        if(messageSent.equalsIgnoreCase("test")) {
              RestAction<List<Message>> messages = event.getChannel().getHistory().retrievePast(80);
              Vector<String> users = new Vector<>();
              StringBuilder teamMessage = new StringBuilder(" a");

              List<Message> messsages = messages.complete();
              System.out.println(messsages.size());

              for(Message message: messsages){
                  String user = message.getAuthor().getName();
                  System.out.println(user + "a");
                  if(!users.contains(user))
                      users.add(user);
              }

              for(String user : users){
                  teamMessage.append(user).append("\n");
              }

              System.out.println(teamMessage);
//            String member = event.getMember().getUser().getName();
//            String member = event.getChannel().getMembers().toArray()[0].toString();
            event.getChannel().sendMessage(teamMessage).queue();
        }

    }
}

