package bedmessage;

import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

public class Event implements Listener {
	
	@EventHandler
	public void onEnterBedEvent(PlayerBedEnterEvent e) {
		String msg = e.getPlayer().getName();
		Random r = new Random();
		int n = r.nextInt(4);
		switch(n) {
		case 0: { msg = msg + " is sleeping in a bed. "; } break;
		case 1: { msg = msg + " is taking a nap. "; } break;
		case 2: { msg = msg + " is getting some ZZZs. "; } break;
		case 3: { msg = msg + " is counting sheep. "; } break;
		}
		n = r.nextInt(4);
		switch(n) {
		case 0: { msg = msg + "Sweat dreams!"; } break;
		case 1: { msg = msg + "Have a nice sleep!"; } break;
		case 2: { msg = msg + "See you in the morning!"; } break;
		case 3: { msg = msg + "Don't let the bedbugs bite!"; } break;
		}
		for(Player p : Bukkit.getOnlinePlayers()) {
			p.sendMessage(msg);
		}
	}
}
