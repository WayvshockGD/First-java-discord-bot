
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;
import java.awt.*;


public class bot extends ListenerAdapter {
	/*
	 * prefix goes here. default = !
	 */
	public static String prefix = "|";

    public static void main(String[] args) throws LoginException {
        String token = "Bot-Token";
        JDABuilder builder = JDABuilder.createDefault(token);
        builder.addEventListeners(new bot());
        builder.setActivity(Activity.playing("Half life " + prefix + "info"));
        builder.build();
    }

    public void onReady(ReadyEvent event) {
        System.out.println("Logged in as " + event.getJDA().getSelfUser().getAsTag());
    }

    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) {
            return;
        }
        else {
            
            if (event.getChannel().getType().name().equals("dm")) return;
			if (event.getMessage().getContentRaw().toLowerCase().equals(prefix + "ping")) {
                long ping = event.getJDA().getGatewayPing();

                event.getChannel().sendMessage("Pong! " + ping + "ms").queue();
            }
            if (event.getMessage().getContentRaw().toLowerCase().equals(prefix + "info")) {
            	
            	EmbedBuilder embedInfo = new EmbedBuilder();
            	
            	embedInfo.setColor(Color.orange);
            	embedInfo.setTitle("Info");
            	embedInfo.addField("This bot is made out of java", "i made this bot out of java because i wanted to and because jda is awsome :sunglasses:", false);
            	embedInfo.addField("How to Use Bot:", "More commands comming soon but for now just a basic ping and help command. to use the command" +
            	" say " + prefix + "help or " + prefix + "commands", false);
            	embedInfo.addField("Bot invite:", "[Click Here](https://discord.com/api/oauth2/authorize?client_id=666480078498168833&permissions=8&scope=bot)", false);
            	embedInfo.addField("Github Repository:", "[click here](https://github.com/WayvshockGD/First-java-discord-bot)", false);
            	embedInfo.setThumbnail(event.getJDA().getSelfUser().getAvatarUrl());
            	embedInfo.setFooter("2020 made in JDA");
            	
            	 event.getChannel().sendMessage(embedInfo.build()).queue();
            }
            if (event.getMessage().getContentRaw().toLowerCase().equals(prefix + "help")) {
            	event.getChannel().sendMessage("help:\n core: " + prefix + "info, " + prefix + "ping").queue();
            }

            if (event.getMessage().getContentRaw().equals("<@!" + event.getJDA().getSelfUser().getId() + ">") ||
            event.getMessage().getContentRaw().equals("<@" + event.getJDA().getSelfUser().getId() + ">")) {
                event.getChannel().sendMessage(":wave: | Hello <@!" + event.getAuthor().getId() + "> my prefix is " + prefix).queue();
            }
        }
    }
}
