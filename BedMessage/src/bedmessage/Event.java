package bedmessage;

import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedEnterEvent.BedEnterResult;

public class Event implements Listener {
	
	public static String[] firstHalf = {"`{player} is sleeping in a bed."};
	public static String[] lastHalf = {"Sweet dreams. `{rand:5}"};
	
	private static final String VARIABLE_IDENTIFIER = "`";
	
	@EventHandler
	public void onEnterBedEvent(PlayerBedEnterEvent e) {
		if(e.getBedEnterResult() == BedEnterResult.OK) {
			String msg = ""; //e.getPlayer().getName();
			Random r = new Random();
			int n = r.nextInt(firstHalf.length);
			msg = firstHalf[n];
			n = r.nextInt(lastHalf.length);
			msg = msg + " " + lastHalf[n];
			while(msg.contains(VARIABLE_IDENTIFIER)) {
				//int debug = 0;
				int start = msg.indexOf(VARIABLE_IDENTIFIER) + 1;
				int end = start - 1;
				String value = "";
				//e.getPlayer().sendMessage("[BedMessage Debug " + debug++ + "] " + start + " to " + end);
				if (msg.charAt(start++) == '{') {
					if(msg.contains("}")) {
						end = msg.indexOf('}');
						String todo = msg.substring(start, end);
						int argstart = todo.length();
						if(todo.contains(":")) {
							argstart = todo.indexOf(':');
						}
						switch(todo.substring(0, argstart)) {
						case "player": {
							value = e.getPlayer().getName(); 
						} break;
						case "rand": {
							value = "" + r.nextInt(Integer.parseInt(todo.substring(argstart + 1))); 
						} break;
						default: value = todo; break;
						}
					}
				}
				msg = msg.substring(0, start - 2) + value + msg.substring(end + 1);
			}
			for(Player p : Bukkit.getOnlinePlayers()) {
				p.sendMessage(msg);
			}
		}
//		switch(n) {
//		case 0: { msg = msg + " is sleeping in a bed. "; } break;
//		case 1: { msg = msg + " is taking a nap. "; } break;
//		case 2: { msg = msg + " is getting some ZZZs. "; } break;
//		case 3: { msg = msg + " is counting sheep. "; } break;
//		}
//		n = r.nextInt(4);
//		switch(n) {
//		case 0: { msg = msg + "Sweet dreams!"; } break;
//		case 1: { msg = msg + "Have a nice sleep!"; } break;
//		case 2: { msg = msg + "See you in the morning!"; } break;
//		case 3: { msg = msg + "Don't let the bedbugs bite!"; } break;
//		}
	}
}
