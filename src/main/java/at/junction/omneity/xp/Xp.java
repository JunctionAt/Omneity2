package at.junction.omneity.xp;

import at.junction.omneity.Module;
import at.junction.omneity.Omneity;

public class Xp extends Module{
    public Configuration configuration;

    public Xp(Omneity plugin) {
        super(plugin);
        configuration = new Configuration(this);
    }
    @Override
    public void onEnable(){
        XpListener listener = new XpListener(this);
        plugin.getServer().getPluginManager().registerEvents(listener, plugin);
    }
}
