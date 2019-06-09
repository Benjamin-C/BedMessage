package bedmessage;

import org.bukkit.plugin.java.JavaPlugin;

public class BedMessage extends JavaPlugin {
	
	public void loadDefaultConfig() {
		// Plugin config
		saveDefaultConfig();
	}
	
	// Fired when plugin is first enabled
    @Override
    public void onEnable() {
    	loadDefaultConfig();
    	getServer().getPluginManager().registerEvents(new Event(), this);
    }
    
    // Fired when plugin is disabled
    @Override
    public void onDisable() {

    }
}
