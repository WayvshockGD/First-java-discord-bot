import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class bot extends ListenerAdapter
{
	public static void main(String[] args)
	{
		try
		{
			JDA jda = JDABuilder.createDefault("Bot-Token-H")
					.addEventListeners(new bot())
					.build();
					jda.awaitReady();
					System.out.print("Finished Building JDA!");
		}
		catch (loginException e)
		{
			
			e.printStackTrace();
		}
		catch (InterruptedException e)
        {
            e.printStackTrace();
	}
}
