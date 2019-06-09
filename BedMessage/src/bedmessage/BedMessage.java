package bedmessage;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.plugin.java.JavaPlugin;

public class BedMessage extends JavaPlugin {
	
	public static final String FIRST_HALF = "first-half";
	public static final String LAST_HALF = "last-half";
	
	public void loadDefaultConfig() {
		// Plugin config
		saveDefaultConfig();
	}
	
	// Fired when plugin is first enabled
    @Override
    public void onEnable() {
    	saveDefaultConfig();
    	
    	Event.firstHalf = loadPart(FIRST_HALF);
    	Event.lastHalf = loadPart(LAST_HALF);
    	getServer().getPluginManager().registerEvents(new Event(), this);
    }
    
    // Fired when plugin is disabled
    @Override
    public void onDisable() {
    	// For saving of config if an in-game modification is added
//    	getConfig().set(FIRST_HALF, Event.firstHalf);
//    	getConfig().set(LAST_HALF, Event.lastHalf);
//    	saveConfig();
    }
    
    private String[] loadPart(String key) {
    	@SuppressWarnings("unchecked")
		ArrayList<String> content = (ArrayList<String>) getConfig().getList(key);
    	String[] items = new String[content.size()];
    	for (int i = 0; i < content.size(); i++) {
    	    String item = content.get(i);
    	    if (item != null) {
    	        items[i] = item;
    	    } else {
    	        items[i] = null;
    	    }
    	}
    	return items;
    }
}
