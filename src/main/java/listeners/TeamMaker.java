package listeners;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import team.M.TeamMBot;

import java.nio.channels.Channel;
import java.util.Locale;
import java.util.*;

public class TeamMaker extends ListenerAdapter{

    private Hashtable<Integer, Vector<String>> teams = new Hashtable<Integer, Vector<String>>();

        public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

            List<Member> members = event.getChannel().getMembers();

            String messageSent = event.getMessage().getContentRaw();
            Integer currentTeam = 1;
            StringBuilder teamMessage = new StringBuilder();

            if(messageSent.equalsIgnoreCase(TeamMBot.prefix + "team-up")) {

                createTeam(members, teams);
                Enumeration<Vector<String>> values = teams.elements();

                while(values.hasMoreElements()){

                    Vector<String> team = values.nextElement();
                    teamMessage.append("Team").append(currentTeam).append(": \n");

                    for(String member : team){
                        teamMessage.append("- ").append(member).append("\n");
                    }

                    event.getChannel().sendMessage(teamMessage).queue();
                }
            }

        }

        private void createTeam(List<Member> members, Hashtable<Integer, Vector<String>> teams){
            Vector<String> team = new Vector<>();

            for(Member member : members){
                team.add(member.getNickname());
            }

            teams.put(1, team);
        }

}
